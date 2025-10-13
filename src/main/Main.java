package main;

import dao.ListaTelefonica;
import ui.Menu;
import java.util.Scanner;
class Main {
public static void main(String[] args) throws Exception {

    Scanner teclado = new Scanner(System.in);

    ListaTelefonica lista = new ListaTelefonica(teclado);

    lista.carregarLista("ListaDeContatos.txt");

    Menu menu = new Menu(teclado);
    
    menu.Mostrarmenu();
    
}
}
