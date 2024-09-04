import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SupplierDAO {
    public void addSupplier(Supplier supplier) throws SQLException {
        Connection conn = DBConnection.getConnection();
        String sql = "INSERT INTO Supplier (name, email, phone_number, address) VALUES (?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, supplier.getName());
        stmt.setString(2, supplier.getEmail());
        stmt.setString(3, supplier.getPhoneNumber());
        stmt.setString(4, supplier.getAddress());
        stmt.executeUpdate();
        stmt.close();
        conn.close();
    }

    public List<Supplier> getSuppliers() throws SQLException {
        Connection conn = DBConnection.getConnection();
        String sql = "SELECT * FROM Supplier";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        List<Supplier> suppliers = new ArrayList<>();
        while (rs.next()) {
            Supplier supplier = new Supplier(
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("phone_number"),
                    rs.getString("address")
            );
            supplier.setSupplierId(rs.getInt("supplier_id"));
            suppliers.add(supplier);
        }
        rs.close();
        stmt.close();
        conn.close();
        return suppliers;
    }

    // You can add updateSupplier and deleteSupplier methods here
}
