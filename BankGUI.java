/**
 * Write a description of class BankGUI here.
 * BankGUI is the main graphical user interface for a bank management system, we can add, edit, and view your debit and credit card information, 
 * and perform various operations such as withdrawing and depositing money. The interface is designed to be intuitive and user-friendly, making it easy 
 * for anyone to navigate and use.
 * @author (Rojina Rawal)
 * @version (05/01/2023)
 */

//importing necessary packages for creating a graphical user interface (GUI)
import javax.swing.*;// for GUI components like jframe,jlabel,imageicon,etc
import java.awt.*; // for font,color
import java.util.ArrayList;//arraylist for managing lists of objects
import java.awt.event.*; //for event handling including ActionEvent and ActionListener.

public class BankGUI extends JFrame
{
        private ArrayList <Bank_Card> bankCards=new ArrayList<Bank_Card>(); //instance arraylist of Bank_Card class/parent class
        private Bank_Card card; //making the objects also instance
        private Debit_Card newdebitCard;
        private Credit_Card newcreditCard;

        //private instance JFrame components
        private JFrame debitFrame,creditFrame;
        private JLabel dtitle,myLabel,Issuerbank,Balanceamt,chipLabel,ClientName,cardID,Pin,Withdrawdate,bankAcc,Withdrawalamt;
        private ImageIcon logo,worldmap1,i3,smartchip,s2,i4,smartchip1,s4;
        private JPanel dpanel,cpanel;
        private JLabel ctitle,C_Name,C_ID,issuerBank,Expirydate,Balance,CVC,C_Limit,BankAc,Grace,Interest,worldLabel,smartLabel;
        private JTextField tfIssuerbank,tfBalanceamt,tfClientName,tfcardID,tfPin,tfbankAcc,tfWithdrawalamt,tfC_Name,tfC_ID,tfissuerBank,tfBalance,tfCVC,tfC_Limit,tfBankAc,tfGrace,tfInterest;
        private Color grey,yellow,orange,tealblue,blue,darkgrey;
        private JComboBox <String> cbWithdrawal_day,cbWithdrawal_mon,cbWithdrawal_year,cbexpiryday,cbexpirymon,cbexpiryyear;//generic
        private JButton addD_card,Withdraw_Debit,Display,Clear;
        private JButton setCredit,CancelCredit,AddCredit,Display1,Clear1;
        
