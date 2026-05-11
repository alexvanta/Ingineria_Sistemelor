package lab9;
import java.util.*;
import java.util.stream.Collectors;

public class problema931 {
    public static void main(String[] args){
        Random random = new Random();

        List<Integer> numbers = random.ints(10, 5, 26)
                .boxed()
                .collect(Collectors.toList());
        System.out.println("Lista initiala: " + numbers);
        int suma = numbers.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Suma elementelor: " + suma);

        int max = numbers.stream().max(Comparator.naturalOrder()).orElse(0);
        int min = numbers.stream().min(Comparator.naturalOrder()).orElse(0);
        System.out.println("Max: " + max + " Min: " + min);
        List<Integer> filteredList = numbers.stream()
                .filter(n -> n >= 10 && n <= 20)
                .collect(Collectors.toList());
        System.out.println( "Lista filtrata [10..20]: " + filteredList);
        List<Double> doubleList = numbers.stream()
                .map(n -> Double.valueOf(n))
                .collect(Collectors.toList());
        System.out.println("Lista Double: " + doubleList);

        boolean are12 = numbers.stream().anyMatch(n -> n == 12);
        System.out.println("Se gaseste valoarea 12? " + (are12 ? "Da" : "Nu"));
    }
}
