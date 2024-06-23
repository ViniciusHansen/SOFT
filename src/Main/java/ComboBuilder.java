package Main.java;

import java.util.ArrayList;
import java.util.List;

public class ComboBuilder {

    private Combo combo;

    public ComboBuilder() {
        this.combo = new Combo();
    }

    public ComboBuilder createCombo() {
        return this;
    }

    public ComboBuilder buildComboSandwich(Sandwich sandwich) {
        if (combo.getSandwiches() == null) {
            combo.setSandwiches(new ArrayList<>());
        }
        combo.getSandwiches().add(sandwich);
        return this;
    }

    public ComboBuilder buildComboSandwiches(List<Sandwich> sandwiches) {
        if (combo.getSandwiches() == null) {
            combo.setSandwiches(new ArrayList<>());
        }
        combo.getSandwiches().addAll(sandwiches);
        return this;
    }

    public ComboBuilder buildComboSide(Side side) {
        if (combo.getSides() == null) {
            combo.setSides(new ArrayList<>());
        }
        combo.getSides().add(side);
        return this;
    }

    public ComboBuilder buildComboSides(List<Side> sides) {
        if (combo.getSides() == null) {
            combo.setSides(new ArrayList<>());
        }
        combo.getSides().addAll(sides);
        return this;
    }

    public ComboBuilder buildComboDrink(Drink drink) {
        if (combo.getDrinks() == null) {
            combo.setDrinks(new ArrayList<>());
        }
        combo.getDrinks().add(drink);
        return this;
    }

    public ComboBuilder buildComboDrinks(List<Drink> drinks) {
        if (combo.getDrinks() == null) {
            combo.setDrinks(new ArrayList<>());
        }
        combo.getDrinks().addAll(drinks);
        return this;
    }

    public Combo getCombo() {
        return combo;
    }
}
