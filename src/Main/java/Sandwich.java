package Main.java;

public class Sandwich implements Item{

    private int id;
    private String name;
    private float price;
    private int quantity;

    public Sandwich(String name, float price) {
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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
