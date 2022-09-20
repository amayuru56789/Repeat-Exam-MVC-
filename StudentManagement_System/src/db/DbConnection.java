package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Amayru
 * @created 20/09/2022 - 10:24
 * @project StudentManagement_System
 */
public class DbConnection {
    private static DbConnection dbConnection = null;
    private Connection connection;

    private DbConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/School management",
                "root",
                "1234"
        );
    }

    public static DbConnection getInstance() throws SQLException, ClassNotFoundException {
        if (dbConnection==null){
            dbConnection = new DbConnection();
        }
        return dbConnection;
    }

    public Connection getConnection(){
        return connection;
    }
}
