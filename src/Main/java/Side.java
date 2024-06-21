package Main.java;

public class Side implements Item{

    int id;
    private String name;
    private float price;
    int quantity;
    public Side(String name, float price) {
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
