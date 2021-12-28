package DB;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection 
{
   // --> dbconnection properties <--
    private static Connection con;
    private static Statement sta;
    private static ResultSet rst;
    
    
    // --> dbconnection methodes <--
    public static void getDbConnection()
    {
        try{
            DBConnection.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cabinet_dentaire1","root","c++javajs");
            DBConnection.sta = con.createStatement();
        }catch(Exception e){
            System.out.println("Connection faild !!");
        } 
    }
    
    public static void closeDbConnection()
    {
        try{
            DBConnection.sta.close();
            DBConnection.con.close();
        }catch(SQLException e){
            System.out.println("Faild to close connection and statement !!");
        } 
    }
    
    public static void add(String query)
    {   
       DBConnection.getDbConnection();
       try{
            sta.executeUpdate(query);  
       }catch(SQLException e){
           System.out.println("Add operation Faild !!");
       }
       DBConnection.closeDbConnection();
    }
    
    public static void delete(String query)
    {
        DBConnection.getDbConnection();
        try{
            sta.executeUpdate(query);
        }catch(SQLException e){
            System.out.println("Delete operation Faild !!");
        }
        DBConnection.closeDbConnection();
    }
    public static void modify(String query)
    {
        DBConnection.getDbConnection();
        try{
            sta.executeUpdate(query);
        }catch(SQLException e){
            System.out.println("Modify operation Faild !!");
        }
        DBConnection.closeDbConnection();
    }
    
    public static ResultSet list(String table)
    {
        DBConnection.getDbConnection();
        String query = "SELECT * FROM `"+table+"`";
        try{
            DBConnection.rst = DBConnection.sta.executeQuery(query);
        }catch(SQLException e){
            System.out.println("List opration Faild !!");
        }
        return DBConnection.rst;
    }
    
    public static ResultSet search(String query)
    {
        DBConnection.getDbConnection();
        try{
            rst = sta.executeQuery(query);
        }catch(SQLException e){
            System.err.println("Search operation failed !!");
        }
        return rst;
    }
    
    public static int executeIntQuery(String query)
    {
        DBConnection.getDbConnection();
        int num = 0;
        try{
            rst = sta.executeQuery(query);
            rst.next();
            num = rst.getInt("maxId");
        }catch(SQLException e){
            System.out.println("Error ::> "+query);
        }
        return num;
    }
}
