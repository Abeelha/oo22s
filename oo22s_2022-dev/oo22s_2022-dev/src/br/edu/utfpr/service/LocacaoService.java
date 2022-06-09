package br.edu.utfpr.service;

import br.edu.utfpr.models.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

import static br.edu.utfpr.models.BancoDeDados.*;

public class LocacaoService {
    public void cadastraLocacao() {//Nessa biblioteca, só pode locar um título por vez!(1 livro por locação)
        Scanner scanner = new Scanner(System.in);

        int codigoLocacao = BancoDeDados.locacao.size() + 1;
        int diasLocacao = 15;
        System.out.println("==CADASTRANDO UMA LOCAÇÃO==");
        System.out.println("Informe o codigo da pessoa:");
        int codPessoa = scanner.nextInt();
        Pessoa pessoa = PessoaService.getPessoaByCodigo(codPessoa);

        System.out.println("Informe o codigo do livro:");
        int codLivro = scanner.nextInt();
        if(livroDisponivel(codLivro) == false){
            System.out.println("Livro já possui locação!");
        }else {
            Livro livro = LivroService.getLivroByCodigo(codLivro);

            Locacao locacao = new Locacao(
                    codigoLocacao,
                    pessoa,
                    LocalDate.now(),
                    ChronoUnit.DAYS.addTo(LocalDate.now(), diasLocacao),
                    livro);

            BancoDeDados.locacao.add(locacao);

            System.out.println("Locação cadastrada! Dados registrados:");
            imprimeLocacao(codigoLocacao);
        }
    }

    public void imprimeLocacao(int codigo) {
        BancoDeDados.locacao.stream().filter(f -> f.getCodigo() == codigo)
                .forEach(fe -> System.out.println(
                        "Código da locação: " + fe.getCodigo() + "\tNome pessoa: " + fe.getPessoa().getNome() + "\tData locação: " + fe.getDataLocacao() + "\tData devolução: " + fe.getDataDevolucao() + "\tTitulo: " + fe.getLivro().getTitulo()));

    }

    public void imprimeTodasAsLocacoes(){
        locacao.stream().forEach(fe -> System.out.println("Código da locação: " + fe.getCodigo() + "\tNome pessoa: " + fe.getPessoa().getNome() + "\tData locação: " + fe.getDataLocacao() + "\tData devolução: " + fe.getDataDevolucao() + "\tTitulo: " + fe.getLivro().getTitulo()));
    }

    public boolean livroDisponivel(int codigo){

//        int livroDisponivel =

                BancoDeDados.locacao.stream()
                .filter(locacao1 -> locacao1.getLivro().getCodigo() == codigo).findFirst().get().getCodigo();


//        if(livroDisponivel > 0){
//            return true;
//        }else{
//            return false;
//        }
    }

}
