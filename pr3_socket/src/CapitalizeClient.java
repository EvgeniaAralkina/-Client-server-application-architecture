import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class CapitalizeClient {
    public static void main(String[] args) throws Exception {
        String ipAd = "127.0.0.1";
        try (var socket = new Socket(ipAd, 59898)) {
            System.out.println("Введите строки текста, затем Ctrl + D или Ctrl + C, чтобы выйти");
            var scanner = new Scanner(System.in);
            var in = new Scanner(socket.getInputStream());
            var out = new PrintWriter(socket.getOutputStream(), true);

            while (scanner.hasNextLine()) {
                out.println(scanner.nextLine());
                messages(in);
            }
        }
    }
    static void messages(Scanner in){
        String mes = in.nextLine();
        while (!(mes.equals("end"))) {
            System.out.println(mes);
            mes = in.nextLine();
        }
    }
}
