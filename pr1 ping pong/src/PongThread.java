public class PongThread implements Runnable{
    PingPong pp;
    Thread thread;

    public PongThread(PingPong pp) {
        this.pp = pp;

        thread = new Thread(this, "SayPong");
        thread.start();
    }

    public void run(){
        while (true) {
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            pp.sayPong();
        }
    }
}
