import java.rmi.Remote;
import java.rmi.RemoteException;

public interface QuadraticCalculator extends Remote {
    QuadraticEquation calculate(float a, float b, float c) throws RemoteException;
}