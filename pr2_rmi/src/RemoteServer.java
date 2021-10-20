import java.rmi.RemoteException;
import static java.lang.Float.NaN;
import static java.lang.Math.sqrt;

public class RemoteServer implements QuadraticCalculator {

    private static final long serialVersionUID = 1L;
    QuadraticEquation qe;

    @Override
    public QuadraticEquation calculate(float a, float b, float c) throws RemoteException {
        float x1 =NaN;
        float x2 = NaN;
        float d = b*b - 4*a*c;
        if (d>0) {
            x1 = (float) ((-b + sqrt(d))/(2*a));
            x2 = (float) ((-b - sqrt(d))/(2*a));
        }
        if (d == 0){
            x1 = -b/(2*a);
        }
        qe = new QuadraticEquation(a,b,c, x1, x2);
        return qe;
    }
}