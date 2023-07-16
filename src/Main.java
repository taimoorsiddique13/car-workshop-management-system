import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a workshop
        Workshop workshop = new Workshop();

        while (true) {
            System.out.println("Car Workshop Management System");
            System.out.println("1. Add Car");
            System.out.println("2. Remove Car");
            System.out.println("3. Update Car Status");
            System.out.println("4. Sell Car");
            System.out.println("5. Add Spare Part");
            System.out.println("6. Sell Spare Part");
            System.out.println("7. Update Spare Part Quantity");
            System.out.println("8. View Car List");
            System.out.println("9. View Spare Parts List");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter car make (or type 'cancel' to cancel): ");
                    String make = scanner.nextLine();
                    if (make.equalsIgnoreCase("cancel")) {
                        System.out.println("Action canceled.");
                        break;
                    }

                    System.out.print("Enter car model: ");
                    String model = scanner.nextLine();
                    System.out.print("Enter car year: ");
                    int year = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Enter car owner: ");
                    String owner = scanner.nextLine();

                    System.out.println("Select car category:");
                    System.out.println("1. For Sale");
                    System.out.println("2. For Repair");
                    System.out.print("Enter your choice: ");
                    int categoryChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character

                    if (categoryChoice == 1) {
                        System.out.print("Enter car price: ");
                        double price = scanner.nextDouble();

                        Car carForSale = new Car(make, model, year, owner);
                        workshop.addCarForSale(carForSale, price);
                        System.out.println("Car added for sale successfully.");
                    } else if (categoryChoice == 2) {
                        System.out.println("Select repair type:");
                        System.out.println("1. Engine Repair");
                        System.out.println("2. Brake Repair");
                        System.out.println("3. Electrical Repair");
                        System.out.print("Enter your choice: ");
                        int repairChoice = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character

                        String repairIssue;
                        switch (repairChoice) {
                            case 1 -> repairIssue = "Engine Repair";
                            case 2 -> repairIssue = "Brake Repair";
                            case 3 -> repairIssue = "Electrical Repair";
                            default -> {
                                System.out.println("Invalid repair choice.");
                                return; // Exit the case early in case of invalid choice
                            }
                        }

                        Car carForRepair = new Car(make, model, year, owner);
                        workshop.addCarForRepair(carForRepair, repairIssue);
                        System.out.println("Car added for repair successfully.");
                    } else {
                        System.out.println("Invalid category choice.");
                    }
                    break;

                case 2:
                    if (workshop.getCarCount() == 0) {
                        System.out.println("No cars available to remove.");
                        break;
                    }

                    System.out.println("Car List:");
                    for (int i = 1; i <= workshop.getCarCount(); i++) {
                        Car c = workshop.getCar(i - 1);
                        System.out.println(i + ". " + c.getDetails());
                    }

                    System.out.print("Enter the ID of the car to remove (or enter 0 to cancel): ");
                    int removeIndex = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character

                    if (removeIndex == 0) {
                        System.out.println("Action canceled.");
                        break;
                    }

                    workshop.removeCar(removeIndex - 1);
                    System.out.println("Car removed successfully.");
                    break;

                case 3:
                    if (workshop.getCarCount() == 0) {
                        System.out.println("No cars available to update status.");
                        break;
                    }

                    System.out.println("Car List:");
                    for (int i = 1; i <= workshop.getCarCount(); i++) {
                        Car c = workshop.getCar(i - 1);
                        System.out.println(i + ". " + c.getDetails());
                    }

                    System.out.print("Enter the ID of the car to update status (or enter 0 to cancel): ");
                    int updateIndex = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character

                    if (updateIndex == 0) {
                        System.out.println("Action canceled.");
                        break;
                    }

                    Car carToUpdate = workshop.getCar(updateIndex - 1);
                    if (carToUpdate == null) {
                        System.out.println("Invalid car index.");
                        break;
                    }

                    workshop.updateCarStatus(updateIndex - 1, "Repaired");
                    System.out.println("Car status updated successfully.");
                    break;

                case 4:
                    if (workshop.getCarCount() == 0) {
                        System.out.println("No cars available to sell.");
                        break;
                    }

                    System.out.println("Car List:");
                    for (int i = 1; i <= workshop.getCarCount(); i++) {
                        Car c = workshop.getCar(i - 1);
                        System.out.println(i + ". " + c.getDetails());
                    }

                    System.out.print("Enter the ID of the car to sell (or enter 0 to cancel): ");
                    int sellIndex = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character

                    if (sellIndex == 0) {
                        System.out.println("Action canceled.");
                        break;
                    }

                    workshop.sellCar(sellIndex - 1);
                    System.out.println("Car sold successfully.");
                    break;

                case 5:
                    System.out.print("Enter spare part name (or type 'cancel' to cancel): ");
                    String partName = scanner.nextLine();
                    if (partName.equalsIgnoreCase("cancel")) {
                        System.out.println("Action canceled.");
                        break;
                    }

                    System.out.print("Enter spare part price: ");
                    double partPrice = scanner.nextDouble();
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Enter spare part quantity: ");
                    int partQuantity = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character

                    SparePart sparePart = new SparePart(partName, partPrice, partQuantity);
                    workshop.addSparePart(sparePart);
                    System.out.println("Spare part added successfully.");
                    break;

                case 6:
                    if (workshop.getSparePartCount() == 0) {
                        System.out.println("No spare parts available for sale.");
                        break;
                    }

                    System.out.println("Spare Parts List:");
                    for (int i = 1; i <= workshop.getSparePartCount(); i++) {
                        SparePart part = workshop.getSparePart(i - 1);
                        System.out.println(i + ". " + part.getName() + " - Quantity: " + part.getQuantity() + " - Price: " + part.getPrice());
                    }

                    System.out.print("Enter the ID of the spare part to sell (or enter 0 to cancel): ");
                    int sellPartIndex = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character

                    if (sellPartIndex == 0) {
                        System.out.println("Action canceled.");
                        break;
                    }

                    System.out.print("Enter the quantity to sell: ");
                    int quantitySold = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    workshop.sellSparePart(sellPartIndex - 1, quantitySold);
                    break;

                case 7:
                    if (workshop.getSparePartCount() == 0) {
                        System.out.println("No spare parts available to update quantity.");
                        break;
                    }

                    System.out.println("Spare Parts List:");
                    for (int i = 1; i <= workshop.getSparePartCount(); i++) {
                        SparePart part = workshop.getSparePart(i - 1);
                        System.out.println(i + ". " + part.getName() + " - Quantity: " + part.getQuantity());
                    }

                    System.out.print("Enter the ID of the spare part to update quantity (or enter 0 to cancel): ");
                    int updatePartIndex = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character

                    if (updatePartIndex == 0) {
                        System.out.println("Action canceled.");
                        break;
                    }

                    System.out.print("Enter the quantity to add: ");
                    int newQuantity = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character

                    workshop.updateSparePart(updatePartIndex - 1, newQuantity);
                    break;

                case 8:
                    if (workshop.getCarCount() == 0) {
                        System.out.println("No cars available.");
                    } else {
                        System.out.println("Car List:");
                        for (int i = 1; i <= workshop.getCarCount(); i++) {
                            Car c = workshop.getCar(i - 1);
                            System.out.println(i + ". " + c.getDetails());
                        }
                    }
                    break;

                case 9:
                    if (workshop.getSparePartCount() == 0) {
                        System.out.println("No spare parts available.");
                    } else {
                        System.out.println("Spare Parts List:");
                        for (int i = 1; i <= workshop.getSparePartCount(); i++) {
                            SparePart part = workshop.getSparePart(i - 1);
                            System.out.println(i + ". " + part.getName() + " - Quantity: " + part.getQuantity() + " - Price: " + part.getPrice());
                        }
                    }
                    break;

                case 0:
                    System.out.println("Exiting program...");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println();
        }
    }

}
