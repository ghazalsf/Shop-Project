import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

public class GUI {
    final Dimension SIZE = new Dimension(1000,800);
    Color mainColor = new Color(141, 141, 170);
    Color secondColor = new Color(223, 223, 222);
    Color thirdColor = new Color(247, 245, 242);
    Color forthColor = new Color(100, 13, 107);
    Font font;
    JFrame frame;
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

    }
    public void main(){}
    public void register(){}
    public void login(String name, String password){}
    public void logout(){}
    public void showInfo(String name, String adress, String phoneNumber, String Budget){}
    public void showProducts(){}

}
