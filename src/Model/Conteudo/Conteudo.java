package Model.Conteudo;

import entities.enums.Genero;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Conteudo {
    private String titulo;
    private LocalDate dataDeLancamento;
    private Genero genero;

    List<Avaliacao> avaliacoes = new ArrayList<>();

    public Conteudo(String titulo, LocalDate dataDeLancamento, Genero genero) {
        this.titulo = titulo;
        this.dataDeLancamento = dataDeLancamento;
        this.genero = genero;
    }

    public double getNotaMedia() {

        if (avaliacoes.isEmpty()) {
            return 0.0;
        }

        double soma = 0.0;
        for (Avaliacao avaliacao : avaliacoes) {
            soma += avaliacao.getNota();
            return soma / avaliacoes.size();
        }
        return soma;
    }

    public void adicionarAvaliacao(Avaliacao avaliacao) {
        avaliacoes.add(avaliacao);
        avaliacoes.sort((a1, a2) -> a2.getNota().compareTo(a1.getNota()));
    }

    public abstract String getInfo ();

    public String getTitulo() {
        return titulo;
    }

    public LocalDate getDataDeLancamento() {
        return dataDeLancamento;
    }

    public Genero getGenero() {
        return genero;
    }

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }
}
