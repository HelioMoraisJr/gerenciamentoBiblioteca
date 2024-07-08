package br.com.biblioteca.models;

import java.time.LocalDate;

public class Emprestimos {

    //Atributos
    private Livros livros;
    private Usuarios usuarios;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;

    public Emprestimos(Livros livros, Usuarios usuarios, LocalDate dataDevolucao, LocalDate dataEmprestimo) {
        this.livros = livros;
        this.usuarios = usuarios;
        this.dataDevolucao = null;
        this.dataEmprestimo = dataEmprestimo;
    }

    public Livros getLivros() {
        return livros;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }
}
