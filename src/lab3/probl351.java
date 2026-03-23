package lab3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class probl351 {
    public static void main(String[] args){
        try{
            Path inputPath = Paths.get("in.txt");
            Path outputPath = Paths.get("output.txt");
            List<String> linii = Files.readAllLines(inputPath);
            List<String> rezultat = new ArrayList<>();
            System.out.println("a)");
            rezultat.add("Rezultat a): ");
            for(String linie : linii){
                String linieModificata = linie + "\n";
                System.out.println(linieModificata);
                rezultat.add(linieModificata);
            }
            System.out.println("b)");
            rezultat.add("Rezultat b): ");
            for(String linie : linii) {
                String liniePuncte = linie.replace(".", ".\n");
                System.out.println(liniePuncte);
                rezultat.add(liniePuncte);
            }
            Files.write(outputPath,rezultat);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
