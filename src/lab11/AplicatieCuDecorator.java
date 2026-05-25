package ro.ulbs.proiectaresoftware.lab11;
import lab4.problema452.Student;
import lab10_final.IStudentiExport;
import lab10_final.StudentiInConsola;
import lab10_final.StudentiInFisierText;
import java.util.Arrays;
import java.util.List;

public class AplicatieCuDecorator {
    public static void main(String[] args) {
        List<Student> studentiCuNote = Arrays.asList(
                new Student(1025, "Andrei", "Popa", "ISM141/2", 8.78f),
                new Student(1024, "Ioan", "Mihalcea", "ISM141/1", 4.18f),
                new Student(1020, "Anamaria", "Prodan", "TI131/1", 8.90f),
                new Student(1029, "Bianca", "Popescu", "TI131/1", 4.10f),
                new Student(1029, "Maria", "Pana", "TI131/2", 7.38f),
                new Student(1029, "Gabriela", "Mocanu", "TI131/2", 5.12f),
                new Student(1029, "Marius", "Nasta", "TI131/2", 2.22f),
                new Student(1029, "Marius", "Nasta", "TI131/1", 5.12f),
                new Student(1029, "Andrei", "Dobrescu", "TI131/2", 2.22f)
        );

        List<IStudentiExport> strategies = Arrays.asList(
                new StudentiInConsola(),
                new StudentiInFisierText("studenti_export.txt")
        );

        for(IStudentiExport strategy : strategies) {
            TimeExecutionDecorator decorator = new TimeExecutionDecorator(strategy, studentiCuNote);
            Long time = decorator.executionTime();

            System.out.println("Execution time: " + time + " ms for strategy: " + strategy.getClass().getSimpleName());
        }
    }
}
