package ui;


import dao.ListaTelefonica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaPrincipal {
private ListaTelefonica lista;
private JFrame framePrincipal;
JButton sair;
JButton adicionar;
JButton sobre;
JButton listacontatos;
JButton editar;
    public TelaPrincipal(ListaTelefonica lista) {

        framePrincipal = new JFrame();
        this.lista = lista;
        framePrincipal.setTitle("Lista Telefônica");
        framePrincipal.setLocationRelativeTo(null);//isso centralizaria a janela, porem demonstra erros

        ImageIcon imagem = new ImageIcon(getClass().getResource("/resources/phonebook.png"));//isso garante que qualquer um possa ter a imagem como icone, mesmo fora do computador principal
        framePrincipal.setIconImage(imagem.getImage());

        framePrincipal.setSize(750,750);//define o tamanho da janela
        framePrincipal.setResizable(false);//garante que nao seja possivel alterar o tamanho da janela


        framePrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        framePrincipal.setLayout(null);

        framePrincipal.getContentPane().setBackground( Color.gray);





        adicionar = new JButton("Adicionar contato");
        adicionar.setBounds(250,200,200,50);
        adicionar.addActionListener(e -> {TelaAdicionarContato dialog = new TelaAdicionarContato(framePrincipal, lista);dialog.setVisible(true);});



        sobre = new JButton("Sobre");
        sobre.setBounds(300,500,100,50);
        sobre.addActionListener(e -> new TelaSobre(framePrincipal).setVisible(true));


        sair = new JButton("Sair");
        sair.setBounds(300,600,100,50);
        sair.addActionListener(e -> System.exit(0));//ao clicar no botao sair, o aplicativo é fechado
        sair.setBackground(Color.RED);






        framePrincipal.add(sobre);
        framePrincipal.add(adicionar);
        framePrincipal.add(sair);
        framePrincipal.setVisible(true);//sempre deve ser o ultimo a ser executado para garantir que tudo ja foi carregado




        }


    }


