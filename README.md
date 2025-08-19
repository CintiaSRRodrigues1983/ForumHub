💬🚀 FórumHub - API REST divertida com Spring Boot! 🚀💬


📚 Sobre o Projeto:

Bem-vindo(a) ao FórumHub! Aqui você pode praticar, aprender, debater tecnologias... e ainda treinar aquele Java maroto com Spring Boot!

Este é o backend de um fórum completo, com autenticação JWT, filtros por tópicos e usuários, e muita energia boa!

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

✨ Funcionalidades Principais:

📝 Cadastro de Usuário: POST /usuario

🔐 Login seguro & Token JWT: POST /login

💡 Cadastro de Tópicos: POST /topicos

👀 Listagem de Tópicos: GET /topicos

🔍 Filtrar tópicos por curso/ano: GET /topicos/filtrado?curso=Java&ano=2025

📄 Listagem paginada: GET /topicos/paginado?page=0&size=10

📑 Detalhe do tópico: GET /topicos/{id}

🔄 Atualização de tópico: PUT /topicos/{id}

🗑️ Exclusão (delete) de tópico: DELETE /topicos/{id}

🔒 Proteção JWT: só entra com token válido, campeão!

💬 (Expansível) Respostas, perfis e muito mais!

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

🚦 Como rodar esse fórum?

1 - Clone repo 💻

2 - Configure seu application.properties com banco e JWT:


1 jwt.secret=umSegredoFeliz123

2 jwt.expiration=86400000

Rode o projeto (Run na IDE ou via terminal)

Use o Postman ou Insomnia com sorrisão no rosto 😄

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

✉️ Como brincar e testar?

1️⃣ Login

Faça um POST /login com:

json

1 {

2  "username": "admin",

3  "password": "senha123"

4 }

Receba seu Token JWT!

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

2️⃣ Não esqueça do token!

Coloque o header:



1   Authorization: Bearer SEU_TOKEN_ALEGRIA_AQUI

E pronto, agora pode usar e abusar dos endpoints protegidos! 🚀

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

🛠️ Tecnologias do bem:

☕ Java 17

🔗 Spring Boot

🔐 Spring Security & JWT

📚 Spring Data JPA

🐘 PostgreSQL (ou H2)

🍃 Lombok

✨ e muito amor pelo código :heart:

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

🎨 Organização do projeto

1 src/main/java/br/com/aluracursos/forumhub

2  ├─ config

3  ├─ controller

4  ├─ dto

5  ├─ model

6  ├─ repository

7  ├─ security

8  └─ service

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
  
👤 Autor(a)

Feito por Cintia Silveira Rosa Rodrigues com muita energia!

LinkedIn: https://www.linkedin.com/in/cintiasilveirarosa/

✉️ cintiasilveira_rosa@hotmail.com

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

🥳 Dicas para um desenvolvimento mais feliz!

Doe bons commits, com mensagens fáceis de entender 💬

Teste tudo usando Postman ou Insomnia 🔁

Valide JWT igual valida nova amizade: com atenção! 😂

Compartilhe sua evolução no LinkedIn, ajude a comunidade 🚀

Feliz codando

-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

Se quiser mais sugestões de emojis, prints do Postman, badges de build ou deploy, só pedir!

Divirta-se codando!












Code Interpreter

