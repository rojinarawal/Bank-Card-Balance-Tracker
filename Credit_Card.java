
/**
 * Write a description of Credit_Card class.
 * 
 * @author(Rojina Rawal)
 * @Date(22 Jan)
 */

//creating a subclass called "Credit_Card" that inherits the "Bank_Card" class.

public class Credit_Card extends Bank_Card{
    
    //declaring the six attributes of "Credit_Card" class with their specific data-type and are made private for data encapsulation
    
        private int CVC_number;
        private double Credit_Limit;
        private double Interest_Rate;
        private String Expiration_Date;
        private int Grace_Period;
        private boolean isGranted;
    
        /*Credit_Card constructor initializes the Credit_Card class object by taking in 8 parameters and
         assigns them to the corresponding fields of the class*/
         
        public Credit_Card(int BalanceAmount,int card_Id,String bank_account,String issuerbank,String client_name,int CVC_number,
        double Interest_Rate,String Expiration_Date)
        {
            //"super" keyword calls the constructor from parent class
            super(BalanceAmount,card_Id,bank_account,issuerbank);
             
            //calling the super class setter method
            setclient_name(client_name);
            
            //assigning the remaining parameters to corresponding fields using "this" keyword 
            this.CVC_number=CVC_number;
            this.Interest_Rate=Interest_Rate;
            this.Expiration_Date=Expiration_Date;
            
            //setting the "isGranted" field to false.
            this.isGranted=false;
        }
    
        /*Getter methods are being used to return the value of the corresponding object's private field.The methods are
        "getCVC_number", "getCredit_Limit", "getInterest_Rate", "getExpiration_Date", "getGrace_Period", and "getisGranted" respectively.*/
        
        public int getCVC_number(){
            return this.CVC_number;
        }
    
        public double getCredit_Limit(){
            return this.Credit_Limit;
        }
    
        public double getInterest_Rate(){
            return this.Interest_Rate;
        }
    
        public String getExpiration_Date(){
            return this.Expiration_Date;
        }
        
        public int getGrace_Period(){
            return this.Grace_Period;
        }
    
        public boolean getisGranted(){
            return this.isGranted;
        }
        
        //setter method to set the credit limit as each client can have different credit limits 
        public void setCredit_Limit(double Credit_Limit) {
        this.Credit_Limit = Credit_Limit;
        }
        
        //grantCredit method grants credit to a user by checking if the credit limit is less than or equal to 2.5 times the user's current balance amount. 
       
        public void grantCredit(double Credit_Limit,int Grace_Period){
            
            // If the credit limit is sufficient,the credit is granted and the user's credit limit and grace period are set.
            if(Credit_Limit<=2.5*getBalanceAmount()){
                this.isGranted=true;
                this.Credit_Limit= Credit_Limit;
                this.Grace_Period=Grace_Period;
                //System.out.print("Credit Granted");
            }
            else{
                //this.isGranted=false;
                //If the credit limit is not sufficient the given message will be displayed.
                System.out.println("Your credit can not be granted due to insufficient balance amount. ");
            }
        }
        
        //method to cancel the credit card
        public void cancelCreditCard(){
            
            //credit card is cancelled by setting the CVC number, credit limit, grace period to 0.
            this.CVC_number=0;
            this.Credit_Limit=0;
            this.Grace_Period=0;
            
            //attribute isGranted is then set to false.
            this.isGranted=false;
        }
    
        //display() method displays the account's information of the "Credit_Card" class by calling the parent class's display method
        
        public void display(){
            super.display();
            
                //the method shows details such as the CVC number, interest rate, and expiration date.
                System.out.println("CVC number: "+CVC_number);
                System.out.println("Interest Rate: "+Interest_Rate);
                System.out.println("Expiration Date: "+Expiration_Date);
            
                if(isGranted==true){
                    
                //If the credit isgranted is true,the credit limit and grace period are displayed.
                    System.out.println("Credit Limit: "+Credit_Limit);
                    System.out.println("Grace Period: "+Grace_Period);
                
                }else{
                
                    //If it is false then a message will be printed that the credit is not granted.
                    System.out.println("Your credit is not granted. ");
                }
                
        }
        
}
