import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.io.IOException;
import java.io.File;

public class GUI {
    final Dimension SIZE = new Dimension(1000,800);
    Color mainColor = new Color(141, 141, 170);
    Color secondColor = new Color(223, 223, 222);
    Color thirdColor = new Color(247, 245, 242);
    Color forthColor = new Color(100, 13, 107);
    Font font;
    JFrame frame;
    JButton menuButton;

    public GUI(){
        initializeFrame();
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, new File("Font\\Ayasamin.ttf"));
        } catch (FontFormatException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void initializeFrame(){
        frame = new JFrame("");
        frame.setResizable(true);
        frame.setBackground(mainColor);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(SIZE);
        frame.setVisible(true);
    }
    public void main(ArrayList<Product> products){
        frame.setLayout(new BorderLayout());

        JPanel commandsPanel = new JPanel();
        JPanel menuPanel = menubar();

        commandsPanel.setLayout(null);
        commandsPanel.setPreferredSize(new Dimension(1000,200));
        commandsPanel.setBounds(0,0,1000,200);

        JTextField searchBar = new JTextField();
        searchBar.setBounds(140,40,150,40);

        JButton searchButton = new JButton("جستجو");
        searchButton.setBounds(290,40,80,40);

        JLabel name = new JLabel("هقدازدفو",SwingConstants.RIGHT);
        name.setBounds(550,50,200,100);

        JButton sortButton = new JButton("مرتب سازی از کمترین قیمت:");
        sortButton.setBounds(140,120,230,40);

        commandsPanel.setBackground(mainColor);
        searchButton.setBackground(forthColor);
        sortButton.setBackground(forthColor);

        searchButton.setForeground(secondColor);
        name.setForeground(forthColor);
        sortButton.setForeground(secondColor);

        addMenuButton(commandsPanel, menuPanel);

        commandsPanel.add(menuButton);
        commandsPanel.add(name);
        commandsPanel.add(searchBar);
        commandsPanel.add(searchButton);
        commandsPanel.add(sortButton);

        int amountOfProducts = products.size();
        int y=0;

        JPanel productPanel = new JPanel();
        productPanel.setPreferredSize(new Dimension(1000,600));
        productPanel.setBounds(0,200,1000,800);
        productPanel.setBackground(mainColor);

        //finding the rows for the grind layout
        if(amountOfProducts%4 ==0)
            y=amountOfProducts/4;
        else
            y= amountOfProducts/4 +1;

        productPanel.setLayout(new GridLayout(y, 4,50,20));

        ArrayList<JButton> productButtons = new ArrayList<>();

        for (Product p : products) {
            JButton proButton = new JButton(p.getName());
            proButton.setBackground(forthColor);
            proButton.setForeground(secondColor);
            productPanel.add(proButton);
        }

        initializeFrame();
        frame.add(commandsPanel,BorderLayout.NORTH);
        frame.add(productPanel,BorderLayout.CENTER);
        frame.setVisible(true);
    }
    public void addMenuButton(JPanel panel1, JPanel panel2){
        menuButton = new JButton("منو");
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

    public void login(){}
    public void register(){
        JPanel registerPanel = new JPanel();
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

        JButton registerButton=new JButton("ثبت");
        registerButton.setFont(font.deriveFont(17f));
        registerButton.setBounds(460,530,100,50);
        registerButton.setBackground(forthColor);
        registerButton.setForeground(secondColor);
        registerPanel.add(registerButton);

        frame.add(titleLabel);
        frame.add(registerPanel);
        frame.setVisible(true);
    }
    public void login(String name, String password) {
//      Information-Insertion panel :
        JPanel infoPanel = new JPanel();
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

        JButton loginButton = new JButton("ورود");
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
}
