public class startMain {
    public static void main(String[] args) {
        CapitalizeServer cp = new CapitalizeServer();
        try {
            cp.start1();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
