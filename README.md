📇 AppContatos

AppContatos é uma aplicação Java desenvolvida com Swing que tem como objetivo oferecer um sistema simples e eficiente para gerenciamento de contatos pessoais.
A aplicação permite cadastrar, listar, editar e remover contatos, armazenando os dados em um arquivo local de texto.
Este projeto foi criado com foco no aprendizado de programação orientada a objetos (POO) e desenvolvimento de interfaces gráficas com Java Swing.

🧱 Estrutura do Projeto

O projeto é dividido em camadas para manter o código limpo, organizado e de fácil manutenção:

AppContatos/
│
├── dao/                  # Camada de acesso a dados
│   └── ListaTelefonica.java
│
├── model/                # Representação das entidades principais
│   └── Contato.java
│
├── ui/                   # Interface gráfica com Swing
│   ├── TelaPrincipal.java
│   ├── TelaListarContatos.java
│   ├── TelaAdicionarContato.java
│   └── TelaEditarContato.java
│
└── ListaDeContatos.txt   # Arquivo local onde os dados são persistidos

🧩 Descrição das Camadas
🔸 model — Camada de Modelo

Contém a classe Contato, que representa um objeto real com atributos:

nome

telefone

email

Essa classe também implementa os métodos de acesso (getters e setters), garantindo o encapsulamento dos dados.

🔸 dao — Camada de Dados

Responsável pela manipulação e persistência dos contatos.
A classe ListaTelefonica atua como um "controlador de dados", sendo capaz de:

Adicionar e remover contatos;

Listar todos os registros existentes;

Ler e gravar os dados no arquivo ListaDeContatos.txt utilizando Java I/O.

A leitura é feita linha por linha, e os dados são separados por delimitadores, permitindo reconstruir os objetos Contato quando o sistema é iniciado.

🔸 ui — Interface Gráfica (Swing)

O pacote ui contém as janelas e diálogos que compõem a interface do usuário:

Tela	Descrição Detalhada
TelaPrincipal	Tela inicial do aplicativo, centraliza o acesso às demais funções.
TelaListarContatos	Exibe todos os contatos em uma lista. Permite selecionar e remover contatos.
TelaAdicionarContato	Formulário para inserir novos contatos, com campos de nome, telefone e e-mail.
TelaEditarContato	Permite alterar as informações de um contato existente de forma simples.

Cada tela é construída utilizando JFrame ou JDialog, aplicando o paradigma orientado a eventos, onde cada botão executa uma ação específica através de listeners.

🖥️ Tecnologias e Conceitos Utilizados

Java SE 8+

Swing para a interface gráfica

Java I/O (FileReader / FileWriter / BufferedReader / BufferedWriter) para leitura e gravação

Collections (ArrayList) para armazenamento em memória

POO (encapsulamento, composição, modularização)

🚀 Funcionalidades Atuais

✅ Adicionar contato com nome, telefone e e-mail
✅ Listar contatos armazenados localmente
✅ Remover contatos de forma simples
✅ Editar informações de contatos já salvos
✅ Salvar e carregar dados automaticamente do arquivo ListaDeContatos.txt
✅ Interface gráfica intuitiva e didática

⚙️ Como Executar o Projeto

Clone o repositório:

git clone https://github.com/OrcadiusDev/AppContatos.git


Abra o projeto no seu ambiente Java preferido (Eclipse, IntelliJ IDEA, NetBeans ou VS Code com extensão Java).

Compile e execute a classe principal:

javac ui/TelaPrincipal.java
java ui.TelaPrincipal


A janela principal será aberta, permitindo adicionar e gerenciar contatos de forma interativa.

🧭 Status do Projeto

📌 Concluído parcialmente

A base funcional está completa e estável, mas novas melhorias estão planejadas para aprimorar a experiência e as possibilidades de uso.

🔮 Futuras Melhorias Planejadas
🔍 Filtragem e Busca Inteligente

Implementar busca por nome, telefone ou e-mail em tempo real.

Adicionar filtros personalizados (ex.: contatos com e-mail corporativo, ordem alfabética, etc).

📖 Mais Opções de Leitura e Exportação

Exibição detalhada de um contato ao clicar sobre ele.

Exportar lista de contatos para CSV, JSON ou PDF.

Importação de contatos a partir de arquivos externos.

🧱 Persistência Avançada

Substituir o arquivo .txt por um banco de dados SQLite ou MySQL.

Criar um sistema de backup e restauração automática.

🎨 Interface e Usabilidade

Atualização do layout Swing com ícones, cores e fontes modernas.

Adição de atalhos de teclado e mensagens de confirmação mais claras.

Possibilidade de visualização em modo escuro (dark mode).

🧪 Outras Ideias

Implementação de testes automatizados (JUnit).

Módulo de estatísticas e relatórios (ex.: total de contatos, duplicatas, etc).

Possibilidade de sincronização em nuvem no futuro.





🤝 Como Contribuir

Se você quiser sugerir melhorias ou colaborar com o projeto:

Faça um fork do repositório

Crie uma nova branch para sua modificação:

git checkout -b minha-feature


Realize as alterações desejadas e faça o commit:

git commit -m "Melhoria na filtragem de contatos"


Envie suas alterações:

git push origin minha-feature


Abra um Pull Request descrevendo suas mudanças.

👨‍💻 Autor

Gabriel Favaro (OrcadiusDev)
💼 Desenvolvedor Java e entusiasta em projetos educacionais e aplicações desktop.
📫 GitHub: github.com/OrcadiusDev
