public class PingThread implements Runnable{

    PingPong pp;
    Thread thread;

    public PingThread(PingPong pp) {
        this.pp = pp;

        thread = new Thread(this, "SayPing");
        thread.start();
    }

    public void run(){
        while(true) {
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            pp.sayPing();
        }
    }
}



