package lab8;
import lab8.Student;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import java.io.*;
import java.util.*;

public class problema854 {
    public static void main(String[] args) {
        String xlsFileName = "laborator8_students.xls";

        Set<Student> studenti = new HashSet<>();
        Student s1 = new Student(201, "Andrei", "Popa", "ISM1");
        s1.setNota(9.20f);
        Student s2 = new Student(202, "Elena", "Radu", "ISM1");
        s2.setNota(10.0f);

        studenti.add(s1);
        studenti.add(s2);

        writeToXls(studenti, xlsFileName);

        List<Student> studentsFromXls = readFromXls(xlsFileName);

        System.out.println("\n--- Studenti cititi din fisierul .xls ---");
        for (Student st : studentsFromXls) {
            System.out.println(st);
        }
    }

    public static void writeToXls(Set<Student> studenti, String fileName) {

        try (Workbook wb = new HSSFWorkbook();
             OutputStream fileOut = new FileOutputStream(fileName)) {

            Sheet sheet = wb.createSheet("Studenti");
            int rowNum = 0;

            for (Student s : studenti) {
                Row row = sheet.createRow(rowNum++);

                row.createCell(0).setCellValue(s.getNrMatricol());
                row.createCell(1).setCellValue(s.getNume());
                row.createCell(2).setCellValue(s.getPrenume());
                row.createCell(3).setCellValue(s.getFormatieDeStudiu());
                row.createCell(4).setCellValue(s.getNota());
            }

            wb.write(fileOut);
            System.out.println("Lista a fost exportată cu succes în " + fileName);

        } catch (IOException e) {
            System.err.println("Eroare la scriere: " + e.getMessage());
        }
    }

    public static List<Student> readFromXls(String fileName) {
        List<Student> listaStudenti = new ArrayList<>();

        try (InputStream in = new FileInputStream(fileName);
             Workbook wb = new HSSFWorkbook(in)) {

            Sheet sheet = wb.getSheetAt(0);

            for (Row row : sheet) {

                int nrMatricol = (int) row.getCell(0).getNumericCellValue();
                String nume = row.getCell(1).getStringCellValue();
                String prenume = row.getCell(2).getStringCellValue();
                String formatie = row.getCell(3).getStringCellValue();
                float nota = (float) row.getCell(4).getNumericCellValue();

                Student s = new Student(nrMatricol, prenume, nume, formatie);
                s.setNota(nota);
                listaStudenti.add(s);
            }
        } catch (IOException e) {
            System.err.println("Eroare la citire: " + e.getMessage());
        }
        return listaStudenti;
    }
}

