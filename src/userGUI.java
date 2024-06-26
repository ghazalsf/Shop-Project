import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class userGUI extends GUI{

    public userGUI(){
    }
    @Override
    public void initializeFrame() {
        super.initializeFrame();
    }
    public void register(){
        JPanel menuPanel = menubar();
        JPanel registerPanel = new JPanel();
        registerPanel.setSize(800, 800);
        registerPanel.setLayout(null);
        registerPanel.setBackground(super.mainColor);

        // set labels
        JLabel titleLabel=  new JLabel("ثبت نام", SwingConstants.LEFT);
        JLabel nameLabel=  new JLabel("نام: ", SwingConstants.LEFT);
        JLabel lastNameLable= new JLabel("نام خانوادگی: ", SwingConstants.LEFT);
        JLabel addressLabel =  new JLabel("آدرس: ", SwingConstants.LEFT);
        JLabel emailLabel =  new JLabel("ایمیل: ", SwingConstants.LEFT);
        JLabel phoneNumberLabel =  new JLabel("شماره تماس: ", SwingConstants.LEFT);
        JLabel userNameLabel =  new JLabel("نام کاربری: ", SwingConstants.LEFT);
        JLabel passwordLabel =  new JLabel("رمز عبور: ", SwingConstants.LEFT);
        JLabel repeatPasswordLabel =  new JLabel("تکرار رمز عبور: ", SwingConstants.LEFT);

        titleLabel.setFont(font.deriveFont(40f));
        nameLabel.setFont(font.deriveFont(20f));
        lastNameLable.setFont(font.deriveFont(20f));
        addressLabel.setFont(font.deriveFont(20f));
        emailLabel.setFont(font.deriveFont(20f));
        phoneNumberLabel.setFont(font.deriveFont(20f));
        userNameLabel.setFont(font.deriveFont(20f));
        passwordLabel.setFont(font.deriveFont(20f));
        repeatPasswordLabel.setFont(font.deriveFont(20f));

        titleLabel.setForeground(forthColor);
        nameLabel.setForeground(thirdColor);
        lastNameLable.setForeground(thirdColor);
        addressLabel.setForeground(thirdColor);
        emailLabel.setForeground(thirdColor);
        phoneNumberLabel.setForeground(thirdColor);
        userNameLabel.setForeground(thirdColor);
        passwordLabel.setForeground(thirdColor);
        repeatPasswordLabel.setForeground(thirdColor);

        titleLabel.setBounds(330,20,400,200);
        nameLabel.setBounds(400,100,400,200);
        lastNameLable.setBounds(400,140,400,200);
        addressLabel.setBounds(400,180,400,200);
        emailLabel.setBounds(400,220,400,200);
        phoneNumberLabel.setBounds(400,260,400,200);
        userNameLabel.setBounds(400,300,400,200);
        passwordLabel.setBounds(400,340,400,200);
        repeatPasswordLabel.setBounds(400,380,400,200);

        registerPanel.add(titleLabel);
        registerPanel.add(nameLabel);
        registerPanel.add(lastNameLable);
        registerPanel.add(addressLabel);
        registerPanel.add(emailLabel);
        registerPanel.add(phoneNumberLabel);
        registerPanel.add(userNameLabel);
        registerPanel.add(passwordLabel);
        registerPanel.add(repeatPasswordLabel);

        //set textfields
        JTextField nameTextField =new JTextField();
        JTextField lastNameTextField =new JTextField();
        JTextField addressTextField =new JTextField();
        JTextField emailTextField =new JTextField();
        JTextField phoneNumberTextField =new JTextField();
        JTextField userNameTextField =new JTextField();
        JPasswordField passwordField =new JPasswordField();
        JPasswordField repeatPasswordField =new JPasswordField();

        Border border = BorderFactory.createLineBorder(forthColor, 2);

        nameTextField.setBorder(border);
        lastNameTextField.setBorder(border);
        addressTextField.setBorder(border);
        emailTextField.setBorder(border);
        phoneNumberTextField.setBorder(border);
        userNameTextField.setBorder(border);
        passwordField.setBorder(border);
        repeatPasswordField.setBorder(border);

        nameTextField.setBounds(250,185,150,30);
        lastNameTextField.setBounds(250,225,150,30);
        addressTextField.setBounds(250,265,150,30);
        emailTextField.setBounds(250,305,150,30);
        phoneNumberTextField.setBounds(250,345,150,30);
        userNameTextField.setBounds(250,385,150,30);
        passwordField.setBounds(250,425,150,30);
        repeatPasswordField.setBounds(250,464,150,30);

        passwordField.setEchoChar('*');
        repeatPasswordField.setEchoChar('*');

        registerPanel.add(nameTextField);
        registerPanel.add(lastNameTextField);
        registerPanel.add(addressTextField);
        registerPanel.add(emailTextField);
        registerPanel.add(phoneNumberTextField);
        registerPanel.add(userNameTextField);
        registerPanel.add(passwordField);
        registerPanel.add(repeatPasswordField);


        frame.add(titleLabel);
        frame.add(registerPanel);
        frame.add(menuPanel);
        frame.setVisible(true);
    }
    public void showInfo(String name, String address, String phoneNumber, String budget){
        //SI stands for ShowInfo
        JPanel menuPanel = menubar();
        JPanel SIPanel = new JPanel();
        SIPanel.setSize(100, 800);
        SIPanel.setLayout(null);
        SIPanel.setBackground(super.mainColor);

        JLabel SILabel =  new JLabel("پروفایل کاربر", SwingConstants.RIGHT);
        JLabel NameLabel =  new JLabel("نام: " + name, SwingConstants.RIGHT);
        JLabel addressLabel =  new JLabel("آدرس: " + address, SwingConstants.RIGHT);
        JLabel phoneNumberLabel =  new JLabel("شماره تماس: " + phoneNumber, SwingConstants.RIGHT);
        JLabel budgetLabel =  new JLabel("موجودی: " + budget, SwingConstants.RIGHT);

        SILabel.setFont(font.deriveFont(40f));
        NameLabel.setFont(font.deriveFont(25f));
        addressLabel.setFont(font.deriveFont(25f));
        phoneNumberLabel.setFont(font.deriveFont(25f));
        budgetLabel.setFont(font.deriveFont(25f));

        SILabel.setForeground(thirdColor);
        NameLabel.setForeground(thirdColor);
        phoneNumberLabel.setForeground(thirdColor);
        addressLabel.setForeground(thirdColor);
        budgetLabel.setForeground(forthColor);

        SILabel.setBounds(350,40,400,200);
        NameLabel.setBounds(300,130,400,200);
        addressLabel.setBounds(300,170,400,200);
        phoneNumberLabel.setBounds(300,210,400,200);
        budgetLabel.setBounds(300,250,400,200);

        SIPanel.add(SILabel);
        SIPanel.add(NameLabel);
        SIPanel.add(addressLabel);
        SIPanel.add(phoneNumberLabel);
        SIPanel.add(budgetLabel);
        frame.add(SIPanel);
        frame.add(menuPanel);
    }

    public JPanel menubar(){
        JPanel panel = new JPanel(null);
        panel.setPreferredSize(new Dimension(100, 800));
        panel.setBounds(0,0,100,800);

        JButton homeButton = new JButton("صفحه اصلی");
        homeButton.setBounds(800, 130, 200, 30);
        JButton contactUsButton = new JButton("ارتباط با ما");
        contactUsButton.setBounds(800, 190, 200, 30);
        JButton cartButton = new JButton("سبد خرید");
        cartButton.setBounds(800, 250, 200, 30);

        flatButton(homeButton);
        flatButton(contactUsButton);
        flatButton(cartButton);

        panel.add(homeButton);
        panel.add(contactUsButton);
        panel.add(cartButton);

        return panel;
    }

    private void flatButton(JButton button) {
        button.setBorderPainted(false); // remove border
        button.setContentAreaFilled(false); // remove bg
        button.setFont(font.deriveFont(15f));
        button.setHorizontalAlignment(SwingConstants.CENTER);
    }
}
