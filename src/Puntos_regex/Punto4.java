
package Puntos_regex;

import java.util.ArrayList;
import java.util.regex.*;
import javax.swing.JOptionPane;

public class Punto4 {
    public static void Menu4(){
        ArrayList<String> general = new ArrayList<>();
        String regex1 = "[A-Z]\\d{3} \\d{3}-\\d{6}" , regex2 = "1\\d{3}[A-Z]{6}[3-9]{2}", regex3 = "E-ISSN \\d{4}-\\d{4}";
        boolean ban = true;
        do { 
            Pattern p = Pattern.compile(regex1);
            String code = JOptionPane.showInputDialog( "Codigo que su primer caracter sea una letra mayúscula, seguida de 3 números, seguido de un espacio, nuevamente 3 números, el signo \"-\" y finalice con 6 números");
            Matcher m = p.matcher(code);
            if (m.matches()) {
                ban = false;
                general.add(code);
            }
        } while (ban);
        ban = true;
        do { 
            Pattern p = Pattern.compile(regex2);
            String code = JOptionPane.showInputDialog( "Codigo que inicie con 4 números donde el primero sea el 1, seguido de 6 letras en mayúscula y finaliza con 2 número entre el 3 y el 9");
            Matcher m = p.matcher(code);
            if (m.matches()) {
                ban = false;
                general.add(code);
            }
        } while (ban);
        ban = true;
        do { 
            Pattern p = Pattern.compile(regex3);
            String code = JOptionPane.showInputDialog( "Codigo que inicie con la letra \"E\" en mayúscula, seguida del signo \"-\", seguido de las letras en mayúscula \"ISSN\", siguiendo un espacio y 4 números, el signo \"-\" y finalizando con 4 números");
            Matcher m = p.matcher(code);
            if (m.matches()) {
                ban = false;
                general.add(code);
            }
        } while (ban);
        
        String coinci = "11|22|33|44|55|66|77|88|99|00", a = "";
        Pattern p = Pattern.compile(coinci);
        ArrayList<String> resultado = new ArrayList<>();
        for (String string : general) {
            Matcher m = p.matcher(string);
            if (m.find()) {
                resultado.add(string);
                a += string + "\n";
            }
        }
        JOptionPane.showMessageDialog(null, a);
        

    }
}
