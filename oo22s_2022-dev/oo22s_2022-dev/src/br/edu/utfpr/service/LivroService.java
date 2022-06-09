package br.edu.utfpr.service;

import br.edu.utfpr.models.BancoDeDados;
import br.edu.utfpr.models.Livro;

import java.util.Scanner;

import static br.edu.utfpr.models.BancoDeDados.livro;

public class LivroService {
    public void cadastraLivro(){
        Scanner scanner = new Scanner(System.in);
        int codigo = livro.size() + 1;
        System.out.println("==CADASTRANDO UM LIVRO==");
        System.out.println("Informe o título do livro: ");
        String titulo = scanner.nextLine();
        System.out.println("Informe o autor do livro: ");
        String autor = scanner.nextLine();
        livro.add(new Livro(codigo,titulo,autor));
        System.out.println("Livro cadastrado!");
        imprimeLivro(codigo);
    }

    public void imprimeLivro(int codigo){
       livro.stream().filter(f -> f.getCodigo() == codigo)
                .forEach(fe -> System.out.printf("Código: %d \t Titulo: %s\t Autor: %s\n", fe.getCodigo(), fe.getTitulo(), fe.getAutor()));
    }
    public static Livro getLivroByCodigo(int codLivro){
        return livro.stream().filter(livro1 -> livro1.getCodigo() == codLivro).findFirst().get();
    }

    public void imprimeTodosOsLivros(){
        livro.stream().forEach(fe -> System.out.printf("Código: %d \t Titulo: %s\t Autor: %s\n", fe.getCodigo(), fe.getTitulo(), fe.getAutor()));
    }

    public void imprimeTodosOsLivrosDisponiveis(){

        livro.stream().forEach(fe -> System.out.printf("Código: %d \t Titulo: %s\t Autor: %s\n", fe.getCodigo(), fe.getTitulo(), fe.getAutor()));
    }
}
