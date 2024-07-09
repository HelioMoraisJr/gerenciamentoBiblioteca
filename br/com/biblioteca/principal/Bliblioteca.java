package br.com.biblioteca.principal;

import br.com.biblioteca.models.Emprestimos;
import br.com.biblioteca.models.Livros;
import br.com.biblioteca.models.Usuarios;

import java.time.LocalDate;
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

        //Lista de usuarios
        ArrayList<Usuarios> listaDeUsuarios = new ArrayList<>();
        listaDeUsuarios.add(primeiroUsuario);
        listaDeUsuarios.add(segundoUsuario);

        //Lista de empréstimos
        ArrayList<Emprestimos> listaDeEmprestimos = new ArrayList<>();


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
                System.out.println("Qual é  o título do livro que deseja emprestar:");
                String tituloEmprestar = leitor.nextLine().toLowerCase();

                Livros livroParaEmprestar = null;
                for(Livros livro : listaDeLivros){
                    if(livro.getTitulo().equalsIgnoreCase(tituloEmprestar) && livro.isDisponivel()){
                        livroParaEmprestar = livro;
                        break;
                    }
                }

                if (livroParaEmprestar == null){
                    System.out.println("Livro não encontrado ou não disponível para empréstimo.");
                } else {
                    System.out.println("Qual é o ID do usuário que está emprestando o livro: ");
                    String idUsuario = leitor.nextLine();

                    Usuarios usuarioParaEmprestar = null;
                    for(Usuarios usuario : listaDeUsuarios){
                        if (usuario.getId().equals(idUsuario)){
                            usuarioParaEmprestar = usuario;
                            break;
                        }
                    }

                    if (usuarioParaEmprestar == null){
                        System.out.println("Usuário não encontrado.");
                    } else{
                        livroParaEmprestar.setDisponivel(false);
                        usuarioParaEmprestar.adicionarLivro(livroParaEmprestar);
                        Emprestimos novoEmprestismo = new Emprestimos(livroParaEmprestar,usuarioParaEmprestar,null, LocalDate.now());
                        listaDeEmprestimos.add(novoEmprestismo);
                        System.out.println("Livro emprestado com sucesso!");
                    }

                }

            } else if (opcao == 4) { // Devolver

                System.out.println("Qual é o título do livro que deseja devolver: ");
                String tituloDevolver = leitor.nextLine();

                Livros livroParaDevolver = null;
                for(Livros livro : listaDeLivros){
                    if(livro.getTitulo().equalsIgnoreCase(tituloDevolver) && !livro.isDisponivel()){
                        livroParaDevolver = livro;
                        break;
                    }
                }

                if (livroParaDevolver == null){
                    System.out.println("Livro não encontrado ou não foi emprestado.");
                } else {
                    Emprestimos emprestimoParaFinalizar = null;
                    for(Emprestimos emprestimos : listaDeEmprestimos){
                        if (emprestimos.getLivros().equals(livroParaDevolver) && emprestimos.getDataDevolucao() == null){
                            emprestimoParaFinalizar = emprestimos;
                            break;
                        }
                    }

                    if(emprestimoParaFinalizar == null){
                        System.out.println("Empréstimo não encontrado.");
                    } else {
                        livroParaDevolver.setDisponivel(true);
                        emprestimoParaFinalizar.getUsuarios().removerLivro(livroParaDevolver);
                        emprestimoParaFinalizar.setDataDevolucao(LocalDate.now());
                        System.out.println("Livro devolvido com sucesso!");
                    }
                }
            }
        }
    }
}

