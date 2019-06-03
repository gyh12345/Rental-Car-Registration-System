
package carrental;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class CarRental{
    CarRental(){//main frame
        JFrame login = new JFrame("Login");//login interface
        JLabel label1 = new JLabel("Username :");  
        JLabel label2 = new JLabel("Password :");
        JTextField jtf1 = new JTextField("Nick");
        JTextField jtf2 = new JTextField("123"); 
        JButton btn1 = new JButton("Login");
        JButton btn2 = new JButton("Cancel");
        
        label1.setBounds(20,20,100,20);
        label2.setBounds(20,60,100,20);
        jtf1.setBounds(100,20,175,20);
        jtf2.setBounds(100,60,175,20);
        btn1.setBounds(50,100,100,20);
        btn2.setBounds(150,100,100,20);
        
            login.setVisible(true);
            login.setSize(300,175);
            login.setResizable(false);
            login.setLayout(null);
            login.setLocationRelativeTo(null);
            login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
        login.add(label1);
        login.add(label2);
        login.add(jtf1);
        login.add(jtf2);
        login.add(btn1);
        login.add(btn2);
        
        btn1.addActionListener(new ActionListener(){//login button
            public void actionPerformed(ActionEvent login){
                String name = jtf1.getText();
                String pass = jtf2.getText();
                if(name.equals("Nick")&&pass.equals("123")){
                    JOptionPane.showMessageDialog(null,"Welcome to the system!");
                    new MainInterface();
                }
                else{
                  JOptionPane.showMessageDialog(null, "LOGIN FAILED!\nPLEASE TRY AGAIN!");
                }
            }
        });
        
        btn2.addActionListener(new ActionListener(){//cancel button
            public void actionPerformed(ActionEvent cancel){
                login.setVisible(false);
                login.dispose();
            }
        });
    }
    
    public static void main(String[] args) {
        new CarRental();   
    }
}
