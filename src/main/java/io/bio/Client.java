package io.bio;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 6789;

        try (Socket socket = new Socket(host, port);
             InputStream inputStream = socket.getInputStream();
             OutputStream outputStream = socket.getOutputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("Type your messages:");

            while (scanner.hasNext()) {
                String input = scanner.nextLine() + "\n";

                bufferedWriter.write(input);
                bufferedWriter.flush();

                String response = bufferedReader.readLine();
                System.out.println("Server response: " + response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
