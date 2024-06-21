package Main.java;

import org.junit.jupiter.api.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    /*
    private static List<Sandwich> sandwiches = new ArrayList<>();
    private static List<Side> sides = new ArrayList<>();
    private static List<Drink> drinks = new ArrayList<>();

    */
    public static List<Combo> orders = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    private static Stock inventory = new Stock();

    public static void main(String[] args) {
        initializeMenu();
        mainMenu();
    }

    private static void initializeMenu() {
        // Add some initial items to the menu
        /*
        sandwiches.add(new Sandwich("Quarteirão", 5.00f));
        sandwiches.add(new Sandwich("X-Burger", 6.50f));

        sides.add(new Side("Batata Frita", 2.50f));
        sides.add(new Side("Onion Rings", 3.00f));

        drinks.add(new Drink("Refrigerante", 1.50f));
        drinks.add(new Drink("Suco", 2.00f));
       */
        inventory.registerSandwich(new Sandwich("Quarteirão", 5.00f),5);
        inventory.registerSandwich(new Sandwich("X-Burger", 6.50f),3);


        inventory.registerSide(new Side("Batata Frita", 2.50f),5);
        inventory.registerSide(new Side("Onion Rings", 3.00f),3);

        inventory.registerDrink(new Drink("Refrigerante", 1.50f),5);
        inventory.registerDrink(new Drink("Suco", 2.00f),3);
    }

    private static void mainMenu() {
        while (true) {
            System.out.println("\n\nRestaurante do Java\n");
            System.out.println("1. Visualizar Menu");
            System.out.println("2. Fazer Pedido");
            System.out.println("3. Gerenciar Catálogo");
            System.out.println("4. Visualizar Histórico de Compras");
            System.out.println("5. Visualizar Estoque");
            System.out.println("6. Sair");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    showMenu();
                    break;
                case 2:
                    placeOrder();
                    break;
                case 3:
                    manageCatalog();
                    break;
                case 4:
                    viewOrderHistory();
                    break;
                case 5:
                    viewInventory();
                    break;
                case 6:
                    System.out.println("Saindo do sistema...");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void showMenu() {
        List<Sandwich> sandwiches = inventory.getAllSandwiches();
        List<Side> sides = inventory.getAllSides();
        List<Drink> drinks = inventory.getAllDrinks();

        System.out.println("\nSanduíches:");
        for (int i = 0; i < sandwiches.size(); i++) {
            Sandwich sandwich = sandwiches.get(i);
            System.out.println((i + 1) + ". " + sandwich.getDescription() + " - R$" + sandwich.getPrice());
        }

        System.out.println("\nAcompanhamentos:");
        for (int i = 0; i < sides.size(); i++) {
            Side side = sides.get(i);
            System.out.println((i + 1 + sandwiches.size()) + ". " + side.getDescription() + " - R$" + side.getPrice());
        }

        System.out.println("\nBebidas:");
        for (int i = 0; i < drinks.size(); i++) {
            Drink drink = drinks.get(i);
            System.out.println((i + 1 + sandwiches.size()+ sides.size()) + ". " + drink.getDescription() + " - R$" + drink.getPrice());
        }
    }

    private static void placeOrder() {
        ComboBuilder cb = new ComboBuilder();
        cb.createCombo();
        List<Sandwich> sandwiches = inventory.getAllSandwiches();
        List<Side> sides = inventory.getAllSides();
        List<Drink> drinks = inventory.getAllDrinks();

        while (true) {
            System.out.println("\nSelecione o item que deseja adicionar ao pedido:");
            showMenu();

            System.out.print("Digite o número do item (ou 0 para finalizar): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            if (choice == 0) {
                break;
            } else if (choice > 0 && choice <= sandwiches.size()) {
                Sandwich sandwich = sandwiches.get(choice - 1);
                cb.buildComboSandwich(sandwich);
                System.out.println("Sanduíche " + sandwich.getDescription() + " adicionado ao pedido.");
                inventory.removeSandwichStock(choice,1);
            } else if (choice > sandwiches.size() && choice <= sandwiches.size() + sides.size()) {
                int sideIndex = choice - sandwiches.size() - 1;
                Side side = sides.get(sideIndex);
                cb.buildComboSide(side);
                System.out.println("Acompanhamento " + side.getDescription() + " adicionado ao pedido.");
                inventory.removeSideStock(choice - sandwiches.size(),1);
            } else if (choice > sandwiches.size() + sides.size() && choice <= sandwiches.size() + sides.size() + drinks.size()) {
                int drinkIndex = choice - sandwiches.size() - sides.size() - 1;
                Drink drink = drinks.get(drinkIndex);
                cb.buildComboDrink(drink);
                System.out.println("Bebida " + drink.getDescription() + " adicionada ao pedido.");
                inventory.removeDrinkStock(choice - sandwiches.size() - sides.size(),1);
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }
        Combo combo = cb.getCombo();

        if (combo != null) {
            System.out.println("\nResumo do Pedido: " + combo.getDescription());
            System.out.println("Total do Pedido: R$" + combo.getPrice());

            System.out.print("Confirmar pedido (S/N)? ");
            String confirmation = scanner.nextLine().toUpperCase();

            if (confirmation.equals("S")) {
                orders.add(combo);
                System.out.println("Pedido realizado com sucesso!");
            }
        } else {
            System.out.println("Nenhum item selecionado para o pedido.");
        }
    }

    private static void manageCatalog() {
        while (true) {
            System.out.println("\nGerenciamento de Catálogo:");
            System.out.println("1. Adicionar Sanduíche");
            System.out.println("2. Remover Sanduíche");
            System.out.println("4. Adicionar Acompanhamento");
            System.out.println("5. Remover Acompanhamento");
            System.out.println("7. Adicionar Bebida");
            System.out.println("8. Remover Bebida");
            System.out.println("9. Manipular estoque");
            System.out.println("10. Voltar para o Menu Principal");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    addSandwich();
                    break;
                case 2:
                    removeSandwich();
                    break;
                case 9:
                    manageInvetory();
                case 10:
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }


    public static void manageInvetory(){
        while (true) {
            System.out.println("\nGerenciamento de Catálogo:");
            System.out.println("1. Adicionar ao estoque");
            System.out.println("2. Remover do estoque");
            System.out.println("3. Voltar para o Menu Principal");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    addToStock();
                    break;
                case 2:
                    removeFromStock();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }



    private static void addSandwich() {
        System.out.print("Digite o nome do sanduíche: ");
        String name = scanner.nextLine();

        System.out.print("Digite o preço do sanduíche: ");
        float price = scanner.nextFloat();
        scanner.nextLine(); // Consume newline character

        System.out.print("Digite a quantidade inicial do sanduíche no estoque: ");
        int initialQuantity = scanner.nextInt();
        scanner.nextLine();

        inventory.registerSandwich(new Sandwich(name, price),initialQuantity);
        System.out.println("Sanduíche adicionado com sucesso!");
    }

    private static void removeSandwich() {


        if (inventory.isSandwichStockEmpty()) {
            System.out.println("Não há sanduíches cadastrados.");
            return;
        }
        List<Sandwich> sandwiches = inventory.getAllSandwiches();

        System.out.println("\nSanduíches Cadastrados:");
        for (int i = 0; i < sandwiches.size(); i++) {
            Sandwich sandwich = sandwiches.get(i);
            System.out.println((i + 1) + ". " + sandwich.getDescription());
        }

        System.out.print("Digite o número do sanduíche para remover: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        if (choice > 0 && choice <= sandwiches.size()) {
            inventory.removeSandwichById(choice);
            System.out.println("Sanduíche removido com sucesso!");
        } else {
            System.out.println("Opção inválida. Tente novamente.");
        }
    }


    // Similar logic for adding, removing, and updating Sides and Drinks (implement methods like addSide, removeSide, updateSide, addDrink, removeDrink, updateDrink)

    private static void viewOrderHistory() {
        if (orders.isEmpty()) {
            System.out.println("Não há histórico de compras.");
            return;
        }

        System.out.println("\nHistórico de Pedidos:");
        for (int i = 0; i < orders.size(); i++) {
            Combo order = orders.get(i);
            System.out.println("\nPedido " + (i + 1) + "\n" +  order.getDescription() + "\n" + order.getPrice() + "\n\n");


        }
    }

    private static void removeFromStock(){

        List<Sandwich> sandwiches = inventory.getAllSandwiches();
        List<Side> sides = inventory.getAllSides();
        List<Drink> drinks = inventory.getAllDrinks();
        System.out.println("\nSelecione o item que deseja manipular o estoque:");
        viewInventory();
        while (true) {
            System.out.println("\nSelecione o item que deseja manipular o estoque:");
            viewInventory();
            int removeQuantity = 0;
            System.out.print("Digite o número do item (ou 0 para finalizar): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            if (choice == 0) {
                break;
            } else if (choice > 0 && choice <= sandwiches.size()) {
                System.out.println("Insira a quantidade a ser removida do estoque: ");
                removeQuantity = scanner.nextInt();
                scanner.nextLine();
                inventory.removeSandwichStock(choice,removeQuantity);
            } else if (choice > sandwiches.size() && choice <= sandwiches.size() + sides.size()) {
                System.out.println("Insira a quantidade a ser removida do estoque: ");
                removeQuantity = scanner.nextInt();
                scanner.nextLine();
                inventory.removeSideStock(choice - sandwiches.size(),removeQuantity);
            } else if (choice > sandwiches.size() + sides.size() && choice <= sandwiches.size() + sides.size() + drinks.size()) {
                System.out.println("Insira a quantidade a ser removida do estoque: ");
                removeQuantity = scanner.nextInt();
                scanner.nextLine();
                inventory.removeDrinkStock(choice - sandwiches.size() - sides.size(),removeQuantity);
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }

    }

    private static void addToStock(){

        List<Sandwich> sandwiches = inventory.getAllSandwiches();
        List<Side> sides = inventory.getAllSides();
        List<Drink> drinks = inventory.getAllDrinks();
        System.out.println("\nSelecione o item que deseja manipular o estoque:");
        viewInventory();
        while (true) {
            System.out.println("\nSelecione o item que deseja manipular o estoque:");
            viewInventory();
            int addQuantity = 0;
            System.out.print("Digite o número do item (ou 0 para finalizar): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            if (choice == 0) {
                break;
            } else if (choice > 0 && choice <= sandwiches.size()) {
                System.out.println("Insira a quantidade a ser adicionada ao estoque: ");
                addQuantity = scanner.nextInt();
                scanner.nextLine();
                inventory.addSandwichStock(choice,addQuantity);
            } else if (choice > sandwiches.size() && choice <= sandwiches.size() + sides.size()) {
                System.out.println("Insira a quantidade a ser adicionada ao estoque: ");
                addQuantity = scanner.nextInt();
                scanner.nextLine();
                inventory.addSideStock(choice - sandwiches.size(),addQuantity);
            } else if (choice > sandwiches.size() + sides.size() && choice <= sandwiches.size() + sides.size() + drinks.size()) {
                System.out.println("Insira a quantidade a ser adicionada ao estoque: ");
                addQuantity = scanner.nextInt();
                scanner.nextLine();
                inventory.addDrinkStock(choice - sandwiches.size() - sides.size(),addQuantity);
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    public static void viewInventory(){
        List<Sandwich> sandwiches = inventory.getAllSandwiches();
        List<Side> sides = inventory.getAllSides();
        List<Drink> drinks = inventory.getAllDrinks();

        System.out.println("\nSanduíches:");
        for (int i = 0; i < sandwiches.size(); i++) {
            Sandwich sandwich = sandwiches.get(i);
            System.out.println((i + 1) + ". " + sandwich.getDescription() + " - Quantidade em estoque: " + sandwich.getQuantity());
        }

        System.out.println("\nAcompanhamentos:");
        for (int i = 0; i < sides.size(); i++) {
            Side side = sides.get(i);
            System.out.println((i + 1 + sandwiches.size()) + ". " + side.getDescription() + " - Quantidade em estoque: " + side.getQuantity());
        }

        System.out.println("\nBebidas:");
        for (int i = 0; i < drinks.size(); i++) {
            Drink drink = drinks.get(i);
            System.out.println((i + 1 + sandwiches.size()+ sides.size()) + ". " + drink.getDescription() + " - Quantidade em estoque: " + drink.getQuantity());
        }
    }


}
