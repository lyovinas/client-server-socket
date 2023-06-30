import ru.demo.Connection;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {
    public static void main(String[] args) {
        long count = 0;
        try (ServerSocket serverSocket = new ServerSocket(8082)) {
            System.out.println("Server started. Waiting for connection.");
            while (true) {
                Connection connection = new Connection(serverSocket);
                long number = ++count;
                new Thread(() -> {
                    String request = connection.receiveMessage();
                    System.out.println("Request received: " + request);

                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    connection.sendMessage(String.valueOf(number));
                    System.out.println("Response sent: " + number);

                    connection.close();
                }).start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
