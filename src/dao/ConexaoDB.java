package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConexaoDB {
    
private static final String URL = "jdbc:postgresql://localhost:5432/lista_telefonica";
private static final String USER = "postgres";
private static final String PASSWORD = "1414";

public static Connection getConnection(){
    try {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    } catch (
     SQLException e) {
        System.err.println("Erro ao conectar ao banco de dados");
    e.printStackTrace();
    return null;
    }

}





}
