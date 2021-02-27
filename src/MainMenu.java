import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame{
    public static JFrame frame=new JFrame("Main Menu");
    public JPanel mainPanel;
    public JButton addNewEntryButton;
    public JButton viewEntriesButton;
    //AddNewEntry addNewEntry=new AddNewEntry();
    TypeOfEntry typeOfEntry=new TypeOfEntry();
    MainView mainView=new MainView();
    String admin="Default";


    public MainMenu()throws HeadlessException{
        frame.setVisible(true);
        addNewEntryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button Pressed");
                frame.setSize(800,700);
                frame.setContentPane(typeOfEntry.typePanel);
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frame.setVisible(true);
                frame.setLocationRelativeTo(null);

                typeOfEntry.admin=admin;
                System.out.println("Main Admin is "+admin);
            }
        });

        viewEntriesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Not Available... yet");
                frame.setSize(900,600);
                frame.setContentPane(mainView.viewPanel);
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                System.out.println("Admin is "+admin);

            }
        });

    }



    public static void main(String[] args) {

        MainMenu mainMenu=new MainMenu();
        frame.setSize(800,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(mainMenu.mainPanel);
        frame.setVisible(true);


    }
}
