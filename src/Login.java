import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Login extends JFrame {
    private JPanel loginPanel;
    private JTextField userNameInput;
    private JPasswordField passwordInput;
    private JTextPane usernameTextPane;
    private JTextPane passwordTextPane;
    private JButton loginButton;
    private String userName,password;
    public static JFrame frame=new JFrame("Login");
    public MainMenu mainMenu=new MainMenu();
    //public AddNewEntry addNewEntry=new AddNewEntry();

    public Login() throws HeadlessException{
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userName=userNameInput.getText();
                password=passwordInput.getText();
                System.out.println("Input ID: "+userName);
                signinAction();
            }
        });
    }



    private void signinAction(){
        try{
            String checkID,checkPass;
            boolean foundAdmin=false,loginPass=false;
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/agrisql","user","pass");
            //Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/agrisql",userName,password);
            Statement tempS=connection.createStatement();
            ResultSet rs=tempS.executeQuery("select * from agroadmin");
            while(rs.next()){
                checkID=rs.getString("user_id");
                checkPass=rs.getString("password");

                if(checkID.equals(userName)){
                    foundAdmin=true;
                    System.out.println("Found "+userName);
                    mainMenu.admin=userName;
                }

                if(checkID.equals(userName)&&checkPass.equals(password)){
                    foundAdmin=true;
                    loginPass=true;
                    System.out.println("Found "+userName);
                }



            }
            if(foundAdmin==false || loginPass==false){
                JOptionPane.showMessageDialog(null,"Username or Password incorrect","Warning",JOptionPane.WARNING_MESSAGE);
            }
            else {
                JOptionPane.showMessageDialog(null, "Login Successful", "Login", JOptionPane.INFORMATION_MESSAGE);
                frame.setContentPane(mainMenu.mainPanel);
                frame.setSize(300,400);


                //System.exit(1);
            }

            connection.close();
        }catch (Exception loginExc){
            loginExc.printStackTrace();
        }
    }

    public static void main(String[] args) {

        Login login=new Login();
        frame.setSize(400,400);
        frame.setContentPane(login.loginPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);




    }


}
