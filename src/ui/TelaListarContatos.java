package ui;

import dao.ListaTelefonica;
import model.Contato;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class TelaListarContatos extends JDialog {

    private ListaTelefonica lista;
    private JTable tabela;
    private DefaultTableModel model;
    private JButton botaoExcluir, botaoAlterar;
    private JLabel labelNome, labelTelefone, labelEmail;

    public TelaListarContatos(JFrame parent, ListaTelefonica lista) {
        super(parent, "Exibição de contatos", true);
        this.lista = lista;

        setSize(800, 500);
        setResizable(false);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        ImageIcon imagem = new ImageIcon(getClass().getResource("/resources/phonebook.png"));
        setIconImage(imagem.getImage());


        String[] colunas = {"Nome", "Telefone", "Email"};
        model = new DefaultTableModel(colunas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tabela = new JTable(model);
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scroll = new JScrollPane(tabela);


        JPanel painelDireita = new JPanel();
        painelDireita.setLayout(new BoxLayout(painelDireita, BoxLayout.Y_AXIS));
        painelDireita.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        painelDireita.setPreferredSize(new Dimension(300, 0));

        labelNome = new JLabel("Nome: ");
        labelTelefone = new JLabel("Telefone: ");
        labelEmail = new JLabel("Email: ");

        botaoAlterar = new JButton("Alterar");
        botaoAlterar.setEnabled(false);

        botaoExcluir = new JButton("Excluir");
        botaoExcluir.setEnabled(false);

        painelDireita.add(labelNome);
        painelDireita.add(labelTelefone);
        painelDireita.add(labelEmail);
        painelDireita.add(Box.createVerticalStrut(20));
        painelDireita.add(botaoAlterar);
        painelDireita.add(botaoExcluir);


        JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scroll, painelDireita);
        split.setDividerLocation(480);
        add(split, BorderLayout.CENTER);


        carregarTabela();


        tabela.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int linha = tabela.getSelectedRow();
                    boolean selecionado = (linha != -1);
                    botaoAlterar.setEnabled(selecionado);
                    botaoExcluir.setEnabled(selecionado);

                    if (selecionado) {
                        labelNome.setText("Nome: " + tabela.getValueAt(linha, 0));
                        labelTelefone.setText("Telefone: " + tabela.getValueAt(linha, 1));
                        labelEmail.setText("Email: " + tabela.getValueAt(linha, 2));
                    } else {
                        labelNome.setText("Nome: ");
                        labelTelefone.setText("Telefone: ");
                        labelEmail.setText("Email: ");
                    }
                }
            }
        });


        botaoAlterar.addActionListener(ae -> {
            int linha = tabela.getSelectedRow();
            if (linha == -1) return;
           Contato c = lista.getContatos().get(linha);


                TelaEditarContato editar = new TelaEditarContato((JFrame) getParent(), lista, c , linha);
            editar.setVisible(true);
                atualizarTabela();
            });










    botaoExcluir.addActionListener(ae -> {
        int linha = tabela.getSelectedRow();
        if (linha == -1) return;
        int ok = JOptionPane.showConfirmDialog(this,"Tem certeza que deseja remover o contato?", "Confirmar",JOptionPane.YES_NO_OPTION);
        if (ok == JOptionPane.YES_NO_OPTION){

            Contato c = lista.getContatos().get(linha);
            lista.excluirContato(c);
            atualizarTabela();

        };





    });














       }
    public void carregarTabela(){ model.setRowCount(0);//inicia a tabelaa zerada
       ArrayList<Contato> contatos = lista.getContatos();
       for (Contato c : contatos) {
           model.addRow(new Object[]{c.getNome(), c.getTelefone(), c.getEmail()});//cada contato da lista é passado para a tabela
       }

    }
    public void atualizarTabela(){
            carregarTabela();
            tabela.clearSelection();
        labelNome.setText("Nome: ");
        labelTelefone.setText("Telefone: ");
        labelEmail.setText("Email: ");


    }
}
