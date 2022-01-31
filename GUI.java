package JavaFinalReport;
import javax.swing.AbstractAction;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;

import static javax.swing.LayoutStyle.ComponentPlacement.UNRELATED;

public class GUI extends JFrame {

    private JTextField field1;
    private JTextField field2;
    private JTextField field3;
    private JTextField field4;
    private JLabel id, name1, job, name2;

    public GUI() {

        initUI();
    }

    private void initUI() {

        id = new JLabel("經銷商編號:");
        name1 = new JLabel("經銷商姓名:");
        job = new JLabel("經銷商級別:");
        name2 = new JLabel("經銷商上級姓名:");

        field1 = new JTextField(10);
        field2 = new JTextField(10);
        field3 = new JTextField(10);
        field4 = new JTextField(10);

        var registerButton = new JButton("注冊");
        registerButton.addActionListener(new RegisterAction());

        createLayout(id, field1, name1, field2, job, field3, name2, field4, registerButton);

        setTitle("注冊LUMINOUS帳號");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private class RegisterAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            doSubmitAction();
        }

    }

    private void doSubmitAction() {

        var id = field1.getText();
        var name1 = field2.getText();
        var job = field3.getText();
        var name2 = field4.getText();
    }

    private void createLayout(Component...arg){

        var pane = getContentPane();
        var gl = new GroupLayout(pane);
        pane.setLayout(gl);

        gl.setAutoCreateGaps(true);
        gl.setAutoCreateContainerGaps(true);

        gl.setHorizontalGroup(gl.createSequentialGroup()
                .addGap(50)
                .addGroup(gl.createSequentialGroup()
                        .addComponent(arg[0])
                        .addComponent(arg[1])
                        .addComponent(arg[2])
                        .addComponent(arg[3])
                        .addComponent(arg[4])
                        .addComponent(arg[5])
                        .addComponent(arg[6])
                        .addComponent(arg[7])
                        .addComponent(arg[8]))
                .addGap(50)
        );

        gl.setVerticalGroup(gl.createSequentialGroup()
                .addGap(50)
                .addGroup(gl.createSequentialGroup()
                        .addComponent(arg[0])
                        .addComponent(arg[1], GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(arg[2])
                        .addComponent(arg[3], GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(arg[4])
                        .addComponent(arg[5], GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(arg[6])
                        .addComponent(arg[7], GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(UNRELATED)
                        .addComponent(arg[8]))

        );

        pack();


    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {

            var ex = new GUI();
            ex.setVisible(true);
        });
    }
}