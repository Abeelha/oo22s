package br.edu.utfpr.service;

import br.edu.utfpr.models.BancoDeDados;
import br.edu.utfpr.models.Pessoa;

import java.util.Scanner;

import static br.edu.utfpr.models.BancoDeDados.livro;
import static br.edu.utfpr.models.BancoDeDados.pessoa;

public class PessoaService {
    public void cadastraPessoa(){
        Scanner scanner = new Scanner(System.in);
        int codigo = pessoa.size() + 1;
        System.out.println("==CADASTRANDO UMA PESSOA==");
        System.out.println("Informe o nome da pessoa: ");
        String nome = scanner.nextLine();
        pessoa.add(new Pessoa(codigo,nome));
        System.out.println("Pessoa cadastrada!");
        imprimePessoa(codigo);
    }

    public void imprimePessoa(int codigo){
        pessoa.stream().filter(f -> f.getCodigo() == codigo)
                .forEach(fe -> System.out.printf("Código: %d \t Nome: %s\n", fe.getCodigo(), fe.getNome()));
    }
    public static Pessoa getPessoaByCodigo(int codPessoa){
        return pessoa.stream().filter(pessoa1 -> pessoa1.getCodigo() == codPessoa).findFirst().get();
    }

    public void imprimirTodasAsPessoas(){
        pessoa.stream().forEach(fe -> System.out.printf("Código: %d \t Nome: %s\n", fe.getCodigo(), fe.getNome()));
    }
}
