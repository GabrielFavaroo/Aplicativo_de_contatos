📇 Aplicativo_de_contatos

Aplicativo_de_contatos é uma aplicação Java desenvolvida com Swing que oferece um sistema simples e eficiente para gerenciamento de contatos pessoais. A aplicação permite cadastrar, listar, editar e remover contatos, agora armazenando os dados em um banco de dados PostgreSQL. Este projeto continua com foco em aprendizado de POO e interfaces gráficas com Java Swing.

🧱 Estrutura do Projeto

O projeto mantém a organização em camadas:

AppContatos/
├── dao/                # Camada de acesso a dados (PostgreSQL)
│   └── ListaTelefonica.java
├── model/              # Representação das entidades principais
│   └── Contato.java
├── ui/                 # Interface gráfica com Swing
│   ├── TelaPrincipal.java
│   ├── TelaListarContatos.java
│   ├── TelaAdicionarContato.java
│   └── TelaEditarContato.java
└── config/             # Configurações de conexão com PostgreSQL
    └── DatabaseConfig.java

🧩 Descrição das Camadas
🔸 model — Camada de Modelo

Contém a classe Contato, representando um contato com atributos:

nome

telefone

email

Inclui getters e setters para garantir encapsulamento.

🔸 dao — Camada de Dados

Responsável por manipular contatos no PostgreSQL.

A classe ListaTelefonica agora:

Conecta ao banco PostgreSQL usando JDBC;

Permite adicionar, remover, listar e editar contatos;

Executa queries SQL para persistência e recuperação de dados.

Exemplo de conexão:

Connection conn = DriverManager.getConnection(
    "jdbc:postgresql://localhost:5432/lista_telefonica", "usuario", "senha"
);

🔸 ui — Interface Gráfica (Swing)

Contém janelas e diálogos para interação com o usuário:

Tela	Descrição
TelaPrincipal	Janela inicial, centraliza acesso às funções
TelaListarContatos	Exibe todos os contatos, permite seleção e remoção
TelaAdicionarContato	Formulário para inserir novos contatos
TelaEditarContato	Permite alterar informações de um contato existente

Cada tela usa JFrame ou JDialog, e botões acionam listeners para executar ações na camada dao.

🖥️ Tecnologias e Conceitos Utilizados

Java SE 8+

Swing para interface gráfica

JDBC para conexão com PostgreSQL

Collections (ArrayList) para manipulação em memória

POO (encapsulamento, modularização, composição)

🚀 Funcionalidades Atuais

✅ Adicionar, listar, editar e remover contatos
✅ Persistência de dados em PostgreSQL
✅ Interface gráfica intuitiva
✅ Carregamento automático de contatos do banco ao iniciar a aplicação

⚙️ Como Configurar e Executar
1️⃣ Instalar PostgreSQL

Baixe do site oficial
 ou use o gerenciador de pacotes do seu sistema.

2️⃣ Criar Banco de Dados e Tabela
CREATE DATABASE lista_telefonica;

\c lista_telefonica

CREATE TABLE contatos (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100),
    telefone VARCHAR(20),
    email VARCHAR(100)
);

3️⃣ Configurar Conexão no Projeto

No arquivo config/DatabaseConfig.java:

public class DatabaseConfig {
    public static final String URL = "jdbc:postgresql://localhost:5432/lista_telefonica";
    public static final String USER = "usuario";
    public static final String PASSWORD = "senha";
}

4️⃣ Executar o Projeto
git clone https://github.com/GabrielFavaroo/Aplicativo_de_contatos.git
cd AppContatos

# Compile
javac -cp ".:postgresql-<versão>.jar" ui/TelaPrincipal.java

# Execute
java -cp ".:postgresql-<versão>.jar" ui.TelaPrincipal


Lembre-se de adicionar o driver JDBC do PostgreSQL no classpath (postgresql-<versão>.jar).

🔮 Futuras Melhorias

Busca e filtragem inteligente de contatos

Exportação/importação para CSV, JSON ou PDF

Backup automático e restauração de banco

Interface mais moderna com dark mode e ícones

Testes automatizados com JUnit

Estatísticas e relatórios sobre contatos

Sincronização em nuvem

🤝 Como Contribuir

Faça um fork do repositório

Crie uma branch: git checkout -b minha-feature

Faça alterações e commit: git commit -m "Descrição da mudança"

Envie para seu fork: git push origin minha-feature

Abra um Pull Request detalhando suas modificações

👨‍💻 Autor

Gabriel Favaro (GabrielFavaroo)
💼 Desenvolvedor Java e entusiasta de aplicações desktop
📫 GitHub: github.com/GabrielFavaroo
