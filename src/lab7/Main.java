package ro.ulbs.proiectare.lab7;

import ro.ulbs.proiectare.lab7.forms.Circle;
import ro.ulbs.proiectare.lab7.forms.Form;
import ro.ulbs.proiectare.lab7.forms.Square;
import ro.ulbs.proiectare.lab7.forms.Triangle;
import ro.ulbs.proiectare.lab7.util.PasswordMaker;

public class Main {

    public static void main(String[] args) {

        // 7.6.1. Contor instante
        Triangle tri = new Triangle(1.1F, 2.0F, "red");
        Circle c = new Circle(1.5F, "yellow");
        Square sq = new Square(1.2F, "blue");
        System.out.println("Area = " + tri.getArea()+" details: " + tri);
        System.out.println("Area = " + c.getArea() + " details: " + c);
        System.out.println("Area = " + sq.getArea() + " details: " + sq);
        System.out.println("Total instance count is " + Form.getInstanceCount());   // sau tri.getInstanceCount() sau sq.getInstanceCount()

        //7.6.2 Password maker singleton
        PasswordMaker pm2 = PasswordMaker.getInstance();
        System.out.println("\n7.6.2 a+b) Generated passwords: ");
        System.out.println("1:" + PasswordMaker.getInstance().getPassword());
        System.out.println("2:" + PasswordMaker.getInstance().getPassword());
        System.out.println("3:" + PasswordMaker.getInstance().getPassword());
        System.out.println("4:" + pm2.getPassword());
        System.out.println("5:" + pm2.getPassword());
        System.out.println("\n7.6.2 c) Number of time getInstance() has been called: "+PasswordMaker.getCallingCounts());

        System.out.println("\n7.6.3 Imutabilitate");
        java.util.Set<Student> studenti = new java.util.HashSet<>();
        studenti.add(new Student(1, "Ana", "Popescu", "Nedefinit", 9.5f));
        studenti.add(new Student(2, "Mihai", "Ionescu", "Nedefinit", 8.0f));
        studenti.add(new Student(3, "Elena", "Dumitru", "Nedefinit" , 10.0f));
        studenti.add(new Student(4, "Radu", "Stan", "Nedefinit", 7.5f));
        studenti.add(new Student(5, "Ioana", "Vasile", "Nedefinit", 8.8f));

        System.out.println("Studenti initiali: ");
        for(Student s : studenti) System.out.println(s);
        studenti = imparteInDouaFormatii(studenti, "TI 211_1", "TI 211_2");
        System.out.println("Studenti dupa impartire in formatii:");
        for(Student s : studenti) System.out.println(s);

    }
    static Student schimbaFormatia(Student st, String nouaFormatieDeStudiu){
        return new Student(st.getNrMatricol(), st.getPrenume(), st.getNume(), nouaFormatieDeStudiu, st.getNota());
    }

    static java.util.Set<Student> imparteInDouaFormatii(java.util.Set<Student> studenti, String formatia1, String formatia2) {
        java.util.Set<Student> rezultat = new java.util.HashSet<>();

        int jumatate = (int) Math.ceil((double) studenti.size() / 2);
        int contor = 0;
        for(Student st : studenti) {
            if(contor < jumatate) {
                rezultat.add(schimbaFormatia(st, formatia1));
            }
            else{
                rezultat.add(schimbaFormatia(st, formatia2));
            }
            contor++;
        }
        return rezultat;
    }
}
