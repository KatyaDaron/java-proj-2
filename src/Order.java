import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Order {
    public Order(ArrayList<Cupcake> cupcakeMenu, ArrayList<Drink> drinkMenu) {
        System.out.println("Hello customer. Would you like to place an order? (Y or N)");
        Scanner scanner = new Scanner(System.in);
        String placeOrder = scanner.nextLine();

        ArrayList<Object> order = new ArrayList<>();

        if (placeOrder.equalsIgnoreCase("y")) {
            order.add(LocalDate.now());
            order.add(LocalTime.now());
            System.out.println("Here is the menu.");
            System.out.println("CUPCAKES:");
            int itemNumber = 0;
            for (Cupcake cupcake : cupcakeMenu) {
                itemNumber++;
                System.out.print(itemNumber + ". ");
                cupcake.type();
                System.out.println("Price: $" + cupcake.getPrice() + "\n");
            }
            System.out.println("DRINKS:");
            for (Drink drink : drinkMenu) {
                itemNumber++;
                System.out.print(itemNumber + ". ");
                drink.type();
                System.out.println("Price: $" + drink.getPrice() + "\n");
            }

            boolean ordering = true;
            while (ordering) {
                System.out.println("What would you like to order? Please use the number associated with each item to order.");
                int orderChoice = scanner.nextInt();
                scanner.nextLine();
                if (orderChoice == 1) {
                    order.add(cupcakeMenu.get(0));
                    System.out.println("Item added to order.");
                } else if (orderChoice == 2) {
                    order.add(cupcakeMenu.get(1));
                    System.out.println("Item added to order.");
                } else if (orderChoice == 3) {
                    order.add(cupcakeMenu.get(2));
                    System.out.println("Item added to order.");
                } else if (orderChoice == 4) {
                    order.add(drinkMenu.get(0));
                    System.out.println("Item added to order.");
                } else if (orderChoice == 5) {
                    order.add(drinkMenu.get(1));
                    System.out.println("Item added to order.");
                } else if (orderChoice == 6) {
                    order.add(drinkMenu.get(2));
                    System.out.println("Item added to order.");
                } else {
                    System.out.println("Sorry, we don’t seem to have that on the menu.");
                }
                System.out.println("Would you like to continue ordering? (Y/N)");
                placeOrder = scanner.nextLine();
                if (!placeOrder.equalsIgnoreCase("y")) {
                    ordering = false;
                }
            }
        } else {
            System.out.println("Have a nice day then.");
        }
    }
}