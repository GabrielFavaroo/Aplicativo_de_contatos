package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaSobre extends JDialog {


    public TelaSobre(JFrame parent) {
        super(parent, "Sobre o programa", true);

        ImageIcon imagem = new ImageIcon(getClass().getResource("/resources/phonebook.png"));//isso garante que qualquer um possa ter a imagem como icone, mesmo fora do computador principal
        setSize(400,300);
        setResizable(false);
        setLocationRelativeTo(parent);
        getContentPane().setBackground(Color.gray);
        setLayout(null);

        JLabel textosobre = new JLabel("<html><center><font color= 'black'>Aplicativo feito por Gabriel Barbosa <br> programador back-end java <br> Icone retirado do site FlatIcon <br> Criador do icone: Iamkikirizky</center></html>",SwingConstants.CENTER);
        textosobre.setBounds(50,50,300,100);
        textosobre.setOpaque(true);

        textosobre.setBackground(Color.darkGray);
        add(textosobre);

        JButton voltar = new JButton("Voltar");


        voltar.setBounds(150, 170, 100, 50);
        voltar.addActionListener(e -> dispose());

        add(voltar);
    }

}

