package Model.Usuario;

import Model.Conteudo.Conteudo;

public class Comum extends Usuario {
    public Comum(String nome, String email, String senha) {
        super(nome, email, senha);
    }

    @Override
    public String getInfo() {
        return "\nUsuário comum\n" + "Nome: " + getNome();
    }
}
