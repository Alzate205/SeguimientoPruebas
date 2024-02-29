package view;

import dtos.ToysDTO;
import model.Category;
import services.ToysService;
import services.ToysServiceImpl;

import java.util.Scanner;
import java.util.concurrent.Future;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ToysService toyService = new ToysServiceImpl();
        boolean letters = false;
        while (!letters) {
            System.out.println("\nWhat do you want to do today");
            System.out.println(" 1 to add new toy");
            System.out.println(" 2 to show the toys by type");
            System.out.println(" 3 to show the total count");
            System.out.println(" 4 to show the toys above that price");
            System.out.println(" 5 to decrease the quantity amount of a toy ");
            System.out.println(" 6 to increase the quantity amount of a toy");
            System.out.println(" 7 to show the major quantity toys");
            System.out.println(" 8 to show the less quantity toys.");
            System.out.println(" 9 to filter toys by price min.");
            System.out.println(" 10 to filter toys by price max.");
            System.out.println(" 17 to sort toys by price.");
            System.out.println(" 11 to exit ");

            int interact = scanner.nextInt();
            scanner.nextLine();
            try {
                switch (interact){
                    case 1:
                        System.out.println("Toy Name: ");
                        String name = scanner.nextLine();
                        System.out.println("Toy Type: 0.Male, 1.Female, 2.Unisex");
                        Category type = Category.fromName(Integer.parseInt(scanner.nextLine()));
                        System.out.println("Toy Price: ");
                        double price = scanner.nextDouble();
                        System.out.println("Toy Quantity: ");
                        int quantity = scanner.nextInt();
                        ToysDTO newToy = new ToysDTO(name, type, price, quantity);

                        break;
                    case 2:
                        System.out.println("\nToys by type: ");
                        System.out.println(toyService.showByType());
                        break;
                    case 3:
                        System.out.println("\n Total count: " + toyService.totalToys());
                        break;
                    case 4:
                        System.out.println("Enter the value");
                        double value = scanner.nextDouble();
                        System.out.println("\n Total Value: " + toyService.showToysAbove(value));
                        break;
                    case 5:

                        System.out.println("\n Name of the toy: ");
                        String decreaseName= scanner.nextLine();
                        System.out.println("Quantity to decrease: ");
                        int decrQuantity = scanner.nextInt();
                        toyService.decrease(toyService.search(decreaseName), decrQuantity);
                        break;
                    case 6:
                        System.out.println("\n Name of the toy: ");
                        String incrementName = scanner.nextLine();
                        System.out.println("Quantity to increase: ");
                        int incrQuantity = scanner.nextInt();
                        toyService.increase(toyService.search(incrementName), incrQuantity);
                        break;
                    case 7:
                        System.out.println("\n Major quantity: " + toyService.maxToy());
                        break;
                    case 8:
                        System.out.println("\n Less quantity: " + toyService.minToy());
                        break;
                    case 9:
                        System.out.println("\n Min Price: ");
                        System.out.println(toyService.minToy());
                        break;
                    case 10:
                        System.out.println("\n Max Price: ");
                        System.out.println(toyService.maxToy());
                        break;

                    case 11:
                        letters = true;
                        break;
                }
            } catch (Exception e) {
                System.out.println("Error :(( " + e.getMessage());
            }

        }
        scanner.close();
    }
}