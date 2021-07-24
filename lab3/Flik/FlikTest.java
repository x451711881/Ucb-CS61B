import static org.junit.Assert.*;

import org.junit.Test;

public class FlikTest {
  @Test
  public void testFlik(){
      int a = 128, b = 128, c = 1;
      assertTrue(Flik.isSameNumber(a,b));
      assertTrue("Flik.isSameNumber(a,b)", true);
    }
}
