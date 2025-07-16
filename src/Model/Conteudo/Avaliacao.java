package Model.Conteudo;

public class Avaliacao {
    private String autor, comentario;
    private Integer nota;
    private String email;

    public Avaliacao(String autor, String comentario, Integer nota, String email) {
        this.autor = autor;
        this.comentario = comentario;
        this.nota = nota;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public String getInfo() {
        return "\nAutor: " + getAutor() + " - Nota: ★ " + getNota() + "\nComentário: " + getComentario();
    }
}
