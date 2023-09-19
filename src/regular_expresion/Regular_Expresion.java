 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package regular_expresion;
import Puntos_regex.*;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.*;

/**
 *
 * @author 57301
 */
public class Regular_Expresion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] opc = {"Punto #1", "Punto #2" , "Punto #3", "Punto #4", "Punto #5", "Salir"};
        int num;
        do {
            num = JOptionPane.showOptionDialog(null, "Escoge una opcion.", "Puntos del taller.", CLOSED_OPTION, INFORMATION_MESSAGE, null, opc, -1);
            switch (num) {
                case 0:
                    Punto1.Vista1();
                    break;
                case 1:
                    Punto2.Vista2();
                    break;
                case 2:
                    Punto3.Inicio3();
                    break;
                case 3:
                    Punto4.Menu4();
                    break;
                case 4:
                    Punto5.Inicio5();
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Se va a cerrar el programa");
                    break;
                default:
                    throw new AssertionError();
            }
            
            
        } while (num != 5);
    
    }
    
}
