import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;

public class CapitalizeServer {
    private ArrayList<Capitalizer> clients = new ArrayList<Capitalizer>();
    static ArrayList<String> mes = new ArrayList<>();

    void start1() throws Exception {
        try (var listener = new ServerSocket(59898)) {
            System.out.println("Сервер запущен...");
            while (true) {
                Capitalizer client = new Capitalizer(listener.accept(), this);
                clients.add(client);
                for (Capitalizer c: clients) System.out.println(c);
                new Thread(client).start();
            }
        }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    void sendToAll(String mes) {
        for (Capitalizer o : clients) {
            System.out.println("send for " + o);
            o.sendMes(mes);
        }
    }
}