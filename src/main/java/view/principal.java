package view;

import view.cadastro.cadastrarUsuarios;
import view.cadastro.cadastroLivros;
import view.lista.listaLivros;
import view.lista.listaUsuario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class principal extends JFrame {
    private JPanel jpanel1;
    private JMenuBar menubar;

    public principal() {
        criacaoDoMenu();
        this.setTitle("Sistema de Gestão de Biblioteca");
        this.setContentPane(jpanel1);
        this.setSize(640, 480);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void criacaoDoMenu() {
        menubar = new JMenuBar();
        this.setJMenuBar(menubar);


        JMenu arquivo = new JMenu("Arquivo");
        JMenuItem sair = new JMenuItem("Sair");
        sair.addActionListener(e -> System.exit(0));
        arquivo.add(sair);
        menubar.add(arquivo);


        JMenu areaCadastro = new JMenu("CRUD Usuario - Livros");
        JMenuItem cadastrarUsuarios = new JMenuItem("Cadastrar Usuários");
        JMenuItem cadastroLivros = new JMenuItem("Cadastrar Livros");
        JMenuItem listaUsuario = new JMenuItem("Listar Usuários");
        JMenuItem listaLivros = new JMenuItem("Listar Livros");
        areaCadastro.add(cadastrarUsuarios);
        areaCadastro.add(listaUsuario);
        areaCadastro.add(cadastroLivros);
        areaCadastro.add(listaLivros);
        menubar.add(areaCadastro);

        cadastrarUsuarios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new cadastrarUsuarios();
            }
        });

        cadastroLivros.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new cadastroLivros();
            }
        });

        listaUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new listaUsuario();
            }
        });
        listaLivros.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new listaLivros();
            }
        });
    }

//    public static void main(String[] args) {
//        new principal();
//    }
}
