package com.biblioteca.dao;

import com.biblioteca.connection.ConnectionFactory;
import com.biblioteca.model.Livro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LivroDAO {

    public void cadastrarLivro(Livro livro) {
        Connection conn = ConnectionFactory.getConexao();
        try {
            String sql = "INSERT INTO livro (titulo, autor, ano) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getAutor());
            stmt.setInt(3, livro.getAno());
            stmt.execute();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Livro> listarLivros() {
        Connection conn = ConnectionFactory.getConexao();
        List<Livro> livros = new ArrayList<>();
        try {
            String sql = "SELECT * FROM livro";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Livro livro = new Livro();
                livro.setId(rs.getInt("id"));
                livro.setTitulo(rs.getString("titulo"));
                livro.setAutor(rs.getString("autor"));
                livro.setAno(rs.getInt("ano"));
                livros.add(livro);
            }
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return livros;
    }

    public void editarLivro(Livro livro) {
        Connection conn = ConnectionFactory.getConexao();
        try {
            String sql = "UPDATE livro SET titulo = ?, autor = ?, ano = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getAutor());
            stmt.setInt(3, livro.getAno());
            stmt.setInt(4, livro.getId());
            stmt.execute();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void excluirLivro(int id) {
        Connection conn = ConnectionFactory.getConexao();
        try {
            String sql = "DELETE FROM livro WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}