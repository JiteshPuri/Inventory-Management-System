import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InventoryDAO {
    public void addInventory(Inventory inventory) throws SQLException {
        Connection conn = DBConnection.getConnection();
        String sql = "INSERT INTO Inventory (medication_id, supplier_id, quantity_received, date_received) VALUES (?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, inventory.getMedicationId());
        stmt.setInt(2, inventory.getSupplierId());
        stmt.setInt(3, inventory.getQuantityReceived());
        stmt.setDate(4, inventory.getDateReceived());
        stmt.executeUpdate();
        stmt.close();
        conn.close();

        // Update quantity_in_stock in Medication table
        sql = "UPDATE Medication SET quantity_in_stock = quantity_in_stock + ? WHERE medication_id = ?";
        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, inventory.getQuantityReceived());
        stmt.setInt(2, inventory.getMedicationId());
        stmt.executeUpdate();
        stmt.close();
        conn.close();
    }

    public List<Inventory> getInventory() throws SQLException {
        Connection conn = DBConnection.getConnection();
        String sql = "SELECT * FROM Inventory";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        List<Inventory> inventoryList = new ArrayList<>();
        while (rs.next()) {
            Inventory inventory = new Inventory(
                    rs.getInt("medication_id"),
                    rs.getInt("supplier_id"),
                    rs.getInt("quantity_received"),
                    rs.getDate("date_received")
            );
            inventory.setInventoryId(rs.getInt("inventory_id"));
            inventoryList.add(inventory);
        }
        rs.close();
        stmt.close();
        conn.close();
        return inventoryList;
    }

    // You can add updateInventory and deleteInventory methods here
}
