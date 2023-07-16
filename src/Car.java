public class Car {
    private String make;
    private String model;
    private int year;
    private String owner;
    private boolean forSale;
    private double price;
    private String repairIssue;
    private boolean repaired;

    public Car(String make, String model, int year, String owner) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.owner = owner;
        this.forSale = false;
        this.price = 0.0;
        this.repairIssue = "";
        this.repaired = false;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getOwner() {
        return owner;
    }

    public boolean isForSale() {
        return forSale;
    }

    public void setForSale(boolean forSale) {
        this.forSale = forSale;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getRepairIssue() {
        return repairIssue;
    }

    public void setRepairIssue(String repairIssue) {
        this.repairIssue = repairIssue;
    }

    public boolean isRepaired() {
        return repaired;
    }

    public void markAsRepaired() {
        this.repaired = true;
    }

    public String getStatus() {
        if (forSale) {
            return "For Sale";
        } else {
            return "Under Repair";
        }
    }

    public void setStatus(String status) {
        if (status.equals("For Sale")) {
            forSale = true;
        } else if (status.equals("Under Repair")) {
            forSale = false;
        }
    }

    public String getDetails() {
        return "Make: " + make + ", Model: " + model + ", Year: " + year + ", Owner: " + owner + ", Status: " + getStatus();
    }

    public void markAsSold() {
        forSale = false;
        price = 0.0;
    }
}
