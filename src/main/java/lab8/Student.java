package lab8;

import java.util.Objects;

public class Student {
    private int nrMatricol;
    private String prenume;
    private String nume;
    private String formatieDeStudiu;
    private float nota;

    public Student(int nrMatricol, String prenume, String nume, String formatieDeStudiu){
        this.nrMatricol = nrMatricol;
        this.prenume = prenume;
        this.nume = nume;
        this.formatieDeStudiu = formatieDeStudiu;
    }
    public void setNota(float nota){
        this.nota = nota;
    }
    public int getNrMatricol(){
        return nrMatricol;
    }
    @Override
    public String toString(){
        return "Student{" + "nrMatricol = " + nrMatricol + ", nume = '" + nume + '\'' + ", nota = " + nota + '}';
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

    public String getPrenume() {
        return prenume;
    }
    public String getNume() {
        return nume;
    }
    public String getFormatieDeStudiu(){
        return formatieDeStudiu;
    }
    public float getNota(){
        return nota;
    }
}
