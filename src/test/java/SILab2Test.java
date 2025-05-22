import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class SILab2Test {
    @Test
    public void testEveryStatementCriteria() {
        RuntimeException ex;


        ex = assertThrows(RuntimeException.class, () -> SILab2.checkCart(null, "1234567890123456"));
        assertTrue(ex.getMessage().contains("allItems list can't be null!"));

        final List<Item> items1 = Arrays.asList(
                new Item("", 10, 300, 0.3f)
        );
        ex = assertThrows(RuntimeException.class, () -> SILab2.checkCart(items1, "1234567890123456"));
        assertTrue(ex.getMessage().contains("Invalid item!"));

        final List<Item> items2 = Arrays.asList(
                new Item("Item1", 13, 220, 0.12f)
        );
        ex = assertThrows(RuntimeException.class, () -> SILab2.checkCart(items2, null));
        assertTrue(ex.getMessage().contains("Invalid card number!"));

        final List<Item> items3 = Arrays.asList(
                new Item("Item2", 4, 130, 0.0f)
        );
        ex = assertThrows(RuntimeException.class, () -> SILab2.checkCart(items3, "0"));
        assertTrue(ex.getMessage().contains("Invalid card number!"));


        final List<Item> items4 = Arrays.asList(
                new Item("Item3", 4, 130, 0.0f)
        );
        assertEquals(520.0, SILab2.checkCart(items4, "1111111111111111"), 0.01);
    }

    @Test
    public void testMultipleConditionCriteria() {

        final List<Item> items = Arrays.asList(
                new Item("Item1", 5, 301, 0.0f),
                new Item("Item2", 5, 300, 0.5f),
                new Item("Item3", 11, 300, 0.0f),
                new Item("Item4", 5, 300, 0.0f)
        );

        assertEquals(6965.0, SILab2.checkCart(items, "1000000000000000"), 0.01);
    }
}