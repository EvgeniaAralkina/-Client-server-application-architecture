import java.io.Serializable;

public class QuadraticEquation implements Serializable{
    private static final long serialVersionUID = 1L;

    float a;
    float b;
    float c;
    float x1;
    float x2;

    public QuadraticEquation(float a, float b, float c, float x1, float x2) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.x1 = x1;
        this.x2 = x2;
    }

    public float getA() {
        return a;
    }

    public void setA(float a) {
        this.a = a;
    }

    public float getB() {
        return b;
    }

    public void setB(float b) {
        this.b = b;
    }

    public float getC() {
        return c;
    }

    public void setC(float c) {
        this.c = c;
    }

    public float getX1() {
        return x1;
    }

    public void setX1(float x1) {
        this.x1 = x1;
    }

    public float getX2() {
        return x2;
    }

    public void setX2(float x2) {
        this.x2 = x2;
    }
}
