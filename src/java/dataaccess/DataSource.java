
/*
 * File: DataSource.java
 * Description:
 * Create: Sep,30,2018
 * Author: Xia Sheng
 * Clients: Michelle Bilek,Farheen Khan
 * Course: Software Development Project
 * Professor: Dr. Anu Thomas
 * Project: A Home to Share
 * Copyright @ 2018
 */
package dataaccess;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;


public class DataSource {

    public Connection createConnection() {
        Connection connection = null;
        try {
            Context initCtx = new InitialContext();
            Context envCtx = (Context) initCtx.lookup("java:comp/env");
            javax.sql.DataSource ds = (javax.sql.DataSource) envCtx.lookup("jdbc/ahometoshare");
            connection = ds.getConnection();
        } catch (NamingException | SQLException ex) {
            Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }
}
