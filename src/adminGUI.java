import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class adminGUI extends GUI{
    @Override
    public void initializeFrame() {
        super.initializeFrame();
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
            JLabel showPro = new JLabel(user.getName(), SwingConstants.CENTER);
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
