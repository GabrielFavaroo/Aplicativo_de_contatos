package main;

import dao.ListaTelefonica;
import ui.Menu;
import ui.TelaPrincipal;

import java.util.Scanner;
class Main {
public static void main(String[] args) throws Exception {

    Scanner teclado = new Scanner(System.in);

    ListaTelefonica lista = new ListaTelefonica();

    

    new TelaPrincipal(lista);
    //Menu menu = new Menu();
    
   // menu.Mostrarmenu();


}
}
