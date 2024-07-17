/**
 * Write a description of Debit_Card class.
 * 
 * @author(Rojina Rawal)
 * @Date(21 Jan)
 */

//creating a new class called "Debit_Card" that inherits the "Bank_Card" class.

public class Debit_Card extends Bank_Card{ 
    
    //declaring the four attributes with their specific data-type and are made private for data encapsulation 
        private int PIN_number;
        private int Withdrawal_Amount;
        private String date_Of_Withdrawal;
        private boolean hasWithdrawn;
    
        /*Debit_Card constructor initializes the Debit_Card class object by taking in 6 parameters and
         assigns them to the corresponding fields of the class.*/
         
        public Debit_Card(int BalanceAmount,int card_Id,String bank_account,String issuerbank,String client_name,int PIN_number){
            
            //"super" keyword calls the super class constructor
            super(BalanceAmount,card_Id,bank_account,issuerbank);
            
            //calling setclient_name method to set the client name field of the class with the value passed in client_name parameter
            setclient_name(client_name);
            this.PIN_number=PIN_number;
            this.hasWithdrawn=false;
            //assigning the attribute value false since no withdrawal has been made yet on the card
        }
    
        //accessor/getter method that returns the value of the private class variable "PIN_number".
        public int getPIN_number(){
            return this.PIN_number;
        }
    
        //getter method that returns the value of the private class variable "Withdrawal_Amount".
        public int getWithdrawal_Amount(){
            return this.Withdrawal_Amount;
        }
    
        //accessor method for the private variable "date_Of_Withdrawal" which returns the value of the date_Of_Withdrawal for the current object
        public String getdate_Of_Withdrawal(){
            return this.date_Of_Withdrawal;
        }
    
        //getter method that returns the value of the private class variable "hasWithdrawn".
        public boolean gethasWithdrawn(){
            return this.hasWithdrawn;
        }
    
        //mutator method to set the value of the instance variable 'Withdrawal_Amount' to the parameter passed in the method 'setWithdrawal_Amount'
        public void setWithdrawal_Amount(int Withdrawal_Amount){
            this.Withdrawal_Amount=Withdrawal_Amount;
        } 
    
        //withdraw() method is used to deduct the money directly from the client account and it takes 3 parameters
        public void withdraw(int Withdrawal_Amount,String date_Of_Withdrawal,int PIN_number) {
            
            /*checks if the input PIN number matches the account's PIN number and if the withdrawal amount is less than or equal to current balance.
               If the conditions are met,a message will be displayed*/
               
                if(PIN_number==this.PIN_number && Withdrawal_Amount <= getBalanceAmount()){
               
                    setBalanceAmount(getBalanceAmount()-Withdrawal_Amount);
                    this.hasWithdrawn=true;
                    this.date_Of_Withdrawal=date_Of_Withdrawal;
                    this.Withdrawal_Amount=Withdrawal_Amount;
                    
                }
            
                else if(PIN_number!=this.PIN_number){
             
                //If the PIN number is incorrect, it will print "Invalid PIN Number".
                System.out.println("Invalid PIN Number");
                }
            
                else{ 
                
                //or if the account doesn't have enough balance it will print "Insufficient balance".    
                System.out.println("Insufficient balance");
                }
                
        }
    
         
        //display() method to display the account's information of the "Debit_Card" class by calling the parent class's display method   
        public void display(){
            super.display();
            
                //if the amount is withdrawn,it will display pin number,withdrawal amount and date. 
                if(hasWithdrawn==true){
                    System.out.println("Withdrawn successful");
                    System.out.println("PIN number: "+PIN_number);
                    System.out.println("Withdrawal Amount: "+Withdrawal_Amount);
                    System.out.println("Date of Withdrawal: "+date_Of_Withdrawal);
                }
                 else{
                 
                    //If not,it will display balance amount only.
                    System.out.println("Your transaction hasn't been carried.Your current balance is "+getBalanceAmount());
                }
                
        } 
        
}

