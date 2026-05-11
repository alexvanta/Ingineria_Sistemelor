package lab9;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.*;

public class problema932 {
    public static void main(String[] args){
        String text = "Acesta este un program scris in java pentru expresii lambda";
        List<String> cuvinte = Arrays.asList(text.split(" "));
        List<String> cuvinteLungi = cuvinte.stream()
                .filter(s -> s.length() >= 5)
                .collect(Collectors.toList());
        System.out.println("Lista filtrata (lungime >= 5): " + cuvinteLungi);
        System.out.println("Numarul de cuvinte gasite: " + cuvinteLungi.size());

        List<String> ordonate = cuvinteLungi.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Lista ordonata: " + ordonate);
        System.out.println("Un element care incepe cu 'p': ");
        cuvinte.stream()
                .filter(s -> s.startsWith("p"))
                .findFirst()
                .ifPresent(System.out::println);
    }
}
