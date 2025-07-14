package Model.Conteudo;

import entities.enums.Genero;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Filme extends Conteudo {
    private Integer minutos;

    public Filme(String titulo, LocalDate dataDeLancamento, Genero genero, Integer minutos) {
        super(titulo, dataDeLancamento, genero);
        this.minutos = minutos;
    }

    @Override
    public String getInfo () {
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        return "\nFilme: " + getTitulo() + " - ★ " + getNotaMedia() + "\nDuração: " + minutos + " minutos - Gênero: " + getGenero().toString() + "\nData de lançamento: " + getDataDeLancamento().format(formatador);
    }
}
