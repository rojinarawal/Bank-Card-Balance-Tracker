/**
 * Write a description of Bank_Card class.
 * 
 * @author(Rojina Rawal)
 * @Date(21st Jan)
 */

//parent class named Bank_Card

public class Bank_Card{
    
     /*Declaring instance variables
        "private" keyword means that these variables can only be accessed within the class or by methods of the class
         The variables are the attribute of the class which hold the data for the objects of the class*/
         
        private int card_Id;
        private String client_name;
        private String issuerbank;
        private String bank_account;
        private int BalanceAmount;
    
        /*Bank_Card constructor is used to create new objects of Bank_Card class and initialize their fields.
           Here,the constructor takes four parameters*/
           
        public Bank_Card (int BalanceAmount, int card_Id, String bank_account, String issuerbank) {
        
            /*Initializing the variables with the values passed into the constructor as arguments when the objects
              are created and assigning the client_name to an empty string*/
                this.client_name="";
                this.card_Id=card_Id;
                this.issuerbank=issuerbank;
                this.bank_account=bank_account;
                this.BalanceAmount=BalanceAmount;
            //this keyword refers to the current object
        }
    
        //getter method for the private variable "card_Id" which returns the value of current object's variable using 'return' keyword
        public int getcard_Id(){    
            return this.card_Id;
        }
        
        /*getter method which returns the value of current object's client_name variable but here as assigned in the constructor,
         the getter will return an empty string.*/
         
        public String getclient_name(){
            return this.client_name;
        }   
    
        //accessor method for the private variable "issuerbank" which returns the value of issuerbank
        public String getissuerbank(){
            return this.issuerbank;
        }
    
        //accessor method for private variable "bank_account" which returns the value of bank_account for the current object
        public String getbank_account(){
            return this.bank_account;
        }
    
        //getter method for the private variable "BalanceAmount" which returns the value of current object's variable using 'return' keyword
        public int getBalanceAmount(){
            return this.BalanceAmount;
        }
        
        /*Setter method called "setclient_name()" assigns the value of the argument "client_name" to the class variable "client_name.
          It permits methods or classes to change the "client name" variable's value from outside the class also it doestn't return any value*/
          
        public void setclient_name (String client_name){
            this.client_name=client_name;
        }
    
        //Setter method that assigns the value of the argument "BalanceAmount" to the class variable "BalanceAmount"
        public void setBalanceAmount (int BalanceAmount){
            this.BalanceAmount=BalanceAmount;
        }
    
        //display() method is used to display the information of the "Bank_Card" class.
        public void display(){
            
                System.out.println("Card Id: "+card_Id);
                System.out.println("Client name: "+client_name);
                System.out.println("Balance Amount: "+BalanceAmount);
                System.out.println("Issuer Bank: "+issuerbank);
                System.out.println("Bank Account: "+bank_account);
            
            /*Using the equals() method,we can check if it is empty or not.
             If it is empty,the given message will be displayed.*/
                if(this.client_name.equals("")){
                    System.out.println("Empty Client Name. ");
                }
        
        }
        
}

