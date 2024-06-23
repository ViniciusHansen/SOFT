package Main.java;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;


public class Stock {

    private Map<Integer, Sandwich> sandwichStock;
    private Map<Integer, Drink> drinkStock;
    private Map<Integer, Side> sideStock;

    private int maxSandwichId;
    private int maxDrinkId;
    private int maxSideId;

    public Stock() {
        this.sandwichStock = new HashMap<>();
        this.drinkStock = new HashMap<>();
        this.sideStock = new HashMap<>();
        this.maxSandwichId = 0;
        this.maxDrinkId = 0;
        this.maxSideId = 0;
    }

    public void registerSandwich(Sandwich newSandwich, int initialQuantity) {
        newSandwich.setQuantity(initialQuantity);
        newSandwich.setId(maxSandwichId + 1);
        maxSandwichId++;
        sandwichStock.put(newSandwich.getId(), newSandwich);
    }

    public void registerDrink(Drink newDrink, int initialQuantity) {
        newDrink.setQuantity(initialQuantity);
        newDrink.setId(maxDrinkId + 1);
        maxDrinkId++;
        drinkStock.put(newDrink.getId(), newDrink);
    }

    public void registerSide(Side newSide, int initialQuantity) {
        newSide.setQuantity(initialQuantity);
        newSide.setId(maxSideId + 1);
        maxSideId++;
        sideStock.put(newSide.getId(), newSide);
    }

    public void addSandwichStock(int sandwichId, int quantity) {
        Sandwich sandwich = sandwichStock.get(sandwichId);
        if (sandwich != null) {
            int currentQuantity = sandwich.getQuantity();
            if (quantity > 0) {
                sandwich.setQuantity(currentQuantity + quantity);
                sandwichStock.put(sandwichId, sandwich);
            }
        }
    }

    public void addSideStock(int sideId, int quantity) {
        Side side = sideStock.get(sideId);
        if (side != null) {
            int currentQuantity = side.getQuantity();
            if (quantity > 0) {
                side.setQuantity(currentQuantity + quantity);
                sideStock.put(sideId, side);
            }
        }
    }

    public void addDrinkStock(int drinkId, int quantity) {
        Drink drink = drinkStock.get(drinkId);
        if (drink != null) {
            int currentQuantity = drink.getQuantity();
            if (quantity > 0) {
                drink.setQuantity(currentQuantity + quantity);
                drinkStock.put(drinkId, drink);
            }
        }
    }

    public void removeSandwichStock(int sandwichId, int quantity){
        Sandwich sandwich = sandwichStock.get(sandwichId);
        if (sandwich != null) {
            int currentQuantity = sandwich.getQuantity();
            if(currentQuantity - quantity == 0){
                sandwich.setQuantity(0);
                sandwichStock.put(sandwichId, sandwich);
            }else if(currentQuantity - quantity < 0){
//                throw new InsufficientQuantityException("Quantidade insuficiente de Sanduíche em estoque");
                sandwich.setQuantity(0);
                sandwichStock.put(sandwichId, sandwich);
                System.out.println("Estoque acabou, por favor selecione outro item.");
            }
            else {
                sandwich.setQuantity(currentQuantity - quantity);
                sandwichStock.put(sandwichId, sandwich);
            }
        }
    }

    public void removeDrinkStock(int drinkId, int quantity) {
        Drink drink = drinkStock.get(drinkId);
        if (drink != null) {
            int currentQuantity = drink.getQuantity();
            if (currentQuantity - quantity == 0) {
                drink.setQuantity(0);
                drinkStock.put(drinkId, drink);
            }else if(currentQuantity - quantity < 0) {
//                throw new InsufficientQuantityException("Quantidade insuficiente de Bebida em estoque");
                System.out.println("Estoque acabou, por favor selecione outro item.");
                drink.setQuantity(0);
                drinkStock.put(drinkId, drink);
            } else {
                drink.setQuantity(currentQuantity - quantity);
                drinkStock.put(drinkId, drink);
            }
        }
    }

    public void removeSideStock(int sideId, int quantity) {
        Side side = sideStock.get(sideId);
        if (side != null) {
            int currentQuantity = side.getQuantity();
            if (currentQuantity - quantity == 0) {
                side.setQuantity(0);
                sideStock.put(sideId, side);
            }else if(currentQuantity - quantity < 0){
//                throw new InsufficientQuantityException("Quantidade insuficiente de Acompanhamento em estoque");
                System.out.println("Estoque acabou, por favor selecione outro item.");
                side.setQuantity(0);
                sideStock.put(sideId, side);
            } else {
                side.setQuantity(currentQuantity - quantity);
                sideStock.put(sideId, side);
            }
        }
    }



    public List<Sandwich> getAllSandwiches() {
        return new ArrayList<>(sandwichStock.values());
    }

    public List<Drink> getAllDrinks() {
        return new ArrayList<>(drinkStock.values());
    }

    public List<Side> getAllSides() {
        return new ArrayList<>(sideStock.values());
    }


    public boolean isSandwichStockEmpty() {
        return sandwichStock.isEmpty();
    }

    public boolean isDrinkStockEmpty() {
        return drinkStock.isEmpty();
    }

    public boolean isSideStockEmpty() {
        return sideStock.isEmpty();
    }


    public void removeSandwichById(int sandwichId) {
        sandwichStock.remove(sandwichId);
    }

    public void removeDrinkById(int drinkId) {
        drinkStock.remove(drinkId);
    }

    public void removeSideById(int sideId) {
        sideStock.remove(sideId);
    }


    public int getMaxSandwichId() {
        return maxSandwichId;
    }

    public int getMaxDrinkId() {
        return maxDrinkId;
    }

    public int getMaxSideId() {
        return maxSideId;
    }

    public int getSandwichQuantity(int sandwichId) {
        Sandwich sandwich = sandwichStock.getOrDefault(sandwichId, null);
        return (sandwich != null) ? sandwich.getQuantity() : 0;
    }

    public int getDrinkQuantity(int drinkId) {
        Drink drink = drinkStock.getOrDefault(drinkId, null);
        return (drink != null) ? drink.getQuantity() : 0;
    }

    public int getSideQuantity(int sideId) {
        Side side = sideStock.getOrDefault(sideId, null);
        return (side != null) ? side.getQuantity() : 0;
    }

}
