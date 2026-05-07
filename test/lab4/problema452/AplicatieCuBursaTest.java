package lab4.problema452;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class AplicatieCuBursaTest {

    @Test
    public void sortTest1(){
        AplicatieCuBursa appCuBursa = new AplicatieCuBursa();
        List<StudentBursier> lista = appCuBursa.genereaza();
        List<StudentBursier> sortata = appCuBursa.sorteaza(lista);
        Assertions.assertEquals("Mihalcea", sortata.get(0).getNume());
        Assertions.assertEquals("Popa", sortata.get(1).getNume());
        Assertions.assertEquals("Popescu", sortata.get(2).getNume());
        Assertions.assertEquals(100.00, sortata.get(2).getCuantumBursa());
        Assertions.assertEquals("Popescu",sortata.get(3).getNume());
        Assertions.assertEquals(780.80, sortata.get(3).getCuantumBursa());
        Assertions.assertEquals("Prodan", sortata.get(4).getNume());
    }
}
