package lab10_final;

import lab4.problema452.Student;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class StudentiInFisierText implements IStudentiExport {
    private String fileName;

    public StudentiInFisierText(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void doExport(List<Student> studenti){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for(Student s : studenti) {
                writer.write(s.getNrMatricol() + ";" + s.getPrenume() + ";" + s.getNume() + ";" + s.getFormatieDeStudiu() + ";" + s.getNota());
                writer.newLine();
            }
            System.out.println("Export cu succes in " + fileName);
        } catch (IOException e) {
            System.out.println("Eroare la scrierea in fisier txt: " + e.getMessage());
        }
    }
}
