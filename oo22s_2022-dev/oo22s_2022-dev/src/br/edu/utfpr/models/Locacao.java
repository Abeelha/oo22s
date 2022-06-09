package br.edu.utfpr.models;

import java.time.LocalDate;
import java.util.List;

public class Locacao {
    private int codigo;
    private Pessoa pessoa;
    private LocalDate dataLocacao;
    private LocalDate dataDevolucao;
    private Livro livro;//Só 1 livro por locação

    public Locacao(int codigo, Pessoa pessoa, LocalDate dataLocacao, LocalDate dataDevolucao, Livro livro) {
        this.codigo = codigo;
        this.pessoa = pessoa;
        this.dataLocacao = dataLocacao;
        this.dataDevolucao = dataDevolucao;
        this.livro = livro;
    }

    public int getCodigo() {
        return codigo;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public LocalDate getDataLocacao() {
        return dataLocacao;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public Livro getLivro() {
        return livro;
    }
}

