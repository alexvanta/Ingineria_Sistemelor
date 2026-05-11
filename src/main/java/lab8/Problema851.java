package lab8;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileOutputStream;
import java.io.OutputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

public class Problema851 {
    public static void main(String[] args){
        File file = new File("laborator8_input.xlsx");
        System.out.println("Se citeste fisierul initial");
        readFile(file);

        System.out.println("\n Se genereaza noul fisier cu media");
        genereazaFisierCuMedie(file);

        System.out.println("\n Se genereaza noul fisier cu formula");
        genereazaFisierCuFormula(file);
    }

    public static void readFile(final File file) {
        try(InputStream in = new FileInputStream(file);
            Workbook workbook = new XSSFWorkbook(in)) {
            Sheet sheet = workbook.getSheetAt(0);

            for(Row row : sheet) {
                for(Cell cell : row){
                    switch (cell.getCellType()){
                        case STRING:
                            System.out.println((cell.getStringCellValue() + "\t\t"));
                            break;
                        case NUMERIC:
                            System.out.println(cell.getNumericCellValue() + "\t\t");
                            break;
                        default:
                            System.out.println("N/A" + "\t\t");
                    }
                }
                System.out.println();
            }
        }catch (final IOException ex) {
            System.err.println("Eroare la citire: " + ex.getMessage());
        }
    }
    public static void genereazaFisierCuMedie(final File inputFile) {
        File outputFile = new File("laborator8_output2.xlsx");

        try (InputStream in = new FileInputStream(inputFile);
             Workbook inputWorkbook = new XSSFWorkbook(in);
             Workbook outputWorkbook = new XSSFWorkbook()) {

            Sheet inputSheet = inputWorkbook.getSheetAt(0);
            Sheet outputSheet = outputWorkbook.createSheet(inputSheet.getSheetName());

            for (int i = 0; i <= inputSheet.getLastRowNum(); i++) {
                Row inputRow = inputSheet.getRow(i);
                if (inputRow == null) continue;

                Row outputRow = outputSheet.createRow(i);
                int lastCellNum = inputRow.getLastCellNum();

                for (int j = 0; j < lastCellNum; j++) {
                    Cell inputCell = inputRow.getCell(j);
                    Cell outputCell = outputRow.createCell(j);

                    if (inputCell != null) {
                        switch (inputCell.getCellType()) {
                            case STRING:
                                outputCell.setCellValue(inputCell.getStringCellValue());
                                break;
                            case NUMERIC:
                                outputCell.setCellValue(inputCell.getNumericCellValue());
                                break;
                            default:
                                outputCell.setCellValue("");
                        }
                    }
                }

                Cell newCell = outputRow.createCell(lastCellNum);

                if (i == 0) {

                    newCell.setCellValue("Media");
                } else {

                    try {
                        double nota1 = inputRow.getCell(lastCellNum - 3).getNumericCellValue();
                        double nota2 = inputRow.getCell(lastCellNum - 2).getNumericCellValue();
                        double nota3 = inputRow.getCell(lastCellNum - 1).getNumericCellValue();

                        double media = (nota1 + nota2 + nota3) / 3.0;
                        newCell.setCellValue(media);
                    } catch (Exception e) {

                        newCell.setCellValue("Eroare calcul");
                    }
                }
            }


            try (OutputStream fileOut = new FileOutputStream(outputFile)) {
                outputWorkbook.write(fileOut);
            }

            System.out.println("Fisierul laborator8_output2.xlsx a fost generat cu succes!");

        } catch (IOException ex) {
            System.err.println("A aparut o eroare la generarea fisierului: " + ex.getMessage());
        }
    }
    public static void genereazaFisierCuFormula(final File inputFile) {

        File outputFile = new File("laborator8_output3.xlsx");

        try (InputStream in = new FileInputStream(inputFile);
             Workbook inputWorkbook = new XSSFWorkbook(in);
             Workbook outputWorkbook = new XSSFWorkbook()) {

            Sheet inputSheet = inputWorkbook.getSheetAt(0);
            Sheet outputSheet = outputWorkbook.createSheet(inputSheet.getSheetName());

            for (int i = 0; i <= inputSheet.getLastRowNum(); i++) {
                Row inputRow = inputSheet.getRow(i);
                if (inputRow == null) continue;

                Row outputRow = outputSheet.createRow(i);
                int lastCellNum = inputRow.getLastCellNum();

                for (int j = 0; j < lastCellNum; j++) {
                    Cell inputCell = inputRow.getCell(j);
                    Cell outputCell = outputRow.createCell(j);

                    if (inputCell != null) {
                        switch (inputCell.getCellType()) {
                            case STRING:
                                outputCell.setCellValue(inputCell.getStringCellValue());
                                break;
                            case NUMERIC:
                                outputCell.setCellValue(inputCell.getNumericCellValue());
                                break;
                            default:
                                outputCell.setCellValue("");
                        }
                    }
                }
                Cell newCell = outputRow.createCell(lastCellNum);

                if (i == 0) {
                    newCell.setCellValue("Media (Formula)");
                } else {

                    int excelRow = i + 1;
                    newCell.setCellFormula("AVERAGE(D" + excelRow + ":F" + excelRow + ")");
                }
            }

            try (OutputStream fileOut = new FileOutputStream(outputFile)) {
                outputWorkbook.write(fileOut);
            }

            System.out.println("Fisierul laborator8_output3.xlsx a fost generat cu succes folosind formule!");

        } catch (Exception ex) {
            System.err.println("A aparut o eroare la generarea fisierului cu formule: " + ex.getMessage());
        }
    }
}
