import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
            System.out.println(order.get(0));
            System.out.println(order.get(1));
            double subtotal = 0.0;
            for (int i = 2; i < order.size(); i++) {
                if (order.get(i).equals(cupcakeMenu.get(0))) {
                    cupcakeMenu.get(0).type();
                    System.out.println("Price: $" + cupcakeMenu.get(0).getPrice());
                    subtotal += cupcakeMenu.get(0).getPrice();
                } else if (order.get(i).equals(cupcakeMenu.get(1))) {
                    cupcakeMenu.get(1).type();
                    System.out.println("Price: $" + cupcakeMenu.get(1).getPrice());
                    subtotal += cupcakeMenu.get(1).getPrice();
                } else if (order.get(i).equals(cupcakeMenu.get(2))) {
                    cupcakeMenu.get(2).type();
                    System.out.println("Price: $" + cupcakeMenu.get(2).getPrice());
                    subtotal += cupcakeMenu.get(2).getPrice();
                } else if (order.get(i).equals(drinkMenu.get(0))) {
                    drinkMenu.get(0).type();
                    System.out.println("Price: $" + drinkMenu.get(0).getPrice());
                    subtotal += drinkMenu.get(0).getPrice();
                } else if (order.get(i).equals(drinkMenu.get(1))) {
                    drinkMenu.get(1).type();
                    System.out.println("Price: $" + drinkMenu.get(1).getPrice());
                    subtotal += drinkMenu.get(1).getPrice();
                } else if (order.get(i).equals(drinkMenu.get(2))) {
                    drinkMenu.get(2).type();
                    System.out.println("Price: $" + drinkMenu.get(2).getPrice());
                    subtotal += drinkMenu.get(2).getPrice();
                }
            }
            System.out.println("Your order total is $" + subtotal + "\n");

            new CreateFile();
            new WriteToFile(order, subtotal);
        } else {
            System.out.println("Have a nice day then.");
        }
    }
}

class CreateFile {
    public CreateFile() {
        try {
            File salesData = new File("salesData.txt");
            if (salesData.createNewFile()) {
                System.out.println("File created: " + salesData.getName() + ".");
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }
}

class WriteToFile {
    public WriteToFile(ArrayList<Object> order, double subtotal) {
        try {
            FileWriter fw = new FileWriter("salesData.txt", true);
            PrintWriter salesWriter = new PrintWriter(fw);

            LocalDate date = (LocalDate) order.get(0);
            LocalTime time = (LocalTime) order.get(1);

            salesWriter.println("RECEIPT:\n");
            salesWriter.println("Date: " + date);
            salesWriter.println("Time: " + time + "\n");

            for (int i = 2; i < order.size(); i++) {
                Object item = order.get(i);
                if (item instanceof Cupcake) {
                    Cupcake cupcake = (Cupcake) item;
                    if (cupcake.getClass().getSimpleName().equals("Cupcake")) {
                        salesWriter.println("Item: Classic cupcake");
                    } else {
                        salesWriter.println("Item: " + cupcake.getClass().getSimpleName() + " cupcake");
                    }
                    salesWriter.println("Price: $" + cupcake.getPrice());
                } else if (item instanceof Drink) {
                    Drink drink = (Drink) item;
                    if (drink.getClass().getSimpleName().equals("Drink")) {
                        salesWriter.println("Item: Water");
                    } else {
                        salesWriter.println("Item: " + drink.getClass().getSimpleName());
                    }
                    salesWriter.println("Price: $" + drink.getPrice());
                }
            }

            salesWriter.println("\nOrder Total: $" + subtotal);
            salesWriter.println("___________________________________");

            salesWriter.close();

            System.out.println("Successfully wrote to the file");
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }
}