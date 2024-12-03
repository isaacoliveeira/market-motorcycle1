package com.example.user.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.naming.NamingException;

public class Conexao {

    private static Connection conexao = null;

    // Método para obter a conexão com o banco de dados
    public static Connection getConnection() throws InstantiationException, 
            IllegalAccessException, ClassNotFoundException, SQLException, NamingException {
        
        // Verifica se a conexão já foi criada e se ainda está aberta
        if (conexao == null || conexao.isClosed()) {
            String url = "jdbc:mysql://localhost:5432/verceldb";
            String user = "default";
            String password = "Q5Ic6OYwWHMr";
            
            // Carrega o driver do MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Cria a conexão
            conexao = DriverManager.getConnection(url, user, password);
        }
        
        return conexao;
    }

    // Método para fechar a conexão
    public static void close() {
        try {
            // Verifica se a conexão não é nula e se está aberta
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
            }
        } catch (SQLException e) {
            // Adiciona informações adicionais no stack trace para depuração
            System.err.println("Erro ao fechar a conexão: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
