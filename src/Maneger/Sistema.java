package Maneger;

import Model.Conteudo.Avaliacao;
import Model.Conteudo.Conteudo;
import Model.Conteudo.Filme;
import Model.Conteudo.Serie;
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

    //listar usuarios
    public boolean listarUsuarios() {
        int i = 0;

        if (usuarios.isEmpty()) {
            return false;
        } else {
            for (Usuario usuario : usuarios) {
                System.out.println(i + " - " + usuario.getInfo());
                i++;
            }
            return true;
        }

    }

    //remover usuario
    public boolean removerUsuario(int idUsuario) {
        if (usuarios.isEmpty()) {
            return false;
        } else {
            if (idUsuario < usuarios.size()) {
                usuarios.remove(idUsuario);
                return true;
            }
            return false;
        }
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
    public boolean adicionarAvaliacao(Avaliacao avaliacao, String obra) {
        if (conteudos.isEmpty()) {
            return false;
        } else {
            for (Conteudo conteudo : conteudos) {
                if (conteudo.getTitulo().equalsIgnoreCase(obra)) {
                    for (Avaliacao avaliacao1 : conteudo.getAvaliacoes()) {
                        if (avaliacao1.getEmail().equals(usuarioLogado.getEmail())) {
                            return false;
                        }
                    }
                    conteudo.adicionarAvaliacao(avaliacao);
                    return true;
                }
            }
            return false;
        }
    }

    //sistema que remove avaliacao
    public boolean removerAvaliacao(String obra) {
        if (conteudos.isEmpty()) {
            return false;
        } else {
            for (Conteudo conteudo : conteudos) {
                if (conteudo.getTitulo().equalsIgnoreCase(obra)) {
                    for (Avaliacao avaliacao : conteudo.getAvaliacoes()) {
                        if (avaliacao.getEmail().equals(usuarioLogado.getEmail())) {
                            conteudo.getAvaliacoes().removeIf(avaliacao1 -> avaliacao1.getEmail().equals(usuarioLogado.getEmail()));
                            return true;
                        }
                    }
                }
            }
            return false;
        }
    }

    //buscar obra pelo nome
    public boolean buscaObra(String nome) {
        if (conteudos.isEmpty()) {
            return false;
        } else {
            for (Conteudo conteudo : conteudos) {
                if (conteudo.getTitulo().toLowerCase().contains(nome.toLowerCase())) {
                    System.out.println(conteudo.getInfo());
                    return true;
                }
            }
        }
        return false;
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

        boolean encontrou = false;

        for (Conteudo conteudo : conteudos) {
            if (conteudo instanceof Serie) {
                System.out.println(conteudo.getInfo());
                encontrou = true;
            }
        }
        return encontrou;
    }

    //Listar todos os filmes
    public boolean listarFilmes() {
        if (conteudos.isEmpty()) {
            return false;
        }

        boolean encontrou = false;

        for (Conteudo conteudo : conteudos) {
            if (conteudo instanceof Filme) {
                System.out.println(conteudo.getInfo());
                encontrou = true;
            }
        }
        return encontrou;
    }

    //sistema que mostra o perfil e as avaliacoes
    public boolean mostrarPerfil() {
        if (usuarios.isEmpty()) {
            return false;
        }

        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(usuarioLogado.getEmail())) {
                System.out.println(usuario.getInfo());
                for (Conteudo conteudo : conteudos) {
                    for (Avaliacao avaliacao : conteudo.getAvaliacoes()) {
                        if (avaliacao.getEmail().equals(getUsuarioLogado().getEmail())) {
                            System.out.println(avaliacao.getInfo());
                        }
                    }
                }
                return true;
            }
        }

        return false;
    }

    //puxa o usuario logado para validar o que ele pode fazer
    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }
}
