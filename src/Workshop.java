import java.util.ArrayList;
import java.util.List;

public class Workshop {
    private final List<Car> cars;
    private final List<SparePart> spareParts;

    public Workshop() {
        cars = new ArrayList<>();
        spareParts = new ArrayList<>();
    }

    public void addCarForSale(Car car, double price) {
        car.setForSale(true);
        car.setPrice(price);
        cars.add(car);
    }

    public void addCarForRepair(Car car, String issue) {
        car.setForSale(false);
        car.setRepairIssue(issue);
        cars.add(car);
    }

    public int getCarCount() {
        return cars.size();
    }

    public Car getCar(int index) {
        if (index >= 0 && index < cars.size()) {
            return cars.get(index);
        }
        return null;
    }

    public void removeCar(int index) {
        if (index >= 0 && index < cars.size()) {
            cars.remove(index);
        } else {
            System.out.println("Invalid car index.");
        }
    }

    public void updateCarStatus(int index, String newStatus) {
        if (index >= 0 && index < cars.size()) {
            Car car = cars.get(index);
            String currentStatus = car.getStatus();

            if (currentStatus.equals("For Sale")) {
                System.out.println("Cannot update status for a car that is for sale.");
                return;
            }

            if (!currentStatus.equals("Repaired")) {
                car.setStatus(newStatus);
                System.out.println("Car status updated successfully.");
                if (newStatus.equals("Repaired")) {
                    System.out.println("Car marked as repaired and removed from the system. Bill: " + calculateBill(car));
                    cars.remove(index);
                }
            } else {
                System.out.println("Cannot update status for a repaired car.");
            }
        } else {
            System.out.println("Invalid car index.");
        }
    }



    public void sellCar(int index) {
        if (index >= 0 && index < cars.size()) {
            Car car = cars.get(index);
            if (car.isForSale()) {
                double sellingPrice = car.getPrice(); // Get the selling price of the car
                car.markAsSold();
                cars.remove(index);
                System.out.println("Car sold successfully. Selling price: " + sellingPrice);
            } else {
                System.out.println("Car is not for sale.");
            }
        } else {
            System.out.println("Invalid car index.");
        }
    }



    public void addSparePart(SparePart sparePart) {
        spareParts.add(sparePart);
    }

    public int getSparePartCount() {
        return spareParts.size();
    }

    public SparePart getSparePart(int index) {
        if (index >= 0 && index < spareParts.size()) {
            return spareParts.get(index);
        }
        return null;
    }

    public void updateSparePart(int index, int quantity) {
        if (index >= 0 && index < spareParts.size()) {
            SparePart sparePart = spareParts.get(index);
            sparePart.setQuantity(sparePart.getQuantity()+quantity);
            System.out.println("Spare part quantity updated successfully.");
        } else {
            System.out.println("Invalid spare part index.");
        }
    }

    public void sellSparePart(int index, int quantitySold) {
        if (index >= 0 && index < spareParts.size()) {
            SparePart sparePart = spareParts.get(index);
            if (sparePart.getQuantity() >= quantitySold) {
                sparePart.setQuantity(sparePart.getQuantity() - quantitySold);
                double bill = calculateSparePartBill(sparePart.getPrice(), quantitySold);
                System.out.println("Spare part sold successfully. Bill amount: " + bill);
            } else {
                System.out.println("Insufficient quantity available.");
            }
        } else {
            System.out.println("Invalid spare part index.");
        }
    }

    private double calculateBill(Car car) {
        double bill = 0;
        String repairIssue = car.getRepairIssue();

        switch (repairIssue) {
            case "Engine Repair" -> bill = 5000.0;
            case "Brake Repair" -> bill = 3000.0;
            case "Electrical Repair" -> bill = 4000.0;
        }

        return bill;
    }

    private double calculateSparePartBill(double unitPrice, int quantitySold) {
        return unitPrice * quantitySold;
    }
}
