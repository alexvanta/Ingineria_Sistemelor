package lab3;

import lab2.Student;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TemaDeCasaLab3 {
    public static void main(String[] args) {
        Path inputPath = Paths.get("studenti_in.txt");
        Path outputPath = Paths.get("studenti_out_sorted.txt");

        try {

            List<String> linii = Files.readAllLines(inputPath);
            List<Student> listaStudenti = new ArrayList<>();

            for (String linie : linii) {
                if (linie.trim().isEmpty()) continue;


                String[] parti = linie.split(",");
                if (parti.length == 4) {
                    int nrMatricol = Integer.parseInt(parti[0].trim());
                    String prenume = parti[1].trim();
                    String nume = parti[2].trim();
                    String formatie = parti[3].trim();

                    listaStudenti.add(new Student(nrMatricol, prenume, nume, formatie));
                }
            }

            Collections.sort(listaStudenti, new Comparator<Student>() {
                @Override
                public int compare(Student s1, Student s2) {
                    int compFormatie = s1.getFormatieDeStudiu().compareToIgnoreCase(s2.getFormatieDeStudiu());

                    if (compFormatie != 0) {
                        return compFormatie;
                    }

                    return s1.getNume().compareToIgnoreCase(s2.getNume());
                }
            });

            List<String> liniiSortate = new ArrayList<>();
            liniiSortate.add("Studenti sortati dupa formatie si nume:");
            for (Student s : listaStudenti) {
                liniiSortate.add(s.toString());
            }

            Files.write(outputPath, liniiSortate);


        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}

