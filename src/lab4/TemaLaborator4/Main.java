package lab4.TemaLaborator4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args){
        Path inputPath = Paths.get("studenti_in.txt");
        Path notesPath = Paths.get("note_anon.txt");
        try{
            List<String> liniiStudenti = Files.readAllLines(inputPath);
            Map<Integer, Student> mapStudenti = new HashMap<>();
            for(String linie : liniiStudenti) {
                if(linie.trim().isEmpty()) continue;
                String[] parti = linie.split(",");
                if(parti.length >= 4){
                    int nrMat = Integer.parseInt(parti[0].trim());
                    mapStudenti.put(nrMat, new Student(nrMat, parti[1].trim(), parti[2].trim(), parti[3].trim()));
                }
            }
            if(Files.exists(notesPath)){
                List<String> liniiNote = Files.readAllLines(notesPath);
                for(String linie : liniiNote) {
                    String[] parti = linie.split(",");
                    if(parti.length == 2){
                        int nrMatricolNota = Integer.parseInt(parti[0].trim());
                        float valoareNota = Float.parseFloat(parti[1].trim());
                        if(mapStudenti.containsKey(nrMatricolNota)){
                            mapStudenti.get(nrMatricolNota).setNota(valoareNota);
                        }
                    }
                }
            }
            mapStudenti.values().forEach(System.out::println);
            float notaM = gasesteNota("Bianca", "Popescu", mapStudenti);
            System.out.println("Nota gasita pentru Bianca Popescu este: " + notaM);

            float notaN = gasesteNota("Ioan", "Popa", mapStudenti);
            System.out.println("Nota gasita pentru Ioan Popa este: " + notaN);
        }
        catch(IOException e){
            e.printStackTrace();
        }
        catch(NumberFormatException e){
            e.printStackTrace();
        }
    }
    public static float gasesteNota(String prenume, String nume, Map<Integer, Student> tineri){
        Map<String, Student> mapNume = new HashMap<>();
        for(Student s : tineri.values()) {
            mapNume.put(s.getPrenume() + "-" + s.getNume(), s);
        }
        String cautat = prenume + "-" + nume;
        if(mapNume.containsKey(cautat)) {
            return mapNume.get(cautat).getNota();
        }
        return 0.0f;
    }
}
