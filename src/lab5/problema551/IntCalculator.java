package lab5.problema551;

public class IntCalculator {
    protected int state;

    public IntCalculator(int state){
        this.state = state;
    }

    public IntCalculator add(int value){
        this.state += value;
        return this;
    }

    public IntCalculator substract(int value){
        this.state -= value;
        return this;
    }

    public IntCalculator multiply(int value){
        this.state *= value;
        return this;
    }

    public int result() {
        return this.state;
    }

    public IntCalculator clear() {
        this.state = 0;
        return this;
    }
}
