import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class userGUI extends GUI{
    public userGUI(){
    }
    @Override
    public void initializeFrame() {
        super.initializeFrame();
    }

    public void cart(ArrayList<Product> selectedProducts){
        int numberOfSelected = selectedProducts.size();
        int rows = numberOfSelected + 3;
        JPanel selectedList = new JPanel();
        selectedList.setBackground(mainColor);
        selectedList.setLayout(new GridLayout(rows, 1, 0, 10)); //hgap is 0 for consistent spacing

        JLabel cost = new JLabel("98645", SwingConstants.CENTER);
        JLabel emptyLabel = new JLabel("   ");

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(mainColor);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10)); // FlowLayout for buttons with spacing

        JButton backButton = new JButton("برگشت");
        JButton confirmButton = new JButton("تایید نهایی");

        for(Product p : selectedProducts){
            JLabel showPro = new JLabel(p.getName(), SwingConstants.CENTER);
            showPro.setForeground(secondColor);
            selectedList.add(showPro);
        }

        buttonPanel.add(backButton);
        buttonPanel.add(confirmButton);

        selectedList.add(cost);
        selectedList.add(emptyLabel);
        selectedList.add(buttonPanel);

        frame.add(selectedList);
        frame.setVisible(true);
    }
    public void register(){
        JPanel registerPanel = new JPanel();
        registerPanel.setSize(800, 800);
        registerPanel.setLayout(null);
        registerPanel.setBackground(super.mainColor);

        JLabel titleLabel=  new JLabel("ثبت نام", SwingConstants.LEFT);
        JLabel nameLabel=  new JLabel("نام: ", SwingConstants.LEFT);
        JLabel lastNameLabel= new JLabel("نام خانوادگی: ", SwingConstants.LEFT);
        JLabel addressLabel =  new JLabel("آدرس: ", SwingConstants.LEFT);
        JLabel emailLabel =  new JLabel("ایمیل: ", SwingConstants.LEFT);
        JLabel phoneNumberLabel =  new JLabel("شماره تماس: ", SwingConstants.LEFT);
        JLabel userNameLabel =  new JLabel("نام کاربری: ", SwingConstants.LEFT);
        JLabel passwordLabel =  new JLabel("رمز عبور: ", SwingConstants.LEFT);
        JLabel repeatPasswordLabel =  new JLabel("تکرار رمز عبور: ", SwingConstants.LEFT);

//        titleLabel.setFont(font.deriveFont(40f));
//        nameLabel.setFont(font.deriveFont(20f));
//        lastNameLabel.setFont(font.deriveFont(20f));
//        addressLabel.setFont(font.deriveFont(20f));
//        emailLabel.setFont(font.deriveFont(20f));
//        phoneNumberLabel.setFont(font.deriveFont(20f));
//        userNameLabel.setFont(font.deriveFont(20f));
//        passwordLabel.setFont(font.deriveFont(20f));
//        repeatPasswordLabel.setFont(font.deriveFont(20f));

        titleLabel.setForeground(forthColor);
        nameLabel.setForeground(thirdColor);
        lastNameLabel.setForeground(thirdColor);
        addressLabel.setForeground(thirdColor);
        emailLabel.setForeground(thirdColor);
        phoneNumberLabel.setForeground(thirdColor);
        userNameLabel.setForeground(thirdColor);
        passwordLabel.setForeground(thirdColor);
        repeatPasswordLabel.setForeground(thirdColor);

        titleLabel.setBounds(460,20,400,200);
        nameLabel.setBounds(550,100,400,200);
        lastNameLabel.setBounds(550,140,400,200);
        addressLabel.setBounds(550,180,400,200);
        emailLabel.setBounds(550,220,400,200);
        phoneNumberLabel.setBounds(550,260,400,200);
        userNameLabel.setBounds(550,300,400,200);
        passwordLabel.setBounds(550,340,400,200);
        repeatPasswordLabel.setBounds(550,380,400,200);

        registerPanel.add(titleLabel);
        registerPanel.add(nameLabel);
        registerPanel.add(lastNameLabel);
        registerPanel.add(addressLabel);
        registerPanel.add(emailLabel);
        registerPanel.add(phoneNumberLabel);
        registerPanel.add(userNameLabel);
        registerPanel.add(passwordLabel);
        registerPanel.add(repeatPasswordLabel);

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

        nameTextField.setBounds(400,185,150,30);
        lastNameTextField.setBounds(400,225,150,30);
        addressTextField.setBounds(400,265,150,30);
        emailTextField.setBounds(400,305,150,30);
        phoneNumberTextField.setBounds(400,345,150,30);
        userNameTextField.setBounds(400,385,150,30);
        passwordField.setBounds(400,425,150,30);
        repeatPasswordField.setBounds(400,464,150,30);

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

        JButton registerButton=new JButton("ثبت");
//        registerButton.setFont(font.deriveFont(17f));
        registerButton.setBounds(460,530,100,50);
        registerButton.setBackground(forthColor);
        registerButton.setForeground(secondColor);
        registerPanel.add(registerButton);

        frame.add(titleLabel);
        frame.add(registerPanel);
        frame.setVisible(true);
    }
    public void showInfo(String name, String address, String phoneNumber, String budget){
        //SI stands for ShowInfo
        JPanel menuPanel = menubar();
        JPanel SIPanel = new JPanel();
        SIPanel.setSize(800, 800);
        SIPanel.setLayout(null);
        SIPanel.setBackground(super.mainColor);

        JLabel SILabel =  new JLabel("پروفایل کاربر", SwingConstants.RIGHT);
        JLabel NameLabel =  new JLabel("نام: " + name, SwingConstants.RIGHT);
        JLabel addressLabel =  new JLabel("آدرس: " + address, SwingConstants.RIGHT);
        JLabel phoneNumberLabel =  new JLabel("شماره تماس: " + phoneNumber, SwingConstants.RIGHT);
        JLabel budgetLabel =  new JLabel("موجودی: " + budget, SwingConstants.RIGHT);

//        SILabel.setFont(font.deriveFont(40f));
//        NameLabel.setFont(font.deriveFont(25f));
//        addressLabel.setFont(font.deriveFont(25f));
//        phoneNumberLabel.setFont(font.deriveFont(25f));
//        budgetLabel.setFont(font.deriveFont(25f));

        SILabel.setForeground(thirdColor);
        NameLabel.setForeground(thirdColor);
        phoneNumberLabel.setForeground(thirdColor);
        addressLabel.setForeground(thirdColor);
        budgetLabel.setForeground(forthColor);

        SILabel.setBounds(550,40,400,200);
        NameLabel.setBounds(500,130,400,200);
        addressLabel.setBounds(500,170,400,200);
        phoneNumberLabel.setBounds(500,210,400,200);
        budgetLabel.setBounds(500,250,400,200);

        addMenuButton(SIPanel, menuPanel);

        SIPanel.add(menuButton);
        SIPanel.add(SILabel);
        SIPanel.add(NameLabel);
        SIPanel.add(addressLabel);
        SIPanel.add(phoneNumberLabel);
        SIPanel.add(budgetLabel);
        frame.add(SIPanel);
        frame.setVisible(true);
    }


    @Override
    public void login() {
//      Information-Insertion panel :
        JPanel infoPanel = new JPanel();
        infoPanel.setSize(1000,800);
        infoPanel.setLayout(null);
        infoPanel.setBackground(super.mainColor);

        Border b = BorderFactory.createLineBorder(forthColor,2);

        JLabel enterL = new JLabel("ورود کاربر",SwingConstants.CENTER);
        enterL.setBounds(360,80,267,80);
        enterL.setForeground(forthColor);

        JLabel enterUserL = new JLabel("نام کاربری خود را وارد کنید:",SwingConstants.CENTER);
        enterUserL.setBounds(360,200,267,80);
        enterUserL.setForeground(secondColor);

        JTextField enterUserTF = new JTextField();
        enterUserTF.setBounds(360,280,267,40);
        enterUserTF.setBorder(b);

        JLabel enterPassL = new JLabel("رمز عبور خود را وارد کنید:",SwingConstants.CENTER);
        enterPassL.setBounds(360,340,267,80);
        enterPassL.setForeground(secondColor);

        JPasswordField enterPassPF = new JPasswordField();
        enterPassPF.setBounds(360,420,267,40);
        enterPassPF.setBorder(b);

        JButton loginButton = new JButton("ورود");
        loginButton.setBounds(450,530,100,50);
        loginButton.setBackground(forthColor);
        loginButton.setForeground(secondColor);

//        enterL.setFont(font.deriveFont(40f));
//        enterUserL.setFont(font.deriveFont(25f));
//        enterPassL.setFont(font.deriveFont(25f));
//        loginButton.setFont(font.deriveFont(25f));

        infoPanel.add(enterL);
        infoPanel.add(enterUserL);
        infoPanel.add(enterUserTF);
        infoPanel.add(enterPassL);
        infoPanel.add(enterPassPF);
        infoPanel.add(loginButton);
        frame.add(infoPanel);
        frame.setVisible(true);
    }
}
