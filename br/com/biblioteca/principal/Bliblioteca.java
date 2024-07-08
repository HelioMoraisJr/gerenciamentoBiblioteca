package br.com.biblioteca.principal;

import br.com.biblioteca.models.Livros;
import br.com.biblioteca.models.Usuarios;

import java.util.*;

public class Bliblioteca {

    public static void main(String[] args){

        Scanner leitor = new Scanner(System.in);
        boolean buscador = true;
        String menu = "*************** Menu ****************" +
                "\n1 - Listar livros" +
                "\n2 - Buscar livro" +
                "\n3 - Emprestar livro" +
                "\n4 - Devolver livro" +
                "\n0 - Sair" +
                "\n"+
                "**************************************";

        Livros primeiroLivro = new Livros("Chamados para criar", "Jordan Raynar", "9786556893532");
        Livros segundoLivro = new Livros("A única coisa", "Gary Keller", "9781885167774");
        Livros terceiroLivro = new Livros("Mais que um carpinteiro", "Josh McDowell", "9780802725646");
        Livros quartoLivro = new Livros("Mais que um carpinteiro", "Josh McDowell", "9780802725646");

        // Cria uma lista para armazenar os livros
        ArrayList<Livros> listaDeLivros = new ArrayList<>();
        listaDeLivros.add(primeiroLivro);
        listaDeLivros.add(segundoLivro);
        listaDeLivros.add(terceiroLivro);
        listaDeLivros.add(quartoLivro);

        Usuarios primeiroUsuario = new Usuarios("Helio", "1");
        Usuarios segundoUsuario  = new Usuarios("Alaide", "2");


        // Remover livros com ISBN duplicados
        // Usando Iterator para evitar ConcurrentModificationException
        Set<String> isbnSet = new HashSet<>();
        Iterator<Livros> iterator = listaDeLivros.iterator();

        while (iterator.hasNext()) {
            Livros livros = iterator.next();
            // verifica se há outro livro com mesmo ISBN
            if(isbnSet.contains(livros.getIsbn())){
                iterator.remove(); // Remove o livro atual se o ISBN estiver duplicado
            } else {
                isbnSet.add(livros.getIsbn());
            }
        }

        int opcao = -1;

        System.out.println(menu);


        while(opcao != 0) {

            System.out.println("Informe o código: ");
                opcao = leitor.nextInt();
                leitor.nextLine();

            if (opcao == 1) { // Listar
                for (Livros item : listaDeLivros) {
                    System.out.println("Título: " + item.getTitulo());
                    System.out.println("Autor: " + item.getAutor());
                    System.out.println("ISBN: " + item.getIsbn());
                    System.out.println("Disponível: " + (item.isDisponivel() ? "Sim" : "Não"));
                    System.out.println();
                }
            } else if (opcao == 2) { // Buscar

                System.out.println("Qual é o título: ");
                String tituloBuscar = leitor.nextLine().toLowerCase();

                boolean livroEncontrado = false;
                for (Livros livro : listaDeLivros) {
                    if (livro.getTitulo().equalsIgnoreCase(tituloBuscar)) {
                        System.out.println("\nLivro encontrado:");
                        System.out.println("Título: " + livro.getTitulo());
                        System.out.println("Autor: " + livro.getAutor());
                        System.out.println("ISBN: " + livro.getIsbn());
                        System.out.println("Disponível: " + (livro.isDisponivel() ? "Sim" : "Não"));
                        System.out.println();
                        livroEncontrado = true;
                    }
                }
                if (!livroEncontrado) {
                    System.out.println("Livro não encontrado.");
                }
            } else if (opcao == 3) { // Emprestar



            } else  { // Devolver
                System.out.println("Devolução");
            }


        }
    }
}

