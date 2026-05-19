package lab10_final;

import lab4.problema452.Student;

import java.util.List;

public class StudentiInConsola implements IStudentiExport {
    @Override
    public void doExport(List<Student> studenti) {
        System.out.println("Exportare studenti in consola");
        for(Student s : studenti) {
            System.out.println(s.toString());
        }
    }
}
