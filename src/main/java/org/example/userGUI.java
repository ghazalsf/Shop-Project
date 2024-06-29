package org.example;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class userGUI extends GUI implements ActionListener{
    JButton registerButton = new JButton("ثبت");

    JButton addbutton =new JButton("اضافه کردن به سبد خرید");
    JButton submitbutton= new JButton("ثبت امتیاز");

    public userGUI(){
        addActionEvent();
    }
    @Override
    public void initializeFrame() {
        super.initializeFrame();
    }


    public void register(){
        super.register();
    }
    public void showInfo(String name, String address, String phoneNumber, String budget){
       super.showInfo(name,address,phoneNumber,budget);
    }

    public void showProduct(Product product){
        JPanel showProductPanel = new JPanel();
        showProductPanel.setSize(1000, 800);
        showProductPanel.setLayout(null);
        showProductPanel.setBackground(super.mainColor);

        String price=Integer.toString(product.getPrice());
        String score=Double.toString(product.getScore());
        String name= product.getName();


        JLabel priceLabel=new JLabel("قیمت: "+price,SwingConstants.RIGHT);
        JLabel scoreLabel=new JLabel("امتیاز کاربران: "+score,SwingConstants.RIGHT);
        JLabel nameLabel=new JLabel(name,SwingConstants.RIGHT);

//        priceLabel.setFont(font.deriveFont(20f));
//        scoreLabel.setFont(font.deriveFont(17f));
//        nameLabel.setFont(font.deriveFont(23f));

        priceLabel.setBounds(750,450,200,50);
        scoreLabel.setBounds(750,500,200,50);
        nameLabel.setBounds(750,400,200,50);

        showProductPanel.add(priceLabel);
        showProductPanel.add(scoreLabel);
        showProductPanel.add(nameLabel);


        JLabel submitscorelabel= new JLabel("امتیاز مورد نظر را از 1 تا 5 وارد کنید",SwingConstants.CENTER);
        submitscorelabel.setForeground(forthColor);
//        submitscorelabel.setFont(font.deriveFont(15f));

        JTextField scoreTextField=new JTextField();

        submitscorelabel.setBounds(50,50,200,50);
        scoreTextField.setBounds(50,100,100,50);
        submitbutton.setBounds(150,100,100,50);

        addbutton.setBounds(800,550,150,50);

        addbutton.setForeground(secondColor);
        addbutton.setBackground(forthColor);
        submitbutton.setBackground(Color.WHITE);
        submitbutton.setForeground(forthColor);

        Border border = BorderFactory.createLineBorder(forthColor, 2);
        submitbutton.setBorder(border);
        scoreTextField.setBorder(border);

        showProductPanel.add(scoreTextField);
        showProductPanel.add(submitbutton);
        showProductPanel.add(submitscorelabel);
        showProductPanel.add(addbutton);

        frame.add(showProductPanel);
        frame.setVisible(true);
    }

    public void changeData(User user){
        User usertmp=new User(user.getFirstName(), user.getLastName(),user.getUserName(),user.getPassword(), user.getAddress(),user.getPhoneNumber(),user.getemail(),user.getBudget());
        JPanel registerPanel = new JPanel();
        registerPanel.setSize(800, 800);
        registerPanel.setLayout(null);
        registerPanel.setBackground(mainColor);

        JLabel titleLabel=  new JLabel("تغییر اطلاعات", SwingConstants.LEFT);
        JLabel nameLabel=  new JLabel("نام: ", SwingConstants.LEFT);
        JLabel lastNameLabel= new JLabel("نام خانوادگی: ", SwingConstants.LEFT);
        JLabel addressLabel =  new JLabel("آدرس: ", SwingConstants.LEFT);
        JLabel emailLabel =  new JLabel("ایمیل: ", SwingConstants.LEFT);
        JLabel phoneNumberLabel =  new JLabel("شماره تماس: ", SwingConstants.LEFT);
        JLabel userNameLabel =  new JLabel("نام کاربری: ", SwingConstants.LEFT);
        JLabel passwordLabel =  new JLabel("رمز عبور: ", SwingConstants.LEFT);
        JLabel repeatPasswordLabel =  new JLabel("تکرار رمز عبور: ", SwingConstants.LEFT);
        JLabel budgetLabel =  new JLabel("موجودی: ", SwingConstants.LEFT);

//        titleLabel.setFont(font.deriveFont(40f));
//        nameLabel.setFont(font.deriveFont(20f));
//        lastNameLabel.setFont(font.deriveFont(20f));
//        addressLabel.setFont(font.deriveFont(20f));
//        emailLabel.setFont(font.deriveFont(20f));
//        phoneNumberLabel.setFont(font.deriveFont(20f));
//        userNameLabel.setFont(font.deriveFont(20f));
//        passwordLabel.setFont(font.deriveFont(20f));
//        repeatPasswordLabel.setFont(font.deriveFont(20f));
//        budgetLabel.setFont(font.deriveFont(20f));

        titleLabel.setForeground(forthColor);
        nameLabel.setForeground(thirdColor);
        lastNameLabel.setForeground(thirdColor);
        addressLabel.setForeground(thirdColor);
        emailLabel.setForeground(thirdColor);
        phoneNumberLabel.setForeground(thirdColor);
        userNameLabel.setForeground(thirdColor);
        passwordLabel.setForeground(thirdColor);
        repeatPasswordLabel.setForeground(thirdColor);
        budgetLabel.setForeground(forthColor);

        titleLabel.setBounds(460,20,400,200);
        nameLabel.setBounds(550,100,400,200);
        lastNameLabel.setBounds(550,140,400,200);
        addressLabel.setBounds(550,180,400,200);
        emailLabel.setBounds(550,220,400,200);
        phoneNumberLabel.setBounds(550,260,400,200);
        userNameLabel.setBounds(550,300,400,200);
        passwordLabel.setBounds(550,340,400,200);
        repeatPasswordLabel.setBounds(550,380,400,200);
        budgetLabel.setBounds(550,420,400,200);

        registerPanel.add(titleLabel);
        registerPanel.add(nameLabel);
        registerPanel.add(lastNameLabel);
        registerPanel.add(addressLabel);
        registerPanel.add(emailLabel);
        registerPanel.add(phoneNumberLabel);
        registerPanel.add(userNameLabel);
        registerPanel.add(passwordLabel);
        registerPanel.add(repeatPasswordLabel);
        registerPanel.add(budgetLabel);

        JTextField nameTextField =new JTextField();
        nameTextField.setText(user.getFirstName());
        JTextField lastNameTextField =new JTextField();
        lastNameTextField.setText(user.getLastName());
        JTextField addressTextField =new JTextField();
        addressTextField.setText(user.getAddress());
        JTextField emailTextField =new JTextField();
        emailTextField.setText(user.getemail());
        JTextField phoneNumberTextField =new JTextField();
        phoneNumberTextField.setText(user.getPhoneNumber());
        JTextField userNameTextField =new JTextField();
        userNameTextField.setText(user.getUserName());
        JTextField passwordField =new JTextField();
        passwordField.setText(user.getPassword());
        JTextField repeatPasswordField =new JTextField();
        repeatPasswordField.setText(user.getPassword());
        JTextField budgetTextField =new JTextField();
        String tmp= Integer.toString(user.getBudget());
        budgetTextField.setText(tmp);

        if (!nameTextField.getText().equals(user.getFirstName()));{
            usertmp.setFirstName(nameTextField.getText());
        }
        if (!lastNameTextField.getText().equals(user.getLastName()));{
            usertmp.setLastName(lastNameTextField.getText());
        }
        if (!addressTextField.getText().equals(user.getAddress()));{
            usertmp.setAddress(addressTextField.getText());
        }
        if (!emailTextField.getText().equals(user.getemail()));{
            usertmp.setEmail(emailTextField.getText());
        }
        if (!phoneNumberTextField.getText().equals(user.getPhoneNumber()));{
            usertmp.setPhoneNumber(phoneNumberTextField.getText());
        }
        if (!passwordField.getText().equals(user.getPassword()));{
            usertmp.setPassword(passwordField.getText());
        }
        if (!budgetTextField.getText().equals(user.getBudget()));{
            usertmp.setBudget(Integer.parseInt(budgetTextField.getText()));
        }

        Border border = BorderFactory.createLineBorder(forthColor, 2);

        nameTextField.setBorder(border);
        lastNameTextField.setBorder(border);
        addressTextField.setBorder(border);
        emailTextField.setBorder(border);
        phoneNumberTextField.setBorder(border);
        userNameTextField.setBorder(border);
        passwordField.setBorder(border);
        repeatPasswordField.setBorder(border);
        budgetTextField.setBorder(border);

        nameTextField.setBounds(400,185,150,30);
        lastNameTextField.setBounds(400,225,150,30);
        addressTextField.setBounds(400,265,150,30);
        emailTextField.setBounds(400,305,150,30);
        phoneNumberTextField.setBounds(400,345,150,30);
        userNameTextField.setBounds(400,385,150,30);
        passwordField.setBounds(400,425,150,30);
        repeatPasswordField.setBounds(400,465,150,30);
        budgetTextField.setBounds(400,505,150,30);


        registerPanel.add(nameTextField);
        registerPanel.add(lastNameTextField);
        registerPanel.add(addressTextField);
        registerPanel.add(emailTextField);
        registerPanel.add(phoneNumberTextField);
        registerPanel.add(userNameTextField);
        registerPanel.add(passwordField);
        registerPanel.add(repeatPasswordField);
        registerPanel.add(budgetTextField);

//        registerButton.setFont(font.deriveFont(17f));
        registerButton.setBounds(460,560,100,50);
        registerButton.setBackground(forthColor);
        registerButton.setForeground(secondColor);
        registerPanel.add(registerButton);

        frame.add(titleLabel);
        frame.add(registerPanel);
        frame.setVisible(true);
    }


    public void addActionEvent(){
        registerButton.addActionListener(this);
        backButton.addActionListener(this);
        confirmButton.addActionListener(this);
        loginButton.addActionListener(this);
        addbutton.addActionListener(this);
        cartButton.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
//        if (e.getSource() == enterAAsUser) {
//            this.getContentPane().removeAll();
//            this.add(infoPanel);
//            this.revalidate();
//            this.repaint();
//        }
    }
}