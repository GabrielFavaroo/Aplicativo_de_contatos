package ui;

import dao.ListaTelefonica;
import dao.Arquivo;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu{

private Scanner teclado;
private ListaTelefonica lista;
private Arquivo arquivo;




public Menu (){

        this.lista = new ListaTelefonica();
        this.arquivo = new Arquivo();

}

    public void Mostrarmenu(){



       
int opcao = 0;
        do{
        try {
System.out.println("\n--Sistema de Lista Telefonica--");                
System.out.println("1 - Listar todos os contatos cadastrados ");
System.out.println("2 - Procurar e listar por nome especifico");
System.out.println("3 - Adicionar contato");
System.out.println("4 - Excluir contato");
System.out.println("5 - Fechar programa");
opcao = teclado.nextInt();
teclado.nextLine();


        switch (opcao){
            case 1:
                lista.ExibirTodosOsContatos();
                break;
        case 2:
        System.out.println("Insira o nome do contato a Pesquisar: " );
        String nomePesquisa = teclado.nextLine();

                lista.pesquisar(nomePesquisa);
                break;
        case 3:
               //lista.Adicionar(String Nome,String Telefone,String Email);
               break;
        
        case 4:
                lista.excluirContato();
                break;
        case 5: 
        System.out.println("Fechando programa, ate mais! ");
        lista.SalvarLista("ListaDeContatos.txt",false);
        

                break;

        

        default:
        System.out.println("Opcao invalida, tente novamente");
                

        }} catch (InputMismatchException e) {
                System.out.println("Somente sao validos numeros para a opcao!!!");
                teclado.nextLine();
        }

        }
        while(opcao != 5);   
}}


        
        

    
    

    
