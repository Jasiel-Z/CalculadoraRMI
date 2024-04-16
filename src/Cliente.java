import java.net.MalformedURLException;
import java.nio.charset.MalformedInputException;
import java.rmi.RemoteException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.NotBoundException;
import javax.swing.JOptionPane;


public class Cliente {
    public static void main(String[] args){
        try{
            int puerto = 9000;
            String servidor = "localhost";
            Calculadora cal = (Calculadora) Naming.lookup("rmi://" + servidor + ":" + puerto + "/Calculadora");
            while(true){
                String opt = JOptionPane.showInputDialog(
                    "Calcular\n" +
                    "Suma............ (1)\n" +
                    "Resta........... (2)\n" +
                    "Multip.......... (3)\n" +
                    "Div............. (4)\n\n" +
                    "Cancelar para salir"
                );

                if (opt == null){
                    break;
                }

                int a = Integer.parseInt(JOptionPane.showInputDialog("Ingrese a "));
                int b = Integer.parseInt(JOptionPane.showInputDialog("Ingrese b "));

                switch (opt) {
                    case "1":
                        JOptionPane.showMessageDialog(null, a + "+" + b + " = " + cal.sum(a,b));
                        break;
                
                    case "2":
                        JOptionPane.showMessageDialog(null, a + "-" + b + " = " + cal.res(a,b));
                        break;

                    case "3":
                    JOptionPane.showMessageDialog(null, a + "*" + b + " = " + cal.mult(a,b));
                    break;
                    
                    case "4": 
                    JOptionPane.showMessageDialog(null, a + "/" + b + " = " + cal.div(a,b));
                    break;
                }

            }

        }catch(RemoteException | NotBoundException ex){
            JOptionPane.showMessageDialog(null, "No se pudo conectar al servidor:\n" + ex);
        }catch(MalformedURLException ex){
            JOptionPane.showMessageDialog(null, "La URL no está en un formato correcto:\n" + ex);
        }
    }
}
