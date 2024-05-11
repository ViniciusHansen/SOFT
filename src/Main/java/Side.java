package Main.java;

public class Side implements Item{

    private String name;
    private float price;

    public Side(String name, float price) {
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
