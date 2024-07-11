package catalogoLivros;

import java.time.LocalDate;

public class Livros {
    private String autor;
    private String titulo;
    private LocalDate datePublicacao;

    public Livros() {
    }

    public Livros(String autor, String titulo, LocalDate datePublicacao) {
        this.autor = autor;
        this.titulo = titulo;
        this.datePublicacao = datePublicacao;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate getDatePublicacao() {
        return datePublicacao;
    }

    public void setDatePublicacao(LocalDate datePublicacao) {
        this.datePublicacao = datePublicacao;
    }

    @Override
    public String toString() {
        return "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", Data='" + datePublicacao +"'"+
                '}'+"\n";
    }
}
