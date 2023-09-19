
package Puntos_regex;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import regular_expresion.Tarjeta;


public class Punto5 {
    
    private static ArrayList<Tarjeta> Array = new ArrayList<>();
    private static ArrayList<Tarjeta> ArrayM = new ArrayList<>();
    private static ArrayList<Tarjeta> ArrayV = new ArrayList<>();
    
    public static void Inicio5(){
        
        int Cant = Integer.parseInt( JOptionPane.showInputDialog(null, "Cuantas tarjetas desea registrar: "));

        for (int i = 0; i < Cant; i++) {
            Tarjeta Tarjeta = new Tarjeta();
            String S = "";
            
            S = ValidarTipo();
            Tarjeta.setTipo(S);
            
            S = ValidarNumero();
            Tarjeta.setNumero(S);
            
            S = ValidarFecha();
            Tarjeta.setFecha(S);

            S = ValidarNombre();
            Tarjeta.setNombre(S);
            
            S = ValidarApellido();
            Tarjeta.setApellido(S);
            
            Array.add(Tarjeta);
            JOptionPane.showMessageDialog(null, "Registro Exitoso.");
        }
        SepararArrays(Array);
    }
    
    static String ValidarTipo(){
        String S = "";
        Pattern Validar = Pattern.compile("MasterCard|Visa");
        boolean Cumple = false;
        
        while (!Cumple){
            String Tipo = JOptionPane.showInputDialog(null, "Ingrese el tipo de la tarjeta(MasterCard/Visa): ");
            Matcher Comparar = Validar.matcher(Tipo);
            
            if (Comparar.matches()){
                S = Tipo;
                Cumple = true;
            }else{
                JOptionPane.showMessageDialog(null, "El tipo no coincide.");
            }
        }
        return S;
    }
    
    static String ValidarNumero(){
        String S = "";
        Pattern Validar = Pattern.compile("\\d{16}");
        boolean Cumple = false;
        
        while (!Cumple){
            String Numero = JOptionPane.showInputDialog(null, "Ingrese el numero de la tarjeta(16) : ");
            Matcher Comparar = Validar.matcher(Numero);
            
            if (Comparar.matches()){
                S = Numero;
                Cumple = true;
            }else{
                JOptionPane.showMessageDialog(null, "El numero de la tarjeta debe ser de 16 numeros.");
            }
        }
        return S;
    }
    
    static String ValidarFecha(){
        String S = "";
        Pattern Validar = Pattern.compile("\\d{2}/\\d{2}");
        boolean Cumple = false;
        
        while (!Cumple){
            String Fecha = JOptionPane.showInputDialog(null, "Ingrese la fecha de la tarjeta(MM/AA): ");
            Matcher Comparar = Validar.matcher(Fecha);
            
            if (Comparar.matches()){
                S = Fecha;
                Cumple = true;
            }else{
                JOptionPane.showMessageDialog(null, "La fecha no cumple la condición.");
            }
        }
        return S;
    }
    
    static String ValidarNombre(){
        String S = "";
        Pattern Validar = Pattern.compile("[A-Z]+");
        boolean Cumple = false;
        
        while (!Cumple){
            String Nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre del dueño la tarjeta(MAYUSCULAS): ");
            Matcher Comparar = Validar.matcher(Nombre);
            
            if (Comparar.matches()){
                S = Nombre;
                Cumple = true;
            }else{
                JOptionPane.showMessageDialog(null, "El nombre no cumple la condición.");
            }
        }
        return S;
    }
    
    static String ValidarApellido(){
        String S = "";
        Pattern Validar = Pattern.compile("[A-Z]+");
        boolean Cumple = false;
        
        while (!Cumple){
            String Apellido = JOptionPane.showInputDialog(null, "Ingrese el apellido del dueño la tarjeta(MAYUSCULAS): ");
            Matcher Comparar = Validar.matcher(Apellido);
            
            if (Comparar.matches()){
                S = Apellido;
                Cumple = true;
            }else{
                JOptionPane.showMessageDialog(null, "El apellido no cumple la condición.");
            }
        }
        return S;
    }
    
    static String ValidarCodigo(){
        String S = "";
        Pattern Validar = Pattern.compile("\\d{3}");
        boolean Cumple = false;
        
        while (!Cumple){
            String Codigo = JOptionPane.showInputDialog(null, "Ingrese el código de la tarjeta(3): ");
            Matcher Comparar = Validar.matcher(Codigo);
            
            if (Comparar.matches()){
                S = Codigo;
                Cumple = true;
            }else{
                JOptionPane.showMessageDialog(null, "El código no cumple la condición.");
            }
        }
        return S;
    }
    
    static void SepararArrays(ArrayList<Tarjeta> Array){
        Pattern ValidarM = Pattern.compile("MasterCard");
        Pattern ValidarV = Pattern.compile("Visa");
        
        for (int i = 0; i < Array.size(); i++) {
            Tarjeta Tarjeta = Array.get(i);
            String Tipo = Tarjeta.getTipo();
            
            Matcher CompararM = ValidarM.matcher(Tipo);
            Matcher CompararV = ValidarV.matcher(Tipo);
            
            if (CompararM.matches()){
                ArrayM.add(Tarjeta);
            }else{
                if (CompararV.matches()){
                    ArrayV.add(Tarjeta);
                }
            }
        }
        Array.clear();
        Buscar(ArrayM, ArrayV);
    }
    
    static void Buscar(ArrayList<Tarjeta> Master, ArrayList<Tarjeta> Visa){
        String S = "";
        
        String A = JOptionPane.showInputDialog(null, "Ingrese el año que desea buscar: ");
        String regex = "\\d{2}/" + A;
        Pattern Validar = Pattern.compile(regex);
        
        S += BuscarMasterCard(Master, Validar);
        S += BuscarVisa(Visa, Validar);
        
        JOptionPane.showMessageDialog(null, S);
    }
    
    static String BuscarMasterCard(ArrayList<Tarjeta> Master, Pattern Validar){
        String S = "";
        
        for (int i = 0; i < Master.size(); i++) {
            Matcher Comparar = Validar.matcher(Master.get(i).getFecha());
            
            if (Comparar.matches()){
                S += Master.get(i).getNombre() + " Fecha: "+ Master.get(i).getFecha() + "\n";
            }
        }
        return S;
    }
    
    static String BuscarVisa(ArrayList<Tarjeta> Visa, Pattern Validar){
        String S = "";

        for (int i = 0; i < Visa.size(); i++) {
            Matcher Comparar = Validar.matcher(Visa.get(i).getFecha());
            
            if (Comparar.matches()){
                S += Visa.get(i).getNombre() + " Fecha: "+ Visa.get(i).getFecha() + "\n";
            }
        }
        return S;
    }
}
