
package carrental;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
import java.util.Scanner;
import java.io.IOException;

public class MainInterface
{ //**************** global variables ******************
    public static ArrayList<Car> cars = new <Car>ArrayList();
    public static ArrayList<Client> clients = new <Client>ArrayList();
    public static File file = new File("data.txt");
    public static String[]columns = {"No.","Car Brand","Plate No.","Rental","Charge(RM)","Rent To","I.C No.","License No.","Phone No."}; //table header
    public static DefaultTableModel tablemodel = new DefaultTableModel(columns,0);
    
    private static void insertFile()//method to add items to file
    {
        try
        {   
            File inFile = new File("data.txt");
            FileWriter outFileStream = new FileWriter(inFile);
            PrintWriter outStream = new PrintWriter(outFileStream);
            
            for(int i=0; i<clients.size(); i++)
            {
                outStream.print(Integer.toString(i+1)+",");
                outStream.print(cars.get(i).getBrand()+",");
                outStream.print(cars.get(i).getNumPlate()+",");
                outStream.print(cars.get(i).getRental()+",");
                outStream.print(cars.get(i).getCharge()+",");
                outStream.print(clients.get(i).getName()+",");
                outStream.print(clients.get(i).getIC()+",");
                outStream.print(clients.get(i).getLicenseNum()+",");
                outStream.println(clients.get(i).getPhoneNum());
            }
            outStream.close();
        }
        catch(IOException ex)
        {
            JOptionPane.showMessageDialog(null,"Error in insertFile() "+ex);
        }
    }//end insertFile()
    
    private static void loadFile()//method to load items from file
    {         
        try
        {   
            Scanner scanner = new Scanner(file);
            String data;
            int i = 1;//to assign row number

                while(scanner.hasNextLine())
                {   
                    data = scanner.nextLine();
                    String dataArr[] = data.split(",");
                
                    dataArr[0] = Integer.toString(i);
                    cars.add(new Car(dataArr[1],dataArr[2],dataArr[3],dataArr[4]));
                    clients.add(new Client(dataArr[5],dataArr[6],dataArr[7],dataArr[8]));
                    tablemodel.addRow(dataArr);
                
                    i++;//assigning number to each number in ascending order
                }
            scanner.close();   
        }
        catch(FileNotFoundException ex)
        {
            JOptionPane.showMessageDialog(null, "The save file is empty!");
        }
    }//end loadFile()
   
    public static void showFoundItem(int i)//to show search item found
    {
        JOptionPane.showMessageDialog(null,"Search item found!"
                                                    +"\n****** CAR INFO ******"
                                                    +"\nBrand: "+cars.get(i).getBrand()
                                                    +"\nPlate no: "+cars.get(i).getNumPlate()
                                                    +"\nRental(days): "+cars.get(i).getRental()
                                                    +"\nCharge(RM): "+cars.get(i).getCharge()
                                                    +"\n\n****** CLIENT INFO ******"
                                                    +"\nRent to: "+clients.get(i).getName()
                                                    +"\nIC no.: "+clients.get(i).getIC()
                                                    +"\nLicense no.: "+clients.get(i).getLicenseNum()
                                                    +"\nPhone no.: "+clients.get(i).getPhoneNum());
    }//end showFoundItem()
    
