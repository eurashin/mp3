package jenkins.model;
import jenkins.model.IdStrategy;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class IdTest {
    @Test
    public void testLegalString() {
        IdStrategy strategy = new IdStrategy.CaseSensitive(); 
        String filename = "legal.txt";
        String id = strategy.idFromFilename(filename); 
        assertEquals(id, filename); 
    }
    
    @Test
    public void testDollarSignChanged() {
        IdStrategy strategy = new IdStrategy.CaseSensitive(); 
        String filename = "legal$to$";
        String id = strategy.idFromFilename(filename); 
        assertThat(id, not(equalTo(filename))); //should go from $ to hex 
    }
    
    @Test
    public void testTildeSignChanged() {
        IdStrategy strategy = new IdStrategy.CaseSensitive(); 
        String filename = "legal~to";
        String id = strategy.idFromFilename(filename); 
        assertThat(id, not(equalTo(filename)));  
    }
}
