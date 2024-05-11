package Test.java;

import Main.java.*;
import org.junit.jupiter.api.*;

import static Main.java.Main.orders;
import static org.junit.jupiter.api.Assertions.*;



class MainTest {
    private Sandwich sandwich;
    private Side side;
    private Drink drink;
    private ComboBuilder comboBuilder;
    private Combo combo1;
    private Combo combo2;

    @Test
    public void testAddOrderToHistory() {

        sandwich = new Sandwich("Quarteirão", 5.00f);
        side = new Side("Batata Frita", 2.50f);
        drink = new Drink("Coca", 1.50f);
        comboBuilder = new ComboBuilder();

        combo1 = comboBuilder
                .createCombo()
                .buildComboSandwich(sandwich)
                .buildComboSide(side)
                .buildComboDrink(drink)
                .getCombo();
        orders.add(combo1);

        combo2 = comboBuilder
                .createCombo()
                .buildComboSandwich(sandwich)
                .getCombo();
        orders.add(combo2);

        // Verify order history
        assertEquals(2, orders.size());
        assertEquals(combo1, orders.get(0));
        assertEquals(combo2, orders.get(1));
    }

}