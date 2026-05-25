package ro.ulbs.proiectaresoftware.lab11;

import lab10_final.IStudentiExport;
import lab4.problema452.Student;
import java.util.List;

public class TimeExecution {
    protected IStudentiExport strategy;
    public TimeExecution(IStudentiExport strategy) {
        this.strategy = strategy;
    }

    public Long executionTime(List<Student> studenti) {
        long startTime = System.currentTimeMillis();
        strategy.doExport(studenti);
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }
}
