package lab4.problema452;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class AppLab5_3 {
    public static void main(String[] args) {
        Set<StudentBursier> bursieri = new HashSet<>();

        bursieri.add( new StudentBursier(1025,"Andrei","Popa","ISM141/2", 8.70f, 725.50));
        bursieri.add( new StudentBursier(1024,"Ioan","Mihalcea","ISM141/1", 9.80f, 801.10));
        bursieri.add( new StudentBursier(1026,"Anamaria","Prodan","TI131/1", 8.90f, 745.50));
        bursieri.add( new StudentBursier(1029,"Bianca","Popescu","TI131/1,", 9.10f, 780.80));

        writeToFile("bursieri_out.txt", bursieri);
    }
    static void writeToFile(String filename, Collection<? extends Student> studenti) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for(Student s : studenti) {
                writer.write(s.toString());
                writer.newLine();
            }
            System.out.println("Lista de bursieri a fost salvata in: " + filename);
        }
        catch (IOException e){
            System.err.println("Eroare la scrierea in fisier: " + e.getMessage());
        }
    }
}
