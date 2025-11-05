import org.junit.jupiter.api.*;
import com.ifsc.tdd_teste.Intervalo;

public class IntervaloTeste {
    private final Intervalo intervalo = new Intervalo(3,4,5);
    
    @Test
    @DisplayName("intervalos")
    public void testaIntervalos(){
        Intervalo intervalo = new Intervalo(3,4,5);
        Intervalo intervalo2 = new Intervalo(6,7,8);
        
        Assertions.assertEquals(3, intervalo.horas());
        Assertions.assertEquals(4, intervalo.minutos());
        Assertions.assertEquals(5, intervalo.segundos());
    }
    @Test
    @DisplayName("Total de minutos do intervalo.")
    public void testaTotalMinutos(){
        Assertions.assertEquals(180, intervalo.totalMinutos());
    }
}
