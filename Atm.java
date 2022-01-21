import java.util.*;
public class Atm {
    private static Scanner sc=new Scanner(System.in);
    static int trac[]={0,0,0,0};
    static void note(int wdraw){
        if(wdraw/2000!=0){
            trac[0]=wdraw/2000;
            wdraw=wdraw%2000;
            arr[0]=arr[0]-trac[0];
        }
        if(wdraw/500!=0){
            trac[1]=wdraw/500;
            wdraw=wdraw%500;
            arr[1]=arr[1]-trac[1];
        }
        if(wdraw/200!=0){
            trac[2]=wdraw/200;
            wdraw=wdraw%200;
            arr[2]=arr[2]-trac[2];
        }
        if(wdraw/100!=0){
            trac[3]=wdraw/100;
            wdraw=wdraw%100;
            arr[3]=arr[3]-trac[3];
        }
    }
    public static void admin(){
        System.out.println("Please Enter username");
        String user=sc.nextLine();
        System.out.println("Enter your password");
        int pin=sc.nextInt();
        if(user.equals("admin")&&pin==1234){
            t:while(true){
                System.out.println("WELCOME ADMIN");
                System.out.println("1. Add amount");
                System.out.println("2. view amount");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");
                int de =sc.nextInt();
                switch(de){
                    case 1:
                    addmoney();
                    break;
                    case 2:
                    showmoney();
                    break;
                    case 3:
                    break t; 
                }
            }
        }
    }
    static int arr[]={0,0,0,0};
    static int total;
    static int amount;
    public static void addmoney(){
        System.out.println("2000,500,200,100");
        for(int i=0;i<4;i++){
            amount=sc.nextInt();
            arr[i]=arr[i]+amount;
        }
        System.out.println("Amount added successfully");
        int m2000 = arr[0]*2000;
        int m500 = arr[1]*500;
        int m200 = arr[2]*200;
        int m100 = arr[3]*100;
        total = m2000+m500+m200+m100;
    }
    public static void showmoney(){
        System.out.println("the count of 2000 is "+arr[0]);
        System.out.println("the count of 500 is "+ arr[1]);
        System.out.println("the count of 200 is "+ arr[2]);
        System.out.println("the count of 100 is "+ arr[3]);
        System.out.println(total);
    }
    static int attempt;
    static int psw=4567;
    static String bank_name;
    public static void user(){
        System.out.println("Please Enter username");
        String user=sc.nextLine();
        System.out.println("Enter your password");
        int pin=sc.nextInt();
        System.out.println("Enter your bank name");
        bank_name=sc.next();
        if(user.equals("suve")&&pin==psw){
            t:while(true){
                System.out.println("WELCOME "+ user);
                System.out.println("1. Withdraw");
                System.out.println("2. View Balance");
                System.out.println("3. Mini Statement");
                System.out.println("4. Change Pin");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                int de =sc.nextInt();
                switch(de){
                    case 1:
                    withdraw();
                    break;
                    case 2:
                    balance();
                    break;
                    case 3:
                    ministatement();
                    break;
                    case 4:
                    changepin();
                    break;
                    case 5:
                    break t;
                }
            }
        }
        else{
            System.out.println("Please check your username and password");
            attempt++;
        }
        if(attempt>2){
            System.out.println("You have exceed your limit");
            System.exit(0);
        }
    }
    static int b= 10000;
    static int count;
    static int wdraw;

    public static void withdraw(){
        System.out.println("Enter the amount to be withdrawn");
        wdraw =sc.nextInt();
        if(wdraw<=total && wdraw<=b){
            System.out.println("collect your money");  
            if(bank_name.equals("canara")){
            b=b-wdraw;
            }
            else{
                b=(b-wdraw)-30;
            }
            total=total-wdraw;
            
            count++;
            note(wdraw);
            System.out.println("2000rs. note ->"+trac[0]);
            System.out.println("500rs. note ->"+trac[1]);
            System.out.println("200rs. note ->"+trac[2]);
            System.out.println("100rs. note ->"+trac[3]);
        }
        else{
            System.out.println("No sufficient amount");
        }
    }
    public static void balance(){
        System.out.println("Your balance is " + b);
    }
    public static void ministatement(){
        for(int i=1;i<=count;i++){
            Date r=java.util.Calendar.getInstance().getTime();
            System.out.println(r+" "+wdraw+" "+b);
        }
    }
    public static void changepin(){
        System.out.println("Enter your current pin");
          int cpin=sc.nextInt();
          if(cpin==psw){
              System.out.println("Enter the new pin");
              int npin=sc.nextInt();
              System.out.println("Confirm the new pin");
              int npin1=sc.nextInt();
              if(npin==npin1){
                psw=npin;
               System.out.println("Pin changed Successfully");
              }
          }
    }
    public static void main(String[] args){
        int ch=0;
        do{
            System.out.println("ATM");
            System.out.println("1. Admin");
            System.out.println("2. User");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            ch =sc.nextInt();
            sc.nextLine();
            switch(ch){
                case 1:
                   admin();
                   break ;
                case 2:
                   user();
                   break;
                case 3:
                System.exit(0);
                break;
                default:
                System.out.println("Invaid Input");
                break;
            }
        }
        while(ch!=3);
    }
}    