public class PingPong {
    boolean doPing = false;

    // Метод, возвращающий число
    synchronized void sayPing() {
        while (doPing) {
            try {
                wait();
            }
            catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("ping");
        doPing=true;
        notify();
    }

    synchronized void sayPong() {
        while (!doPing) {
            try {
                wait();
            }
            catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("pong");
        doPing=false;
        notify();
    }
}
