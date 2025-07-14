package Model.Conteudo;

public class Avaliacao {
    private String autor, comentario;
    private Integer nota;

    public Avaliacao(String autor, String comentario, Integer nota) {
        this.autor = autor;
        this.comentario = comentario;
        this.nota = nota;
    }

    public String getAutor() {
        return autor;
    }

    public String getComentario() {
        return comentario;
    }

    public Integer getNota() {
        return nota;
    }

    public String getInfo() {
        return "\nAutor: " + getAutor() + " - Nota: " + getNota() + "\n Comentário: " + getComentario();
    }
}
