public class Medication {
    private int medicationId;
    private String name;
    private String description;
    private double price;
    private int quantityInStock;

    public Medication(String name, String description, double price, int quantityInStock) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantityInStock = quantityInStock;
    }

    // Getters and setters
    public int getMedicationId() { return medicationId; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public double getPrice() { return price; }
    public int getQuantityInStock() { return quantityInStock; }

    public void setMedicationId(int medicationId) { this.medicationId = medicationId; }
    public void setName(String name) { this.name = name; }
    public void setDescription(String description) { this.description = description; }
    public void setPrice(double price) { this.price = price; }
    public void setQuantityInStock(int quantityInStock) { this.quantityInStock = quantityInStock; }

    @Override
    public String toString() {
        return "Medication{" +
                "medicationId=" + medicationId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", quantityInStock=" + quantityInStock +
                '}';
    }
}
