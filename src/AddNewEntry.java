import sun.applet.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class AddNewEntry extends JFrame {
    public JPanel addPanel;
    //public static String[] addTypeName={"Crop","Fertilizer","Seed","Warehouse"};

    private JTextField IDField;
    private JTextPane IDPane;
    private JTextPane namePane;
    private JTextField NameField;
    public JTextPane Opt1Pane;
    private JTextField Opt1Field;
    public JTextPane Opt2Pane;
    private JTextField Opt2Field;
    private JButton addButton;
    String name,admin;
    int ID,quantity,rate;


    //public JComboBox<String> addType=new JComboBox<String>(addTypeName);
    //public JComboBox<String> addType;

    //public static int selectType;

    public static JFrame frame;

    public AddNewEntry(int selectType){

        //initializeList();
        //System.out.println("Type of ");
        //addType.setSelectedIndex(3);



                    addButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            insertInto(selectType);


                        }
                    });


                }




    public void insertInto(int selectType){
        try {
            System.out.println("Add Menu Admin is "+admin);
            String IDText,quantityText,rateText;

            IDText=IDField.getText();
            ID=Integer.parseInt(IDText);

            name=NameField.getText();

            quantityText=Opt1Field.getText();
            quantity=Integer.parseInt(quantityText);

            rateText=Opt2Field.getText();
            rate=Integer.parseInt(rateText);


            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/agrisql", "user", "pass");
            //Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/agrisql",userName,password);
            Statement createS = connection.createStatement();
            if (selectType == 1) {
                ID=ID+112000;
                //createS.executeUpdate("insert into enters(user_id, crop_id, fertilizer_id, seed_id, warehouse_id) VALUES (\""+admin+"\","+ID+",0,0,0)");
                createS.executeUpdate("insert into crop(crop_id,cname,quantity) VALUES ("+ID+",\""+name+"\","+quantity+")");
                System.out.println("insert into crop(crop_id,cname,quantity) VALUES ("+ID+",\""+name+"\","+quantity+")");
            }
            if (selectType == 2) {
                ID=ID+222000;
                //createS.executeUpdate("insert into enters(user_id, crop_id, fertilizer_id, seed_id, warehouse_id) VALUES (\""+admin+"\",0,"+ID+",0,0)");
                createS.executeUpdate("insert into fertilizer(fertilizer_id,fname,fquantity,frate) VALUES ("+ID+",\""+name+"\","+quantity+","+rate+")");
                System.out.println("insert into fertilizer(fertilizer_id,fname,fquantity,frate) VALUES ("+ID+",\""+name+"\","+quantity+","+rate+")");
            }
            if (selectType == 3) {
                ID=ID+212000;
                //createS.executeUpdate("insert into enters(user_id, crop_id, fertilizer_id, seed_id, warehouse_id) VALUES (\""+admin+"\",0,0,"+ID+",0)");
                createS.executeUpdate("insert into seed(seed_id,sname,rate) VALUES ("+ID+",\""+name+"\","+quantity+")");
                System.out.println("insert into seed(seed_id,sname,rate) VALUES ("+ID+",\""+name+"\","+quantity+")");
            }
            if (selectType == 4) {
                ID=ID+300000;
                //createS.executeUpdate("insert into enters(user_id, crop_id, fertilizer_id, seed_id, warehouse_id) VALUES (\""+admin+"\",0,0,0,"+ID);
                createS.executeUpdate("insert into warehouse(warehouse_id,wname,capacity) VALUES ("+ID+",\""+name+"\","+quantity+")");
                System.out.println("insert into warehouse(warehouse_id,wname,capacity) VALUES ("+ID+",\""+name+"\","+quantity+")");
            }
            System.out.println("By "+admin);
            connection.close();
        }catch (Exception ie){
            ie.printStackTrace();
            JOptionPane.showMessageDialog(null,"Invalid Data","Error",JOptionPane.ERROR_MESSAGE);
        }

    }


}
