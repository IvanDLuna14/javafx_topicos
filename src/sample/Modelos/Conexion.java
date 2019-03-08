package sample.Modelos;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    private static String host = "127.0.0.1";
    private static String user = "topicos2";
    private static String pswd = "123456";
    private static String bd   = "mexflix";
    public static Connection con = null;

    public static void getConexion(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://"+host+":3306/"+bd,user,pswd);
        }
        catch (Exception e){}
    }
}
