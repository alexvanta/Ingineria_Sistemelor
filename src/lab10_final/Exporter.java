package lab10_final;

import lab4.problema452.Student;

import java.util.List;

public class Exporter {
    public void startExport(IStudentiExport strategyInstance, List<Student> students) {
        strategyInstance.doExport(students);
    }
}
