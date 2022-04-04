/**
 * @author Satvir Uppal
 * CS2212 - Intro to Software Engineering
 * @purpose this class is the LoginUI window that initializes and generates the loginUI
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

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

    /** GetInstance Method: this method will make the LoginUI the current instance.
     * This is ane example of Singleton design patter
     *
     * @return the instance of the current window
     */
    public static LoginUI getInstance() {
        if (instance == null)
            instance = new LoginUI();
        return instance;
    }

    /**
     * SetFrame method that initializes the frame and panel of the UI
     * This method sets the dimensions and location of the window
     */
    private static void setFrame(){
        panel.setLayout(null);

        frame.setTitle("<CoinTrader> Login");
        frame.setLocation(new Point(500, 300));
        frame.add(panel);
        frame.setSize(new Dimension(450, 300));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
    }

    /**
     * SetElements method that sets the locations and size of the elements of the UI such as the
     * username & password labels, text-enterable-fields, and buttons (login, show password, and reset)
     */
    private static void setElements(){
        usernameLabel.setBounds(50, 8, 200, 20);
        username.setBounds(50, 25, 193, 28);
        passwordLabel.setBounds(50, 58, 200, 20);
        password.setBounds(50, 75, 193, 28);
        loginBtn.setBounds(50, 120, 90, 25);
        resetBtn.setBounds(152, 120, 90, 25);
        showPass.setBounds(250, 80, 150, 25);
    }

    /**
     * addElements method that adds the elements on to the panel such that
     *they can be interacted with and utilized
     */
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

    /**
     * setAction that will set the buttons (login, show password, and reset)
     * this makes the buttons 'observers' so they are awaiting an action to commence their methods
     */
    private static void setAction(){
        showPass.addActionListener((ActionListener) new LoginUI());
        loginBtn.addActionListener((ActionListener) new LoginUI());
        resetBtn.addActionListener((ActionListener) new LoginUI());
    }

    /**
     * LaunchLoginUI acts as a main method that is called by MainSystem.java to open and commence the program
     * this method calls the helper methods above to initialize and create the UI
     */
    public static void launchLogInUI(){
        setFrame();
        setElements();
        addElements();
        getInstance();
    }

    /**
     * ActionPerformed that is called only when an action such as a button check or click happens
     * this is similar to an observer design pattern as it only commences a method when an action is performed
     * @param e that is passed only when a button that is included on the LoginUI is pressed/ checked
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == loginBtn){
            String User = username.getText().toLowerCase();
            String Pass = String.valueOf(password.getPassword());
            if(User.isEmpty() && Pass.isEmpty())
                JOptionPane.showMessageDialog(this, "Enter your Username and Password");
            else {
                try {
                    if (LoginValidator.validate(User, Pass)) {
                        frame.dispose();
                        MainSystem.loginCheck(true);
                    } else {
                        JOptionPane.showMessageDialog(this, "LOGIN FAILED \nProgram will now terminate");
                        MainSystem.loginCheck(false);
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
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