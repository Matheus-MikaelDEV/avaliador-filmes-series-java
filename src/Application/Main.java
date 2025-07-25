package Application;

import Maneger.Sistema;
import Model.Conteudo.Avaliacao;
import Model.Conteudo.Conteudo;
import Model.Conteudo.Filme;
import Model.Conteudo.Serie;
import Model.Usuario.Admin;
import Model.Usuario.Comum;
import Model.Usuario.Usuario;
import entities.enums.Genero;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Sistema de avaliação de filmes e séries!");

        System.out.print("Qual o token de cadastrar ADM? ");
        int token = sc.nextInt();
        sc.nextLine();

        int option = 0;
        String nome = "", email, senha;

        Sistema sistema = new Sistema();

        //Primeiro menu responsavel por cadastrar admin, comum e logar. Para se ter admin pode apenas se quem tem o token inicial.
        do {
            System.out.println("Menu: \n"+ "1 - Cadastrar Admin\n2 - Cadastrar Usuário Comum\n3 - Login\n4 - Fechar Programa");
            System.out.print("Opção: ");
            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    System.out.println("Cadastrando admin...");
                    System.out.print("Qual o nome do usuário? ");
                    nome = sc.nextLine();
                    System.out.print("Qual o email do usuário? ");
                    email = sc.nextLine();
                    System.out.print("Qual a senha do usuário? ");
                    senha = sc.nextLine();
                    System.out.print("Qual o token? ");
                    int token1 = sc.nextInt();
                    sc.nextLine();

                    if (token1 == token) {
                        Usuario admin = new Admin(nome, email, senha);

                        if (sistema.adicionarUsuario(admin)) {
                            System.out.println(admin.getInfo());
                            System.out.println("Admin cadastrado com sucesso!");
                        } else {
                            System.out.println("Email já cadastrado!");
                        }
                    } else {
                        System.out.println("Token inválido! Você não pode ser admin!");
                    }

                    break;
                case 2:
                    System.out.println("Cadastrando usuário comum...");

                    System.out.print("Qual o nome do usuário? ");
                    nome = sc.nextLine();
                    System.out.print("Qual o email do usuário? ");
                    email = sc.nextLine();
                    System.out.print("Qual a senha do usuário? ");
                    senha = sc.nextLine();

                    Usuario usuario = new Comum(nome, email, senha);

                    if (sistema.adicionarUsuario(usuario)) {
                        System.out.println(usuario.getInfo());
                        System.out.println("Usuário cadastrado com sucesso!");
                    } else {
                        System.out.println("Email já cadastrado!");
                    }

                    break;
                case 3:
                    System.out.println("Logando...");

                    System.out.print("Email: ");
                    email = sc.nextLine();
                    System.out.print("Senha: ");
                    senha = sc.nextLine();

                    if (sistema.login(email, senha)) {
                        System.out.println("Login realizado com sucesso!");

                        //verifica se ele é admin
                        if (sistema.getUsuarioLogado().getClass() == Admin.class) {

                            int option1 = 0;

                            //Segundo menu caso o usuario seja um adm do sistema ai ele tem o direito de cadastrar filmes ou series
                            do {
                                System.out.println("Menu: \n"+ "1 - Cadastrar Filme\n2 - Cadastrar Série\n3 - Listar Usuários\n4 - Remover Usuário\n5 - Deslogar");
                                System.out.print("Opção: ");
                                option1 = sc.nextInt();
                                sc.nextLine();

                                LocalDate dataDeLancamento;
                                Genero genero;

                                switch (option1) {

                                    case 1:

                                        //cadastrar filme
                                        System.out.println("Cadastrando filme...");
                                        System.out.print("Qual o nome do filme? ");
                                        nome = sc.nextLine();
                                        System.out.print("Qual a data de lançamento do filme (dd/MM/yyyy)? ");
                                        dataDeLancamento = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                                        System.out.print("Qual o gênero do filme (escreva sem acentos)? ");
                                        genero = Genero.valueOf(sc.nextLine().toUpperCase());
                                        System.out.print("Qual a duração do filme (em minutos)? ");
                                        Integer duracao = sc.nextInt();
                                        sc.nextLine();

                                        Conteudo filme = new Filme(nome, dataDeLancamento, genero, duracao);

                                        if (sistema.adicionarConteudo(filme)) {
                                            System.out.println(filme.getInfo());
                                            System.out.println("Filme cadastrado com sucesso!");
                                        } else {
                                            System.out.println("Filme já cadastrado!");
                                        }
                                        break;
                                    case 2:

                                        //cadastrar serie
                                        System.out.println("Cadastrando série...");
                                        System.out.print("Qual o nome da série? ");
                                        nome = sc.nextLine();
                                        System.out.print("Qual a data de lançamento da série (dd/MM/yyyy)? ");
                                        dataDeLancamento = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                                        System.out.print("Qual o gênero da série (escreva sem acentos)? ");
                                        genero = Genero.valueOf(sc.nextLine().toUpperCase());
                                        System.out.print("Qual a quantidade de temporadas da série? ");
                                        Integer temporadas = sc.nextInt();
                                        sc.nextLine();
                                        System.out.print("Qual a quantidade de episódios por temporada da série? ");
                                        Integer episodiosPorTemporada = sc.nextInt();
                                        sc.nextLine();
                                        System.out.print("Foi finalizada (sim ou não)? ");
                                        String finalizada = sc.nextLine().toLowerCase();

                                        Conteudo serie;

                                        if (finalizada.equals("sim")) {
                                            serie = new Serie(nome, dataDeLancamento, genero, temporadas, episodiosPorTemporada, true);
                                        } else {
                                            serie = new Serie(nome, dataDeLancamento, genero, temporadas, episodiosPorTemporada, false);
                                        }

                                        if (sistema.adicionarConteudo(serie)) {
                                            System.out.println(serie.getInfo());
                                            System.out.println("Série cadastrada com sucesso!");
                                        } else {
                                            System.out.println("Série já cadastrada!");
                                        }
                                        break;
                                    case 3:
                                        System.out.println("Listando usuários...");

                                        if (sistema.listarUsuarios()) {
                                            System.out.println("Usuários listados com sucesso!");
                                        } else {
                                            System.out.println("Nenhum usuário cadastrado!");
                                        }

                                        break;
                                    case 4:
                                        System.out.println("Removendo usuário...");

                                        System.out.print("Qual o id do usuário que deseja remover? ");
                                        int idUsuario = sc.nextInt();

                                        if (sistema.removerUsuario(idUsuario)) {
                                            System.out.println("Usuário removido com sucesso!");
                                        } else {
                                            System.out.println("Usuário não encontrado!");

                                        }

                                        break;
                                    case 5:
                                        System.out.println("Deslogando...");
                                        break;
                                    default:
                                        System.out.println("Opção inválida! Tente novamente:");
                                        break;
                                }

                            } while (option1 != 5);
                        } else if (sistema.getUsuarioLogado().getClass() == Comum.class) {
                            int option2 = 0;

                            do {
                                System.out.println("Menu: \n"+ "1 - Cadastrar Avaliação\n2 - Remover Avaliação\n3 - Listar Todos os Conteúdos\n4 - Listar Todas as Séries\n5 - Listar Todos os Filmes\n6 - Buscar\n7 - Perfil\n8 - Deslogar");
                                System.out.print("Opção: ");
                                option2 = sc.nextInt();
                                sc.nextLine();

                                switch (option2) {
                                    case 1:
                                        System.out.println("Cadastrando avaliação...");

                                        System.out.print("Qual obra ira avaliar? ");
                                        String obra = sc.nextLine();

                                        System.out.print("Comentário: ");
                                        String comentario = sc.nextLine();
                                        System.out.print("Nota: ");
                                        Integer nota = sc.nextInt();
                                        sc.nextLine();

                                        Avaliacao avaliacao = new Avaliacao(sistema.getUsuarioLogado().getNome(), comentario, nota, sistema.getUsuarioLogado().getEmail());

                                        if (sistema.adicionarAvaliacao(avaliacao, obra)) {
                                            System.out.println("Avaliação cadastrada com sucesso!");
                                        } else {
                                            System.out.println("Obra não encontrada!");
                                        }

                                        break;
                                    case 2:
                                        System.out.println("Removendo avaliação...");

                                        System.out.print("Qual o filme que você deseja remover sua avaliação? ");
                                        nome = sc.nextLine();

                                        if (sistema.removerAvaliacao(nome)) {
                                            System.out.println("Avaliação removida com sucesso!");
                                        } else {
                                            System.out.println("Avaliação não encontrada!");
                                        }

                                        break;
                                    case 3:
                                        System.out.println("Listando todos os conteúdos...");

                                        if (sistema.listarTudo()) {
                                            System.out.println("Conteúdos listados com sucesso!");
                                        } else {
                                            System.out.println("Nenhum conteúdo cadastrado!");
                                        }

                                        break;
                                    case 4:
                                        System.out.println("Listando todas as séries...");

                                        if (sistema.listarSeries()) {
                                            System.out.println("Séries listadas com sucesso!");
                                        } else {
                                            System.out.println("Nenhuma série cadastrada!");
                                        }

                                        break;
                                    case 5:
                                        System.out.println("Listando todos os filmes...");

                                        if (sistema.listarFilmes()) {
                                            System.out.println("Filmes listados com sucesso!");
                                        } else {
                                            System.out.println("Nenhum filme cadastrado!");
                                        }

                                        break;
                                    case 6:
                                        System.out.println("Buscando...");

                                        System.out.print("Título da obra que deseja localizar: ");
                                        nome = sc.nextLine();

                                        if (sistema.buscaObra(nome)) {
                                            System.out.println("Obra encontrada!");
                                        } else {
                                            System.out.println("Obra não encontrada!");
                                        }

                                        break;
                                    case 7:
                                        System.out.println("Mostrando seu perfil...");

                                        if (sistema.mostrarPerfil()) {
                                            System.out.println("Perfil encontrado com sucesso!");
                                        } else {
                                            System.out.println("Perfil não encontrado!");
                                        }

                                        break;
                                    case 8:
                                        System.out.println("Deslogando...");
                                        break;
                                    default:
                                        System.out.println("Opção inválida! Tente novamente:");
                                        break;
                                }

                            } while (option2 != 8);
                        }
                    } else {
                        System.out.println("Email ou senha incorretos!");
                    }

                    break;
                case 4:
                    System.out.println("Fechando programa...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente:");
                    break;
            }
        } while (option != 4);
    }
}
