import java.sql.Date;

public class Inventory {
    private int inventoryId;
    private int medicationId;
    private int supplierId;
    private int quantityReceived;
    private Date dateReceived;

    public Inventory(int medicationId, int supplierId, int quantityReceived, Date dateReceived) {
        this.medicationId = medicationId;
        this.supplierId = supplierId;
        this.quantityReceived = quantityReceived;
        this.dateReceived = dateReceived;
    }

    // Getters and setters
    public int getInventoryId() { return inventoryId; }
    public int getMedicationId() { return medicationId; }
    public int getSupplierId() { return supplierId; }
    public int getQuantityReceived() { return quantityReceived; }
    public Date getDateReceived() { return dateReceived; }

    public void setInventoryId(int inventoryId) { this.inventoryId = inventoryId; }
    public void setMedicationId(int medicationId) { this.medicationId = medicationId; }
    public void setSupplierId(int supplierId) { this.supplierId = supplierId; }
    public void setQuantityReceived(int quantityReceived) { this.quantityReceived = quantityReceived; }
    public void setDateReceived(Date dateReceived) { this.dateReceived = dateReceived; }

    @Override
    public String toString() {
        return "Inventory{" +
                "inventoryId=" + inventoryId +
                ", medicationId=" + medicationId +
                ", supplierId=" + supplierId +
                ", quantityReceived=" + quantityReceived +
                ", dateReceived=" + dateReceived +
                '}';
    }
}
