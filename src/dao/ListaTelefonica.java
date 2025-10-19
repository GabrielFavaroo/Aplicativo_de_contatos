package dao;

import model.Contato;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;



public class ListaTelefonica {

private ArrayList<Contato> contatos  = new ArrayList<>();

private Scanner teclado;

public ListaTelefonica(){

  carregarLista("ListaDeContatos.txt");

}


    public ArrayList<Contato> getContatos() {
        return contatos;
    }

    public void ExibirTodosOsContatos(){

  //System.out.println("--Inicio da Lista--");

for( Contato cnt : contatos ){
System.out.println(cnt.getNome());
System.out.println(cnt.getTelefone());     
System.out.println(cnt.getEmail());

}
//System.out.println("--Fim da Lista--");

}

public void editarContato(Contato c, String novoNome, String novoEmail, String novoTelefone)//recebe o contato de parametro e já traz os passiveis valores, que sao implementados caso nao sejam vazios nem nulos

{
    if(!novoNome.isEmpty() && novoNome.isEmpty()){c.setNome(novoNome);}
    if(!novoTelefone.isEmpty() && novoTelefone.isEmpty()){c.setTelefone(novoTelefone);}
    if(!novoEmail.isEmpty() && novoEmail.isEmpty()){c.setEmail(novoEmail);}


    try {
        SalvarLista("ListaDeContatos.txt",false);

    }catch (Exception e){}
}



public void Adicionar(String Nome, String Telefone, String Email){

/*
System.out.println("--Adicionando contato--");
    System.out.println("Insira o Nome: ");
String Nome = teclado.nextLine(); 

System.out.println("Insira o Telefone: ");
String Telefone = teclado.nextLine();

System.out.println("Insira o Email: ");
String Email = teclado.nextLine();
*/
  Contato novoContato = new Contato(Nome,Telefone,Email);
    contatos.add(novoContato);
    SalvarLista("ListaDeContatos.txt",false);


    }




public void excluirContato(){

System.out.println("Insira o nome do contato para Excluir");
String nomeParaExcluir = teclado.nextLine();

Contato cnt = pesquisar(nomeParaExcluir);

if( cnt != null){
  System.out.println(cnt.getNome()+" foi removido da sua lista de contatos");
  contatos.remove(cnt);}
else{
  System.out.println("O contato fornecido não existe na lista, portanto nada foi removido.");
}  

}






public Contato pesquisar(String nomePesquisa){
  

for(Contato cnt : contatos){
  
  if (cnt.getNome().equalsIgnoreCase(nomePesquisa)){
  System.out.println("O contato -" + nomePesquisa + "- foi encontrado na lista");
  return cnt;

}
}
System.out.println("Nada foi encontrado com o nome -" + nomePesquisa+ "- na sua lista de contatos");
  return null ;
}




public String ListaParaTexto(){
  StringBuilder sb = new StringBuilder();
  
  for (Contato cnt : contatos){
sb.append(cnt.getNome()).append("\n") ;
sb.append(cnt.getTelefone()).append( "\n");
sb.append(cnt.getEmail()).append("\n");


  }
return sb.toString();

}



public void SalvarLista(String arquivo, boolean adicionar){
  try{
    String conteudo = ListaParaTexto();  
   
if(conteudo == null || conteudo.isEmpty()){
  System.out.println("A lista se encontra vazia");
return;
}
 Arquivo.salvar(arquivo, conteudo, adicionar);
  System.out.println("dao.Arquivo salvo com sucesso");
  }
    
catch( IOException e){
  System.out.println("Não foi possivel carregar o arquivo");
}

}





public void carregarLista(String arquivo){
try {
      
String conteudo = Arquivo.carregar(arquivo);
 if(conteudo == null || conteudo.isEmpty()){
     System.out.println("Nada foi achado");
     return;
 }


ArrayList<String> linhasValidas = new ArrayList<>();
String[] linhas = conteudo.split("\n");

for( String linha : linhas){
if(!linha.trim().isEmpty())
{
    linhasValidas.add(linha.trim());

}
}



  if(conteudo == null|| conteudo.isEmpty()){return;}



for(int i = 0;i < linhasValidas.size() ; i += 3 ){
  if( i + 2 >= linhasValidas.size())break;

  String nome=linhasValidas.get(i);
  String telefone = linhasValidas.get(i + 1);
  String email = linhasValidas.get(i + 2);

Contato cnt = new Contato(nome, telefone, email);
contatos.add(cnt);

}

}catch (IOException e) {
  System.out.println("Não foi possivel carregar o arquivo");
 
}

}
 
}

