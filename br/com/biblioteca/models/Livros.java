package br.com.biblioteca.models;

public class Livros {

    //Atributos
     private String titulo;
     private String autor;
     private String isbn;
     private boolean disponivel;

     //Métodos

    //Contrutor: inicializa os atributos.
    public Livros(String titulo, String autor, String isbn ){
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.disponivel = true;
    }

    //métodos para obter os valores dos atributos.
     public String getTitulo(){
         return titulo;
     }

     public String getAutor(){
         return autor;
     }

    public String getIsbn(){
        return isbn;
    }

    //método para definir a disponibilidade do livro
    public void setDisponivel(boolean disponivel){
        this.disponivel = disponivel;
    }

    //método para verificar se o livro está disponível.
    public boolean isDisponivel(){
        return disponivel;
    }

}
