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
                System.out.println("A basic, generic cupcake, with vanilla frosting");
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

        List<Object> cupcakeMenu = new ArrayList<>();

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
    }
}