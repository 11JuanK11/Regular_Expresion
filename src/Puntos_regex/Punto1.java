
package Puntos_regex;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class Punto1 {
    public static void Vista1(){
        int k = 0, Num_Primos; 
        boolean bandera;
        //Valida si el numero ingresado es un numero primo, sino es así el usuario debe ingresar un numero nuevamente
        do {            
            Num_Primos = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa la cantidad de nodos. \n(Recuerda que debe de ser un numero primo)"));
            bandera = Es_Primo(Num_Primos);
            if(!bandera){
                JOptionPane.showMessageDialog(null, "El numero ingresado no es un numero primo");
            }
        } while (!bandera);
        //Crea el array con los nodos correspondientes
        ArrayList<String> Lista_Gen = Creacion(Num_Primos);    
        for (int i = 0; i < Lista_Gen.size() ; i++) {
            String objeto, S ="\\d"+"{"+(i+1)+"}";
            do {                
                objeto = JOptionPane.showInputDialog("Ingresa los tres numeros de " + (i+1) + " Digitos separados por espacios");
                //Confirma si los numeros estan separados por espacios en blanco o corresponden a los digitos exactos
                Pattern patron = Pattern.compile(S+" "+S+" "+S);
                Matcher coincidencia = patron.matcher(objeto);
                if(coincidencia.matches()){
                    String[] vector = objeto.split(" ");
                    int j=0;
                    boolean bandera2 = true;
                    while ( (j+1) < vector.length && bandera2) {
                        //Compara si los numeros estan de menor a mayor
                        if(Integer.parseInt(vector[j]) > Integer.parseInt(vector[j+1])){
                            bandera = true;
                            bandera2 = false;
                            JOptionPane.showInternalMessageDialog(null, "No se esta respetando el orden de menor a mayor en el contenido");
                        }else{
                            bandera = false;
                        }    
                        j++;
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "El contenido ingresado es erroneo");
                    bandera = true;
                }
            } while (bandera);
            Lista_Gen.set(i, objeto);
        }
        int total_1, total_2;
        String fin = "";
        if(Lista_Gen.size() % 2 == 0){
            for (String string : Lista_Gen) {
                String[] nums = string.split(" ");
                total_1 = 0;
                for (String num : nums) {
                    total_1 += Integer.parseInt(num);
                }
                total_1 = (total_1) / 3;
                fin += total_1;
            }    
        }else{
            int i=0, j = (Lista_Gen.size()-1);
            boolean controlador = true;
            //Concatena el promedio de los nodos
            do { 
                String[] ini = Lista_Gen.get(i).split(" "), ult = Lista_Gen.get(j).split(" ");
                total_1 = 0;
                total_2 = 0;
                if(i == j){
                    for (int l = 0; l < 3; l++) {
                        total_1 += Integer.parseInt(ini[l]);   
                    }
                    fin += (total_1) / 3;
                    controlador = false;
                }else{
                    for (int l = 0; l < 3; l++) {
                        total_1 += Integer.parseInt(ini[l]);
                        total_2 += Integer.parseInt(ult[l]);
                    }
                    fin += (total_1) / 3;
                    fin += (total_2) / 3;
                    fin += ", ";
                    
                }
                i++;
                j--;
            } while (controlador);
        }
        JOptionPane.showMessageDialog(null, "El resultado es: " + fin);
      
        
    }
    //Crea el arraylist con la cantidad de los numeros primos validados
    private static ArrayList Creacion( int Num_Primos){
        ArrayList<String> List = new ArrayList<>();
        for (int i = 0; i < Num_Primos; i++) {
            List.add("");  
        }
        return List;
    }
    //Metodo que compara si el numero ingresado es o no un numero primo
    private static boolean Es_Primo(int Num_Primos){
        boolean bandera = false;   
            int i = 1, cont = 0;
            while (i <= Num_Primos) {
                if(Num_Primos % i  == 0)
                    cont++;
                i++;
            }
            if (cont == 2){
                bandera = true; 
            }   
        return bandera;
    }
    
    
}
