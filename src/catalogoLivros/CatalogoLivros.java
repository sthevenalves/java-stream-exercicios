package catalogoLivros;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CatalogoLivros {
    List<Livros> listLivros;

    public CatalogoLivros() {
        this.listLivros = new ArrayList<>();
    }

    public void addLivros(String autor, String titulo, LocalDate dataPublic) {
        listLivros.add(new Livros(autor, titulo, dataPublic));
    }

    public List<Livros> buscarLivrosPorAutor(String autor) {
        if (listLivros.isEmpty()) {
            throw new RuntimeException("Lista de livros vazia");
        } else {
            return listLivros.stream().filter(l ->
                            l.getAutor().equalsIgnoreCase(autor))
                    .collect(Collectors.toList());
        }
    }

    public List<Livros> buscarLivrosPorData(LocalDate date1, LocalDate date2) {
        if (listLivros.isEmpty()) {
            throw new RuntimeException("Lista de livros vazia");
        } else {
            return listLivros.stream().filter(l ->
                    l.getDatePublicacao().isAfter(date1.minusDays(1)) &&
                            l.getDatePublicacao().isBefore(date2.plusDays(1)))
                    .collect(Collectors.toList());
        }
    }

    public Optional<Livros> buscarLivrosPorTitulo(String titulo) {
        if (listLivros.isEmpty()) {
            throw new RuntimeException("Lista de livros vazia");
        } else {
            return listLivros.stream().filter(t ->
                            t.getTitulo().equalsIgnoreCase(titulo)).findFirst();
        }
    }



    public static void main(String[] args) {
        CatalogoLivros livros = new CatalogoLivros();
        livros.addLivros("Stheven", "Em busca do meu Eu", LocalDate.of(2000, 10, 24));
        livros.addLivros("Stheven", "Tempos dificeis geram pessoas fortes", LocalDate.of(2024,4,1));
        livros.addLivros("Rafael", "Meu primeiro Peido", LocalDate.of(2007,8,16));

        System.out.println(livros.buscarLivrosPorAutor("stheven"));

        System.out.println(livros.buscarLivrosPorTitulo("Meu primeiro Peido"));

        System.out.println(livros.buscarLivrosPorData(LocalDate.of(2005, 1,1),
                LocalDate.of(2030, 1, 1)));
    }

}
