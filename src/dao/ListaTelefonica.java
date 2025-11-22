package dao;

import model.Contato;

import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;



public class ListaTelefonica {

private ArrayList<Contato> contatos  = new ArrayList<>();

private Scanner teclado;



public ArrayList<Contato> getContatos(){
  contatos.clear();
  String sql = "SELECT id,nome,telefone,email FROM contato ORDER BY nome";

  try(Connection conn = ConexaoDB.getConnection();
    java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
    java.sql.ResultSet rs = stmt.executeQuery()) {

        if(conn == null) {
            System.err.println("Conexao com o banco de dados falhou ao listar contatos");
            return contatos;
        }

        while (rs.next()) {
            Integer id = rs.getInt("id");         
            String nome = rs.getString("nome");
            String telefone = rs.getString("telefone");
            String email = rs.getString("email");
          
            Contato novoContato = new Contato(id,nome, telefone, email);
            contatos.add(novoContato);


            } }catch(SQLException e) {
          System.err.println("Erro ao listar contatos do banco de dados");
          e.printStackTrace();
        }
         
    
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

public void editarContato(Contato c, String novoNome, String novoEmail, String novoTelefone){//recebe o contato de parametro e já traz os passiveis valores, que sao implementados caso nao sejam vazios nem nulos

  if(c == null || c.getId() == null){
    System.err.println("Erro ao editar contato, nome ou Id invalidos");
    return;
  }

  if(!novoNome.isEmpty()){c.setNome(novoNome);}
  if(!novoTelefone.isEmpty()){c.setTelefone(novoTelefone);}
  if(!novoEmail.isEmpty()){c.setEmail(novoEmail);}


  String sql = "UPDATE contato SET nome = ?,telefone = ?,email = ? WHERE id = ?";

  try(Connection conn = ConexaoDB.getConnection();
        java.sql.PreparedStatement stmt = conn.prepareStatement(sql)){

  

    stmt.setString(1, c.getNome());
    stmt.setString(2, c.getTelefone());
    stmt.setString(3, c.getEmail());
    stmt.setInt(4, c.getId());
    
    int linhasAfetadas = stmt.executeUpdate();
    if (linhasAfetadas > 0) {
      System.out.println("Contato atualizado com sucesso");
      
    }


    }catch (SQLException e){
      System.err.println("Erro ao editar contato no banco de dados");
      e.printStackTrace();
    }


  }

public void Adicionar(String nome, String telefone, String email){

  String sql = "INSERT INTO contato (nome,telefone,email) VALUES (?,?,?)";

      try (Connection conn = ConexaoDB.getConnection();
      java.sql.PreparedStatement stmt = conn.prepareStatement(sql)
      ){
          if (conn == null) {
            return;
            
          }
          stmt.setString(1, nome);
          stmt.setString(2, telefone);
          stmt.setString(3, email);

          int linhasAfetadas = stmt.executeUpdate();

          if(linhasAfetadas > 0){
            System.out.println("Contato salvo com sucesso no banco de dados.");
          }


      } catch (SQLException e) { 
        System.err.println("Erro ao inserir contato no banco de dados.");
        e.printStackTrace();
      }


    }




public void excluirContato(Contato contato) {

  if (contato.getId() == null || contato == null) 
{
  System.out.println("Contato não encontrado");
}

  String sql = "DELETE FROM Contato WHERE id = ?";

      try(Connection conn = ConexaoDB.getConnection();
      java.sql.PreparedStatement stmt = conn.prepareStatement(sql)){

        stmt.setInt(1,contato.getId());
        int linhasAfetadas = stmt.executeUpdate();

        if(linhasAfetadas > 0) {
          System.out.println("Contato (Id: "+contato.getId()+"excluido do banco de dados");
        }

        contatos.remove(contato);


}catch(SQLException e){
  System.err.println("Erro ao excluir contato");
  e.printStackTrace();
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

}




