
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
            boolean ban = true;
            Pattern patrones = null;
            do {                
                String num_lim = JOptionPane.showInputDialog("Ingresa el limite de los numeros ha ingresar.");
                if (Character.isDigit(num_lim.charAt(0))) {
                    patrones = Patrones(num_lim);
                    ban = false;
                }else{
                    JOptionPane.showMessageDialog(null, "Ingresaste algo erroneo.");
                }    
            } while (ban);
            int k = 0;
            do { 
                String s = JOptionPane.showInputDialog("Ingresa un numero que sean menores al ingresado anteriormente ");
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
        String a = "", b = "" ;
        for (int i = 0; i < num_lim.length()-1; i++) {
            a += "0";
        }
        Pattern p = Pattern.compile(a), patron;
        Matcher m = p.matcher(num_lim.substring(1));
        if(m.matches()){
            b = "[0-" + (Integer.parseInt(num_lim.substring(0, 1))-1) + "]?";
            for (int i = 1; i < num_lim.length(); i++) {
                b += "\\d";
                if (i != num_lim.length()-1)
                    b+="?";
            }
            patron = Pattern.compile(b); 
        }else{
            for (int i = 0; i < num_lim.length() ; i++) {
                boolean bandera = true, ban2 = true;
                for (int j = 0; j < num_lim.length() ; j++) {
                    if(j != (num_lim.length()-i)-1 && bandera){
                        b += "[0-" + num_lim.substring(j, j+1) +"]";   
                    }else{
                        if (bandera) {
                            if (!num_lim.substring(j, j+1).equals("0")) {
                                b += "[0-" + (Integer.parseInt(num_lim.substring(j, j+1))-1) +"]";
                            }else{
                                ban2 = false;
                            }
                            
                            bandera = false;
                        } 
                    }
                    if (j < num_lim.length()-1 && ban2) 
                        b+="?";
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
        int d_may = 0;
        String may = ""; 
        Pattern p ;
        for (int i = 0; i < general.size(); i++) {
            ArrayList<String> inter = general.get(i);
            for (String S : inter) {
                if(S.length() > d_may){
                    d_may = S.length();
                    may = S;
                }else if( S.length() == d_may){
                    boolean coinc = true;
                    String aux;
                    for (int j = 0; j+1 <= d_may && coinc ; j++) {
                        aux = "[0-" + may.substring(j, j+1) + "]";
                        p = Pattern.compile(aux);
                        Matcher mm = p.matcher(S.substring(j, j+1));
                        if (!mm.matches()) {
                            coinc = false;
                            may = S;
                        }
                    }
                }
            }
        }  
        return may;
    }
}
