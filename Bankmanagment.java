import java.io.*;
import java.util.*;
class create{
    private int NewAccountid;
    private String NewAccountHolder;
    private double balance;
    private int Age;
    private int pin;

    public void setnewid(int NewAccountid){
        this.NewAccountid = NewAccountid;
    }
    public int getnewid(){
        return NewAccountid;
    }
    public void setnewname(String NewAccountHolder){
        this.NewAccountHolder = NewAccountHolder;
    }
    public String getnewname(){
        return NewAccountHolder;
    }
    public void setnewbalance(double balance){
        this.balance = balance;
    }
    public double getnewbalance(){
        return balance;
    }
    public void setnewage(int Age){
        this.Age = Age;
    }
    public int getnewage(){
        return Age;
    }
    public void setnewpin(int pin){
        this.pin = pin; 
    }
    public int getnewpin(){
        return pin;
    }
}

class Bankmanagment{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        ArrayList<create> detail = new ArrayList<>();
        while(true){
            System.out.println("\n-----Bank Managment System-----");
            System.out.println("1) -----create a Account-------");
            System.out.println("2) -----Deposite-----");
            System.out.println("3) -----Withdraw-----");
            System.out.println("4) -----Check Balance-----");
            System.out.println("5) -----Exit-----");

            System.out.println("Enter a Method:");
            int n = sc.nextInt();
            sc.nextLine();
            create c = new create();
            switch(n){
                case 1:
                    System.out.println("Enter a New AccountId:");
                    int ID = sc.nextInt();
                    sc.nextLine();
                    c.setnewid(ID);
                    System.out.println("Enter a New AccountHolder Name:");
                    String name = sc.nextLine();
                    c.setnewname(name);
                    System.out.println("Enter a Age:");
                    int a = sc.nextInt();
                    c.setnewage(a);
                    sc.nextLine();
                    System.out.println("Enter a New PIN:");
                    String p = sc.nextLine();
                    if(p.length() == 4){
                        int changetype = Integer.parseInt(p);
                        c.setnewpin(changetype);
                        System.out.println("Account Created Succesfully");
                    }
                    else{
                        System.out.println("Pin must be Equal to 4 Digit");
                        break;
                    }
                    c.setnewbalance(0);
                    System.out.println("0 balance Because New account created");
                    detail.add(c);
                    System.out.println("Account Created Succesfully");
                    break;
                case 2:
                    System.out.println("Enter a AccountHolderID:");
                    int searchid = sc.nextInt();
                    System.out.println("Enter a 4 Digit PIN:");
                    int userpin = sc.nextInt();
                    sc.nextLine();
                    int len = detail.size();
                    for(int i = 0;i<len;i++){
                        if(detail.get(i).getnewid() == searchid && detail.get(i).getnewpin() == userpin){
                                System.out.println("Enter a Amount: NOTE: MAXIMUM $100000 per transaction");
                                double amu = sc.nextInt();
                                sc.nextLine();
                                double updateamount = amu + detail.get(i).getnewbalance();
                                detail.get(i).setnewbalance(updateamount);
                                System.out.println("Amount Depostite Successfully");
                                System.out.println("Available Balance:");
                                System.out.println(detail.get(i).getnewbalance());
                            }
                            else{
                                System.out.println("Incorrect Details are Filled");
                            }
                        }
                    break;
                case 3:
                    System.out.println("Enter a AccountHolderID:");
                    int aid = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter a 4 digit Pin:");
                    int apin = sc.nextInt();
                    sc.nextLine();
                    int length = detail.size();
                    for(int i = 0;i<length;i++){
                        if(detail.get(i).getnewid() == aid && detail.get(i).getnewpin() == apin){
                            System.out.println("Available Balance:"+detail.get(i).getnewbalance());
                            System.out.println("Enter a Amount:");
                            double aamu = sc.nextInt();
                            if(detail.get(i).getnewbalance() >= 0){
                                double temp = detail.get(i).getnewbalance()-aamu;
                                if(temp >= 0){
                                    detail.get(i).setnewbalance(temp);
                                    System.out.println("Amount Withdraw Successfully");
                                    System.out.println("Available Balance:"+detail.get(i).getnewbalance());
                                }
                                else{
                                    System.out.println("Available Balance:"+detail.get(i).getnewbalance());
                                    System.out.println("Not much money");
                                }
                            }
                        }
                    }
                    break;
                case 4:
                    System.out.println("Enter a AccountHolderID");
                    int checkid = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter a 4 digit Pin:");
                    int checkpin = sc.nextInt();
                    sc.nextLine();
                    int checksize = detail.size();
                    for(int i = 0;i<checksize;i++){
                        if(detail.get(i).getnewid() == checkid && detail.get(i).getnewpin() == checkpin){
                            System.out.println("Available Balance:");
                            System.out.println(detail.get(i).getnewbalance());
                        }
                    }
                    
                    break;
                case 5:
                    System.exit(0);  
                    break;
                default:
                    System.out.println("Invalid Method");          
            }
        }
    }
}
