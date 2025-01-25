package view;

import controller.UsuarioController;
import model.UsuariosModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class cadastrarUsuarios extends JFrame {

    private JPanel jpanelUsuarios;
    private JButton enviarButton;
    private JTextField textFieldNome;
    private JTextField textFieldEmail;
    private JTextField textFieldSexo;
    private JTextField textFieldNumero;


    private UsuarioController usuarioController;

    public cadastrarUsuarios() {
        this.setTitle("Cadastrar Usuários");
        this.setContentPane(jpanelUsuarios);
        this.setSize(640, 480);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);

        usuarioController = new UsuarioController();

        enviarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvarUsuario();
            }
        });
    }

    private void salvarUsuario() {
        try {
            // Criando um objeto UsuariosModel com os valores dos campos de texto
            UsuariosModel usuario = new UsuariosModel();
            usuario.setNome(textFieldNome.getText());
            usuario.setEmail(textFieldEmail.getText());
            usuario.setSexo(textFieldSexo.getText());
            usuario.setNumeroCelular(textFieldNumero.getText());

            // Chamando o método salvar do controller
            String mensagem = usuarioController.salvar(usuario);
            //textField1
            // Mostrando uma mensagem ao usuário
            JOptionPane.showMessageDialog(this, mensagem);

            // Limpando os campos após salvar
            limparCampos();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar o usuário: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limparCampos() {
        textFieldNome.setText("");
        textFieldEmail.setText("");
        textFieldSexo.setText("");
        textFieldNumero.setText("");
    }

    public static void main(String[] args) {
        new cadastrarUsuarios();
    }
}
