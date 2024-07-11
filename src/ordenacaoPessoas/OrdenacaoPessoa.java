package ordenacaoPessoas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class OrdenacaoPessoa {
    List<Pessoa> pessoaList;

    public OrdenacaoPessoa() {
        this.pessoaList = new ArrayList<>();
    }

    public void addPessoa(String nome, short idade, float altura) {
        pessoaList.add(new Pessoa(nome, idade, altura));
    }

    public List<Pessoa> ordenarPorIdadeStream() {
        if (pessoaList.isEmpty()) {
            throw new RuntimeException("Lista Vazia");
        }
        return pessoaList.stream().sorted((p1, p2) -> Integer.compare(p1.getIdade(), p2.getIdade()))
                .collect(Collectors.toList());
    }

    public List<Pessoa> ordenarPorAlturaStream() {
        if (pessoaList.isEmpty()) {
            throw new RuntimeException("Lista Vazia");
        }
        return pessoaList.stream().sorted((p1, p2) -> Double.compare(p1.getAltura(), p2.getAltura()))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        OrdenacaoPessoa ordenacaoPessoas = new OrdenacaoPessoa();

        // Adicionando pessoas à lista
        ordenacaoPessoas.addPessoa("Alice", (short) 20, 1.56f);
        ordenacaoPessoas.addPessoa("Bob", (short) 30, 1.80f);
        ordenacaoPessoas.addPessoa("Charlie", (short) 25, 1.70f);
        ordenacaoPessoas.addPessoa("David", (short) 17, 1.56f);

        System.out.println(ordenacaoPessoas.pessoaList);
        System.out.println(ordenacaoPessoas.ordenarPorAlturaStream());
        System.out.println(ordenacaoPessoas.ordenarPorIdadeStream());
    }


    //Sem Streams: deve antes implementar um Comparable<T> na entidade Pessoa
    public List<Pessoa> ordenarPorIdade() {
        List<Pessoa> porIdade = new ArrayList<>(pessoaList);
        if (pessoaList.isEmpty()) {
            throw new RuntimeException("Lista Vazia");
        }
        Collections.sort(porIdade);
        return porIdade;
    }

    //Sem Streams: deve antes implementar um Comparator<T> na entidade Pessoa
    public List<Pessoa> ordenarPorAltura() {
        List<Pessoa> porAltura = new ArrayList<>(pessoaList);
        if (pessoaList.isEmpty()) {
            throw new RuntimeException("Lista Vazia");
        }
        Collections.sort(porAltura, new comparePorAltura());
        return porAltura;
    }


}
