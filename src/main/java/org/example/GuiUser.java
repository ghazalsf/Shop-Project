package org.example;

import org.example.models.ManageDB;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GuiUser implements ActionListener{

    User user;
    ArrayList<Product> selectedProducts=new ArrayList<Product>();
    JFrame frameUser = new JFrame("hello");
    ManageDB manageDB = new ManageDB();

    JPanel infoPanel = new JPanel();
    JPanel productPanel = new JPanel();
    JPanel registerPanel = new JPanel();
    JPanel showProductPanel = new JPanel();

    JButton addbutton =new JButton("اضافه کردن به سبد خرید");
    JButton submitbutton= new JButton("ثبت امتیاز");


    JButton loginButton = new JButton("ورود");
    JButton newRegister = new JButton("حساب کاربری ندارم");
    JButton homeButton = new JButton("صفحه اصلی");
    JButton contactUsButton = new JButton("ارتباط با ما");
    JButton cartButton = new JButton("سبد خرید");
    JButton menuButton = new JButton("منو");
    JButton searchButton = new JButton("جستجو");
    JButton sortButton = new JButton("مرتب سازی از کمترین قیمت:");
    JButton sortButtonBigger = new JButton("مرتب سازی از بیشترین قیمت:");
    JButton sortButtonCategory = new JButton("مرتب سازی بر اساس دسته بندی:");
    JButton registerButton=new JButton("ثبت");
    JButton backButton = new JButton("برگشت");
    JButton confirmButton = new JButton("تایید نهایی");
    JButton showInfoPanel = new JButton("اطلاعات کاربری");
    JButton exitAsUser = new JButton("خروج کاربر");
    JButton changeData = new JButton("ویرایشراطلاعات");

    JTextField enterUserTF = new JTextField();
    JTextField nameTextField =new JTextField();
    JTextField lastNameTextField =new JTextField();
    JTextField addressTextField =new JTextField();
    JTextField emailTextField =new JTextField();
    JTextField phoneNumberTextField =new JTextField();
    JTextField userNameTextField =new JTextField();
    JTextField passwordField =new JTextField();
    JTextField repeatPasswordField =new JTextField();
    JTextField enterPassPF = new JTextField();

    final Dimension SIZE = new Dimension(1000,800);
    Color mainColor = new Color(141, 141, 170);
    Color secondColor = new Color(223, 223, 222);
    Color thirdColor = new Color(247, 245, 242);
    Color forthColor = new Color(100, 13, 107);
    Font font;
    Border border = BorderFactory.createLineBorder(forthColor, 2);

    GuiUser() {
//        try {
//            font = Font.createFont(Font.TRUETYPE_FONT, new File("Font\\Ayasamin.ttf"));
//        } catch (FontFormatException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
        frameUser.setSize(SIZE);
        frameUser.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameUser.setTitle("help");
        frameUser.setResizable(true);
        login();
        frameUser.setVisible(true);
        addActionevent();
    }
    public void login() {
        infoPanel.setSize(1000,800);
        infoPanel.setLayout(null);
        infoPanel.setBackground(mainColor);

        Border b = BorderFactory.createLineBorder(forthColor,2);

        JLabel enterL = new JLabel("ورود کاربر",SwingConstants.CENTER);
        enterL.setBounds(360,80,267,80);
//        enterL.setFont(font.deriveFont(40f));
        enterL.setForeground(forthColor);

        JLabel enterUserL = new JLabel("نام کاربری خود را وارد کنید:",SwingConstants.CENTER);
        enterUserL.setBounds(360,200,267,80);
//        enterUserL.setFont(font.deriveFont(25f));
        enterUserL.setForeground(secondColor);

        enterUserTF.setBounds(360,280,267,40);
        enterUserTF.setBorder(b);

        JLabel enterPassL = new JLabel("رمز عبور خود را وارد کنید:",SwingConstants.CENTER);
        enterPassL.setBounds(360,340,267,80);

        enterPassL.setForeground(secondColor);
//        enterPassL.setFont(font.deriveFont(25f));

        enterPassPF.setBounds(360,420,267,40);
        enterPassPF.setBorder(b);

        loginButton.setBounds(450,530,100,50);
        loginButton.setBackground(forthColor);
        loginButton.setForeground(secondColor);
//        loginButton.setFont(font.deriveFont(25f));

        newRegister.setBounds(400,600,200,50);
        flatButton(newRegister);
//        newRegister.setFont(font.deriveFont(20f));

        infoPanel.add(newRegister);
        infoPanel.add(enterL);
        infoPanel.add(enterUserL);
        infoPanel.add(enterUserTF);
        infoPanel.add(enterPassL);
        infoPanel.add(enterPassPF);
        infoPanel.add(loginButton);
        frameUser.add(infoPanel);
        frameUser.setVisible(true);
    }
    public void showProduct(Product product){
        showProductPanel.setSize(1000, 800);
        showProductPanel.setLayout(null);
        showProductPanel.setBackground(mainColor);

        JPanel menuPanel = menubar();
        addMenuButton(showProductPanel,menuPanel);

        String price=Integer.toString(product.getPrice());
        String score=Double.toString(product.getScore());
        String name= product.getName();

        try {
            File file = new File(product.getPictureAddress()); // Replace with your image file path
            Image image = ImageIO.read(file);

            // Create a JLabel to display the image
            JLabel imageLabel = new JLabel(new ImageIcon(image));
            imageLabel.setBounds(490,15,500,500);

            // Add the label to the panel
            showProductPanel.add(imageLabel);
        } catch (IOException e) {
            e.printStackTrace();
        }


        JLabel priceLabel=new JLabel("قیمت: "+price,SwingConstants.RIGHT);
        JLabel scoreLabel=new JLabel("امتیاز کاربران: "+score,SwingConstants.RIGHT);
        JLabel nameLabel=new JLabel(name,SwingConstants.RIGHT);

//        priceLabel.setFont(font.deriveFont(20f));
//        scoreLabel.setFont(font.deriveFont(17f));
//        nameLabel.setFont(font.deriveFont(23f));

        priceLabel.setBounds(750,550,200,50);
        scoreLabel.setBounds(750,600,200,50);
        nameLabel.setBounds(750,500,200,50);

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

        addbutton.setBounds(800,650,150,50);

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
        addbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedProducts.add(product);
            }
        });

        showProductPanel.add(menuButton);
        frameUser.add(showProductPanel);
        frameUser.setVisible(true);
    }
    public JPanel menubar(){
        JPanel panel = new JPanel(null);
        panel.setPreferredSize(new Dimension(100, 800));
        panel.setBounds(0,0,100,800);

        homeButton.setBounds(800, 130, 200, 30);
        contactUsButton.setBounds(800, 190, 200, 30);
        cartButton.setBounds(800, 250, 200, 30);
        showInfoPanel.setBounds(800,310,200,30);
        exitAsUser.setBounds(800,370,200,30);

        flatButton(homeButton);
        flatButton(contactUsButton);
        flatButton(cartButton);
        flatButton(showInfoPanel);
        flatButton(exitAsUser);

        panel.add(homeButton);
        panel.add(contactUsButton);
        panel.add(cartButton);
        panel.add(showInfoPanel);
        panel.add(exitAsUser);

        return panel;
    }

    public void logout(){}
    private void flatButton(JButton button) {
        button.setBorderPainted(false); // remove border
        button.setContentAreaFilled(false); // remove bg
//        button.setFont(font.deriveFont(15f));
        button.setHorizontalAlignment(SwingConstants.CENTER);
    }

    public void addMenuButton(JPanel panel1, JPanel panel2){
        menuButton.setBounds(940,10,50,50);
        menuButton.setBackground(forthColor);
//        menuButton.setFont(font.deriveFont(13f));
        menuButton.setForeground(secondColor);

        final boolean[] panel2Visible = {false};
        menuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!panel2Visible[0]) {
                    // move panel1 to left
                    movePanelToLeft(panel1, 200); // move 200 pixel
                    // show panel2 to left
                    frameUser.add(panel2);
                    frameUser.revalidate();
                    frameUser.repaint();
                    panel2Visible[0] = true;
                } else {
                    // move panel 1 using animation
                    movePanelToOriginalPosition(panel1, 0); // return to first place
                    // remove panel2 from main
                    frameUser.remove(panel2);
                    frameUser.revalidate();
                    frameUser.repaint();
                    panel2Visible[0] = false;
                }
            }
        });
    }

    public static void movePanelToLeft(JPanel panel, int distance) {
        int startX = panel.getLocation().x;
        int endX = startX - distance;
        Timer timer = new Timer(10, new ActionListener() {
            int currentX = startX;
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentX > endX) {
                    currentX -= 5; // speed
                    panel.setLocation(currentX, panel.getLocation().y);
                } else {
                    ((Timer) e.getSource()).stop();
                }
            }
        });
        timer.start();
    }

    public static void movePanelToOriginalPosition(JPanel panel, int distance) {
        int startX = panel.getLocation().x;
        int endX = distance;
        Timer timer = new Timer(10, new ActionListener() {
            int currentX = startX;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentX < endX) {
                    currentX += 5;
                    panel.setLocation(currentX, panel.getLocation().y);
                } else {
                    ((Timer) e.getSource()).stop();
                }
            }
        });
        timer.start();
    }
    public void main(ArrayList<Product> products) {
        frameUser.setLayout(new BorderLayout());

        // پاک کردن محتویات قبلی productPanel
        productPanel.removeAll();

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JPanel commandsPanel = new JPanel();
        commandsPanel.setLayout(null);
        commandsPanel.setPreferredSize(new Dimension(1000, 200));
        commandsPanel.setBounds(0, 0, 1000, 200);

        JPanel menuPanel = menubar();

        JTextField searchBar = new JTextField();
        searchBar.setBounds(140, 25, 150, 30);

        searchButton.setBounds(290, 25, 80, 30);

        JLabel name = new JLabel("هقداژدفو", SwingConstants.RIGHT);
        name.setBounds(550, 50, 200, 100);
        // name.setFont(font.deriveFont(50f));

        sortButton.setBounds(140, 65, 230, 30);

        sortButtonBigger.setBounds(140, 105, 230, 30);

        sortButtonCategory.setBounds(140, 145, 230, 30);

        commandsPanel.setBackground(mainColor);
        searchButton.setBackground(forthColor);
        searchButton.setForeground(secondColor);
        name.setForeground(secondColor);
        sortButton.setForeground(secondColor);
        sortButton.setBackground(forthColor);
        sortButtonBigger.setForeground(secondColor);
        sortButtonBigger.setBackground(forthColor);
        sortButtonCategory.setBackground(forthColor);
        sortButtonCategory.setForeground(secondColor);

        commandsPanel.add(name);
        commandsPanel.add(searchBar);
        commandsPanel.add(searchButton);
        commandsPanel.add(sortButton);
        commandsPanel.add(sortButtonBigger);
        commandsPanel.add(sortButtonCategory);

        int amountOfProducts = products.size();
        int y = 0;

        productPanel.setPreferredSize(new Dimension(1000, 600));
        productPanel.setBounds(0, 200, 1000, 800);
        productPanel.setBackground(mainColor);

        // finding the rows for the grind layout
        if (amountOfProducts % 4 == 0)
            y = amountOfProducts / 4;
        else
            y = amountOfProducts / 4 + 1;

        productPanel.setLayout(new GridLayout(y, 4, 50, 20));

        for (Product p : products) {
            JButton proButton = new JButton(p.getName() + ", " + p.getPrice() + ", " + p.getScore() + ", " + p.getCategory());
            proButton.setBackground(forthColor);
            proButton.setForeground(secondColor);
            productPanel.add(proButton);

            proButton.addActionListener(e -> {
                frameUser.getContentPane().removeAll();
                showProduct(p);
            });
        }

        productPanel.revalidate();
        productPanel.repaint();

        addMenuButton(mainPanel, menuPanel);
        mainPanel.add(menuButton);
        mainPanel.add(commandsPanel, BorderLayout.NORTH);
        mainPanel.add(productPanel, BorderLayout.CENTER);

        frameUser.add(mainPanel);
        frameUser.setVisible(true);
    }

    public void register(){
        registerPanel.setSize(800, 800);
        registerPanel.setLayout(null);
        registerPanel.setBackground(mainColor);

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

        registerPanel.add(nameTextField);
        registerPanel.add(lastNameTextField);
        registerPanel.add(addressTextField);
        registerPanel.add(emailTextField);
        registerPanel.add(phoneNumberTextField);
        registerPanel.add(userNameTextField);
        registerPanel.add(passwordField);
        registerPanel.add(repeatPasswordField);

//        registerButton.setFont(font.deriveFont(17f));
        registerButton.setBounds(460,530,100,50);
        registerButton.setBackground(forthColor);
        registerButton.setForeground(secondColor);
        registerPanel.add(registerButton);

        frameUser.add(titleLabel);
        frameUser.add(registerPanel);
        frameUser.setVisible(true);
    }

    public void contactUs(){
        JPanel contactUspanel = new JPanel();
        contactUspanel.setSize(800, 800);
        contactUspanel.setLayout(null);
        contactUspanel.setBackground(mainColor);

        JLabel emailLabel=new JLabel("آدرس ایمیل: flint.lockwood@gmail.com",SwingConstants.RIGHT);
        JLabel phonenumberLabel= new JLabel("شماره تماس: 02100000000 ",SwingConstants.RIGHT);
        JLabel addressLabel=new JLabel("آدرس: وسط اقیانوس اطلس| چلچله خوش اشتها| حیاط پشتی منزل لاکوود",SwingConstants.RIGHT);
        JLabel telegramLabel= new JLabel("تلگرام:t.me/haghdazhdefo",SwingConstants.RIGHT);

//        emailLabel.setFont(font.deriveFont(20f));
//        phonenumberLabel.setFont(font.deriveFont(20f));
//        addressLabel.setFont(font.deriveFont(20f));
//        telegramLabel.setFont(font.deriveFont(20f));

        emailLabel.setForeground(forthColor);
        phonenumberLabel.setForeground(forthColor);
        addressLabel.setForeground(forthColor);
        telegramLabel.setForeground(forthColor);

        emailLabel.setBounds(200,200,600,100);
        phonenumberLabel.setBounds(200,250,600,100);
        addressLabel.setBounds(200,300,600,100);
        telegramLabel.setBounds(200,350,600,100);

        contactUspanel.add(emailLabel);
        contactUspanel.add(phonenumberLabel);
        contactUspanel.add(addressLabel);
        contactUspanel.add(telegramLabel);

        JPanel menuPanel = menubar();
        addMenuButton(contactUspanel, menuPanel);
        contactUspanel.add(menuButton);
        frameUser.add(contactUspanel);
        frameUser.setVisible(true);
    }
    public void cart(){
        int numberOfSelected = selectedProducts.size();
        int rows = numberOfSelected + 3;
        int price=0;
        JPanel selectedList = new JPanel();
        selectedList.setBackground(mainColor);
        selectedList.setLayout(new GridLayout(rows, 1, 0, 10)); //hgap is 0 for consistent spacing

        JLabel emptyLabel = new JLabel("   ");

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(mainColor);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10)); // FlowLayout for buttons with spacing


