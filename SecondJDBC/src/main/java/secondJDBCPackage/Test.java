package secondJDBCPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {
    // Provide your actual JDBC URL here
    private static String url = "jdbc:postgresql://localhost:5432/college?user=postgres&password=hritick123";

    public static void main(String args[]) {
        // Step 2 & 3: Establish Connection
        try (Connection c = DriverManager.getConnection(url)) {
            // Step 3: Create Statement
            String query = "UPDATE students SET name='hwch' WHERE id=1";
            Statement s = c.createStatement();
            
            // Step 4: Execute the update
            int noOfRowsAffected = s.executeUpdate(query);
            System.out.println("By this query, this many rows got affected = " + noOfRowsAffected);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
