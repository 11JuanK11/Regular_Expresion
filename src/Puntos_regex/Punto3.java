
package Puntos_regex;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class Punto3 {
    
    static Scanner leer = new Scanner(System.in);
    
    public static void Inicio3(){
        ArrayList<ArrayList<String>> ArrayPrincipal = new ArrayList<>();
        
        for (int i = 0; i < 2; i++) {
            ArrayList<String> ArrayInterno = new ArrayList<>();
            //Cantidad de veces que se equivoca al ingresar la cedula
            ArrayInterno = ValidarCedula(ArrayInterno);
            
            //Ingresar la profesion
            String Profesion = null;
            Profesion = JOptionPane.showInputDialog(null, "Ingrese si es Docente de Catedra, Docente Ocasional o Docente de Planta:");
            ArrayInterno.add(Profesion);
            
            //Ingreso de la fecha
            ArrayInterno = ValidarFecha(ArrayInterno);
       
            ArrayPrincipal.add(ArrayInterno);
        }
        //Porcentajes de docentes
        String S = ValidarPorcentajes(ArrayPrincipal);
        System.out.println(S);
        
        //Cantidad de erros cedula
        String S1 = CantidadCedMalIngresada(ArrayPrincipal);
        System.out.println(S1);
        
        //Docentes con fecha de Septiembre
        String S2 = MesSeptiembre(ArrayPrincipal);
        System.out.println(S2);
    }
    
    static ArrayList<String> ValidarCedula (ArrayList<String> Interno){
        int Cont=0;
        boolean Igual = false;
        Pattern ValidarCed = Pattern.compile("\\d{10}");
        
        while (!Igual){
            System.out.println("Ingrese la cedula: ");
            String Cedula = leer.next();
            
            Matcher ComparacionCed = ValidarCed.matcher(Cedula);

            if(!ComparacionCed.matches()){
                Cont++;
                System.out.println("Se ha ingresado mal la cedula.");
            }else{
                Interno.add(Cedula);
                Interno.add(Integer.toString(Cont));
                Igual = true;
            }
        }
        return Interno;
    }
    
    static ArrayList<String> ValidarFecha(ArrayList<String> Interno){
        boolean Cumple = false;
        Pattern ValidarFecha = Pattern.compile("\\d{1,2}-\\d{1,2}-\\d{4}");
        
        while (!Cumple){
            System.out.println("Ingrese la fecha(DD-MM-AAAA:");
            String Fecha = leer.next();

            Matcher ComparacionFecha = ValidarFecha.matcher(Fecha);
            
            if(ComparacionFecha.matches()){
                Interno.add(Fecha);
                Cumple = true;
            }else{
                System.out.println("Se ha ingresado en un formato diferente la fecha.");
            }
        }
        return Interno;
    }
    
    static String ValidarPorcentajes(ArrayList<ArrayList<String>> Principal){
        String S = "";
        int CantCatedra = 0, CantPlanta = 0, CantOcasional = 0;
        
        for (int i = 0; i < Principal.size(); i++) {
            for (int j = 0; j < Principal.get(i).size(); j++) {
                String Docente = Principal.get(i).get(2);

                if (Docente.equalsIgnoreCase("Docente de Catedra")){
                    CantCatedra++;
                }else{
                    if (Docente.equalsIgnoreCase("Docente de Planta")){
                        CantPlanta++;
                    }else{
                        if (Docente.equalsIgnoreCase("Docente Ocasional")){
                            CantOcasional++;
                        }
                    }
                }
            }
        }
        int PC = (CantCatedra*100)/(CantCatedra+CantOcasional+CantPlanta);
        int PP = (CantPlanta*100)/(CantCatedra+CantOcasional+CantPlanta);
        int PO = (CantOcasional*100)/(CantCatedra+CantOcasional+CantPlanta);
        
        S = "Docentes de Catedra: " + PC + "% \nDocentes de Planta: " + PP + "% \nDocentes Ocasionales: " + PO + "%";
        return S;
    }
    
    static String MesSeptiembre(ArrayList<ArrayList<String>> Principal){
        String S = "";
        Pattern Evaluar = Pattern.compile("\\d{1,2}-09-\\d{4}");
        ArrayList<String> Array = new ArrayList<>();
        
        for (int i = 0; i < Principal.size(); i++) {
            if (Principal.get(i).get(2).equalsIgnoreCase("Docente de Catedra")){
                String Fecha = Principal.get(i).get(3);
                Matcher Comparacion = Evaluar.matcher(Fecha);
                
                if (Comparacion.matches()){
                    Fecha = "Cedula: " + Principal.get(i).get(0) + "; Fecha: " + Fecha;
                    Array.add(Fecha);
                }
            }
        }
        S = LeerArray(Array);
        return S;
    }
    
    static String LeerArray(ArrayList<String> Array){
        String S = "";
        
        for (int i = 0; i < Array.size(); i++) {
            S += Array.get(i) + "\n";
        }
        
        return S;
    }
    
    static String CantidadCedMalIngresada(ArrayList<ArrayList<String>> Principal){
        String S = "\nCantidad de veces de la cedula mal ingresada por usuario: \n";
        
        for (int i = 0; i < Principal.size(); i++) {
            String Cant = Principal.get(i).get(1);
            S +=  "Usuario #" + (i+1) + ": " + Cant + "\n";
        }
        return S;
    }
}