//        cost.setFont(font.deriveFont(20f));
        //backButton.setFont(font);
        //confirmButton.setFont(font);

        for(Product p : selectedProducts){
            price= price+ p.getPrice();
            JLabel showPro = new JLabel(p.getName(), SwingConstants.CENTER);
            showPro.setForeground(secondColor);
            selectedList.add(showPro);
        }
        JLabel cost = new JLabel("جمع خرید شما: "+ price, SwingConstants.CENTER);

        buttonPanel.add(backButton);
        buttonPanel.add(confirmButton);

        selectedList.add(cost);
        selectedList.add(emptyLabel);
        selectedList.add(buttonPanel);

        frameUser.add(selectedList);
        frameUser.setVisible(true);
    }
    public void showInfo(){
        //SI stands for ShowInfo
        JPanel menuPanel = menubar();
        JPanel SIPanel = new JPanel();
        SIPanel.setSize(800, 800);
        SIPanel.setLayout(null);
        SIPanel.setBackground(mainColor);

        JLabel SILabel =  new JLabel("پروفایل کاربر", SwingConstants.RIGHT);
        JLabel NameLabel =  new JLabel("نام و نام خانوادگی: " + user.getUserName()+" "+user.getFirstName(), SwingConstants.RIGHT);
        JLabel addressLabel =  new JLabel("آدرس: " + user.getAddress(), SwingConstants.RIGHT);
        JLabel phoneNumberLabel =  new JLabel("شماره تماس: " + user.getPhoneNumber(), SwingConstants.RIGHT);
        JLabel budgetLabel =  new JLabel("موجودی: " + user.getBudget(), SwingConstants.RIGHT);

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
        frameUser.add(SIPanel);
        frameUser.setVisible(true);
    }
    public void changeData(){

        User tmpuser=user;
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
            user.setFirstName(nameTextField.getText());
        }
        if (!lastNameTextField.getText().equals(user.getLastName()));{
            user.setLastName(lastNameTextField.getText());
        }
        if (!addressTextField.getText().equals(user.getAddress()));{
            user.setAddress(addressTextField.getText());
        }
        if (!emailTextField.getText().equals(user.getemail()));{
            user.setEmail(emailTextField.getText());
        }
        if (!phoneNumberTextField.getText().equals(user.getPhoneNumber()));{
            user.setPhoneNumber(phoneNumberTextField.getText());
        }
        if (!passwordField.getText().equals(user.getPassword()));{
            user.setPassword(passwordField.getText());
        }
        if (!budgetTextField.getText().equals(user.getBudget()));{
            user.setBudget(Integer.parseInt(budgetTextField.getText()));
        }
        ManageDB db=new ManageDB();
        db.editUser(tmpuser,user);
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

        frameUser.add(titleLabel);
        frameUser.add(registerPanel);
        frameUser.setVisible(true);


    }

    public void doRegister(){
        String name = nameTextField.getText();
        String lastName = lastNameTextField.getText();
        String userName = userNameTextField.getText();
        String address = addressTextField.getText();
        String email = emailTextField.getText();
        String phoneNumber = phoneNumberTextField.getText();
        String password1 = passwordField.getText();
        String password2 = repeatPasswordField.getText();

        Border redBorder = BorderFactory.createLineBorder(Color.RED,2);

        nameTextField.setBorder(border);
        lastNameTextField.setBorder(border);
        addressTextField.setBorder(border);
        emailTextField.setBorder(border);
        phoneNumberTextField.setBorder(border);
        userNameTextField.setBorder(border);
        passwordField.setBorder(border);
        repeatPasswordField.setBorder(border);

        if (name.isEmpty()){
            nameTextField.setBorder(redBorder);
        } else if (lastName.isEmpty()) {
            lastNameTextField.setBorder(redBorder);
        } else if(address.isEmpty()){
            addressTextField.setBorder(redBorder);
        } else if (email.isEmpty()) {
            emailTextField.setBorder(redBorder);
        } else if(phoneNumber.isEmpty()){
            phoneNumberTextField.setBorder(redBorder);
        } else if(userName.isEmpty()){
            userNameTextField.setBorder(redBorder);
        } else if (password1.isEmpty()) {
            passwordField.setBorder(redBorder);
        } else if (password2.isEmpty()) {
            repeatPasswordField.setBorder(redBorder);
        }else if(!validatePhoneNumber(phoneNumber)){
            phoneNumberTextField.setBorder(redBorder);
            phoneNumberTextField.setText("شماره تلفن معتبر نیست");
        }else if(!password1.equals(password2)) {
            passwordField.setText("رمز عبورها یکسان نیست");
            repeatPasswordField.setText("رمز عبورها یکسان نیست");
            passwordField.setBorder(redBorder);
            repeatPasswordField.setBorder(redBorder);
        }else {
            password1 = MD5hashPassword(password1);
            if (password1 != null) {
                Boolean isRegistered = manageDB.userRegisterCheck(name, lastName, userName, address, email, phoneNumber, password1);
                if (isRegistered == true) {
                    frameUser.getContentPane().removeAll();
                    main(manageDB.getAllProducts());
                } else {
                    nameTextField.setText("خطایی رخ داده است. دوباره تلاش کنید");
                }
            }else {
                System.out.println("خطایی رخ داده است. دوباره تلاش کنید.");
            }

        }
    }
    public Boolean validatePhoneNumber(String phoneNumber){
        String regex = "^09\\d{9}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);

        if (matcher.matches()) {
            return true;
        } else {
            return false;
        }
    }
    private void addActionevent() {
        loginButton.addActionListener(this);
        searchButton.addActionListener(this);
        homeButton.addActionListener(this);
        contactUsButton.addActionListener(this);
        cartButton.addActionListener(this);
        backButton.addActionListener(this);
        confirmButton.addActionListener(this);
        newRegister.addActionListener(this);
        registerButton.addActionListener(this);
        exitAsUser.addActionListener(this);
        showInfoPanel.addActionListener(this);
        changeData.addActionListener(this);
        addbutton.addActionListener(this);
    }

    public String MD5hashPassword(String originalPass){
        try {
            //computes the MD5 hash
            MessageDigest digest = MessageDigest.getInstance("MD5");
            byte[] hash = digest.digest(originalPass.getBytes());

            //Convert byte array to hexadecimal string
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();


        }
        catch (NoSuchAlgorithmException e) {
            System.err.println("MD5 hash algorithm doesn't work");
        }
        return null;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String loginUserName = enterUserTF.getText();
            String loginPass = enterPassPF.getText();
            loginPass = MD5hashPassword(loginPass);
            Boolean isLoggedin = manageDB.userloginCheck(loginUserName, loginPass);
            if (isLoggedin == true){
                frameUser.getContentPane().removeAll();
                main(manageDB.getAllProducts());

            }else {
                enterUserTF.setText("خطایی رخ داده است. دوباره تلاش کنید");
            }
        } else if (e.getSource() == newRegister) {
            frameUser.getContentPane().removeAll();
            register();
        } else if (e.getSource() == registerButton) {
            doRegister();
        } else if (e.getSource() == homeButton) {
            frameUser.getContentPane().removeAll();
            main(manageDB.getAllProducts());
        } else if (e.getSource() == contactUsButton) {
            frameUser.getContentPane().removeAll();
            contactUs();
        }else if (e.getSource() == cartButton) {
            frameUser.getContentPane().removeAll();
            cart();
        }else if (e.getSource() == backButton) {
            frameUser.getContentPane().removeAll();
            main(manageDB.getAllProducts());
        } else if (e.getSource()==confirmButton) {
            //To do
        } else if (e.getSource()== exitAsUser) {
            frameUser.setVisible(false);
            new StartGui();
        } else if (e.getSource()== showInfoPanel) {
            frameUser.getContentPane().removeAll();
            showInfo();
        } else if (e.getSource() == changeData) {
            frameUser.getContentPane().removeAll();
            changeData();
        }
    }
}
