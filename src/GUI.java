import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
//        try {
//            font = Font.createFont(Font.TRUETYPE_FONT, new File("/Users/hasti/Downloads/500.Font.Collection"));
//        } catch (FontFormatException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
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
        commandsPanel.setLayout(null);
        commandsPanel.setPreferredSize(new Dimension(1000,200));
        commandsPanel.setBounds(0,0,1000,200);

        JPanel menuPanel = menubar();


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
        searchButton.setForeground(secondColor);
        name.setForeground(forthColor);
        sortButton.setBackground(forthColor);
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
//        button.setFont(font.deriveFont(15f));
        button.setHorizontalAlignment(SwingConstants.CENTER);
    }
    public void register(){}
    public void login(){}
    public void logout(){}
    public void showInfo(String name, String adress, String phoneNumber, String Budget){}
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
