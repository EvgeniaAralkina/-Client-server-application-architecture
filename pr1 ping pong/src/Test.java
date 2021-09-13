public class Test {
    public static void main(String[] args) throws InterruptedException {
        PingPong pingPong = new PingPong();
        new PingThread(pingPong);
        new PongThread(pingPong);
    }
}
