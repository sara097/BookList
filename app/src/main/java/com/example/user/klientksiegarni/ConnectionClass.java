package com.example.user.klientksiegarni;

import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionClass {

    private String ip="192.168.1.10";
    private String db="Ksiegarnia";

    @SuppressLint("NewApi")
    public Connection CONN(String user, String password) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection conn = null;
        try {

            Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
            conn= DriverManager.getConnection(
                    "jdbc:jtds:sqlserver://"+ip+":1433/"+db+";encrypt=false;user="+user+";password="+password+";instance=MSSQLSERVER;"
            );

        } catch (SQLException se) {
            Log.e("ERRO", se.getMessage());
        } catch (ClassNotFoundException e) {
            Log.e("ERRO", e.getMessage());
        } catch (Exception e) {
            Log.e("ERRO", e.getMessage());
        }
        return conn;
    }

}
