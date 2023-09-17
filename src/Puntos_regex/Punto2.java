/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Puntos_regex;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author 57301
 */
public class Punto2 {
    public static void Vista2(){
        int cant = Integer.parseInt(JOptionPane.showInputDialog("Ingresa la cantidad de nodos que tendra el ArrayList principal."));
        ArrayList<ArrayList<String>> general = Creacion(cant);
        for (int i = 0; i < general.size(); i++) {
            String num_lim = JOptionPane.showInputDialog("Ingresa el limite de los numeros ha ingresar.");
            Pattern patrones = Patrones(num_lim);
            int k = 0;
            do { 
                String s = JOptionPane.showInputDialog("Ingresa un numero que sean menores al ingresado anteriormente ");
                if(s.length() < num_lim.length())
                    s = 0 + s;
                Matcher m = patrones.matcher(s);
                if (m.matches()) {
                    general.get(i).set(k, s);
                    k++;
                }else{
                    JOptionPane.showMessageDialog(null, "No cumple con la condicion");
                }
            } while (k < general.get(i).size());  
        }
        
        JOptionPane.showMessageDialog(null, Mayor(general));
        
    }
    
    private static Pattern Patrones(String num_lim){
        String a = "", b = "" ,c ,d;
        for (int i = 0; i < num_lim.length()-1; i++) {
            a += "0";
        }
        Pattern p = Pattern.compile(a), patron;
        Matcher m = p.matcher(num_lim.substring(1));
        if(m.matches()){
            b = "[0-" + (Integer.parseInt(num_lim.substring(0, 0))-1) + "]?";
            for (int i = 1; i < num_lim.length(); i++) {
                b += "\\d";
            }
            patron = Pattern.compile(b); 
        }else{
            for (int i = 0; i < num_lim.length() ; i++) {
                boolean bandera = true;
                for (int j = 0; j < num_lim.length() ; j++) {
                    if(j != (num_lim.length()-i)-1 && bandera){
                        b += "[0-" + num_lim.substring(j, j+1) +"]";
                        if(j == 0)
                            b+="?";
                    }else{
                        if (bandera) {
                            b += "[0-" + (Integer.parseInt(num_lim.substring(j, j+1))-1) +"]";
                            bandera = false;
                        } 
                    }
                    if(!bandera && j < num_lim.length()-1){
                        b += "\\d";
                    }
                }
                if (i != num_lim.length()-1 ) {
                    b += "|";
                }
                
            }
            patron = Pattern.compile(b); 
        }
        return patron;
    }
    
    private static ArrayList Creacion(int cant){
        ArrayList<ArrayList> general = new ArrayList<>();
        for (int i = 0; i < cant; i++) {
            ArrayList<String> interno = new ArrayList<>();
            for (int j = 0; j < ((2*(i+1))+1); j++) {
                interno.add("");
            }
            general.add(interno);
            
        }
        return general; 
    }
    
    private static String Mayor(ArrayList<ArrayList<String>> general){
        for (int i = 0; i < general.size(); i++) {
            ArrayList<String> interno = general.get(i);
            int cifras = interno.get(0).length();
            String S = "";
            for (int j = 0; j < cifras; j++) {
                S += "[^0]";
            }
            Pattern p = Pattern.compile(S);
            for (String string : interno) {
                Matcher m = p.matcher(string);
                if(m.matches()){
                }
            }
            
        }
        
        return "";
    }
}