    public static void refreshData()//to delete old file & create new file with updated data
    {
        try
        {
            file.delete();
            file.createNewFile();
            FileWriter fileOutStream = new FileWriter(file);
            PrintWriter outStream = new PrintWriter(fileOutStream);
            
            for(int i=0; i<clients.size(); i++)
            {
                outStream.print(Integer.toString(i+1)+",");
                outStream.print(cars.get(i).getBrand()+",");
                outStream.print(cars.get(i).getNumPlate()+",");
                outStream.print(cars.get(i).getRental()+",");
                outStream.print(cars.get(i).getCharge()+",");
                outStream.print(clients.get(i).getName()+",");
                outStream.print(clients.get(i).getIC()+",");
                outStream.print(clients.get(i).getLicenseNum()+",");
                outStream.println(clients.get(i).getPhoneNum());
            }
            outStream.close();
            
                Scanner scanner = new Scanner(file);
                String data;
                int i = 1;//to assign row number

                while(scanner.hasNextLine())
                {   
                    data = scanner.nextLine();
                    String dataArr[] = data.split(",");
                    dataArr[0] = Integer.toString(i);
                       
                    tablemodel.addRow(dataArr);
                    i++;//assigning number to each number in ascending order
                }
                scanner.close();   
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,"refreshData() Error: "+ex);
        }
    }//end refreshData()    

    MainInterface()
    {
        JFrame mainframe = new JFrame("Rental Car Registration System");
        JLabel L1 = new JLabel("Car Brand :");
        JLabel L2 = new JLabel("Number Plate :");
        JLabel L3 = new JLabel("Rental(days) :");
        JLabel L4 = new JLabel("Charge : RM");
        JLabel L5 = new JLabel("Rent to :");
        JLabel L6 = new JLabel("IC Number :");
        JLabel L7 = new JLabel("License No. :");
        JLabel L8 = new JLabel("Phone No. :");
        JLabel L9 = new JLabel("*** CAR RENTAL INFO ***");
        JLabel L10 = new JLabel("*** CLIENT INFO ***"); 
        JLabel L11 = new JLabel("***** Update and Delete function can be done with Plate Number and IC Number *****");
        JTextField jtf1 = new JTextField("Proton Satria");
        JTextField jtf2 = new JTextField("JEJ 5668");
        JTextField jtf3 = new JTextField("3");
        JTextField jtf4 = new JTextField("100");
        JTextField jtf5 = new JTextField("Miss Lim");
        JTextField jtf6 = new JTextField("981118087799");
        JTextField jtf7 = new JTextField("123456789012");
        JTextField jtf8 = new JTextField("018-5725842");        
        JButton btn1 = new JButton("Add");
        JButton btn2 = new JButton("Search");
        JButton btn3 = new JButton("Update");
        JButton btn4 = new JButton("Delete");      
        JTable table = new JTable(tablemodel); 
        JScrollPane sclTable = new JScrollPane(table);
        
        L1.setBounds(20,60,90,20);//car brand
        L2.setBounds(20,100,90,20);//number plate
        L3.setBounds(20,140,90,20);//rental
        L4.setBounds(20,180,90,20);//charge
        L5.setBounds(340,60,90,20);//rent to
        L6.setBounds(340,100,90,20);//ic
        L7.setBounds(340,140,90,20);//license number
        L8.setBounds(340,180,90,20);//phone number
        L9.setBounds(100,20,180,20);//*** CAR RENTAL INFO ***
        L10.setBounds(430,20,180,20);//*** CLIENT INFO ***
        L11.setBounds(85,585,600,20);//Info
        jtf1.setBounds(110,60,200,20);//jtextfield brand
        jtf2.setBounds(110,100,200,20);//plate no.
        jtf3.setBounds(110,140,200,20);//rental
        jtf4.setBounds(110,180,200,20);//charge
        jtf5.setBounds(420,60,200,20);//rent to
        jtf6.setBounds(420,100,200,20);//ic no.
        jtf7.setBounds(420,140,200,20);//license no.
        jtf8.setBounds(420,180,200,20);//jtextfield phone no.
        btn1.setBounds(20,220,150,40);//add button
        btn2.setBounds(170,220,150,40);//search button
        btn3.setBounds(320,220,150,40);//update button
        btn4.setBounds(470,220,150,40);//delete button
        sclTable.setBounds(20,280,600,300);//JScrollPane        
        table.getColumnModel().getColumn(0).setPreferredWidth(25);//random width (no.)
        table.getColumnModel().getColumn(3).setPreferredWidth(45);//random width (rental)
        table.getColumnModel().getColumn(4).setPreferredWidth(75);//random width (charge)
        table.setRowHeight(20);//set height for each row
        sclTable.setVisible(true);
        
            mainframe.setSize(650,650);
            mainframe.setVisible(true);
            mainframe.setResizable(false);
            mainframe.setLayout(null);
            mainframe.setLocationRelativeTo(null);
            mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        mainframe.add(L1);//label
        mainframe.add(L2);
        mainframe.add(L3);
        mainframe.add(L4);
        mainframe.add(L5);
        mainframe.add(L6);
        mainframe.add(L7);
        mainframe.add(L8);
        mainframe.add(L9);
        mainframe.add(L10);//label
        mainframe.add(L11);
        mainframe.add(jtf1);//jtextfield
        mainframe.add(jtf2);
        mainframe.add(jtf3);
        mainframe.add(jtf4);
        mainframe.add(jtf5);
        mainframe.add(jtf6);
        mainframe.add(jtf7);
        mainframe.add(jtf8);//jtextfield
        mainframe.add(btn1);//insert button
        mainframe.add(btn2);//search button
        mainframe.add(btn3);//edit button
        mainframe.add(btn4);//delete button
        mainframe.add(sclTable);
        
        loadFile();//load data from file to arraylist and jtable upon program start
        
        btn1.addActionListener(new ActionListener()//for add button
        {
            public void actionPerformed(ActionEvent add)
            {
                try
                {
                    String brand = jtf1.getText();//get text from jtextfield
                    String plate = jtf2.getText(); 
                    String rental = jtf3.getText();
                    String charge = jtf4.getText();
                    String rentTo = jtf5.getText();
                    String ic = jtf6.getText();
                    String license = jtf7.getText();
                    String phone = jtf8.getText();//get text from jtextfield
                    
                    cars.add(new Car(brand,plate,rental,charge));//declare new car
                    clients.add(new Client(rentTo,ic,license,phone));//declare new client
                    insertFile();//save to file.txt
                        
                        for(int i=cars.size()-1; i<cars.size(); i++)
                        {//displaying the inputs in jtable
                            String[]data = new String[9];
                           
                            data[0] = Integer.toString(i+1);
                            data[1] = cars.get(i).getBrand();
                            data[2] = cars.get(i).getNumPlate();
                            data[3] = cars.get(i).getRental();
                            data[4] = cars.get(i).getCharge();
                            data[5] = clients.get(i).getName();
                            data[6] = clients.get(i).getIC();
                            data[7] = clients.get(i).getLicenseNum();
                            data[8] = clients.get(i).getPhoneNum();
                            
                            tablemodel.addRow(data);//displaying data row by row  
                        }
                        tablemodel.fireTableDataChanged();
                }
                catch(Exception ex)
                {
                    JOptionPane.showMessageDialog(null, "error in add: "+ex);
                }
            }//end actionEvent add
        });//end actionListener(add)
        
        btn2.addActionListener(new ActionListener()//for search button
        {
            public void actionPerformed(ActionEvent search)
            {
                JFrame Sframe = new JFrame("Search Panel");
                JLabel l1 = new JLabel("Search using Plate Number or IC Number ?");
                JLabel l2 = new JLabel("Your search :");
                JTextField jtf1 = new JTextField();
                JButton btn1 = new JButton("Plate Number");
                JButton btn2 = new JButton("IC Number");

                l1.setBounds(20,50,300,20);//search by plate
                l2.setBounds(20,20,80,20);//your search
                jtf1.setBounds(110,20,150,20);//textfield your search 
                btn1.setBounds(20,80,130,40);//plate number button
                btn2.setBounds(150,80,130,40);//ic number button
                
                    Sframe.setLayout(null);
                    Sframe.setSize(300,180);
                    Sframe.setVisible(true);
                    Sframe.setResizable(false);
                    Sframe.setLocationRelativeTo(null);
                    Sframe.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                
                Sframe.add(l1);//search by plate
                Sframe.add(l2);//search by ic
                Sframe.add(jtf1);//textfield search by plate 
                Sframe.add(btn1);//plate button
                Sframe.add(btn2);//ic button
                
                btn1.addActionListener(new ActionListener()
                {//the button to search with plate number
                    public void actionPerformed(ActionEvent searchPlate)
                    {
                        String plate = jtf1.getText();
                        boolean search = false;
                        for(int i=0; i<cars.size(); i++)
                        {
                            if(plate.equalsIgnoreCase(cars.get(i).getNumPlate()))
                            {
                                showFoundItem(i);//invoke method to show found items
                                search = true;
                            }
                        }
                        if(search == false)
                        {
                            JOptionPane.showMessageDialog(null,"Item not found!");
                        }
                    }//end actionEvent(searchPlate)
                });//end actionListener(searchPlate)
                
                btn2.addActionListener(new ActionListener()
                {//the button to search with IC
                    public void actionPerformed(ActionEvent searchIC)
                    {
                        String ic = jtf1.getText();
                        boolean search = false;
                        
                        for(int i=0; i<clients.size(); i++)
                        {
                            if(ic.equals(clients.get(i).getIC()))
                            {
                                showFoundItem(i);//invoke method to show found items
                                search = true;
                            }
                        }
                        
                        if(search == false)
                        {
                            JOptionPane.showMessageDialog(null,"Item not found!");
                        }
                    }//end actionEvent(searchIC)
                });//end actionListener(searchIC)
            }//end actionPerformed(search)
        });//end actionListener(search)
        
        btn3.addActionListener(new ActionListener()//for update button 
        {
            public void actionPerformed(ActionEvent updateData)
            {//search and update using main interface(search with num plate & ic)
                String brand, rental, charge, rentTo, license, phone;
                String plate = jtf2.getText();
                String ic = jtf6.getText();
                boolean update = false;
                
                for(int i=0; i<cars.size(); i++)
                {
                    if((plate.equalsIgnoreCase(cars.get(i).getNumPlate())) && (ic.equals(clients.get(i).getIC())))
                    {
                        brand = jtf1.getText();
                        rental = jtf3.getText();
                        charge = jtf4.getText();
                        rentTo = jtf5.getText();
                        license = jtf7.getText();
                        phone = jtf8.getText();
                       
                        cars.get(i).setBrand(brand);
                        cars.get(i).setRental(rental);
                        cars.get(i).setCharge(charge);
                        clients.get(i).setName(rentTo);
                        clients.get(i).setLicenseNum(license);
                        clients.get(i).setPhoneNum(phone);
                        
                        tablemodel.getDataVector().removeAllElements();//remove all data listed in jtable
                        refreshData();//delete file & create file again, then display new info to table
                        update = true;
                        break;
                    }
                }
                if(update == true && cars.isEmpty())
                    JOptionPane.showMessageDialog(null,"List is empty!");
                else if(update == false)
                    JOptionPane.showMessageDialog(null,"Update failed! Please check if plate number and ic number inserted is correct.");
            }//end actionPerformed(update)
        });//end actionListener(update)
        
        btn4.addActionListener(new ActionListener()//for delete button
        {
            public void actionPerformed(ActionEvent delete)
            {
                String plate = jtf2.getText();
                String ic = jtf6.getText();
                boolean del = false;
                
                for(int i=0; i<cars.size(); i++)
                {
                    if((plate.equalsIgnoreCase(cars.get(i).getNumPlate())) && (ic.equals(clients.get(i).getIC())))
                    {//if item found, delete item in arraylist, reset table, delete & recreate file with modified data, display in jtable 
                        cars.remove(cars.get(i));
                        clients.remove(clients.get(i));
                        
                        tablemodel.getDataVector().removeAllElements();//remove all rows in jtable
                        refreshData();//save new data to file
                        
                        JOptionPane.showMessageDialog(null,"Item successfully deleted!");
                        del = true;
                    }
                }
                
                if(del == true && cars.isEmpty())
                {//reset the table when file is empty after delete
                    tablemodel.fireTableDataChanged();
                }
                else if(del == false)
                {//if the item that you want to delete is not found
                    JOptionPane.showMessageDialog(null,"Item not found!");
                }
            }//end actionPerformed(delete)
        });//end actionListener(delete)   
    }
}
