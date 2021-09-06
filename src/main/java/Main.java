import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Задача \"Клиент-серверное приложение\" (client)");
        //C:\Windows\System32\drivers\etc\hosts
        String host = "netology.homework";//"localhost";//"127.0.0.1";
        int port = 9533;

        Scanner scan = new Scanner(System.in);

        //names.add("shuthodnw");
        while (true){
            try (Socket clientSocket = new Socket(host, port);
                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

                String serverText = in.readLine();
                System.out.println(serverText);

                String myText = scan.nextLine();
                out.println(myText);

                serverText = in.readLine();
                System.out.println(serverText);

                myText = scan.nextLine();
                out.println(myText);

                serverText = in.readLine();
                System.out.println(serverText);
                serverText = in.readLine();
                System.out.println(serverText);

                myText = scan.nextLine();
                out.println(myText);
                if (myText.equalsIgnoreCase("yes")) {
                    serverText = in.readLine();
                    System.out.println(serverText);
                    serverText = in.readLine();
                    System.out.println(serverText);
                    break;
                }

            }catch (IOException ex){
                System.out.println(ex);
                System.out.println("Application has shut down");
                break;
            }
        }



    }

}
