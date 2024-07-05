package br.com.biblioteca.principal;

import br.com.biblioteca.controller.Livros;

import java.util.ArrayList;
import java.util.List;

public class Bliblioteca {

    public static void main(String[] args){

        // Cria uma lista para armazenar os livros
        List<Livros> listaDeLivros = new ArrayList<>();

        Livros primeiroLivro = new Livros("Chamados para criar", "Jordan Raynar", "9786556893532");
        Livros segundoLivro = new Livros("A única coisa", "Gary Keller", "9781885167774");
        Livros terceiroLivro = new Livros("Mais que um carpinteiro", "Josh McDowell", "9780802725646");

        listaDeLivros.add(primeiroLivro);
        listaDeLivros.add(segundoLivro);
        listaDeLivros.add(terceiroLivro);

        //Lista de livros

    }
}
