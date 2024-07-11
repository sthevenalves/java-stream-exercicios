package ordenacaoPessoas;

import java.util.Comparator;

public class Pessoa implements Comparable<Pessoa> {
    private String nome;
    private Short idade;
    private Float altura;

    public Pessoa(String nome, Short idade, Float altura) {
        this.nome = nome;
        this.idade = idade;
        this.altura = altura;
    }

    public Pessoa() {
    }

    @Override
    public int compareTo(Pessoa p) {
        return Short.compare(idade, p.getIdade());
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Short getIdade() {
        return idade;
    }

    public void setIdade(Short idade) {
        this.idade = idade;
    }

    public Float getAltura() {
        return altura;
    }

    public void setAltura(Float altura) {
        this.altura = altura;
    }

    @Override
    public String toString() {
        return "Pessoas{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", altura=" + altura +
                '}';
    }

}

class comparePorAltura implements Comparator<Pessoa>{

    @Override
    public int compare(Pessoa p1, Pessoa p2) {
        return Float.compare(p1.getAltura(), p2.getAltura());
    }
}


