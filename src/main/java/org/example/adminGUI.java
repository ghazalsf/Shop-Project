import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;

public class adminGUI extends GUI {
    public adminGUI(){
    }
    @Override
    public void initializeFrame() {
            super.initializeFrame();
    }
    public void adminCheck(){
        JPanel adminCheckPanel = new JPanel();
        adminCheckPanel.setSize(1000, 800);
        adminCheckPanel.setLayout(null);
        adminCheckPanel.setBackground(super.mainColor);

        Border border = BorderFactory.createLineBorder(forthColor, 2);

        JPasswordField passwordField=new JPasswordField();
        passwordField.setBounds(400,400,200,50);
        passwordField.setBorder(border);
        passwordField.setEchoChar('*');

        JLabel passwordLabel=new JLabel("در صورت تمایل به ورود به عنوان ادمین رمز ورود فروشگاه را وارد کنید",SwingConstants.CENTER);
        passwordLabel.setFont(font.deriveFont(20f));
        passwordLabel.setBounds(200,320,600,50);

        adminCheckPanel.add(passwordLabel);
        adminCheckPanel.add(passwordField);

        frame.add(adminCheckPanel);
        frame.setVisible(true);
    }
    public void showInfo(String name, String address, String phoneNumber, String budget){
        super.showInfo(name,address,phoneNumber,budget);
    }
    public void register(){
        super.register();
    }
    public void login(String name, String password) {
        super.login(name, password);
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

        priceLabel.setFont(font.deriveFont(20f));
        scoreLabel.setFont(font.deriveFont(17f));
        nameLabel.setFont(font.deriveFont(23f));

        priceLabel.setBounds(750,450,200,50);
        scoreLabel.setBounds(750,500,200,50);
        nameLabel.setBounds(750,400,200,50);

        showProductPanel.add(priceLabel);
        showProductPanel.add(scoreLabel);
        showProductPanel.add(nameLabel);

        JButton deletebutton =new JButton("حذف محصول");
        JButton editbutton =new JButton("ویرایش محصول");

        deletebutton.setBounds(800,550,150,50);
        editbutton.setBounds(800,600,150,50);

        deletebutton.setForeground(secondColor);
        deletebutton.setBackground(forthColor);
        editbutton.setForeground(secondColor);
        editbutton.setBackground(forthColor);

        Border border = BorderFactory.createLineBorder(mainColor, 2);
        deletebutton.setBorder(border);
        editbutton.setBorder(border);

        showProductPanel.add(deletebutton);
        showProductPanel.add(editbutton);

        frame.add(showProductPanel);
        frame.setVisible(true);
    }

    public void userList(ArrayList<User> users){
        int numberOfUsers = users.size();
        int rows = numberOfUsers + 3;
        JPanel usersPanel = new JPanel();
        usersPanel.setBackground(mainColor);
        usersPanel.setLayout(new GridLayout(rows, 1, 0, 10)); //hgap is 0 for consistent spacing

        JLabel emptyLabel = new JLabel("   ");

        JButton backButton = new JButton("برگشت");
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0)); // Create a panel with FlowLayout
        backButton.setPreferredSize(new Dimension(100, 30));// Set the preferred size of the button
        buttonPanel.setBackground(mainColor);

        for(User user : users){
            JLabel showPro = new JLabel(user.getFirstName(), SwingConstants.CENTER);
            showPro.setForeground(secondColor);
            usersPanel.add(showPro);
        }

//        usersPanel.add(backButton);

        buttonPanel.add(backButton);
        usersPanel.add(emptyLabel);
        usersPanel.add(buttonPanel);
        frame.add(usersPanel);
        frame.setVisible(true);
    }
}
