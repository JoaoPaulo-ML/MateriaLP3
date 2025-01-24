import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class cadastroLivros extends JFrame{
    private JButton enviarButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JPanel jpanelLivros;

    public cadastroLivros() {
        this.setTitle("teste");
        this.setContentPane(jpanelLivros);
        this.setSize(640,480);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        enviarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
