package ro.ulbs.proiectaresoftware.lab11;
import lab10_final.IStudentiExport;
import lab4.problema452.Student;

import java.sql.Time;
import java.util.List;

public class TimeExecutionDecorator extends TimeExecution {
    private List<Student> studenti;

    public TimeExecutionDecorator(IStudentiExport exporter, List<Student> studenti) {
        super(exporter);
        this.studenti = studenti;
    }

    public long executionTime() {
        Long execTime = super.executionTime(studenti);
        return execTime;
    }
}
