package Test.java;

import Main.java.*;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ComboBuilderTest {

    private Sandwich sandwich;
    private Side side;
    private Drink drink, drink2, drink3;
    private ComboBuilder comboBuilder;
    private Combo combo;
    private List<Drink> drinks;

    @BeforeEach
    public void setUp() {
        sandwich = new Sandwich("Quarteirão", 5.00f);
        side = new Side("Batata Frita", 2.50f);
        drink = new Drink("Coca", 1.50f);
        comboBuilder = new ComboBuilder();
        drink2 = new Drink("Suco", 2f);
        drink3 = new Drink("Suco", 2f);
        drinks = new ArrayList<Drink>();
        drinks.add(drink2);
        drinks.add(drink3);
    }

    @Test
    public void testBuildComboWithSandwichOnly() {
        combo = comboBuilder
                .createCombo()
                .buildComboSandwich(sandwich)
                .getCombo();

        assertEquals("Quarteirão", combo.getDescription());
        assertEquals(5.00f, combo.getPrice());
    }

    @Test
    public void testBuildComboWithDrinkOnly() {
        combo = comboBuilder
                .createCombo()
                .buildComboDrink(drink)
                .getCombo();

        assertEquals("Coca", combo.getDescription());
        assertEquals(1.50f, combo.getPrice());
    }

    @Test
    public void testBuildComboWithSandwichAndSide() {
        combo = comboBuilder
                .createCombo()
                .buildComboSandwich(sandwich)
                .buildComboSide(side)
                .getCombo();

        assertEquals("Quarteirão, Batata Frita", combo.getDescription());
        assertEquals(7.50f, combo.getPrice());
    }

    @Test
    public void testBuildComboWithSandwichSideAndDrink() {
        combo = comboBuilder
                .createCombo()
                .buildComboSandwich(sandwich)
                .buildComboSide(side)
                .buildComboDrink(drink)
                .getCombo();

        assertEquals("Quarteirão, Batata Frita, Coca", combo.getDescription());
        assertEquals(9.00f, combo.getPrice());
    }
    @Test
    public void testBuildComboWith2Drinks() {
        combo = comboBuilder
                .createCombo()
                .buildComboDrinks(drinks)
                .getCombo();

        assertEquals("Suco, Suco", combo.getDescription());
        assertEquals(4.00f, combo.getPrice());
    }
}
