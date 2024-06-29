package org.example;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.color.ColorSpace;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.awt.image.RescaleOp;
import java.io.File;
import java.io.IOException;


public class ImageViewer extends JFrame implements ActionListener{
    JButton selectFileButton = new JButton("Choose File");
    JButton showImageButton = new JButton("Show Image");
    JButton closeButton = new JButton("Exit");
    JLabel picturelabel=new JLabel();
    JButton backButton = new JButton("back");
    String filePath = "/home/pariya/photo";
    File file;
    JFileChooser fileChooser = new JFileChooser(filePath);


    ImageViewer(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Image Viewer");
        this.setSize(700, 300);
        this.setVisible(true);
        this.setResizable(true);
        this.setResizable(false);

        mainPanel();
        addActionEvent();
    }

    public void mainPanel(){
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);


        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setBounds(200, 100, 300, 100);
        buttonsPanel.setLayout(new GridLayout(3, 2));


        buttonsPanel.add(this.selectFileButton);
        buttonsPanel.add(this.showImageButton);
        buttonsPanel.add(this.closeButton);

        mainPanel.add(buttonsPanel);

        this.add(mainPanel);
    }
    public void chooseFileImage(int option){

        option = fileChooser.showOpenDialog(ImageViewer.this);

    }
    public void showImage (JPanel productPanel){

        JPanel tempPanel = new JPanel();
        JPanel tempmainPanel = new JPanel();


        tempmainPanel.setLayout(new BorderLayout());
        tempmainPanel.setBorder(new EmptyBorder(20,20,20,20));

        tempPanel.add(picturelabel);


        tempmainPanel.add(tempPanel, BorderLayout.CENTER);
        System.out.println(String.valueOf(file));

        ImageIcon imageIcon = new ImageIcon(new ImageIcon(String.valueOf(file)).getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT));
        picturelabel.setIcon(imageIcon);
        tempPanel.setSize(1800, 1000);


    }
    public void showOriginalImage(int option){

        if (option == JFileChooser.APPROVE_OPTION) ;{
            file = fileChooser.getSelectedFile();
            if (file==null){
                err("choose your file first");
            }
            else {
                JFrame tempFrame = new JFrame();
                JPanel tempPanel = new JPanel();
                JPanel tempmainPanel = new JPanel();


                tempmainPanel.setLayout(new BorderLayout());
                tempmainPanel.setBorder(new EmptyBorder(20,20,20,20));

                tempPanel.add(picturelabel);

                tempFrame.add(tempmainPanel, BorderLayout.NORTH);
                tempFrame.setSize(900,900);
                tempFrame.setDefaultCloseOperation(3);
                tempFrame.setVisible(true);

                tempmainPanel.add(tempPanel, BorderLayout.CENTER);
                System.out.println(String.valueOf(file));

                ImageIcon imageIcon = new ImageIcon(new ImageIcon(String.valueOf(file)).getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT));
                picturelabel.setIcon(imageIcon);
                tempPanel.setSize(1800, 1000);
                tempFrame.setTitle("Image Viewer");
                tempFrame.setSize(1800, 1000);
                tempFrame.setVisible(true);
                tempFrame.setResizable(true);
                tempFrame.add(tempPanel);
            }
        }


    }

    public void err(String str){

        JPanel errpanel = new JPanel();

        errpanel.setLayout(null);
        errpanel.setBounds(0,0,700,300);

        JLabel brightnesslabel=new JLabel(str);
        brightnesslabel.setBounds(200,100,300,100);

        errpanel.add(brightnesslabel);
        backButton.setBounds(20,220,90,30);
        errpanel.add(backButton);

        this.getContentPane().removeAll();
        this.add(errpanel);
        this.repaint();
        this.revalidate();

    }
    public void addActionEvent() {

        selectFileButton.addActionListener(this);
        showImageButton.addActionListener(this);

        closeButton.addActionListener(this);
        backButton.addActionListener(this);

    }
    @Override
    public void actionPerformed(ActionEvent e){
        int option=0;
       if(e.getSource()== showImageButton){

            try {
                showOriginalImage(option);
            }
            catch (Exception ex){
                err("choose your file first");
            }

        }else if(e.getSource()== selectFileButton){
            chooseFileImage(option);

        }else if(e.getSource()==closeButton){
            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        }
        else if(e.getSource()==  backButton){
            this.getContentPane().removeAll();
            this.mainPanel();
            this.revalidate();
            this.repaint();
        }
    }
}