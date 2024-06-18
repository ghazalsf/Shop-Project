import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GUI {

    Color mainColor = new Color(238, 245, 255);
    Color secondColor = new Color(158, 184, 217);
    Color thirdColor = new Color(124, 147, 195);
    Color forthColor = new Color(162, 87, 114);

    JFrame frame;
    public GUI(){
        initializeFrame();

    }

    public void initializeFrame(){
        frame = new JFrame("");
        frame.setVisible(true);
        frame.setBackground(mainColor);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(1440,810);

    }
    public static void main(){}
    public static void register(){}
    public static void login(){}
    public static void logout(){}
    public static void showInfo(){}
    public static void showProducts(){}

}
