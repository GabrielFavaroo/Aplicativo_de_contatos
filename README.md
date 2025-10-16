# 📞 Lista Telefônica em Java

Projeto de **Lista Telefônica** desenvolvido em **Java**, com persistência de dados em arquivo texto (`ListaDeContatos.txt`) e interface de console. Organizado em **arquitetura em camadas**, facilitando futuras melhorias e a implementação de interface gráfica com **Swing**.

---

## 🔹 Funcionalidades atuais (CRUD)

- Listar todos os contatos cadastrados
- Pesquisar contatos por nome
- Adicionar novos contatos
- Excluir contatos existentes
- Salvar e carregar contatos de/para arquivo texto

---

## 🗂 Estrutura do projeto

src/
└── br/com/gabrielfavaro/listatelefonica/
├── model/ → classes de dados (Contato.java)
├── dao/ → CRUD da lista e persistência (ListaTelefonica.java, Arquivo.java)
├── service/ → regras de negócio (opcional, para validações futuras)
├── ui/ → interface com o usuário (Menu.java, futura versão Swing)
└── main/ → classe Main.java para iniciar o programa

markdown
Copiar código

- **model/** → representa os dados de um contato (`nome`, `telefone`, `email`)
- **dao/** → contém CRUD e gerencia a persistência em arquivo
- **service/** → camada opcional para regras de negócio
- **ui/** → menu de console atual e futuras telas Swing
- **main/** → inicializa o programa

---

## ⚙️ Tecnologias utilizadas

- Java SE 8+
- Manipulação de arquivos (`BufferedReader`, `BufferedWriter`)
- Estrutura de dados `ArrayList` para armazenar contatos

---

## 🚀 Como executar

1. Clone o repositório:

```bash
git clone https://github.com/OrcadiusDev/contatos.git
cd contatos


```
Compile e execute:
```bash
cd src
javac br/com/gabrielfavaro/listatelefonica/main/Main.java
java br.com.gabrielfavaro.listatelefonica.main.Main

```
O programa abrirá o menu de console, onde você poderá interagir com a lista de contatos.

📌 Observações
Contatos são persistidos em ListaDeContatos.txt.

A estrutura modularizada permite fácil evolução para interface gráfica (Swing) ou integração com banco de dados.

Segue boas práticas de programação, separando dados, persistência, regras de negócio e interface.

🎯 Próximos passos
Implementar interface gráfica completa com Swing

Adicionar edição de contatos existentes

Melhorar validações de dados (telefone, email)

Integrar com banco de dados ou armazenamento online

Feito por Gabriel Favaro | Java Developer