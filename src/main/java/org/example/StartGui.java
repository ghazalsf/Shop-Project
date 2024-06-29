package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class StartGui implements ActionListener {
    JFrame frameStart = new JFrame("فروشگاه");
    JButton enterAsAdmin = new JButton("vorood admin");
    JButton enterAAsUser = new JButton("yorood user");
    JPanel firstPanel = new JPanel();

    final Dimension SIZE = new Dimension(1000,800);
    Color mainColor = new Color(141, 141, 170);
    Color secondColor = new Color(223, 223, 222);
    Color thirdColor = new Color(247, 245, 242);
    Color forthColor = new Color(100, 13, 107);
    Font font;

    StartGui(){
        frameStart.setSize(SIZE);
        frameStart.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameStart.setTitle("help");
        frameStart.setResizable(true);
//        try {
//            font = Font.createFont(Font.TRUETYPE_FONT, new File("Font\\Ayasamin.ttf"));
//        } catch (FontFormatException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
        startPanel();
        frameStart.setVisible(true);

        addActionevent();
    }
    public void startPanel(){
        frameStart.setLayout(new BorderLayout());

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
        frameStart.add(firstPanel, BorderLayout.CENTER);
    }
    private void addActionevent() {
        enterAAsUser.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== enterAAsUser){
            frameStart.setVisible(false);
            new GuiUser();
        } else if (e.getSource()== enterAsAdmin) {
            frameStart.setVisible(false);

        }
    }
}
