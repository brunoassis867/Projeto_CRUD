package com.biblioteca;

import com.biblioteca.controller.Controlabiblioteca;
import com.biblioteca.model.Livro;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static String menu() {
        return "\nBIBLIOTECA\n" +
                "1. Cadastrar livro\n" +
                "2. Listar livros\n" +
                "3. Editar livro\n" +
                "4. Excluir livro\n" +
                "5. Sair\n" +
                "Opção: ";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Controlabiblioteca controller = new Controlabiblioteca();

        while (true) {
            System.out.print(menu());
            int opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1: {
                    cadastrarLivro(sc, controller);
                    break;
                }
                case 2: {
                    listarLivros(controller);
                    break;
                }
                case 3: {
                    editarLivro(sc, controller);
                    break;
                }
                case 4: {
                    excluirLivro(sc, controller);
                    break;
                }
                case 5:
                    System.out.println("Sistema finalizado!");
                    System.exit(0);
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void cadastrarLivro(Scanner sc, Controlabiblioteca controller) {
        System.out.print("Título: ");
        String titulo = sc.nextLine();
        System.out.print("Autor: ");
        String autor = sc.nextLine();
        System.out.print("Ano: ");
        int ano = sc.nextInt();
        sc.nextLine();

        Livro livro = new Livro();
        livro.setTitulo(titulo);
        livro.setAutor(autor);
        livro.setAno(ano);
        controller.cadastrarLivro(livro);
    }

    private static void listarLivros(Controlabiblioteca controller) {
        List<Livro> livros = controller.listarLivros();
        System.out.println("\nLIVROS");
        for (Livro l : livros) {
            System.out.println(
                    "ID: " + l.getId() +
                            " | Título: " + l.getTitulo() +
                            " | Autor: " + l.getAutor() +
                            " | Ano: " + l.getAno()
            );
        }
    }

    private static void editarLivro(Scanner sc, Controlabiblioteca controller) {
        System.out.print("ID do livro a editar: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Novo título: ");
        String titulo = sc.nextLine();
        System.out.print("Novo autor: ");
        String autor = sc.nextLine();
        System.out.print("Novo ano: ");
        int ano = sc.nextInt();
        sc.nextLine();

        Livro livro = new Livro();
        livro.setId(id);
        livro.setTitulo(titulo);
        livro.setAutor(autor);
        livro.setAno(ano);
        controller.editarLivro(livro);
    }

    private static void excluirLivro(Scanner sc, Controlabiblioteca controller) {
        System.out.print("ID do livro a excluir: ");
        int id = sc.nextInt();
        sc.nextLine();
        controller.excluirLivro(id);
    }
}