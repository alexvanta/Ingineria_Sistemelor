package lab2;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {


    public static boolean existaStudent(Set<Student> setStudenti, Student studentCautat) {
        return setStudenti.contains(studentCautat);
    }
    public static void main(String[] args) {
        List<Student> listaStudenti = new ArrayList<>();
        Student student1 = new Student(599, "Alexandru", "Vanta", "Grupa 211");
        Student student2 = new Student(112, "Maria", "Popa", "TI21/1");

        listaStudenti.add(student1);
        listaStudenti.add(student2);

        for(Student student : listaStudenti) {
            System.out.println(student);
        }

        Set<Student> setStudenti = new HashSet<>(listaStudenti);

        Student alis = new Student(120, "Alis", "Popa", "TI21/2");
        boolean esteAlis = existaStudent(setStudenti, alis);
        System.out.println("Este prezent studentul Alis Popa?" + esteAlis);


        Student maria = new Student(112, "Maria", "Popa", "TI21/1");
        boolean esteMaria = existaStudent(setStudenti, maria);
        System.out.println("Este prezent studentul Maria?" + esteMaria);
    }
}