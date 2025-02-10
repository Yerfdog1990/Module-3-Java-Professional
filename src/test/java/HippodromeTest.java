import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HippodromeTest {
  @Test
  @DisplayName("Null exception test")
  public void nullExceptionTest() {
    IllegalArgumentException exception =
        assertThrows(IllegalArgumentException.class, () -> new Hippodrome(null));
    assertEquals("Horses cannot be null.", exception.getMessage());
  }

  @Test
  @DisplayName("Empty list exception test")
  public void emptyListExceptionTest() {
    IllegalArgumentException exception =
        assertThrows(IllegalArgumentException.class, () -> new Hippodrome(new ArrayList<>()));
    assertEquals("Horses cannot be empty.", exception.getMessage());
  }

  @Test
  @DisplayName("getHorses method test")
  public void getHorsesMethodTest() {
    List<Horse> horses = new ArrayList<>();
    for (int i = 1; i <= 30; i++) {
      horses.add(new Horse("Houdini" + i, i, i));
    }
    Hippodrome hippodrome = new Hippodrome(horses);

    assertEquals(horses, hippodrome.getHorses());
  }

  // MENTOR SUGGESTION
  // Functional approach for doing the same as above
  // Instead of using a loop and a mutable list, we can use a stream and a map function
  @Test
  @DisplayName("Alternative getHorses method test")
  public void alternativeGetHorsesMethodTest() {
    List<Horse> horses = IntStream.rangeClosed(1, 30)
                                  .mapToObj(i -> new Horse("Houdini" + i, i, i))
                                  .collect(Collectors.toList());
    Hippodrome hippodrome = new Hippodrome(horses);
    assertEquals(horses, hippodrome.getHorses());
  }

  @Test
  @DisplayName("getWinner method test")
  public void getWinnerMethodTest() {
    Horse horse1 = new Horse("Houdini1", 1, 1);
    Horse horse2 = new Horse("Houdini2", 2, 2);
    Horse horse3 = new Horse("Houdini3", 3, 3);
    List<Horse> horses = List.of(horse1, horse2, horse3);
    Hippodrome hippodrome = new Hippodrome(horses);
    assertEquals(horse3, hippodrome.getWinner());
  }

  @Test
  @DisplayName("move method test")
  public void moveMethodTest() {
    List<Horse> horses = new ArrayList<>();
    for (int i = 1; i < 50; i++) {
      horses.add(mock(Horse.class));
    }
    new Hippodrome(horses).move();

    for (Horse horse : horses) {
      verify(horse, times(1)).move();
      // times(1) is the default (redundant, but correct anyway)
      // verify(horse).move(); Also valid and equivalent
    }
  }
}
