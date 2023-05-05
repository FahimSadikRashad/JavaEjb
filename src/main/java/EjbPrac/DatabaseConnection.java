package EjbPrac;

import java.sql.Connection;
import java.sql.DriverManager;

///This class simply made the connection and get the conn for models uses
public class DatabaseConnection {

    public static Connection getConnection(){
        try {
//            String driver="com.mysql.jdbc.Driver";
            String databaseUrl="jdbc:mysql://localhost:3307/shopcart";
            String user="root";
            String password="";
//            Class.forName(driver);
            Connection conn= DriverManager.getConnection(databaseUrl,user,password);
            System.out.println("Database connected");

            return  conn;
        }catch (Exception e){
            System.out.println(e);
        }
        return  null;
    }
}
