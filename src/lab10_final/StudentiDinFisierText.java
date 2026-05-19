package lab10_final;

import lab4.problema452.Student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentiDinFisierText  implements IStudentiImport {
    private String fileName;

    public StudentiDinFisierText(String fileName) {
        this.fileName = fileName;
    }
    @Override
    public List<Student> doImport() {
        List<Student> studenti = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if(parts.length == 5) {
                    Student st = new Student(Integer.parseInt(parts[0]), parts[1], parts[2], parts[3]);
                    st.setNota(Float.parseFloat(parts[4]));
                    studenti.add(st);
                }
            }
            System.out.println("Import cu succes din " + fileName);
        } catch (IOException e) {
            System.out.println("Eroare la citirea din fisier txt: " + e.getMessage());
        }
        return studenti;
    }
}
