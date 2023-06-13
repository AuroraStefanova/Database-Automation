package com.java_parabank_demo.helpers;
import java.sql.*;

public class Database {
    public void readFromDb(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con  = DriverManager.getConnection("jdbc:mysql://127.0.0.1/zoridb","root","");
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from usersinfo");

            while(resultSet.next()){
                System.out.println(resultSet.getString(1) + " " + resultSet.getString(2));
            }
        }
        catch (Exception e){
            System.out.println("something went wrong ");
            e.printStackTrace();
        }
    }
    public void writeInDb(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con  = DriverManager.getConnection("jdbc:mysql://127.0.0.1/zoridb","root","");
            Statement statement = con.createStatement();

            System.out.println("Inserting records into the table!");
            String sql = "INSERT INTO usersinfo VALUES ('Zori', 'ZoriTest123')";
            statement.executeUpdate(sql);

            System.out.println("Inserted records into the table...");
        }
        catch (Exception e){
            System.out.println("something went wrong ");
            e.printStackTrace();
        }
    }
    public static void main(String[] arg){
        Database database = new Database();
        database.readFromDb();
        database.writeInDb();
        database.readFromDb();
    }
}
