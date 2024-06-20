import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

public class GUI {
    final Dimension SIZE = new Dimension(1000,800);
    Color mainColor = new Color(238, 245, 255);
    Color secondColor = new Color(158, 184, 217);
    Color thirdColor = new Color(124, 147, 195);
    Color forthColor = new Color(162, 87, 114);
    Font font;
    JFrame frame;
    public GUI(){
        initializeFrame();

        try {
            font = Font.createFont(Font.TRUETYPE_FONT, new File("Font\\Ayasamin.ttf")).deriveFont(12f);
        } catch (FontFormatException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void initializeFrame(){
        frame = new JFrame("");
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setBackground(mainColor);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(SIZE);

    }
    public void main(){}
    public void register(){}
    public void login(){}
    public void logout(){}
    public void showInfo(){}
    public void showProducts(){}

}
