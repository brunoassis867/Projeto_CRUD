package com.biblioteca.controller;

import com.biblioteca.dao.LivroDAO;
import com.biblioteca.model.Livro;

import java.util.List;

public class Controlabiblioteca {

    private LivroDAO livroDAO = new LivroDAO();

    public void cadastrarLivro(Livro livro) {
        try {
            livroDAO.cadastrarLivro(livro);
            System.out.println("Livro cadastrado com sucesso!");
        } catch (RuntimeException e) {
            System.out.println("Erro ao cadastrar livro: " + e.getMessage());
        }
    }

    public List<Livro> listarLivros() {
        try {
            return livroDAO.listarLivros();
        } catch (RuntimeException e) {
            System.out.println("Erro ao listar livros: " + e.getMessage());
            return null;
        }
    }

    public void editarLivro(Livro livro) {
        try {
            livroDAO.editarLivro(livro);
            System.out.println("Livro editado com sucesso!");
        } catch (RuntimeException e) {
            System.out.println("Erro ao editar livro: " + e.getMessage());
        }
    }

    public void excluirLivro(int id) {
        try {
            livroDAO.excluirLivro(id);
            System.out.println("Livro excluído com sucesso!");
        } catch (RuntimeException e) {
            System.out.println("Erro ao excluir livro: " + e.getMessage());
        }
    }
}