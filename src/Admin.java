import java.io.File;
import java.io.FileWriter;
import java.util.Formatter;
import java.util.Scanner;

public class Admin {
    boolean bo= false;
    private Formatter x;
    private Scanner f;
    public void openFile(){
        try{
            FileWriter k= new FileWriter("Admin.txt", false);
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
            f= new Scanner(new File("Admin.txt"));
        }
        catch(Exception e){
            System.out.println("You have an error");
        }
    }

    public void readFile(String n, String ni){
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

    public void openFile3(){
        try{
            f= new Scanner(new File("Student.txt"));
        }
        catch(Exception e){
            System.out.println("You have an error");
        }
    }

    public void readFile3(){
        int i=1;
        while (f.hasNext()) {
            String a= f.next();
            String b= f.next();
            System.out.println(i+": "+"ID: "+a+" Password: "+b);
            i++;
        }
          i=1;
    }

    public void closeFile3(){
        f.close();
    }


    public void login(){
        String id,pass;
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter admin user ID: ");
        id= sc.next();
        System.out.println("Enter admin password: ");
        pass=sc.next();
        openFile2();
        readFile(id,pass);
        closeFile2();
        if(bo==true){
        Menu();
        }
        else{
            System.out.println("Wrong user info");
        }

    }

    public void openFile4(){
        try{
            f= new Scanner(new File("Student.txt"));
        }
        catch(Exception e){
            System.out.println("You have an error");
        }
    }
    public void readFile4(int xh){
        int i=1;
        while (f.hasNext()) {
            if(i==xh){
                String a= f.next();
                String b= f.next();
            }
            try{
                String a= f.next();
                String b= f.next();
                System.out.println(i+": "+"ID: "+a+" Password: "+b);
                i++;
                openFile5();
                addRecords5(a,b);
                closeFile5();
            }
            catch(Exception e){

            };
        }
        i=1;
    }
    public void closeFile4(){
        f.close();
    }

    public void openFile5(){
        try{
            FileWriter k= new FileWriter("StudentEdit.txt",true);
            x = new Formatter(k);
        }
        catch(Exception e){
            System.out.println("You have an error");
        }
    }
    public void addRecords5(String a, String b){
        x.format("%s%s%s", a," ",b);
        x.format("%s%n", " ");
    }
    public void closeFile5(){
        x.close();
    }

    public void openFileBS(){
        try{
            FileWriter k= new FileWriter("Student.txt", false);
            x= new Formatter(k);
        }
        catch(Exception e){
            System.out.println("You have an error");
        }
    }
    public void addRecordsBS(){
        x.format("%s"," ");
    }
    public void closeFileBS(){
        x.close();
    }

    public void openFileSE(){
        try{
            FileWriter k= new FileWriter("StudentEdit.txt", false);
            x= new Formatter(k);
        }
        catch(Exception e){
            System.out.println("You have an error");
        }
    }
    public void addRecordsSE(){
        x.format("%s"," ");
    }
    public void closeFileSE(){
        x.close();
    }

    public void openFileManual(){
        try{
            f= new Scanner(new File("StudentEdit.txt"));
        }
        catch(Exception e){
            System.out.println("You have an error");
        }
    }
    public void readFileManual(){
        while (f.hasNext()) {
            String a= f.next();
            String b= f.next();
            openFileBS2();
            addRecordsBS2(a,b);
            closeFileBS2();
        }
    }
    public void closeFileManual(){
        f.close();
    }

    public void openFileBS2(){
        try{
            FileWriter k= new FileWriter("Student.txt", true);
            x= new Formatter(k);
        }
        catch(Exception e){
            System.out.println("You have an error");
        }
    }
    public void addRecordsBS2(String a,String b){
        x.format("%s%s%s", a," ",b);
        x.format("%s%n", " ");
    }
    public void closeFileBS2(){
        x.close();
    }


    public void Menu(){
        Scanner pk= new Scanner(System.in);
        int c;
        System.out.println("Enter 1 to change admin Id and pass: ");
        System.out.println("Enter 2 to see registered students: ");
        System.out.println("Enter 3 to delete a user: ");
        System.out.println("Enter 4 to logout: ");
        System.out.println("Press 5 to reset: ");
        c= pk.nextInt();
        if(c==1){
            Scanner sc= new Scanner(System.in);
            String nID, nPass;
            System.out.println("Enter new ID: ");
            nID= sc.next();
            System.out.println("Enter new Pass: ");
            nPass= sc.next();
            openFile();
            addRecords(nID,nPass);
            closeFile();
            System.out.println("ID and Password Changed");
            choose();
        }
        if(c==2){
            openFile3();
            readFile3();
            closeFile3();
            choose();
        }

        if(c==3){
            openFileSE();
            addRecordsSE();
            closeFileSE();
            Scanner sc= new Scanner(System.in);
            openFile3();
            readFile3();
            closeFile3();
            System.out.println("Enter the serial number of the id to remove: ");
            int ccc=sc.nextInt();
            openFile4();
            readFile4(ccc);
            closeFile4();
            openFileBS();
            addRecordsBS();
            closeFileBS();
            openFileManual();
            readFileManual();
            closeFileManual();
            System.out.println("Deleted Successfully");
            choose();

        }

        if(c==4){
            Students s=new Students();
            s.login();
        }
        if(c==5) {
            Scanner scc = new Scanner(System.in);
            System.out.println("Do you really want to reset? ");
            System.out.println("Press 1 to proceed and 2 to go back");
            int kkk = scc.nextInt();
            if (kkk == 1) {
                Reset rs = new Reset();
                rs.rs();
                System.out.println("Reset successful");
                Menu();
            }
            if (kkk == 2) {
                Menu();
            }
        }
    }

    public void choose(){
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter 1 to go back to menu");
        int k= sc.nextInt();
        Menu();
    }
}
