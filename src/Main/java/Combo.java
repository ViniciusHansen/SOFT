package Main.java;
import java.util.ArrayList;
import java.util.List;

public class Combo {

    private List<Sandwich> sandwiches = new ArrayList<>();
    private List<Side> sides = new ArrayList<>();
    private List<Drink> drinks = new ArrayList<>();

    public List<Sandwich> getSandwiches() {
        return sandwiches;
    }

    public void setSandwiches(List<Sandwich> sandwiches) {
        this.sandwiches = sandwiches;
    }

    public List<Side> getSides() {
        return sides;
    }

    public void setSides(List<Side> sides) {
        this.sides = sides;
    }

    public List<Drink> getDrinks() {
        return drinks;
    }

    public void setDrinks(List<Drink> drinks) {
        this.drinks = drinks;
    }

    public void addSandwich(Sandwich sandwich) {
        this.sandwiches.add(sandwich);
    }

    public void addSide(Side side) {
        this.sides.add(side);
    }

    public void addDrink(Drink drink) {
        this.drinks.add(drink);
    }

    public String getDescription() {
        StringBuilder description = new StringBuilder();

        for (Sandwich sandwich : sandwiches) {
            if (description.length() > 0) {
                description.append(", ");
            }
            description.append(sandwich.getDescription());
        }

        for (Side side : sides) {
            if (description.length() > 0) {
                description.append(", ");
            }
            description.append(side.getDescription());
        }

        for (Drink drink : drinks) {
            if (description.length() > 0) {
                description.append(", ");
            }
            description.append(drink.getDescription());
        }

        return description.toString();
    }

    public float getPrice() {
        float price = 0;

        for (Sandwich sandwich : sandwiches) {
            price += sandwich.getPrice();
        }

        for (Side side : sides) {
            price += side.getPrice();
        }

        for (Drink drink : drinks) {
            price += drink.getPrice();
        }

        return price;
    }
}
