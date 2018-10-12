import io.github.guilhermedelemos.blackjack.Baralho;
import io.github.guilhermedelemos.blackjack.Carta;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ExemploMockTest {
    
    @Test
    public void exemploTest() {
        // Mock
        Baralho baralhoMock = mock(Baralho.class);
        when(baralhoMock.puxar()).thenReturn(new Carta("A", 10, "Ouros"));
        
        // Test
        Carta carta = baralhoMock.puxar();
        assertEquals(Integer.valueOf(10), carta.getValor());
    }
    
}
