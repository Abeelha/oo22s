package br.edu.utfpr.main;

import br.edu.utfpr.models.*;
import br.edu.utfpr.service.LivroService;
import br.edu.utfpr.service.LocacaoService;
import br.edu.utfpr.service.PessoaService;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;
/*
Criar programa orientado à objetos para solucionar os seguintes casos de uso:
- Será o controle de uma biblioteca
- Desenvolver método para a locação de livro
- deverá validar se livro está disponível
- Método para reserva de livro
- Validá se há alguma reserva para data e se estará disponível
- Método para devolução do livro
- Válida se a data da entrega é anterior a data máxima
- caso tenha vencido calcular 50 centavos ao dia até 20 reais, depois 1 real por dia
*/
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LivroService livroService = new LivroService();
        PessoaService pessoaService = new PessoaService();
        LocacaoService locacaoService = new LocacaoService();

        //Cadastros já feitos
        Livro livro1 = new Livro(1,"Senhor dos Anéis", "Token");
        BancoDeDados.livro.add(livro1);
        Livro livro2 = new Livro(2,"Harry Potter", "JK Rowling");
        BancoDeDados.livro.add(livro2);
        Pessoa pessoa1 = new Pessoa(1,"Valcir");
        BancoDeDados.pessoa.add(pessoa1);
        Pessoa pessoa2 = new Pessoa(2,"Tiago");
        BancoDeDados.pessoa.add(pessoa2);
        Locacao locacao1 = new Locacao(1,pessoa1, LocalDate.of(2022,5,1), LocalDate.of(2022,5,15),livro1);
        BancoDeDados.locacao.add(locacao1);


        int menu = 0;
        do{
            System.out.println("================================");
            System.out.println("Selecione uma opção:");
            System.out.println("1 - Cadastrar livros");
            System.out.println("2 - Cadastrar pessoas");
            System.out.println("3 - Cadastrar locação");
            System.out.println("4 - Listar todos os livros");
            System.out.println("5 - Listar todas as pessoas");
            System.out.println("6 - Listar todas as locações");
            System.out.println("7 - Listar todos os livros disponíveis");
            System.out.println("================================");

            menu = scanner.nextInt();
            switch (menu){
                case  1:
                    livroService.cadastraLivro();
                     break;
                case 2:
                    pessoaService.cadastraPessoa();
                    break;
                case 3:
                    locacaoService.cadastraLocacao();
                    break;
                case 4:
                    livroService.imprimeTodosOsLivros();
                    break;
                case 5:
                    pessoaService.imprimirTodasAsPessoas();
                    break;
                case 6:
                    locacaoService.imprimeTodasAsLocacoes();
                    break;
                case 7:
                    break;
            }

        }while (menu > 0);
    }
}
