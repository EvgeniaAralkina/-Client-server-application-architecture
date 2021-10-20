import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Capitalizer implements Runnable {
    private Socket socket;
    Scanner in;
    PrintWriter out;
    CapitalizeServer cs;

    Capitalizer(Socket socket,CapitalizeServer cs ) throws IOException {
        this.socket = socket;
        this.in = new Scanner(socket.getInputStream());
        this.out = new PrintWriter(socket.getOutputStream(), true);
        this.cs = cs;
    }

    @Override
    public void run() {
        System.out.println("Подключение: " + socket);
        try {
            while (true){
                if (in.hasNextLine()) {
                    String h = in.nextLine();
                    System.out.print("get new message " + h + "\n");
                    cs.mes.add(h);
                }
                TimeUnit.SECONDS.sleep(10);
                if (!(cs.mes.isEmpty())) {
                    cs.mes.add("end");
                    for (String i : cs.mes) {
                        cs.sendToAll(i);
                    }
                    cs.mes.clear();
                }
            }
        } catch (Exception e) {
            System.out.println("Ошибка:" + socket);
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
            }
            System.out.println("Closed: " + socket);
        }
    }
    void sendMes(String mes){
        try {
            out.println(mes);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
