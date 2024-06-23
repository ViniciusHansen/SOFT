package Test.java;

import Main.java.*;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StockTest {

    private Sandwich sandwich;
    private Side side;
    private Drink drink;
    private ComboBuilder comboBuilder;
    private Combo combo;
    private Stock invetory;
    @BeforeEach
    public void setUp() {
        invetory = new Stock();
        sandwich = new Sandwich("Quarteirão", 5.00f);
        side = new Side("Batata Frita", 2.50f);
        drink = new Drink("Coca", 1.50f);
    }

    @Test
    public void testRegisterSandwichStock() {
        List<Sandwich> listSandwitch = new ArrayList<>();
        listSandwitch.add(sandwich);
        invetory.registerSandwich(sandwich,5);
        assertEquals(invetory.getMaxSandwichId(), 1);
        assertEquals(invetory.isSandwichStockEmpty(),false);
        assertEquals(invetory.getAllSandwiches(),listSandwitch);
    }

    @Test
    public void testRegisterDrinkStock() {
        List<Drink> listDrink = new ArrayList<>();
        listDrink.add(drink);
        invetory.registerDrink(drink,5);
        assertEquals(invetory.getMaxDrinkId(), 1);
        assertEquals(invetory.isDrinkStockEmpty(),false);
        assertEquals(invetory.getAllDrinks(),listDrink);
    }

    @Test
    public void testRegisterSideStock() {
        List<Side> listSide = new ArrayList<>();
        listSide.add(side);
        invetory.registerSide(side,5);
        assertEquals(invetory.getMaxSideId(), 1);
        assertEquals(invetory.isSideStockEmpty(),false);
        assertEquals(invetory.getAllSides(),listSide);
    }

    @Test
    public void testRemoveSandwichStock(){
        int startingStock = 5;
        invetory.registerSandwich(sandwich,startingStock);
        invetory.removeSandwichStock(sandwich.getId(),1);
        assertEquals(startingStock - 1, invetory.getSandwichQuantity(sandwich.getId()));
    }

    @Test
    public void testRemoveSideStock(){
        int startingStock = 5;
        invetory.registerSide(side,startingStock);
        invetory.removeSideStock(side.getId(),1);
        assertEquals(startingStock - 1, invetory.getSideQuantity(side.getId()));
    }

    @Test
    public void testRemoveDrinkStock(){
        int startingStock = 5;
        invetory.registerDrink(drink,startingStock);
        invetory.removeDrinkStock(drink.getId(),1);
        assertEquals(startingStock - 1, invetory.getDrinkQuantity(drink.getId()));
    }

    @Test
    public void testAddSandwichStock(){
        int startingStock = 5;
        invetory.registerSandwich(sandwich,startingStock);
        invetory.addSandwichStock(sandwich.getId(),100);
        assertEquals(startingStock + 100, invetory.getSandwichQuantity(sandwich.getId()));
    }

    @Test
    public void testAddSideStock(){
        int startingStock = 5;
        invetory.registerSide(side,startingStock);
        invetory.addSideStock(side.getId(),100);
        assertEquals(startingStock + 100, invetory.getSideQuantity(side.getId()));
    }

    @Test
    public void testAddDrinkStock(){
        int startingStock = 5;
        invetory.registerDrink(drink,startingStock);
        invetory.addDrinkStock(drink.getId(),100);
        assertEquals(startingStock + 100, invetory.getDrinkQuantity(drink.getId()));
    }


}
