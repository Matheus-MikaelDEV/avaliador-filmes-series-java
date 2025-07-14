package Model.Usuario;

public class Admin extends Usuario{
    public Admin(String nome, String email, String senha) {
        super(nome, email, senha);
    }

    @Override
    public String getInfo() {
        return "\nAdmnistrador\n" + "Nome: " + getNome();
    }
}
