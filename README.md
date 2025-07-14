# 🎬 Sistema de Avaliação de Filmes e Séries

Este projeto é um sistema de console em Java que permite aos usuários comuns avaliar filmes e séries, enquanto administradores podem cadastrar conteúdos. O sistema utiliza os princípios da Programação Orientada a Objetos, como herança, polimorfismo, abstração, composição e enums.

---

## 🛠️ Tecnologias Utilizadas

- **Java 17+**
- **POO (Programação Orientada a Objetos)**
- **Coleções (List)**
- **Enums**
- **Classes Abstratas**
- **Encapsulamento e Polimorfismo**
- **Console (Scanner)**

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

- **Admin:** Pode cadastrar filmes e séries.
- **Usuário Comum:** Pode avaliar conteúdos e visualizar avaliações.

---

## 🚀 Funcionalidades

### 1. Cadastro e Login
- Cadastro de Admin requer token de segurança.
- Evita e-mails duplicados.
- Autenticação de login com e-mail e senha.

### 2. Admin
- Cadastrar filmes (com título, data de lançamento, gênero, duração).
- Cadastrar séries (com título, data de lançamento, gênero, temporadas, episódios, status finalizada).

### 3. Usuário Comum
- Avaliar qualquer conteúdo já cadastrado.
- Comentários e notas são armazenados e listados.
- As avaliações são ordenadas por nota (maior para menor).

### 4. Sistema
- Evita cadastro de obras duplicadas.
- Exibe todas as obras com avaliações.
- Gêneros são definidos por `enum` (valores como AÇÃO, COMÉDIA, DRAMA...).

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
