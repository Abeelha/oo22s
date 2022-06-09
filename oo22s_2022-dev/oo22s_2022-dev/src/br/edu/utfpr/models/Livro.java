package br.edu.utfpr.models;

public class Livro {
    private int codigo;
    private String titulo;
    private String autor;


    public Livro(int codigo, String titulo, String autor) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getCodigo() {
        return codigo;
    }

}
