package http;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpServer;

import java.io.OutputStream;
import java.net.InetSocketAddress;

public class Server {
    int port;
    int maxConnection;
    HttpServer server;

    public Server(int port, int maxConnection) {
        this.port = port;
        this.maxConnection = maxConnection;
        try {
            server = HttpServer.create(new InetSocketAddress(port), maxConnection);
            HttpContext pageDefault = server.createContext("/");
            pageDefault.setHandler(exchange -> {
                try (exchange;
                     OutputStream responseBody = exchange.getResponseBody()) {

                    exchange.sendResponseHeaders(200, 0);
                    String content = "<h1 align=\"center\">Server Start</h1>";
                    responseBody.write(content.getBytes());
                    responseBody.flush();
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void start() {
        server.start();
    }

    public static void main(String[] args) {
        Server server = new Server(6789, 5);
        server.start();
    }
}
