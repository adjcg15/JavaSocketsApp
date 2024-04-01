import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Cliente {
    public static void main(String[] args) {
        int port = 8080;

        try {
            Socket cs = new Socket("localhost", port);

            PrintWriter out = new PrintWriter(cs.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(cs.getInputStream()));

            String receivedLine;
            while (!(receivedLine = in.readLine()).equalsIgnoreCase("Adios")) {
                System.out.println("Servidor: " + receivedLine);
            }

            out.println("Despedida desde el cliente...");
            out.close();
            in.close();
            cs.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}
