import javax.imageio.ImageIO;
import javax.swing.*;
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
