import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MedicationDAO {
    public void addMedication(Medication medication) throws SQLException {
        Connection conn = DBConnection.getConnection();
        String sql = "INSERT INTO Medication (name, description, price, quantity_in_stock) VALUES (?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, medication.getName());
        stmt.setString(2, medication.getDescription());
        stmt.setDouble(3, medication.getPrice());
        stmt.setInt(4, medication.getQuantityInStock());
        stmt.executeUpdate();
        stmt.close();
        conn.close();
    }

    public List<Medication> getMedications() throws SQLException {
        Connection conn = DBConnection.getConnection();
        String sql = "SELECT * FROM Medication";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        List<Medication> medications = new ArrayList<>();
        while (rs.next()) {
            Medication medication = new Medication(
                    rs.getString("name"),
                    rs.getString("description"),
                    rs.getDouble("price"),
                    rs.getInt("quantity_in_stock")
            );
            medication.setMedicationId(rs.getInt("medication_id"));
            medications.add(medication);
        }
        rs.close();
        stmt.close();
        conn.close();
        return medications;
    }

    // You can add updateMedication and deleteMedication methods here
}
