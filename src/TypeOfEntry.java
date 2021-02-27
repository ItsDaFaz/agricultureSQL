import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by faiya on 27-Dec-17.
 */
public class TypeOfEntry extends JFrame{
    private JButton CropButton;
    public JPanel typePanel;
    private JButton SeedButton;
    private JButton WarehouseButton;
    private JButton FertilizerButton;
    String admin;
    public static JFrame frame=new JFrame("Add new");


    public TypeOfEntry() throws HeadlessException{

        CropButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                AddNewEntry addNewEntry1=new AddNewEntry(1);
                frame.setSize(250,500);
                frame.setContentPane(addNewEntry1.addPanel);
                frame.setVisible(true);
                frame.setResizable(false);
                frame.revalidate();
                addNewEntry1.admin=admin;
                System.out.println("Type of Admin "+admin);

            }

        });
        FertilizerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddNewEntry addNewEntry2=new AddNewEntry(2);
                frame.setSize(250,500);
                frame.setContentPane(addNewEntry2.addPanel);
                frame.setVisible(true);
                frame.setResizable(false);
                frame.revalidate();
                addNewEntry2.admin=admin;
                System.out.println("Type of Admin "+admin);
            }
        });
        SeedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddNewEntry addNewEntry3=new AddNewEntry(3);
                frame.setSize(250,500);
                frame.setContentPane(addNewEntry3.addPanel);
                frame.setVisible(true);
                frame.revalidate();
                addNewEntry3.admin=admin;
                System.out.println("Type of Admin "+admin);
            }
        });
        WarehouseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddNewEntry addNewEntry4=new AddNewEntry(4);
                frame.setSize(250,500);
                frame.setContentPane(addNewEntry4.addPanel);
                frame.setVisible(true);
                frame.revalidate();
                addNewEntry4.admin=admin;
                System.out.println("Type of Admin "+admin);
            }
        });



    }

    public static void main(String[] args) {
        TypeOfEntry typeOfEntry=new TypeOfEntry();
        frame.setSize(200,500);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
