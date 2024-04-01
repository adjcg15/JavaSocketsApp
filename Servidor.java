import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor {
    public static void main(String[] args) {
        int port = 8080;

        try {
            ServerSocket ss = new ServerSocket(port);
            System.out.println("Servidor escuchando en el puerto " + port + "...");

            Socket ch = ss.accept();

            PrintWriter out = new PrintWriter(ch.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(ch.getInputStream()));

            Scanner scanner = new Scanner(System.in);
            String sentLine = "Hola mundo desde servidor de Angel";
            while (!(sentLine).equalsIgnoreCase("Adios")) {
                out.println(sentLine);
                sentLine = scanner.nextLine();
            }
            out.println(sentLine);

            System.out.println("Cliente: " + in.readLine());
            
            out.close();
            in.close();
            ch.close();
            ss.close();
            scanner.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}