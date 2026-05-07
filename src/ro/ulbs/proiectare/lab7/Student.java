package ro.ulbs.proiectare.lab7;

import java.util.Objects;

public class Student {
    private final int nrMatricol;
    private final String prenume;
    private final String nume;
    private final String formatieDeStudiu;
    private final float nota;

    public Student(int nrMatricol, String prenume, String nume, String formatieDeStudiu, float nota){
        this.nrMatricol = nrMatricol;
        this.prenume = prenume;
        this.nume = nume;
        this.formatieDeStudiu = formatieDeStudiu;
        this.nota = nota;
    }

    public int getNrMatricol(){
        return nrMatricol;
    }
    public String getPrenume(){
        return prenume;
    }
    public String getNume(){
        return nume;
    }
    public String getFormatieDeStudiu(){
        return formatieDeStudiu;
    }
    public float getNota(){
        return nota;
    }

    @Override
    public String toString() {
        return "Student{" + "nr=" + nrMatricol + ", nume=" + nume + " " + prenume + '\'' + ", formatie='" + formatieDeStudiu + '\'' + "}";
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof Student)) return false;
        Student student = (Student) o;
        return nrMatricol == student.nrMatricol;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nrMatricol);
    }
}
