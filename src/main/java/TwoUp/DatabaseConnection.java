package TwoUp;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    public Connection databaseLink;

    public Connection getConnection(){
        String databaseName = "database1";
        String databaseUser = "root";
        String databasePassword = "Night0505?";
        String url = "jdbc:mysql://127.0.0.1:3306/" + databaseName;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url,databaseUser,databasePassword);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return databaseLink;
    }

}
