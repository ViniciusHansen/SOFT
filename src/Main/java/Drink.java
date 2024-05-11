package Main.java;

public class Drink implements Item{

    private String name;
    private float price;

    public Drink(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getDescription() {
        return name;
    }

    @Override
    public float getPrice() {
        return this.price;
    }
}
