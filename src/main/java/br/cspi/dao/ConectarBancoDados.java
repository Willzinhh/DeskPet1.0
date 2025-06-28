
package br.cspi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class ConectarBancoDados {

    public static Connection  conectarBancoDados()
            throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");
        System.out.println("driver loaded");


        String url = "jdbc:postgresql://db:5432/deskpet";

        String usuario = "postgres";
        String senha = "94786422Wp$";

        Connection conn =
                DriverManager.getConnection(url, usuario, senha);

        return conn;
    }

}
