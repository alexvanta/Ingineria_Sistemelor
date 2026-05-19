package lab10_final;

import lab4.problema452.Student;

import java.util.Arrays;
import java.util.List;

public class AplicatieCuStrategy {
    private static Student creeazaStudent(int nrMatricol, String prenume, String nume, String formatieDeStudiu, float nota) {
        Student s = new Student(nrMatricol, prenume, nume, formatieDeStudiu);
        s.setNota(nota);
        return s;
    }


    public static void main(String[] args) {
        List<Student> studenti = Arrays.asList(
                creeazaStudent(1025, "Andrei", "Popa", "ISMI41/2", 8.70f),
                creeazaStudent(1024, "Ioan", "Mihalcea", "ISM141/1", 10.0f),
                creeazaStudent(1026, "Anamaria", "Prodan", "TI131/1", 8.90f),
                creeazaStudent(1029, "Bianca", "Popescu", "TI131/1", 10.0f),
                creeazaStudent(1029, "Maria", "Pana", "TI131/2", 4.10f),
                creeazaStudent(1029, "Gabriela", "Mohanu", "TI131/2", 7.33f),
                creeazaStudent(1029, "Marius", "Nasta", "TI131/2", 3.20f),
                creeazaStudent(1029, "Marius", "Nasta", "TI131/1", 5.12f),
                creeazaStudent(1029, "Andrei", "Dobrescu", "TI131/2", 2.22f)
        );

        Exporter exporter = new Exporter();
        Importer importer = new Importer();
        System.out.println("Test Export Consola");

        IStudentiExport strategyConsole = new StudentiInConsola();
        exporter.startExport(strategyConsole, studenti);
        System.out.println("Test Export Fisier Text");
        String fileNameTxt = "studenti_export.txt";
        IStudentiExport strategyFisierText = new StudentiInFisierText(fileNameTxt);
        exporter.startExport(strategyFisierText, studenti);
        System.out.println("Test Import Fisier Text");
        IStudentiImport strategyImportText = new StudentiDinFisierText(fileNameTxt);
        List<Student> studentiImportati = importer.startImport(strategyImportText);
        System.out.println("S-au importat " + studentiImportati.size() + " studenti din fisierul " + fileNameTxt);
        if(!studentiImportati.isEmpty()) {
            System.out.println("Primul student importat este: " + studentiImportati.get(0).toString());
        }
    }
}
