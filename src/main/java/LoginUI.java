
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginUI extends JFrame implements ActionListener {
    private static JPanel panel = new JPanel();
    private static JFrame frame = new JFrame();

    private static JLabel usernameLabel = new JLabel("USERNAME:");
    private static JLabel passwordLabel = new JLabel("PASSWORD:");

    private static JTextField username = new JTextField();
    private static JPasswordField password = new JPasswordField();

    private static JButton loginBtn = new JButton("LOGIN");
    private static JButton resetBtn = new JButton("RESET");

    private static JCheckBox showPass = new JCheckBox("Show Password");

    private static LoginUI instance;

    public static LoginUI getInstance() {
        if (instance == null)
            instance = new LoginUI();
        return instance;
    }
    private static void setFrame(){
        panel.setLayout(null);

        frame.setTitle("<CoinTrader> Login");
        frame.setLocation(new Point(500, 300));
        frame.add(panel);
        frame.setSize(new Dimension(400, 200));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
    }
    private static void setElements(){
        usernameLabel.setBounds(50, 8, 200, 20);
        username.setBounds(50, 25, 193, 28);
        passwordLabel.setBounds(50, 58, 200, 20);
        password.setBounds(50, 75, 193, 28);
        loginBtn.setBounds(50, 120, 90, 25);
        resetBtn.setBounds(152, 120, 90, 25);
        showPass.setBounds(250, 80, 150, 25);
    }
    private static void addElements(){
        panel.add(usernameLabel);
        panel.add(username);
        panel.add(passwordLabel);
        panel.add(password);
        panel.add(loginBtn);
        panel.add(resetBtn);
        panel.add(showPass);
        setAction();
    }
    private static void setAction(){
        showPass.addActionListener((ActionListener) new LoginUI());
        loginBtn.addActionListener((ActionListener) new LoginUI());
        resetBtn.addActionListener((ActionListener) new LoginUI());
    }

    public static void main(String[] args){
        setFrame();
        setElements();
        addElements();
        getInstance();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == loginBtn){
            String User = username.getText().toLowerCase();
            String Pass = String.valueOf(password.getPassword());
            if(User.isBlank() && Pass.isBlank())
                JOptionPane.showMessageDialog(this, "Enter your Username and Password");
            else {
                if (LoginValidator.validate(User, Pass)) {
                    JOptionPane.showMessageDialog(this, "LOGIN SUCCESS");
                    //MainUI.main(null);
                } else {
                    JOptionPane.showMessageDialog(this, "LOGIN FAILED \nProgram will now terminate");
                    //System.exit(0);
                }
            }
        }
        if(e.getSource() == resetBtn){
            username.setText("");
            password.setText("");
        }
        if(e.getSource() == showPass){
            if(!showPass.isSelected())
                password.setEchoChar('*');
            else
                password.setEchoChar((char) 0);
        }
    }
}