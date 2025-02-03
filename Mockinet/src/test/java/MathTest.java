
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.example.Math;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class MathTest {
    @Test
    @DisplayName("Test Add")
    public void testAdd(){
        Math math = new Math();
        int result = math.add(1, 2);
        assertEquals(3, result);
    }
    @Test
    @DisplayName("Test Subtract")
    public void testSubtract(){
        Math math = Mockito.spy(new Math());
        int result = math.subtract(1, 2);
        assertEquals(-1, result);
    }
    @Test
    @DisplayName("Test Multiply")
    public void testMultiply(){
        Math math = Mockito.spy(new Math());
        int result = math.multiply(1, 2);
        assertEquals(2, result);
        Mockito.verify(math, Mockito.times(1)).multiply(1, 2);
    }
  @Test
  @DisplayName("Test Divide")
  public void testDivide() {
    Math math = Mockito.mock(Math.class);
    int result = math.divide(1, 2);
    assertEquals(0, result);
    Mockito.verify(math, Mockito.times(1)).divide(1, 2);
  }

  @Test
  @DisplayName("Test Modulo")
  public void testModulo() {
    Math math = Mockito.mock(Math.class);
    Mockito.when(math.modulo(5, 2)).thenReturn(2);
    int result = math.modulo(5, 2);
    System.out.println(result);
    assertEquals(2, result);
    Mockito.verify(math, Mockito.times(1)).modulo(5, 2);
  }
  @Test
    @DisplayName("Test square")
    public void testSquare(){
      try (MockedStatic<Math> mathMock = Mockito.mockStatic(Math.class)) {
          mathMock.when(()->Math.square(2)).thenReturn(4);
          assertEquals(4, Math.square(2));
      }
    }
}
