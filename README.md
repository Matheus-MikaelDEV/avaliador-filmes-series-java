# 🎬 Sistema de Avaliação de Filmes e Séries

Este projeto é um sistema de console em Java que permite aos usuários comuns avaliar filmes e séries, enquanto administradores podem cadastrar conteúdos. O sistema utiliza os princípios da Programação Orientada a Objetos, como herança, polimorfismo, abstração, composição e enums.

---

## 🛠️ Tecnologias Utilizadas

- Java 17+
- Programação Orientada a Objetos (POO)
- Coleções (List)
- Enums
- Classes Abstratas
- Encapsulamento e Polimorfismo
- Entrada pelo Console (`Scanner`)

---

## 📁 Estrutura do Projeto

```
src/
├── Application/
│   └── Main.java
├── Maneger/
│   └── Sistema.java
├── Model/
│   ├── Conteudo/
│   │   ├── Avaliacao.java
│   │   ├── Conteudo.java
│   │   ├── Filme.java
│   │   └── Serie.java
│   └── Usuario/
│       ├── Admin.java
│       ├── Comum.java
│       └── Usuario.java
├── entities/
│   └── enums/
│       └── Genero.java
```

---

## 👤 Tipos de Usuário

- **Admin:** Pode cadastrar filmes e séries, listar e remover usuários.
- **Usuário Comum:** Pode avaliar conteúdos e visualizar avaliações.

---

## 🚀 Funcionalidades

### Cadastro e Login

- Cadastro de Admin requer token de segurança.
- Evita e-mails duplicados.
- Autenticação por e-mail e senha.

### Admin

- Cadastrar filmes (título, data de lançamento, gênero, duração).
- Cadastrar séries (título, data de lançamento, gênero, temporadas, episódios por temporada, status finalizada).
- Listar usuários cadastrados.
- Remover usuários.

### Usuário Comum

- Avaliar qualquer conteúdo cadastrado (com comentário e nota).
- Listar todos os conteúdos, somente séries ou somente filmes.
- Avaliações são armazenadas e exibidas ordenadas por nota (maior para menor).

### Sistema

- Evita cadastro duplicado de usuários e conteúdos.
- Gêneros são definidos por enum (`Genero`) com valores como AÇÃO, COMÉDIA, DRAMA, etc.

---

## ✅ Exemplo de Uso

```bash
$ java Main
Sistema de avaliação de filmes e séries!
Qual o token de cadastrar ADM? 1234
Menu:
1 - Cadastrar Admin
2 - Cadastrar Usuário Comum
3 - Login
4 - Fechar Programa
```

---

## ⚙️ Fluxo principal do sistema (Baseado em `Main.java`)

1. Solicita token para cadastrar administrador.
2. Menu inicial com opções para:
   - Cadastrar administrador (token obrigatório).
   - Cadastrar usuário comum.
   - Login.
   - Fechar programa.

3. Após login, mostra menus conforme o tipo de usuário:

   - **Admin:**
     - Cadastrar filmes.
     - Cadastrar séries.
     - Listar usuários.
     - Remover usuários.
     - Deslogar.

   - **Usuário Comum:**
     - Cadastrar avaliação em obras existentes.
     - Listar todos os conteúdos.
     - Listar todas as séries.
     - Listar todos os filmes.
     - Deslogar.

---

## 📝 Observações

- As datas devem ser inseridas no formato `dd/MM/yyyy`.
- Gêneros devem ser escritos sem acentos e em letras maiúsculas (ex: `ACAO`, `COMEDIA`, `DRAMA`).
- Avaliações são vinculadas ao usuário logado.

---

## Contato

Projeto criado por Matheus Mikael.

---
