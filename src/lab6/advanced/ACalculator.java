package ro.ulbs.proiectaresoftware.lab6.advanced;

public abstract class ACalculator<T> {
    protected Object state;

    public abstract ACalculator<T> init();

    public T result() {
        return (T) state;
    }

    public ACalculator<T> clear(){
        return this.init();
    }
}
