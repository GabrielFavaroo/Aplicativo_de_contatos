package ui;
import dao.ListaTelefonica;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaAdicionarContato extends JDialog{
    private ListaTelefonica lista;
    JTextField textoNome;
    JTextField textoTelefone;
    JTextField textoEmail;

   TelaAdicionarContato(JFrame parent,ListaTelefonica lista){

        super(parent,"Adicionar contato",true);
       this.lista = lista;

       ImageIcon imagem = new ImageIcon(getClass().getResource("/resources/phonebook.png"));//isso garante que qualquer um possa ter a imagem como icone, mesmo fora do computador principal
       setSize(600,400);
       setResizable(false);
       setLocationRelativeTo(parent);
       getContentPane().setBackground(Color.gray);
       setLayout(null);

       textoNome = new JTextField();
       textoNome.setBackground(Color.white);
        textoNome.setBounds(230,60,200,30);
        JLabel indicadorNome = new JLabel("Nome",SwingConstants.CENTER);
        indicadorNome.setBounds(80,60,200,30);


      textoTelefone = new JTextField();
       textoTelefone.setBackground(Color.white);
       textoTelefone.setBounds(230,120,200,30);
       JLabel indicadorTelefone = new JLabel("Telefone",SwingConstants.CENTER);
       indicadorTelefone.setBounds(80,120,200,30);

       textoEmail = new JTextField();
       textoEmail.setBackground(Color.white);
        textoEmail.setBounds(230,180,200,30);
       JLabel indicadorEmail = new JLabel("Email",SwingConstants.CENTER);
        indicadorEmail.setBounds(80,180,200,30);

       JButton adicionarContato = new JButton("Adicionar contato");
       adicionarContato.setBounds(180, 230, 200, 50);
       adicionarContato.addActionListener( this::addContato);


       JButton voltar = new JButton("Voltar");
       voltar.setBounds(230, 300, 100, 50);
       voltar.addActionListener(e -> dispose());

       add(indicadorNome);
       add(indicadorEmail);
       add(indicadorTelefone);


       add(adicionarContato);
       add(textoTelefone);
       add(textoNome);
       add(textoEmail);
       add(voltar);;


   }


    public void addContato(ActionEvent e){
        String Nome = textoNome.getText();
        String Telefone = textoTelefone.getText();
        String Email = textoEmail.getText();

       lista.Adicionar(Nome,Telefone,Email);
        lista.SalvarLista("ListaDeContatos.txt",false);
       JOptionPane.showMessageDialog(this,"Contato salvo com sucesso");
       dispose();
   }



}
