import java.io.FileWriter;
import java.util.Formatter;
import java.util.Scanner;
import java.io.File;
public class Students {
    private Formatter x;
    private Scanner f;
    static boolean bo=false;
    public void openFile(){
        try{
            FileWriter k= new FileWriter("Student.txt", true);
            x= new Formatter(k);
        }
        catch(Exception e){
            System.out.println("You have an error");
        }
    }
    public void addRecords(String z, String y){
        x.format("%s%s%s", z," ", y);
        x.format("%s%n"," ");
    }
    public void closeFile(){
        x.close();
    }

    public void openFile2(){
        try{
            f= new Scanner(new File("Student.txt"));
        }
        catch(Exception e){
            System.out.println("You have an error");
        }
    }

    public void readFile(String n, String ni){
        bo=false;
        while (f.hasNext()) {

            String a= f.next();
            String b= f.next();
            if(a.compareTo(n)==0 && b.compareTo(ni)==0){
                bo=true;
            }
        }

    }

    public void closeFile2(){
        f.close();
    }



    public static void main(String[] args) throws Exception {
        System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("|||||||||||||||||Welcome to Event management system||||||||||||||||||||||");
        System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        Students std = new Students();
        std.login();
    }
    public void login(){
        Scanner sc= new Scanner(System.in);
        System.out.println("Press 1 to login");
        System.out.println("Press 2 to register");
        System.out.println("Press 3 to access admin panel");
        System.out.println("Press 4 to Exit");
        int c;
        c=sc.nextInt();
        if(c==1){

            String id,pass;
            System.out.println("Enter ID: ");
            id=sc.next();
            System.out.println("Enter password: ");
            pass=sc.next();
            Students g= new Students();
            g.openFile2();
            g.readFile(id,pass);
            g.closeFile2();

            if(bo==true){

                Booking b= new Booking();
                Scanner sc1=new Scanner(System.in);
                int s;

                System.out.println("Enter 1 to Book an Event");
                System.out.println("Enter 2 to view Events");
                System.out.println("Enter 3 to Delete an Event");
                System.out.println("Enter 4 to Edit an Event");
                System.out.println("Enter 5 to exit to main menu");
                s=sc1.nextInt();

                if(s==1){
                    b.eventBook();
                }
                if(s==2){
                    b.showEvents();
                }
                if(s==3){
                    b.delete();
                    System.out.println("Event deleted");
                }
                if(s==4){
                    b.delete();
                    System.out.println("Now book the event again with the necessary changes: ");
                    b.eventBook();
                }
                if(s==5){
                    login();
                }

            }
            else{
                System.out.println("Wrong ID or Password");
                login();
            }


        }
        if(c==2){

            String id,pass;
            System.out.println("Enter ID: ");
            id=sc.next();
            System.out.println("Enter new password: ");
            pass=sc.next();
            Students g= new Students();
            g.openFile();
            g.addRecords(id,pass);
            g.closeFile();
            System.out.println("Information saved.");
            Students std = new Students();
            std.login();
        }
        if(c==3){
            Admin a = new Admin();
                a.login();
        }
        if(c==4){
            System.out.println("Thanks for using");
        }

    }
}
