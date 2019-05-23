package com.mtqn.gymdrive;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


// create a users class
class Users{

    private int PRT_ID;
    private String 	PRT_Name;

    public Users(int id,String fname){
        this.PRT_ID = id;
        this.PRT_Name = fname;
    }

    public int getId(){
        return this.PRT_ID;
    }

    public String getFname(){
        return this.PRT_Name;
    }

}

public class Work {

    public Work(){

    }

    // create a Function to get the connection
    static Connection getConnection(){
        Connection con = null;

        try {
            con = DriverManager.getConnection("jdbc:mysql://oberon-serveurs.fr/test_db","jorel","1ReANZZeUuQZhUcG"); //("jdbc:mysql://oberon-serveurs.fr", "jorel", "jorel", "1ReANZZeUuQZhUcG", 3306);
        } catch (SQLException ex) {
            Logger.getLogger(Work.class.getName()).log(Level.SEVERE, null, ex);
        }

        return con;
    }

    // create a function to fill the an arraylist from database
    static ArrayList<Users> getUsers(){

        ArrayList<Users> users = new ArrayList<Users>();

        Connection con = getConnection();

        Statement st;

        ResultSet rs;

        Users u;


        return users;
    }


}
