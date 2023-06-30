import ru.demo.Connection;

public class Client {
    public static void main(String[] args) {
        try (Connection connection = new Connection("localhost", 8082)) {
            String request = "Next number";
            connection.sendMessage(request);
            System.out.println("Request sent: " + request);

            String response = connection.receiveMessage();
            System.out.println("Response received: " + response);
        }
    }
}
