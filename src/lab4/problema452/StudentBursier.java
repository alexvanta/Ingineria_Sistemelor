package lab4.problema452;

import java.util.Objects;

public class StudentBursier extends Student {
    private double cuantumBursa;

    public StudentBursier(int nrMatricol, String prenume, String nume, String formatieDeStudiu, float nota, double cuantumBursa) {
        super(nrMatricol, prenume, nume, formatieDeStudiu);
        this.setNota(nota);
        this.cuantumBursa = cuantumBursa;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof StudentBursier)) return false;
        if(!super.equals(o)) return false;
        StudentBursier that = (StudentBursier) o;
        return Double.compare(that.cuantumBursa, cuantumBursa) == 0;
    }

    @Override
    public int hashCode(){
        return Objects.hash(super.hashCode(), cuantumBursa);
    }

    @Override
    public String toString() {
        return super.toString() + "Cuantum bursa: " + cuantumBursa;
    }
    public double getCuantumBursa(){
        return cuantumBursa;
    }
}
