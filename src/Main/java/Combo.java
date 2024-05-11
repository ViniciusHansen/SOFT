package Main.java;

public class Combo {

    private Sandwich sandwich;
    private Side side;
    private Drink drink;

    public Sandwich getSandwich() {
        return sandwich;
    }

    public void setSandwich(Sandwich sandwich) {
        this.sandwich = sandwich;
    }

    public Side getSide() {
        return side;
    }

    public void setSide(Side side) {
        this.side = side;
    }

    public Drink getDrink() {
        return drink;
    }

    public void setDrink(Drink drink) {
        this.drink = drink;
    }

    public String getDescription() {
        StringBuilder description = new StringBuilder();
        if (sandwich != null) {
            description.append(sandwich.getDescription());
        }
        if (side != null) {
            if (!description.isEmpty()) {
                description.append(", ");
            }
            description.append(side.getDescription());
        }
        if (drink != null) {
            if (!description.isEmpty()) {
                description.append(", ");
            }
            description.append(drink.getDescription());
        }
        return description.toString();
    }

    public float getPrice() {
        float price = 0;
        if (sandwich != null) {
            price += sandwich.getPrice();
        }
        if (side != null) {
            price += side.getPrice();
        }
        if (drink != null) {
            price += drink.getPrice();
        }
        return price;
    }
}

// You would implement Sandwich, Side, and Drink here following the same pattern as Combo
