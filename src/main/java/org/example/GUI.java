package org.example;

import org.example.models.ManageDB;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.io.IOException;
import java.io.File;
public class GUI extends JFrame implements ActionListener {
    final Dimension SIZE = new Dimension(1000,800);
    Color mainColor = new Color(141, 141, 170);
    Color secondColor = new Color(223, 223, 222);
    Color thirdColor = new Color(247, 245, 242);
    Color forthColor = new Color(100, 13, 107);
    Font font;
    JFrame frame = new JFrame("");
    ManageDB manageDB = new ManageDB();

    JButton menuButton = new JButton("منو");
    JButton searchButton = new JButton("جستجو");
    JButton sortButton = new JButton("مرتب سازی از کمترین قیمت:");
    JButton sortButtonBigger = new JButton("مرتب سازی از بیشترین قیمت:");
    JButton sortButtonCategory = new JButton("مرتب سازی بر اساس دسته بندی:");
    JButton enterAAsUser = new JButton("ورود ادمین");
    JButton  enterAsAdmin = new JButton("ورود کاربر");
    JButton registerButton=new JButton("ثبت");
    JButton loginButton = new JButton("ورود");
    JButton homeButton = new JButton("صفحه اصلی");
    JButton contactUsButton = new JButton("ارتباط با ما");
    JButton cartButton = new JButton("سبد خرید");

    JTextField searchBar = new JTextField();

    ArrayList<Product> products = manageDB.getAllProducts();

    JPanel firstPanel = new JPanel(); // startPanel()
    JPanel infoPanel = new JPanel(); // login()
    JPanel productPanel = new JPanel(); // main()
    JPanel registerPanel = new JPanel(); // register()

