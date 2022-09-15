package bd;
import java.sql.*;
import javax.swing.JOptionPane;

public class conectar {  
   public static Connection getConexion(){
       Connection cn=null;
       try {
           //cargar nuestro driver
           //"com.mysql.jdbc.Driver"
           Class.forName("com.mysql.jdbc.Driver");
           cn=DriverManager.getConnection("jdbc:mysql://localhost:3308/proyecto2?autoReconnect=true&useSSL=false","root","Dcarpi");
           System.out.println("conexion establecida");
       } catch (ClassNotFoundException | SQLException e) {
           System.out.println("Error de conexion");
           JOptionPane.showMessageDialog(null, "error de conexion "+e);
       }
       return cn;
   }
}
