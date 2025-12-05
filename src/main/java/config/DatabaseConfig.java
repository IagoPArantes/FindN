package config;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConfig {

    private static final String URL = "jdbc:mysql://127.0.0.1:3306/Find";
    private static final String USER = "root";
    private static final String PASSWORD = "nova_senha";

    public static Connection getConnection() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            return DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (Exception e) {
            throw new RuntimeException("Erro ao conectar ao banco: " + e.getMessage());
        }
    }
}
