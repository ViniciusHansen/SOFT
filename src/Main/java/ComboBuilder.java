package Main.java;

public class ComboBuilder {

    private Combo combo;

    public ComboBuilder() {
        this.combo = new Combo();
    }

    public ComboBuilder createCombo() {
        return this;
    }

    public ComboBuilder buildComboSandwich(Sandwich sandwich) {
        combo.setSandwich(sandwich);
        return this;
    }

    public ComboBuilder buildComboSide(Side side) {
        combo.setSide(side);
        return this;
    }

    public ComboBuilder buildComboDrink(Drink drink) {
        combo.setDrink(drink);
        return this;
    }

    public Combo getCombo() {
        return combo;
    }
}