package view;

import controller.LivrosController;
import model.LivrosModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

public class cadastroLivros extends JFrame {
    private JButton enviarButton;
    private JTextField textFieldTitulo;
    private JTextField textFieldTema;
    private JTextField textFieldAutor;
    private JTextField textFieldIsbn;
    private JTextField textFieldDataPublicacao;
    private JTextField textFieldQuantidadeDisponivel;
    private JPanel jpanelLivros;

    private LivrosController livrosController;

    public cadastroLivros() {
        this.setTitle("Cadastro de Livros");
        this.setContentPane(jpanelLivros);
        this.setSize(640, 480);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);

        livrosController = new LivrosController();

        enviarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvarLivro();
            }
        });
    }

    private void salvarLivro() {
        try {
            // Criando um objeto LivrosModel com os valores dos campos de texto
            LivrosModel livro = new LivrosModel();
            livro.setTitulo(textFieldTitulo.getText());
            livro.setTema(textFieldTema.getText());
            livro.setAutor(textFieldAutor.getText());
            livro.setIsbn(textFieldIsbn.getText());

            // Convertendo a data de publicação para o formato correto
            String dataPublicacao = textFieldDataPublicacao.getText();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            livro.setDataPublicacao(dateFormat.parse(dataPublicacao));

            // Definindo a quantidade disponível
            livro.setQuantidadeDisponivel(Integer.parseInt(textFieldQuantidadeDisponivel.getText()));

            // Chamando o método salvar do controller
            String mensagem = livrosController.salvar(livro);

            // Mostrando uma mensagem ao usuário
            JOptionPane.showMessageDialog(this, mensagem);

            // Limpando os campos após salvar
            limparCampos();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar o livro: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limparCampos() {
        textFieldTitulo.setText("");
        textFieldTema.setText("");
        textFieldAutor.setText("");
        textFieldIsbn.setText("");
        textFieldDataPublicacao.setText("");
        textFieldQuantidadeDisponivel.setText("");
    }

    public static void main(String[] args) {
        new cadastroLivros();
    }
}
