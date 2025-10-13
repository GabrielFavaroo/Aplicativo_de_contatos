package dao;

import java.io.*;
public class Arquivo
{
   public static void salvar(String arquivo, String conteudo, 
   boolean adicionar)throws IOException {
    
          BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo, adicionar));
          writer.write(conteudo);
          writer.close();
    }
   


   public static String carregar(String arquivo)throws FileNotFoundException, 
   IOException{
    File file = new File (arquivo);
    if (!file.exists()) return null;
    BufferedReader br = new BufferedReader( new FileReader(arquivo));  
    String saida = "";
    String linha;
    while((linha = br.readLine()) != null) {
        saida += linha + "\n";
    }
    br.close();
    return saida;
}


public static boolean pesquisar(String arquivo, String pesquisa)
throws FileNotFoundException, IOException {
        File file = new File(arquivo);
        boolean retorno = false;
        if (!file.exists()){
        System.out.println("Esse arquivo não existe");
        return retorno;
        }
    BufferedReader br = new BufferedReader( new FileReader(arquivo));
    String linha;
    while((linha=br.readLine()) != null) {
    if (linha.equals(pesquisa)){
    System.out.println(linha);
    retorno = true;
    break;
    }
    
}
br.close();
return retorno;
}
    }