    public BankGUI(){ //working on constructor 
        
        //creating custom color 
        grey=new Color(68,68,68); 
        yellow=new Color(254, 198,  61);
        orange=new Color(255, 102, 36);
        tealblue=new Color(0, 78, 99);
        blue=new Color(0, 164, 211);
        darkgrey=new Color(35, 35, 35);
        
        //array to store day, month and year
        String Day []={"00","01", "02", "03", "04", "05", "06", "07", "08", "09", "10","11", "12", "13", "14", "15", "16", "17", "18", "19", "20","21", "22", "23", "24", "25", "26", "27", "28", "29", "30"};
        
        String Month []={"00","01", "02", "03", "04", "05", "06", "07", "08", "09", "10","11", "12"};
        
        String Year []={"0000","2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030"};
        
        // Create the debit card frame
        debitFrame = new JFrame("Debit Card");
        logo=new ImageIcon("logo.png");//creating new ImageIcon obj called logo and setting the image
        Image i2=logo.getImage().getScaledInstance(187,187,Image.SCALE_DEFAULT); //logo is resized to 187x187 pixels using the SCALE_DEFAULT
        i3 = new ImageIcon(i2);
        myLabel=new JLabel(i3);//setting the image inside myLabel by passing the obj containing img i.e i3 in parameters
        myLabel.setBounds(797,65,187,187);
        debitFrame.add(myLabel);

          
        dtitle=new JLabel("Debit Card");
        dtitle.setFont(new Font("Ariel",Font.BOLD,16)); //setting the new older font for title
        dtitle.setBounds(52,158,132,30);
        dtitle.setForeground(Color.WHITE);
        myLabel.add(dtitle);
        
        smartchip=new ImageIcon("smartchip.png");//setting the background image inside label
        Image s1=smartchip.getImage().getScaledInstance(272,153,Image.SCALE_DEFAULT);
        s2 = new ImageIcon(s1);
        chipLabel=new JLabel(s2);
        chipLabel.setBounds(0,90,272,153);
        debitFrame.add(chipLabel);
        
        
        dpanel=new JPanel();
        dpanel.setBounds(272,85,485,206);
        dpanel.setBackground(tealblue); //Sets the background color of the JPanel to tealblue which is instance customcolor .
        dpanel.setBorder(BorderFactory.createLineBorder(Color.BLACK,1)); //Adding a border around the JPanel with a black line of width 1 pixel.
        debitFrame.add(dpanel);
        dpanel.setLayout(null); //setting layout to nulll to position it manually
        
        Issuerbank=new JLabel("Issuer Bank");
        Issuerbank.setBounds(28,29,98,27);
        Issuerbank.setForeground(Color.WHITE);
        Issuerbank.setFont(new Font("Helvetica",Font.PLAIN,16));
        dpanel.add(Issuerbank);
        
        tfIssuerbank=new JTextField();
        tfIssuerbank.setBounds(181,21,193,32);
        dpanel.add(tfIssuerbank);
        
        Balanceamt=new JLabel("Balance Amount");
        Balanceamt.setBounds(28,90,124,27);
        Balanceamt.setForeground(Color.WHITE);
        Balanceamt.setFont(new Font("Helvetica",Font.PLAIN,16));
        dpanel.add(Balanceamt);
        
        tfBalanceamt=new JTextField();
        tfBalanceamt.setBounds(181,84,193,32);
        dpanel.add(tfBalanceamt);
        
        ClientName=new JLabel("Client Name");
        ClientName.setBounds(28,150,124,27);
        ClientName.setForeground(Color.WHITE);
        ClientName.setFont(new Font("Helvetica",Font.PLAIN,16));
        dpanel.add(ClientName);
        
        tfClientName=new JTextField();
        tfClientName.setBounds(181,150,286,32);
        dpanel.add(tfClientName);
 
        cardID=new JLabel("CARD ID");
        cardID.setBounds(52,329,81,39);
        cardID.setForeground(yellow);
        cardID.setFont(new Font("Helvetica",Font.BOLD,16));
        debitFrame.add(cardID);
        
        tfcardID=new JTextField();
        tfcardID.setBounds(142,329,687,32);
        tfcardID.setForeground(Color.RED);
        tfcardID.setFont(new Font("Helvetica",Font.PLAIN,16));
        debitFrame.add(tfcardID);
        
        Pin=new JLabel("PIN Number");
        Pin.setBounds(52,413,100,20);
        Pin.setForeground(Color.WHITE);
        Pin.setFont(new Font("Helvetica",Font.PLAIN,16));
        debitFrame.add(Pin);
        
        tfPin=new JTextField();
        tfPin.setBounds(52,443,210,32);
        tfPin.setFont(new Font("Helvetica",Font.PLAIN,16));
        debitFrame.add(tfPin);
        
        Withdrawdate=new JLabel("Withdrawal Date");
        Withdrawdate.setBounds(55,495,140,16);
        Withdrawdate.setForeground(Color.WHITE);
        Withdrawdate.setFont(new Font("Helvetica",Font.PLAIN,16));
        debitFrame.add(Withdrawdate);
        
        
        // create the JComboBoxes with the arrays of options
        cbWithdrawal_day=new JComboBox<String>(Day); //creates a new JComboBox object called cbWithdrawal_day with elements from the Day string array.
        cbWithdrawal_mon=new JComboBox<String>(Month);
        cbWithdrawal_year=new JComboBox<String>(Year);
        cbWithdrawal_day.setBounds(53,532,65,32);
        cbWithdrawal_mon.setBounds(128,532,65,32);
        cbWithdrawal_year.setBounds(203,532,89,32);
        debitFrame.add(cbWithdrawal_day);
        debitFrame.add(cbWithdrawal_mon);
        debitFrame.add(cbWithdrawal_year);
        
        bankAcc=new JLabel("Bank Account");
        bankAcc.setBounds(433,415,100,20);
        bankAcc.setForeground(Color.WHITE);
        bankAcc.setFont(new Font("Helvetica",Font.PLAIN,16));
        debitFrame.add(bankAcc);
        
        tfbankAcc=new JTextField();
        tfbankAcc.setBounds(407,438,223,32);
        debitFrame.add(tfbankAcc);
        
        Withdrawalamt=new JLabel("Withdrawal Amount");
        Withdrawalamt.setBounds(419,491,140,41);
        Withdrawalamt.setForeground(Color.WHITE);
        Withdrawalamt.setFont(new Font("Helvetica",Font.PLAIN,16));
        debitFrame.add(Withdrawalamt);
        
        tfWithdrawalamt=new JTextField();
        tfWithdrawalamt.setBounds(407,532,223,32);
        debitFrame.add(tfWithdrawalamt);
        
        addD_card=new JButton("Add a Debit Card");
        addD_card.setBounds(729,438,235,32);
        addD_card.setBackground(Color.BLACK);
        addD_card.setFont(new Font("Helvetica",Font.PLAIN,16));
        addD_card.setForeground(Color.WHITE);
        addD_card.setBorder(BorderFactory.createLineBorder(yellow,1));
        debitFrame.add(addD_card);
        
            //creating anonymous local/inner class to implement the "AcitonListener' interface 
            addD_card.addActionListener(new ActionListener(){ 
                @Override
                public void actionPerformed(ActionEvent a){
                    if(tfBalanceamt.getText().isEmpty() || tfcardID.getText().isEmpty() || tfbankAcc.getText().isEmpty() || tfIssuerbank.getText().isEmpty() || tfClientName.getText().isEmpty() || tfPin.getText().isEmpty()){
                        JOptionPane.showMessageDialog(debitFrame, "Error: Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }else{
                        try{
                            int Balanceamt=Integer.parseInt(tfBalanceamt.getText());
                            int cardID= Integer.parseInt(tfcardID.getText());
                            String bankAcc=tfbankAcc.getText();
                            String Issuerbank=tfIssuerbank.getText();
                            String ClientName=tfClientName.getText();
                            int Pin=Integer.parseInt(tfPin.getText());
                            
                            // create new DebitCard object
                            newdebitCard=new Debit_Card( Balanceamt,cardID,bankAcc,Issuerbank,ClientName,Pin); //parameters inside constructor should be same as the Debit_Card class
                            
                            //check if Arraylist is empty before adding new debit card
                            if(bankCards.isEmpty()){
                                // add DebitCard object to ArrayList
                                bankCards.add(newdebitCard);
                                    
                                // display message to user
                                JOptionPane.showMessageDialog(debitFrame, "Debit card added successfully!");
                            }else{
                                //loop through ArrayList to check if cardID already exists
                                boolean Card_exists=false;
                                
                                //using for each loop to check duplicate cardID
                                for(Bank_Card card: bankCards){
                                    if(card instanceof Debit_Card && card.getcard_Id() == cardID) {
                                        Card_exists=true;
                                        JOptionPane.showMessageDialog(debitFrame, "This card ID already exists.\n Please enter a valid Card ID.", "Validation Error", JOptionPane.WARNING_MESSAGE);
                                        break;
                                    }
                                }
                                
                                if(Card_exists==false){ 
                                    bankCards.add(newdebitCard);//adding new debitcard if similar cardId doesn't exists
                                   JOptionPane.showMessageDialog(debitFrame, "Debit card added successfully!");
                                }
                                }
                                 
                        }catch (NumberFormatException ex) {
                            // Display an error message if the user input is invalid
                            JOptionPane.showMessageDialog(debitFrame, "Enter valid card ID,balance amount and PIN Number", "Invalid Input", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                }
            });
        
        Withdraw_Debit=new JButton(" Withdraw from a Debit Card");
        Withdraw_Debit.setBounds(729,532,235,32);
        Withdraw_Debit.setBackground(Color.BLACK);
        Withdraw_Debit.setFont(new Font("Helvetica",Font.PLAIN,16));
        Withdraw_Debit.setForeground(Color.WHITE);
        Withdraw_Debit.setBorder(BorderFactory.createLineBorder(yellow,1));
        debitFrame.add(Withdraw_Debit);
        
        
            Withdraw_Debit.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent a){
                  if(tfcardID.getText().isEmpty() || tfWithdrawalamt.getText().isEmpty() || tfPin.getText().isEmpty()){
                        JOptionPane.showMessageDialog(debitFrame, "Error: Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                  }else{
                       try{
                             
                            // Getting input values and Parsing cardID,withdrawal amount and PIN number to integers
                            int cardID= Integer.parseInt(tfcardID.getText());
                            int Withdrawalamt= Integer.parseInt(tfWithdrawalamt.getText());
                            int Pin= Integer.parseInt(tfPin.getText());
                            
                            String selectedWithdrawalDay = (String)cbWithdrawal_day.getSelectedItem();
                            String selectedWithdrawalMonth = (String)cbWithdrawal_mon.getSelectedItem();
                            String selectedWithdrawalYear = (String) cbWithdrawal_year.getSelectedItem();
                            String Withdrawdate = selectedWithdrawalDay + "/" + selectedWithdrawalMonth + "/" + selectedWithdrawalYear;
                            boolean foundCard=false;
                            card=newdebitCard;//upcast
                            for(Bank_Card card:bankCards){   
                                if(card instanceof Debit_Card){ //instanceof checks if it belongs or not 
                                    Debit_Card newdebitCard= (Debit_Card) card; //downcast 
                                    if(card.getcard_Id()== cardID && newdebitCard.getPIN_number() == Pin){
                                        foundCard=true;
                                        if(Withdrawalamt > card.getBalanceAmount()){
                                            JOptionPane.showMessageDialog(debitFrame, "Error: Insufficient balance.", "Error", JOptionPane.ERROR_MESSAGE);
                                        }else{
                                            newdebitCard.withdraw(Withdrawalamt,Withdrawdate,Pin); //calling the withdraw method from Debit_Card class using debitcard obj
                                            //Displaying the information dialogue with all entered data
                                             String message = "Card ID: " + cardID + "\n" 
                                                             + "Withdrawal Amount: " +Withdrawalamt  + "\n" 
                                                             + "Current Balance: "+newdebitCard.getBalanceAmount() +"\n"
                                                             + "Withdrawal Date: " +Withdrawdate  + "\n" 
                                                             + "PIN Number: " + Pin; 
                                             JOptionPane.showMessageDialog(debitFrame,message,"Withdrawn successful", JOptionPane.INFORMATION_MESSAGE);
                                        }
                                    }
                                }
                            }
                            
                            if(foundCard==false){
                                    JOptionPane.showMessageDialog(debitFrame, "Error: Please enter valid Card ID and PIN Number.", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                      }catch(NumberFormatException e) {
                            JOptionPane.showMessageDialog(debitFrame, "Error: Invalid input.You may have written text value instead of integer value.", "Error", JOptionPane.ERROR_MESSAGE);
                      }
                   }
                }
            });
                        
        
        Display=new JButton(" Display");
        Display.setBounds(753,637,93,25);
        Display.setBackground(Color.BLACK);
        Display.setForeground(Color.WHITE);
        Display.setFont(new Font("Helvetica",Font.BOLD,16));
        Display.setBorder(BorderFactory.createLineBorder(blue,1));
        debitFrame.add(Display);
        
            Display.addActionListener(new ActionListener (){
                @Override
                    public void actionPerformed(ActionEvent a) {
                    // Check if a debit card has been added
                    card=newdebitCard;//upcast
                    if (newdebitCard == null) {
                        // Display error message if no debit card has been added
                        JOptionPane.showMessageDialog(debitFrame, "Error: No debit card added.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }else{
                        // Create a message string containing debit card information.
                        String message = "Card ID: " + card.getcard_Id() + "\n"
                        + "Card Holder Name: "+ card.getclient_name() + "\n"
                        + "Bank Account Number: " + card.getbank_account() + "\n"
                        + "Issuer Bank: " +card.getissuerbank() + "\n"
                        + "Balance Amount: "+card.getBalanceAmount()+ "\n\n";
                        
                        // Downcast to Debit_Card and check if any withdrawals have been made
                        Debit_Card newdebitCard= (Debit_Card) card; 
            
                        if (newdebitCard.getWithdrawal_Amount()==0) {
                            message += "No withdrawals made yet.";
                        } else {
                            //if withdrawal is made,following details are added
                            message += "Withdrawal Details:\n"
                                    + "Withdrawal Amount: " + newdebitCard.getWithdrawal_Amount() + "\n"
                                    + "PIN Number: "+newdebitCard.getPIN_number() +"\n"
                                    + "Withdrawal Date: " + newdebitCard.getdate_Of_Withdrawal() + "\n";
                        }
                        JOptionPane.showMessageDialog(debitFrame, message, "-----------Debit Card Information-------", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            });

        
        Clear=new JButton("Clear");
        Clear.setBounds(858,637,92,25);
        Clear.setBackground(Color.BLACK);
        Clear.setForeground(Color.WHITE);
        Clear.setFont(new Font("Helvetica",Font.BOLD,16));
        Clear.setBorder(BorderFactory.createLineBorder(blue,1));
        debitFrame.add(Clear);
        
            Clear.addActionListener(new ActionListener() {
                   @Override
                   public void actionPerformed(ActionEvent a) {
                      // displays a confirmation dialog to make sure the user really wants to clear the fields. 
                 int confirmed = JOptionPane.showConfirmDialog(debitFrame, "Are you sure you want to clear everything?", "Confirm ", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                    if (confirmed == JOptionPane.YES_OPTION) {     
                       //clear text fields
                     tfBalanceamt.setText("");
                     tfcardID.setText("");
                     tfbankAcc.setText("");
                     tfIssuerbank.setText("");
                     tfClientName.setText("");
                     tfPin.setText("");
                     tfWithdrawalamt.setText("");
                }else{
                    JOptionPane.showMessageDialog(debitFrame,"Cancelled");
                }
              }
            });
        
        debitFrame.setLayout(null);
        debitFrame.getContentPane().setBackground(darkgrey);
        debitFrame.setSize(1030,753); 
        debitFrame.setLocationRelativeTo(null);
        debitFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               
        
        
        
        
        // Create the credit card frame
        creditFrame = new JFrame("Credit Card");
        
        ctitle=new JLabel("Credit Card");
        ctitle.setBounds(62,10,180,36);
        ctitle.setForeground(yellow);
        ctitle.setFont(new Font("Helvetica",Font.PLAIN,26));
        creditFrame.add(ctitle);
        
        cpanel=new JPanel();
        cpanel.setBounds(0,72,777,129);
        cpanel.setBackground(Color.BLACK);
        creditFrame.add(cpanel);
        cpanel.setLayout(null);
        
        smartchip1=new ImageIcon("smartchip.png");//setting the background image inside label
        Image s=smartchip1.getImage().getScaledInstance(194,109,Image.SCALE_DEFAULT);
        s4= new ImageIcon(s);
        smartLabel=new JLabel(s4);
        smartLabel.setBounds(11,13,194,109);
        cpanel.add(smartLabel);
        
        C_Name=new JLabel("Client Name");
        C_Name.setFont(new Font("Helvetica",Font.PLAIN,16));
        C_Name.setForeground(Color.WHITE);
        C_Name.setBounds(203,32,114,24);
        cpanel.add(C_Name);
        
        tfC_Name=new JTextField();
        tfC_Name.setBounds(198,61,245,32);
        cpanel.add(tfC_Name);
        
        C_ID=new JLabel("CARD ID");
        C_ID.setFont(new Font("Helvetica",Font.BOLD,16));
        C_ID.setForeground(orange);
        C_ID.setBounds(69,252,83,39);
        creditFrame.add(C_ID);
        
        tfC_ID=new JTextField();
        tfC_ID.setBounds(69,299,321,32);
        tfC_ID.setForeground(Color.RED);
        tfC_ID.setFont(new Font("Helvetica",Font.PLAIN,16));
        tfC_ID.setToolTipText("Card ID is required.");
        creditFrame.add(tfC_ID);
        
        issuerBank=new JLabel(" Issuer Bank");
        issuerBank.setFont(new Font("Helvetica",Font.PLAIN,16));
        issuerBank.setForeground(Color.WHITE);
        issuerBank.setBounds(69,358,96,23);
        creditFrame.add(issuerBank);
        
        tfissuerBank=new JTextField();
        tfissuerBank.setBounds(69,399,314,32);
        creditFrame.add(tfissuerBank);
        
        Expirydate=new JLabel(" Expiration Date");
        Expirydate.setFont(new Font("Helvetica",Font.PLAIN,16));
        Expirydate.setForeground(Color.WHITE);
        Expirydate.setBounds(69,468,125,19);
        creditFrame.add(Expirydate);
        
        cbexpiryday=new JComboBox<String>(Day);
        cbexpirymon=new JComboBox<String>(Month);
        cbexpiryyear=new JComboBox<String>(Year);
        cbexpiryday.setBounds(69,495,68,32);
        cbexpirymon.setBounds(137,495,66,32);
        cbexpiryyear.setBounds(203,495,81,32);
        creditFrame.add(cbexpiryday);
        creditFrame.add(cbexpirymon);
        creditFrame.add(cbexpiryyear);
        
        Balance=new JLabel("Balance Amount");
        Balance.setFont(new Font("Helvetica",Font.PLAIN,16));
        Balance.setForeground(Color.WHITE);
        Balance.setBounds(69,556,125,17);
        creditFrame.add(Balance);
        
        tfBalance=new JTextField();
        tfBalance.setBounds(69,584,180,30);
        creditFrame.add(tfBalance);
        
        CVC=new JLabel("CVC Number");
        CVC.setFont(new Font("Helvetica",Font.PLAIN,16));
        CVC.setForeground(Color.WHITE);
        CVC.setBounds(317,468,116,31);
        creditFrame.add(CVC);
        
        tfCVC=new JTextField();
        tfCVC.setBounds(308,495,125,32);
        creditFrame.add(tfCVC);
        
        C_Limit=new JLabel("Credit Limit");
        C_Limit.setFont(new Font("Helvetica",Font.PLAIN,16));
        C_Limit.setForeground(Color.WHITE);
        C_Limit.setBounds(318,556,105,31);
        creditFrame.add(C_Limit);
        
        tfC_Limit=new JTextField();
        tfC_Limit.setBounds(308,587,125,30);
        tfC_Limit.setFont(new Font("Helvetica",Font.PLAIN,16));
        creditFrame.add(tfC_Limit);
        
        BankAc=new JLabel("Bank account");
        BankAc.setFont(new Font("Helvetica",Font.PLAIN,16));
        BankAc.setForeground(Color.WHITE);
        BankAc.setBounds(495,358,142,27);
        creditFrame.add(BankAc);
        
        tfBankAc=new JTextField();
        tfBankAc.setBounds(436,399,227,32);
        creditFrame.add(tfBankAc);
        
        Grace=new JLabel("Grace Period");
        Grace.setFont(new Font("Helvetica",Font.PLAIN,16));
        Grace.setForeground(Color.WHITE);
        Grace.setBounds(495,468,122,31);
        creditFrame.add(Grace);
        
        tfGrace=new JTextField();
        tfGrace.setBounds(483,495,142,32);
        tfGrace.setFont(new Font("Helvetica",Font.PLAIN,16));
        creditFrame.add(tfGrace);
        
        Interest=new JLabel("Interest Rate");
        Interest.setFont(new Font("Helvetica",Font.PLAIN,16));
        Interest.setForeground(Color.WHITE);
        Interest.setBounds(495,556,122,25);
        creditFrame.add(Interest);
        
        tfInterest=new JTextField();
        tfInterest.setBounds(483,584,142,30);
        creditFrame.add(tfInterest);
        
        worldmap1=new ImageIcon("worldmap.jpg");
        Image i=worldmap1.getImage().getScaledInstance(252,142,Image.SCALE_DEFAULT);
        i4 = new ImageIcon(i);
        worldLabel=new JLabel(i4);
        worldLabel.setBounds(777,65,252,142);
        worldLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        creditFrame.add(worldLabel);
        
        AddCredit=new JButton("Add a Credit Card");
        AddCredit.setBounds(784,308,222,35);
        AddCredit.setBackground(Color.BLACK);
        AddCredit.setFont(new Font("Helvetica",Font.PLAIN,16));
        AddCredit.setBorder(BorderFactory.createLineBorder(yellow,1));
        AddCredit.setForeground(Color.WHITE);
        creditFrame.add(AddCredit);
        
            AddCredit.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent a){
                    //checking empty fields first
                    if(tfBalance.getText().isEmpty() || tfC_ID.getText().isEmpty() ||  tfBankAc.getText().isEmpty() || tfissuerBank.getText().isEmpty() || tfC_Name.getText().isEmpty() ||  tfCVC.getText().isEmpty() || tfInterest.getText().isEmpty()){
                        JOptionPane.showMessageDialog(creditFrame, "Error: Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }else{
                        try{
                            int Balance=Integer.parseInt(tfBalance.getText());
                            int C_ID=Integer.parseInt(tfC_ID.getText());
                            String BankAc=tfBankAc.getText();
                            String issuerBank=tfissuerBank.getText();
                            String C_Name= tfC_Name.getText();
                            int CVC=Integer.parseInt(tfCVC.getText());
                            double Interest=Double.parseDouble(tfInterest.getText());
                            String selectedDay = (String)cbexpiryday.getSelectedItem();
                            String selectedMonth =(String)cbexpirymon.getSelectedItem();
                            String selectedYear = (String)cbexpiryyear.getSelectedItem();
                            
                            // we have the selected day, month, and year values as string so concatenating them to form the date strings to be displayed on the labels
                            String Expirydate = selectedDay + "/" + selectedMonth + "/" + selectedYear;
    
                            
                            // create new CreditCard object
                            newcreditCard=new Credit_Card(Balance,C_ID,BankAc,issuerBank,C_Name,CVC,Interest,Expirydate);
                            
                            //check if Arraylist is empty before adding new credit card
                            if(bankCards.isEmpty()){
                                // add CreditCard object to ArrayList
                                bankCards.add(newcreditCard);
                                    
                                // display message to user
                                JOptionPane.showMessageDialog(creditFrame, "Credit card added successfully!");
                            }else{
                                //initializing it to false 
                                boolean Cardexists=false;
                                
                                   //using for each loop to check duplicate card id
                                    for(Bank_Card card: bankCards){
                                        if(card instanceof Credit_Card && card.getcard_Id() == C_ID) {
                                            Cardexists=true; //initializing it to true if a card Id already exists
                                            JOptionPane.showMessageDialog(creditFrame,"Card ID already exists.","Duplicate CardID", JOptionPane.WARNING_MESSAGE);
                                            break;
                                        }
                                    }
                                        
                                    if(Cardexists==false){
                                        bankCards.add(newcreditCard);
                                        JOptionPane.showMessageDialog(creditFrame, "Credit card added successfully!");
                                    }
                               }
                                 
                        }catch (NumberFormatException ex) {
                            // Display an error message if the user input is invalid
                            JOptionPane.showMessageDialog(creditFrame, "Invalid input.You may have written an integer value as a string value.","Validation Error", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                    
                }
            });
        
        setCredit=new JButton("Set the Credit Limit");
        setCredit.setBounds(784,364,222,35);
        setCredit.setBackground(Color.BLACK);
        setCredit.setFont(new Font("Helvetica",Font.PLAIN,16));
        setCredit.setForeground(Color.WHITE);
        setCredit.setBorder(BorderFactory.createLineBorder(yellow,1));
        creditFrame.add(setCredit);
        
            setCredit.addActionListener(new ActionListener(){
              @Override
                public void actionPerformed(ActionEvent a){
                   if(tfC_ID.getText().isEmpty() || tfGrace.getText().isEmpty() || tfC_Limit.getText().isEmpty()){
                        JOptionPane.showMessageDialog(debitFrame, "Error: Please fill in all fields:Card ID,Grace Period and Credit Limit ", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                   }else{
                        try{
                             
                            // Getting input values and Parsing cardID,withdrawal amount and PIN number to integers
                            int C_ID = Integer.parseInt(tfC_ID.getText());
                            int Grace= Integer.parseInt(tfGrace.getText());
                            double C_Limit= Double.parseDouble(tfC_Limit.getText());
                        
                            boolean validcard=false;
                            card=newcreditCard;//upcast
                            for(Bank_Card card:bankCards){   
                                if(card instanceof Credit_Card){
                                    Credit_Card newcreditCard= (Credit_Card) card; //downcast 
                                    if(card.getcard_Id()== C_ID ){
                                       validcard=true;
                                       if(C_Limit<=2.5*newcreditCard.getBalanceAmount()){
                                             newcreditCard.grantCredit(C_Limit,Grace);
                                          //Displaying the information dialogue with all entered data
                                            String message = "Credit Limit: " +C_Limit + "\n" 
                                                             + "Grace Period: " + Grace + "\n";
                                            JOptionPane.showMessageDialog(creditFrame,message,"Credit Granted", JOptionPane.INFORMATION_MESSAGE);
                                           
                                       }else{
                                          JOptionPane.showMessageDialog(creditFrame,"Your Credit can not be issued due to insufficient balance amount."+"\n","Error", JOptionPane.ERROR_MESSAGE);
                                       }
                                           
                                    }
                                }
                            }
                            
                            if(validcard==false){
                                    JOptionPane.showMessageDialog(creditFrame, "Error: Please enter valid Card ID and Credit Limit .", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                            
                       }catch(NumberFormatException e) {
                            JOptionPane.showMessageDialog(creditFrame, "Error: Invalid input.You may have written text value instead of integer value.", "Error", JOptionPane.ERROR_MESSAGE);
                       }
                    }
                }
            });
        
        
        
        
        CancelCredit=new JButton("Cancel Credit Card");
        CancelCredit.setBounds(784,420,222,35);
        CancelCredit.setBackground(Color.BLACK);
        CancelCredit.setFont(new Font("Helvetica",Font.PLAIN,16));
        CancelCredit.setForeground(Color.WHITE);
        CancelCredit.setBorder(BorderFactory.createLineBorder(yellow,1));
        creditFrame.add(CancelCredit);
        
           CancelCredit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                try {
                    int C_ID = Integer.parseInt(tfC_ID.getText());
                    if (tfC_ID.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(creditFrame, "Please enter a card ID.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                    }
                    boolean cardfound = false;
                    card=newcreditCard; //upcast
                    for (Bank_Card card : bankCards) {
                        if (card instanceof Credit_Card && card.getcard_Id() == C_ID) { 
                            cardfound = true;
                            Credit_Card newcreditCard = (Credit_Card) card;
                            newcreditCard.cancelCreditCard(); //calling the cancelcreditcard method from Credit_Card class using credit card obj
                            tfCVC.setText("");
                            tfC_Limit.setText("");
                            tfGrace.setText("");
                            JOptionPane.showMessageDialog(creditFrame, "Credit card with ID " + C_ID + " has been canceled.", "Credit Card Cancelled.", JOptionPane.INFORMATION_MESSAGE);
                            break;
                        }
                    }
        
                    if (!cardfound) {
                        JOptionPane.showMessageDialog(creditFrame, "Credit card with ID " + C_ID + " not found.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(creditFrame, "Please enter a valid card ID.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
          });
            
        
        Display1=new JButton(" Display");
        Display1.setBounds(784,587,103,30);
        Display1.setBackground(Color.BLACK);
        Display1.setForeground(Color.WHITE);
        Display1.setFont(new Font("Helvetica",Font.PLAIN,16));
        Display1.setBorder(BorderFactory.createLineBorder(orange,1));
        creditFrame.add(Display1);
        
            Display1.addActionListener(new ActionListener (){
                @Override
                    public void actionPerformed(ActionEvent a) {
                    // Check if a credit card has been added
                    card=newcreditCard;//upcast
                    if (newcreditCard == null) {
                        JOptionPane.showMessageDialog(creditFrame, "Error: No credit card added.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }else{
                        
                        String message = "Card ID: " + card.getcard_Id() + "\n"    
                        + "Card Holder Name: "+ card.getclient_name()+ "\n"                        
                        + "Bank Account Number: " + card.getbank_account()+ "\n"
                        + "Issuer Bank: " +card.getissuerbank() + "\n"
                        + "Balance Amount: "+card.getBalanceAmount()+ "\n"
                        + "Expirydate: "+ newcreditCard.getExpiration_Date()+"\n" 
                        + "CVC Number: "+newcreditCard.getCVC_number()+"\n\n";
                        Credit_Card newcreditCard=(Credit_Card) card; //downcast
                        
                        if (newcreditCard.getCredit_Limit()==0.0) {  // check if credit limit is set or not
                            message += "Credit card not issued yet.";
                        } else{
                            //if it is set then the following details will be added
                            message += "---Credit Granted Details---:\n"
                                    + "Credit Limit: " +newcreditCard.getCredit_Limit() + "\n" 
                                    + "Grace Period: " + newcreditCard.getGrace_Period() + "\n\n";
                        }
                        JOptionPane.showMessageDialog(creditFrame, message,  "-----------Credit Card Information----------", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            });
        
        Clear1=new JButton(" Clear");
        Clear1.setBounds(895,587,111,30);
        Clear1.setBackground(Color.BLACK);
        Clear1.setForeground(Color.WHITE);
        Clear1.setFont(new Font("Helvetica",Font.PLAIN,16));
        Clear1.setBorder(BorderFactory.createLineBorder(orange,1));
        creditFrame.add(Clear1);
        
           Clear1.addActionListener(new ActionListener() {
             @Override
               public void actionPerformed(ActionEvent a) {
                int confirmed = JOptionPane.showConfirmDialog(creditFrame, "Are you sure you want to clear everything?", "Confirm ", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                    if (confirmed == JOptionPane.YES_OPTION) { 
                        //clear text fields by setting the text of textfield  to empty string
                           tfBalance.setText("");
                           tfC_ID.setText("");
                           tfBankAc.setText("");
                           tfissuerBank.setText("");
                           tfC_Name.setText("");
                           tfCVC.setText("");
                           tfInterest.setText("");
                           tfGrace.setText("");
                           tfC_Limit.setText("");
                    }else{
                        JOptionPane.showMessageDialog(creditFrame,"Cancelled.");
                    }
                 }
           });
        
        creditFrame.setLayout(null);
        creditFrame.getContentPane().setBackground(grey); //sets the background color of the content pane of the credit frame to "grey"
        creditFrame.setSize(1045,735);
        creditFrame.setLocationRelativeTo(null);//to make gui appear on center of the screen
        creditFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //dialog box to choose between debit and credit card
        String[] options = {"Debit Card", "Credit Card"}; //array to store options
        int choice = JOptionPane.showOptionDialog(null,"Please choose your card type", "Bank Card System",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]); //passing null cause it is not displayed in any specific frame
                    //6th parameter options: card options and 7th parameter:option[0] default option to be selected
                    
            // Displaying the appropriate details based on the user's choice 
            if (choice == JOptionPane.YES_OPTION) { // Debit card
                debitFrame.setVisible(true);
            } else if(choice == JOptionPane.NO_OPTION) { 
                creditFrame.setVisible(true); //creditcard
            }else {
                JOptionPane.showMessageDialog(null, "No card selected.", "Closed", JOptionPane.ERROR_MESSAGE);
                //display a error message and exit the program
            }
    
    }
    
    public static void main(String[]args){  //main method of the program
        // Create an instance of the BankGUI class which displays the GUI of Bank
        new BankGUI();
        
    }
}