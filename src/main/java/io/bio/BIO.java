package io.bio;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BIO {
    private int port;
    private int maxConnection;
    private ExecutorService fixedThreadPool;

    public BIO(int port, int maxConnection) {
        this.port = port;
        this.maxConnection = maxConnection;
        fixedThreadPool = Executors.newFixedThreadPool(maxConnection);
    }

    public void start() {
        System.out.println("Bio server start");
        new Thread(() -> {
            // Socket for handling incoming connections
            try (ServerSocket serverSocket = new ServerSocket(port)) {
                while (true) {
                    // Sockets for handling the actual work
                    Socket clientSocket = serverSocket.accept();

                    fixedThreadPool.submit(() -> clientHandler(clientSocket));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }

    public void clientHandler(Socket clientSocket) {
        System.out.println("Handle: " + clientSocket + " request");
        try (clientSocket;
             InputStream inputStream = clientSocket.getInputStream();
             OutputStream outputStream = clientSocket.getOutputStream();
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {

            String request;
            while ((request = bufferedReader.readLine()) != null) {
                System.out.println("Client request: " + request);

                bufferedWriter.write("received\n");
                bufferedWriter.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        fixedThreadPool.shutdown();
    }

    public static void main(String[] args) {
        BIO bio = new BIO(6789, 5);
        bio.start();
    }
}
