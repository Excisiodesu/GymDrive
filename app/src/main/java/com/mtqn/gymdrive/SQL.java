package com.mtqn.gymdrive;

import java.sql.*;

public class SQL {

    private Connection connection;
    private String address, database, user, password;
    private int port;

    SQL(String address, String database, String user, String password, int port)
    {
        this.address = address;
        this.database = database;
        this.user = user;
        this.password = password;
        this.port = port;
    }

    Connection getConnection() throws SQLException {
        if (this.connection == null || connection.isClosed())
            this.connection = DriverManager.getConnection("jdbc:mysql://" + address + ":" + port + "/" + database, user, password);
//        if (this.connection != null && this.connection.isClosed())
//            this.connection = DriverManager.getConnection(this.address + "/" + this.database, this.user, this.password);
        return this.connection;
    }

    void closeConnection() throws SQLException {
        this.connection.close();
    }
}