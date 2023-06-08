import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        class Cupcake {
            public double price;

            public double getPrice() {
                return price;
            }

            public void setPrice(double price) {
                this.price = price;
            }

            public void type() {
                System.out.println("A basic, generic cupcake, with vanilla frosting.");
            }
        }
        class RedVelvet extends Cupcake {
            public void type() {
                System.out.println("A red velvet based cupcake, with cream cheese frosting.");
            }
        }
        class Chocolate extends Cupcake {
            public void type() {
                System.out.println("A chocolate based cupcake, with chocolate frosting.");
            }
        }

        List<Cupcake> cupcakeMenu = new ArrayList<>();

        Cupcake cupcake = new Cupcake();
        RedVelvet redVelvet = new RedVelvet();
        Chocolate chocolate = new Chocolate();

        System.out.println("We are in the middle of creating the cupcake menu.\nWe currently have three cupcakes on the menu but we need to decide on pricing.");

        Scanner input = new Scanner(System.in);

        //Setting price for cupcake
        System.out.println("We are deciding on the price for our standard cupcake. Here is the description:");
        cupcake.type();
        System.out.println("How much would you like to charge for the cupcake?\n(Input a numerical number taken to 2 decimal places)");
        String priceText = input.nextLine();
        double price = Double.parseDouble(priceText);
        cupcake.setPrice(price);

        //Setting price for redVelvet
        System.out.println("We are deciding on the price for our red velvet cupcake. Here is the description:");
        redVelvet.type();
        System.out.println("How much would you like to charge for the red velvet cupcake?\n(Input a numerical number taken to 2 decimal places)");
        priceText = input.nextLine();
        price = Double.parseDouble(priceText);
        redVelvet.setPrice(price);

        //Setting price for chocolate
        System.out.println("We are deciding on the price for our chocolate cupcake. Here is the description:");
        chocolate.type();
        System.out.println("How much would you like to charge for the chocolate cupcake?\n(Input a numerical number taken to 2 decimal places)");
        priceText = input.nextLine();
        price = Double.parseDouble(priceText);
        chocolate.setPrice(price);

        cupcakeMenu.add(cupcake);
        cupcakeMenu.add(redVelvet);
        cupcakeMenu.add(chocolate);

        class Drink {
            public double price;

            public double getPrice() {
                return price;
            }

            public void setPrice(double price) {
                this.price = price;
            }

            public void type() {
                System.out.println("A bottle of water.");
            }
        }
        class Soda extends Drink {
            public void type() {
                System.out.println("A bottle of soda.");
            }
        }
        class Milk extends Drink {
            public void type() {
                System.out.println("A bottle of milk.");
            }
        }
        List<Drink> drinkMenu = new ArrayList<>();
        Drink water = new Drink();
        Soda soda = new Soda();
        Milk milk = new Milk();

        System.out.println("We are in the middle of creating the drink menu.\nWe currently have three drinks on the menu but we need to decide on pricing.");

        //Setting price for water
        System.out.println("We are deciding on the price for our bottled water. Here is the description:");
        water.type();
        System.out.println("How much would you like to charge for the bottle of water?\n(Input a numerical number taken to 2 decimal places)");
        priceText = input.nextLine();
        price = Double.parseDouble(priceText);
        water.setPrice(price);

        //Setting price for soda
        System.out.println("We are deciding on the price for our bottle of soda. Here is the description:");
        soda.type();
        System.out.println("How much would you like to charge for the bottle of soda?\n(Input a numerical number taken to 2 decimal places)");
        priceText = input.nextLine();
        price = Double.parseDouble(priceText);
        soda.setPrice(price);

        //Setting price for milk
        System.out.println("We are deciding on the price for our bottle of milk. Here is the description:");
        milk.type();
        System.out.println("How much would you like to charge for the bottle of milk?\n(Input a numerical number taken to 2 decimal places)");
        priceText = input.nextLine();
        price = Double.parseDouble(priceText);
        milk.setPrice(price);

        drinkMenu.add(water);
        drinkMenu.add(soda);
        drinkMenu.add(milk);
    }
}