    ArrayList<JButton> productsButtons;
    public GUI(){
        initializeFrame();
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, new File("Font\\Ayasamin.ttf"));
        } catch (FontFormatException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //addActionEvent();
    }

    public void initializeFrame(){
        frame.setResizable(true);
        frame.setBackground(mainColor);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(SIZE);
        frame.setVisible(true);
    }
    public void startPanel(){
        frame.setLayout(new BorderLayout());

        firstPanel.setBackground(mainColor);
        firstPanel.setLayout(new GridBagLayout());
        firstPanel.setPreferredSize(new Dimension(1000, 800));

        JLabel enter = new JLabel("ورود");

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.CENTER;
        Dimension buttonSize = new Dimension(200, 100);
        enterAAsUser.setPreferredSize(buttonSize);
        enterAsAdmin.setPreferredSize(buttonSize);

        enterAAsUser.setBackground(forthColor);
        enterAAsUser.setForeground(secondColor);
        enterAsAdmin.setBackground(forthColor);
        enterAsAdmin.setForeground(secondColor);

        firstPanel.add(enter, gbc);
        gbc.gridy=1;
        firstPanel.add(enterAAsUser, gbc);
        gbc.gridy = 2;
        firstPanel.add(enterAsAdmin, gbc);
        initializeFrame();
        frame.add(firstPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
    public void main(ArrayList<Product> products){
        frame.setLayout(new BorderLayout());

        addActionEvent();
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JPanel commandsPanel = new JPanel();
        commandsPanel.setLayout(null);
        commandsPanel.setPreferredSize(new Dimension(1000,200));
        commandsPanel.setBounds(0,0,1000,200);

        JPanel menuPanel = menubar();

        JTextField searchBar = new JTextField();
        searchBar.setBounds(140,25,150,30);

        searchButton.setBounds(290,25,80,30);

        JLabel name = new JLabel("هقداژدفو",SwingConstants.RIGHT);
        name.setBounds(550,50,200,100);
        name.setFont(font.deriveFont(50f));

        sortButton.setBounds(140,65,230,30);

        sortButtonBigger.setBounds(140,105,230,30);

        sortButtonCategory.setBounds(140, 145,230,30);

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
        int y=0;

        productPanel.setPreferredSize(new Dimension(1000,600));
        productPanel.setBounds(0,200,1000,800);
        productPanel.setBackground(mainColor);

        //finding the rows for the grind layout
        if(amountOfProducts%4 ==0)
            y=amountOfProducts/4;
        else
            y= amountOfProducts/4 +1;

        productPanel.setLayout(new GridLayout(y, 4,50,20));

        for (Product p : products) {
            JButton proButton = new JButton(p.getName()+", "+ p.getPrice()+", "+p.getScore()+", "+p.getCategory());
            proButton.setBackground(forthColor);
            proButton.setForeground(secondColor);
            productPanel.add(proButton);
        }

        addMenuButton(mainPanel, menuPanel);
        mainPanel.add(menuButton);
        mainPanel.add(commandsPanel,BorderLayout.NORTH);
        mainPanel.add(productPanel,BorderLayout.CENTER);
        initializeFrame();
        frame.add(mainPanel);
        frame.setVisible(true);
    }
    public void addMenuButton(JPanel panel1, JPanel panel2){
        menuButton.setBounds(940,10,50,50);
        menuButton.setBackground(forthColor);
        menuButton.setFont(font.deriveFont(13f));
        menuButton.setForeground(secondColor);

        final boolean[] panel2Visible = {false};
        menuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!panel2Visible[0]) {
                    // move panel1 to left
                    movePanelToLeft(panel1, 200); // move 200 pixel
                    // show panel2 to left
                    frame.add(panel2);
                    frame.revalidate();
                    frame.repaint();
                    panel2Visible[0] = true;
                } else {
                    // move panel 1 using animation
                    movePanelToOriginalPosition(panel1, 0); // return to first place
                    // remove panel2 from main
                    frame.remove(panel2);
                    frame.revalidate();
                    frame.repaint();
                    panel2Visible[0] = false;
                }
            }
        });
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

        titleLabel.setFont(font.deriveFont(40f));
        nameLabel.setFont(font.deriveFont(20f));
        lastNameLabel.setFont(font.deriveFont(20f));
        addressLabel.setFont(font.deriveFont(20f));
        emailLabel.setFont(font.deriveFont(20f));
        phoneNumberLabel.setFont(font.deriveFont(20f));
        userNameLabel.setFont(font.deriveFont(20f));
        passwordLabel.setFont(font.deriveFont(20f));
        repeatPasswordLabel.setFont(font.deriveFont(20f));

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

        registerButton.setFont(font.deriveFont(17f));
        registerButton.setBounds(460,530,100,50);
        registerButton.setBackground(forthColor);
        registerButton.setForeground(secondColor);
        registerPanel.add(registerButton);

        frame.add(titleLabel);
        frame.add(registerPanel);
        frame.setVisible(true);
    }
        public void login() {
        infoPanel.setSize(1000,800);
        infoPanel.setLayout(null);
        infoPanel.setBackground(mainColor);

        Border b = BorderFactory.createLineBorder(forthColor,2);

        JLabel enterL = new JLabel("ورود کاربر",SwingConstants.CENTER);
        enterL.setBounds(360,80,267,80);
        enterL.setFont(font.deriveFont(40f));
        enterL.setForeground(forthColor);

        JLabel enterUserL = new JLabel("نام کاربری خود را وارد کنید:",SwingConstants.CENTER);
        enterUserL.setBounds(360,200,267,80);
        enterUserL.setFont(font.deriveFont(25f));
        enterUserL.setForeground(secondColor);

        JTextField enterUserTF = new JTextField();
        enterUserTF.setBounds(360,280,267,40);
        enterUserTF.setBorder(b);

        JLabel enterPassL = new JLabel("رمز عبور خود را وارد کنید:",SwingConstants.CENTER);
        enterPassL.setBounds(360,340,267,80);

        enterPassL.setForeground(secondColor);
        enterPassL.setFont(font.deriveFont(25f));

        JPasswordField enterPassPF = new JPasswordField();
        enterPassPF.setBounds(360,420,267,40);
        enterPassPF.setBorder(b);

        loginButton.setBounds(450,530,100,50);
        loginButton.setBackground(forthColor);
        loginButton.setForeground(secondColor);
        loginButton.setFont(font.deriveFont(25f));

        infoPanel.add(enterL);
        infoPanel.add(enterUserL);
        infoPanel.add(enterUserTF);
        infoPanel.add(enterPassL);
        infoPanel.add(enterPassPF);
        infoPanel.add(loginButton);
        frame.add(infoPanel);
        frame.setVisible(true);
    }
    public void logout(){}
    private void flatButton(JButton button) {
        button.setBorderPainted(false); // remove border
        button.setContentAreaFilled(false); // remove bg
        button.setFont(font.deriveFont(15f));
        button.setHorizontalAlignment(SwingConstants.CENTER);
    }
    public JPanel menubar(){
        JPanel panel = new JPanel(null);
        panel.setPreferredSize(new Dimension(100, 800));
        panel.setBounds(0,0,100,800);

        homeButton.setBounds(800, 130, 200, 30);
        contactUsButton.setBounds(800, 190, 200, 30);
        cartButton.setBounds(800, 250, 200, 30);

        flatButton(homeButton);
        flatButton(contactUsButton);
        flatButton(cartButton);

        panel.add(homeButton);
        panel.add(contactUsButton);
        panel.add(cartButton);

        return panel;
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

        emailLabel.setFont(font.deriveFont(20f));
        phonenumberLabel.setFont(font.deriveFont(20f));
        addressLabel.setFont(font.deriveFont(20f));
        telegramLabel.setFont(font.deriveFont(20f));

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

        frame.add(contactUspanel);
        frame.setVisible(true);
    }
    public void showInfo(String name, String address, String phoneNumber, String budget){
        //SI stands for ShowInfo
        JPanel menuPanel = menubar();
        JPanel SIPanel = new JPanel();
        SIPanel.setSize(800, 800);
        SIPanel.setLayout(null);
        SIPanel.setBackground(mainColor);

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
    public void showProducts(){}

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

    public ArrayList<Product> searchNameAndCategory(String searchString) {
        ArrayList<Product> foundProducts = new ArrayList<>();
        System.out.println("searchhhh");
        System.out.println("searchstring" + searchString);
        // Convert the search string to lowercase for case-insensitive matching
        searchString = searchString.toLowerCase();
        ArrayList<Product> products = manageDB.getAllProducts();
        System.out.println(products.size());

        for (int i = 0; i < products.size(); i++) {

            System.out.println("product:"+products.get(i).getCategory());
            System.out.println(products.get(i).getName());
            String productCategory = products.get(i).getCategory();
            String productName = products.get(i).getName();
            if (productCategory == null || productName == null)continue;
            System.out.println(productCategory.contains(searchString));
            System.out.println(productName.contains(searchString));
            if (productCategory.contains(searchString) || productName.contains(searchString)){
                System.out.println("item founded");
                foundProducts.add(products.get(i));
            }
        }
        frame.getContentPane().removeAll();
        System.out.println(foundProducts.size());
        for (int i = 0; i < foundProducts.size(); i++) {
            System.out.println(foundProducts.get(i).getName());
        }
        main(foundProducts);
        return foundProducts;
    }

    public void addActionEvent(){
        searchButton.addActionListener(this);
        //searchBar.addActionListener(this);
        System.out.println("help");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==searchButton){
            System.out.println("hey");
            String searchString = searchBar.getText();
            System.out.println(searchString);
            searchNameAndCategory(searchString);
        }
    }
    public void notFound(){
        JPanel nothing = new JPanel();
        nothing.setLayout(new FlowLayout());
        JLabel nothingL = new JLabel("یافت نشد");
        nothing.add(nothingL);
        initializeFrame();
        frame.add(nothing);
        frame.setVisible(true);
    }

}
