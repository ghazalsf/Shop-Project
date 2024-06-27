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

        JLabel cost = new JLabel("جمع خرید شما: 98645", SwingConstants.CENTER);
        JLabel emptyLabel = new JLabel("   ");

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(mainColor);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10)); // FlowLayout for buttons with spacing

        JButton backButton = new JButton("برگشت");
        JButton confirmButton = new JButton("تایید نهایی");

        cost.setFont(font.deriveFont(20f));
        //backButton.setFont(font);
        //confirmButton.setFont(font);

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

        priceLabel.setFont(font.deriveFont(20f));
        scoreLabel.setFont(font.deriveFont(17f));
        nameLabel.setFont(font.deriveFont(23f));

        priceLabel.setBounds(750,450,200,50);
        scoreLabel.setBounds(750,500,200,50);
        nameLabel.setBounds(750,400,200,50);

        showProductPanel.add(priceLabel);
        showProductPanel.add(scoreLabel);
        showProductPanel.add(nameLabel);

        JButton addbutton =new JButton("اضافه کردن به سبد خرید");
        JButton submitbutton= new JButton("ثبت امتیاز");
        JLabel submitscorelabel= new JLabel("امتیاز مورد نظر را از 1 تا 5 وارد کنید",SwingConstants.CENTER);
        submitscorelabel.setForeground(forthColor);
        submitscorelabel.setFont(font.deriveFont(15f));

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
    @Override
    public void login(String name, String password) {
        super.login(name, password);
    }
}
