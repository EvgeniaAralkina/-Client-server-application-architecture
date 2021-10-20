import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {

    public static final String UNIQUE_BINDING_NAME = "server.quadraticCalculator";

    public static void main(String[] args) throws RemoteException, NotBoundException {

        final Registry registry = LocateRegistry.getRegistry(2000);

        QuadraticCalculator calculator = (QuadraticCalculator) registry.lookup(UNIQUE_BINDING_NAME);

        float a = 3;
        float b = -14;
        float c = -5;

        QuadraticEquation result = calculator.calculate(a, b, c);

        System.out.println(a + "x^2 + " + b + "x + " + c + " = 0\n" +
                "x1 = " + result.x1 + "\nx2 = " + result.x2);
    }
}
