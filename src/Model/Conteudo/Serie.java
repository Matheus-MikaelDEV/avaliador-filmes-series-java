package Model.Conteudo;

import entities.enums.Genero;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Serie extends Conteudo {
    private Integer temporadas;
    private Integer episodiosPorTemporada;
    private Boolean finalizada;

    public Serie(String titulo, LocalDate dataDeLancamento, Genero genero, Integer temporadas, Integer episodiosPorTemporada, Boolean finalizada) {
        super(titulo, dataDeLancamento, genero);
        this.temporadas = temporadas;
        this.episodiosPorTemporada = episodiosPorTemporada;
        this.finalizada = finalizada;
    }

    @Override
    public String getInfo () {
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        if (finalizada == true) {
            return "\nSérie: " + getTitulo() + " - ★ " + getNotaMedia() + "\nTemporadas: " + temporadas + " Temp - Episódios por temporada: " + episodiosPorTemporada + " EP - Gênero: " + getGenero().toString() + "\nData de lançamento: " + getDataDeLancamento().format(formatador) + "Finalizada: Sim";
        } else {
            return "\nSérie: " + getTitulo() + " - ★ " + getNotaMedia() + "\nTemporadas: " + temporadas + " Temp - Episódios: " + episodiosPorTemporada + " EP - Gênero: " + getGenero().toString() + "\nData de lançamento: " + getDataDeLancamento().format(formatador) + "\nFinalizada: Não";
        }
    }
}
