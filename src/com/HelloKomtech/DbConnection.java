package com.HelloKomtech;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection
{
    static Connection con;
    public static Connection CreateDbConnection()
    {

        try {
            //load driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            //get connection
            //String url = "jdbc:sqlserver://localhost:1433;"+"databaseName=HelloKomtechDb;"+";Trusted_Connection=false;encrypt=true;trustServerCertificate=true;";
            String url = "jdbc:sqlserver://localhost:1433;databaseName=HelloKomtechDb;integratedSecurity=true;encrypt=true;trustServerCertificate=true;";

            //String user = "DESKTOP-9BTB0O9\\Admin";
            //String password = "";


            con = DriverManager.getConnection(url);

        }
        catch (Exception ex){
            ex.printStackTrace();
        }

        return con;
    }
}
