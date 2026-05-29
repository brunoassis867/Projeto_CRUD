package com.biblioteca.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static Connection getConexao() {
        try {
            String serverName = "localhost";
            String mydatabase = "biblioteca";
            String url = "jdbc:mysql://"
                    + serverName
                    + ":3306/"
                    + mydatabase
                    + "?useSSL=false";
            String username = "root";
            String password = "9656";
            return DriverManager.getConnection(url, username, password);
        } catch (Exception ex) {
            throw new RuntimeException("Conexão falhou: " + ex.getMessage());
        }
    }

    public static void closeConexao(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException("Erro ao fechar conexão: " + e.getMessage());
            }
        }
    }
}