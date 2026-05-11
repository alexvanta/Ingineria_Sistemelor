package lab9;
import lab4.problema452.Student;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class problema933 {
    public static void main(String[] args){
        List<Student> studentiCuNote = Arrays.asList(
                new Student(1025, "Andrei", "Popa", "ISM141/2"),
                new Student(1024, "Ioan", "Mihalcea", "ISM141/1"),
                new Student(1026, "Anamaria", "Prodan", "TI131/1"),
                new Student(1029, "Bianca", "Popescu", "TI131/1"),
                new Student(1029, "Maria", "Pana", "TI131/2"),
                new Student(1029, "Gabriela", "Mohanu", "TI131/2"),
                new Student(1029, "Marius", "Nasta", "TI131/2"),
                new Student(1029, "Marius", "Nasta", "TI131/1"),
                new Student(1029, "Andrei", "Dobrescu", "TI131/2")
        );

        studentiCuNote.get(0).setNota(8.70f);
        studentiCuNote.get(1).setNota(10f);
        studentiCuNote.get(2).setNota(8.90f);
        studentiCuNote.get(3).setNota(10f);
        studentiCuNote.get(4).setNota(4.10f);
        studentiCuNote.get(5).setNota(7.33f);
        studentiCuNote.get(6).setNota(3.20f);
        studentiCuNote.get(7).setNota(5.12f);
        studentiCuNote.get(8).setNota(2.22f);

        System.out.println("Studenti cu nota 10: ");
        studentiCuNote.stream()
                .filter(s -> s.getNota() == 10)
                .forEach(System.out::println);

        System.out.println("\n Studenti cu nota sub 5: ");
        studentiCuNote.stream()
                .filter(s -> s.getNota() < 5)
                .forEach(System.out::println);

        List<Student> noteActualizate = studentiCuNote.stream()
                .map(s -> {
                    if(s.getNota() < 4) s.setNota(4);
                    return s;
                })
                .collect(Collectors.toList());

        double sumaNotelor = noteActualizate.stream()
                .map(Student::getNota)
                .reduce(0f, Float::sum);
        System.out.println("\n Suma notelor tuturor studentilor: " + sumaNotelor);

        double media = sumaNotelor / noteActualizate.size();
        System.out.println("Media notelor: " + media);
    }
}
