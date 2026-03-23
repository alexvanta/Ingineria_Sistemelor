package lab2;
import java.util.Objects;

public class Student {
    private int nrMatricol;
    private String prenume;
    private String nume;
    private String formatieDeStudiu;

    public Student(int nrMatricol, String prenume, String nume, String formatieDeStudiu) {
        this.nrMatricol = nrMatricol;
        this.prenume = prenume;
        this.nume = nume;
        this.formatieDeStudiu = formatieDeStudiu;
    }

    public String getPrenume(){
        return prenume;
    }
    public String getNume() {
        return nume;
    }
    public String getFormatieDeStudiu() {
        return formatieDeStudiu;
    }

    @Override
    public String toString() {
        return "Student {" + "nrMatricol = " + nrMatricol + ", prenume = '" + prenume + '\'' + ", nume = '" + nume + '\'' + ", formatieDeStudiu = '" + formatieDeStudiu + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(prenume, student.prenume) && Objects.equals(nume, student.nume) && Objects.equals(formatieDeStudiu, student.formatieDeStudiu);
    }
    @Override
    public int hashCode() {
        return Objects.hash(prenume, nume, formatieDeStudiu);
    }
}