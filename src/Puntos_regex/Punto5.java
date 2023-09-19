
package Puntos_regex;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import regular_expresion.Tarjeta;


public class Punto5 {
    
    static Scanner leer = new Scanner(System.in);
    
    public static void Inicio5(){
        
        ArrayList<Tarjeta> Array = new ArrayList<>();
        
        for (int i = 0; i < 2; i++) {
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
            
            S = ValidarCodigo();
            Tarjeta.setCodigo(S);
        }
    }
    
    static String ValidarTipo(){
        String S = "";
        Pattern Validar = Pattern.compile("MasterCard|Visa");
        boolean Cumple = false;
        
        while (!Cumple){
            System.out.println("Ingrese el tipo de la tarjeta(MasterCard/Visa): ");
            String Tipo = leer.next();
            Matcher Comparar = Validar.matcher(Tipo);
            
            if (Comparar.matches()){
                S = Tipo;
                Cumple = true;
            }else{
                System.out.println("El tipo no coincide.");
            }
        }
        return S;
    }
    
    static String ValidarNumero(){
        String S = "";
        Pattern Validar = Pattern.compile("\\d{16}");
        boolean Cumple = false;
        
        while (!Cumple){
            System.out.println("Ingrese el numero de la tarjeta(16) : ");
            String Numero = leer.next();
            Matcher Comparar = Validar.matcher(Numero);
            
            if (Comparar.matches()){
                S = Numero;
                Cumple = true;
            }else{
                System.out.println("El numero de la tarjeta debe ser de 16 numeros.");
            }
        }
        return S;
    }
    
    static String ValidarFecha(){
        String S = "";
        Pattern Validar = Pattern.compile("\\d{2}/\\d{2}");
        boolean Cumple = false;
        
        while (!Cumple){
            System.out.println("Ingrese la fecha de la tarjeta(MM/AA): ");
            String Fecha = leer.next();
            Matcher Comparar = Validar.matcher(Fecha);
            
            if (Comparar.matches()){
                S = Fecha;
                Cumple = true;
            }else{
                System.out.println("La fecha no cumple la condición.");
            }
        }
        return S;
    }
    
    static String ValidarNombre(){
        String S = "";
        Pattern Validar = Pattern.compile("[A-Z]+");
        boolean Cumple = false;
        
        while (!Cumple){
            System.out.println("Ingrese el nombre del dueño la tarjeta(MAYUSCULAS): ");
            String Nombre = leer.next();
            Matcher Comparar = Validar.matcher(Nombre);
            
            if (Comparar.matches()){
                S = Nombre;
                Cumple = true;
            }else{
                System.out.println("El nombre no cumple la condición.");
            }
        }
        return S;
    }
    
    static String ValidarApellido(){
        String S = "";
        Pattern Validar = Pattern.compile("[A-Z]+");
        boolean Cumple = false;
        
        while (!Cumple){
            System.out.println("Ingrese el apellido del dueño la tarjeta(MAYUSCULAS): ");
            String Apellido = leer.next();
            Matcher Comparar = Validar.matcher(Apellido);
            
            if (Comparar.matches()){
                S = Apellido;
                Cumple = true;
            }else{
                System.out.println("El apellido no cumple la condición.");
            }
        }
        return S;
    }
    
    static String ValidarCodigo(){
        String S = "";
        Pattern Validar = Pattern.compile("\\d{3}");
        boolean Cumple = false;
        
        while (!Cumple){
            System.out.println("Ingrese el código de la tarjeta(3): ");
            String Codigo = leer.next();
            Matcher Comparar = Validar.matcher(Codigo);
            
            if (Comparar.matches()){
                S = Codigo;
                Cumple = true;
            }else{
                System.out.println("El código no cumple la condición.");
            }
        }
        return S;
    }
    
}
