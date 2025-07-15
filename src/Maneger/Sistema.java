package Maneger;

import Model.Conteudo.Avaliacao;
import Model.Conteudo.Conteudo;
import Model.Usuario.Usuario;

import java.util.ArrayList;
import java.util.List;

public class Sistema {
    List<Conteudo> conteudos = new ArrayList<>();
    List<Usuario> usuarios = new ArrayList<>();

    Usuario usuarioLogado;

    //Sistema que cadastra usuario
    public boolean adicionarUsuario(Usuario usuario) {
        for (Usuario usuario1 : usuarios) {
            if (usuario1.getEmail().equals(usuario.getEmail())) {
                return false;
            }
        }
        usuarios.add(usuario);
        return true;
    }

    //Verifica o login do usuario
    public boolean login(String email, String senha) {
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)) {
                usuarioLogado = usuario;
                return true;
            }
        }
        return false;
    }

    //Sistema que adiciona filmes ou series e impede de adicionar series ou filmes duplicados
    public boolean adicionarConteudo(Conteudo conteudo) {
        for (Conteudo conteudo1 : conteudos) {
            if (conteudo1.getTitulo().equals(conteudo.getTitulo())) {
                return false;
            }
        }
        conteudos.add(conteudo);
        return true;
    }

    //sistema que adiciona nota a alguma obra
    public boolean adicionarAvaliacao(String obra, String comentario, Integer nota) {
        if (conteudos.isEmpty()) {
            return false;
        } else {
            for (Conteudo conteudo : conteudos) {
                if (conteudo.getTitulo().equals(obra)) {
                    conteudo.adicionarAvaliacao(new Avaliacao(usuarioLogado.getNome(), comentario, nota));
                    conteudo.getAvaliacoes().sort((a1, a2) -> a2.getNota().compareTo(a1.getNota()));
                    return true;
                }
            }
            return false;
        }
    }

    //Listar todos os conteudos
    public boolean listarTudo() {
        if (conteudos.isEmpty()) {
            return false;
        }
        for (Conteudo conteudo : conteudos) {
            System.out.println(conteudo.getInfo());
        }
        return true;
    }

    //Listar todas as séries
    public boolean listarSeries() {
        if (conteudos.isEmpty()) {
            return false;
        }
        for (Conteudo conteudo : conteudos) {
            if (conteudo.getClass() == Serie.class) {
                System.out.println(conteudo.getInfo());
            }
        }
        return true;
    }

    //Listar todos os filmes
    public boolean listarFilmes() {
        if (conteudos.isEmpty()) {
            return false;
        }
        for (Conteudo conteudo : conteudos) {
            if (conteudo.getClass() == Filme.class) {
                System.out.println(conteudo.getInfo());
            }
        }
        return true;
    }

    //puxa o usuario logado para validar o que ele pode fazer
    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }
}
