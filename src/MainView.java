import com.sun.org.apache.xpath.internal.SourceTree;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by faiya on 27-Dec-17.
 */
public class MainView {
    private JTable table1;
    private JComboBox comboBox1;
    public JPanel viewPanel;
    private JButton goButton;
    DefaultTableModel model=new DefaultTableModel(new String[]{"ID","Name","Quantity"},0);
    String sqlQuery;
    public MainView(){
        table1.setModel(model);
        execquery();
    }

    public void execquery() {

        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int comboIndex=comboBox1.getSelectedIndex();
                System.out.println("Selected: "+comboIndex);
                try{
                switch (comboIndex){

                    case 1:
                        model.setRowCount(0);
                        sqlQuery="SELECT * FROM crop";
                        System.out.println(sqlQuery);
                        break;

                    case 2:
                        model.setRowCount(0);
                        sqlQuery="SELECT * FROM fertilizer";
                        System.out.println(sqlQuery);
                        break;

                    case 3:
                        model.setRowCount(0);
                        sqlQuery="SELECT * FROM seed";
                        System.out.println(sqlQuery);
                        break;

                    case 4:
                        model.setRowCount(0);
                        sqlQuery="SELECT * FROM warehouse";
                        System.out.println(sqlQuery);
                        break;
                    default:
                        model.setRowCount(0);
                        sqlQuery=null;

                }
                }catch (Exception e1){

                }
            }


        });

        goButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewTable(sqlQuery);
            }
        });


    }

    public void viewTable(String sqlQuery){
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/agrisql", "user", "pass");
            //Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/agrisql",userName,password);
            Statement tempS = connection.createStatement();
            ResultSet rs = tempS.executeQuery(sqlQuery);

            switch (sqlQuery){
                case "SELECT * FROM crop":
                    model.addRow(new Object[]{"ID","Name","Quantity"});
                    break;
                case "SELECT * FROM fertilizer":
                    model.addRow(new Object[]{"ID","Name","Quantity"});
                    break;
                case "SELECT * FROM seed":
                    model.addRow(new Object[]{"ID","Name","Quantity"});
                    break;
                case "SELECT * FROM warehouse":
                    model.addRow(new Object[]{"ID","Name","Capacity"});
                    break;
                default:
                    System.out.println("Invalid");
                    break;

            }


            while(rs.next()){
                String a=rs.getString(1);
                String b=rs.getString(2);
                String c=rs.getString(3);
                model.addRow(new Object[]{a,b,c});
            }

        }catch (Exception qe){
            qe.printStackTrace();
        }
    }

    public static void main(String[] args) {

    }


}
