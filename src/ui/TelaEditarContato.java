package ui;

import dao.ListaTelefonica;
import model.Contato;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TelaEditarContato extends JDialog {

    private ListaTelefonica lista;
    private Contato contato;
    private  int indiceLista;
    private  JTextField campoNome;
    private  JTextField campoTelefone;
    private  JTextField campoEmail;

    public TelaEditarContato(JFrame parent, ListaTelefonica lista, Contato contato, int indiceLista){

        super(parent,"Editar contato",true);
        this.lista = lista;
        this.contato = contato;
        this.indiceLista = indiceLista;

        setSize(500, 300);
        setResizable(false);
        setLocationRelativeTo(parent);
        getContentPane().setBackground(Color.gray);
        setLayout(null);

        ImageIcon imagem = new ImageIcon(getClass().getResource("/resources/phonebook.png"));
        setIconImage(imagem.getImage());

        JLabel labelNome = new JLabel("Nome: ");
        labelNome.setBounds(30,30,80,25);
        add(labelNome);

        campoNome = new JTextField(contato.getNome());
        campoNome.setBounds(120,30,240,25);
        add(campoNome);




        JLabel labelTelefone = new JLabel("Telefone: ");
        labelTelefone.setBounds(30,70,60,25);
        add(labelTelefone);

        campoTelefone = new JTextField(contato.getTelefone());
        campoTelefone.setBounds(120,70,240,25);
        add(campoTelefone);


        JLabel labelEmail = new JLabel("Email: ");
        labelEmail.setBounds(30,110,80,25);
        campoEmail = new JTextField(contato.getEmail());
        campoEmail.setBounds(120,110,240,25);
        add(labelEmail);



        add(campoEmail);


        JButton botaoSalvar = new JButton("Salvar");
        botaoSalvar.setBounds(90,180,100,35);
        botaoSalvar.addActionListener((ActionEvent e) -> salvarEdicao());
        add(botaoSalvar);

        JButton botaoCancelar = new JButton("Cancelar");
        botaoCancelar.setBounds(220,180,100,35);
        botaoCancelar.addActionListener((ev -> dispose()));
        add(botaoCancelar);






    }


    private void salvarEdicao(){

        String novoNome = campoNome.getText().trim();
        String novoTelefone = campoTelefone.getText().trim();
        String novoEmail = campoEmail.getText().trim();

        if (!novoNome.isEmpty()) contato.setNome (novoNome);
        if (!novoTelefone.isEmpty()) contato.setTelefone (novoTelefone);
        if (!novoEmail.isEmpty()) contato.setEmail (novoEmail);

        lista.editarContato(
             this.contato,novoNome,novoTelefone,novoEmail

        );

        
        JOptionPane.showMessageDialog(this,"Contato alterado");
        dispose();

    }
}
