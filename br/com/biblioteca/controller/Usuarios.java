package br.com.biblioteca.controller;

import java.util.ArrayList;
import java.util.List;

public class Usuarios {

    //Atributos
    private String nome;
    private String id;
    private List<Livros> livrosEmprestados;

    //Métodos
    public Usuarios(String nome, String id){
        this.nome = nome;
        this.id = id;
        this.livrosEmprestados = new ArrayList<>();
    }

    public String getNome(){
        return nome;
    }

    public String getId(){
        return id;
    }

    public List<Livros> getLivrosEmprestados() {
        return livrosEmprestados;
    }

    public void adicionarLivro(Livros livros){
        livrosEmprestados.add(livros);
    }

    public void removerLivero(Livros livros){
        livrosEmprestados.remove(livros);
    }
}
