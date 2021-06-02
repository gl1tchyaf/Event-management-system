import java.io.File;
import java.io.FileWriter;
import java.util.Formatter;
import java.util.Scanner;
public class Booking {
    static int i=1;
    private Formatter x;
    private Scanner f;
    public void openFile(){
        try{

            FileWriter k= new FileWriter("Booking.txt",true);
            x = new Formatter(k);
        }
        catch(Exception e){
            System.out.println("You have an error");
        }
    }
    public void addRecords(String a, String b,String c, String d, String e, String f){
        x.format("%s%s%s%s%s%s%s%s%s%s%s%s", a," ",b," ",c," ",d," ",e," ",f," ");
        x.format("%s%n", " ");
    }
    public void closeFile(){
        x.close();
    }

    public void openFile3(){
        try{
            FileWriter k= new FileWriter("BookingEdit.txt",true);
            x = new Formatter(k);
        }
        catch(Exception e){
            System.out.println("You have an error");
        }
    }
    public void addRecords3(String a, String b,String c, String d, String e, String f){
        x.format("%s%s%s%s%s%s%s%s%s%s%s%s", a," ",b," ",c," ",d," ",e," ",f," ");
        x.format("%s%n", " ");
    }
    public void closeFile3(){
        x.close();
    }

    public void openFile4(){
        try{
            FileWriter k= new FileWriter("BookingEdit.txt",false);
            x = new Formatter(k);
        }
        catch(Exception e){
            System.out.println("You have an error");
        }
    }
    public void addRecords4(){
        x.format("%s"," ");
    }
    public void closeFile4(){
        x.close();
    }


    public void openFile2(){
        try{
            f= new Scanner(new File("Booking.txt"));
        }
        catch(Exception e){
            System.out.println("You have an error");
        }
    }
    public void readFile(){
        while (f.hasNext()) {
            String a= f.next();
            String b= f.next();
            String c= f.next();
            String d= f.next();
            String e= f.next();
            String g= f.next();

            System.out.println("\n"+i +":");
            System.out.println("Title: "+a+"\nDescription: "+b+"\nType: "+c+"\nURL or Location: "+d+"\nDate and Time: "+e+"\nPlace Limitation: "+g);
            i++;
        }
        i=1;
    }
    public void readFile2(int xh){
        i=1;
        while (f.hasNext()) {
            if(i==xh){
                String a= f.next();
                String b= f.next();
                String c= f.next();
                String d= f.next();
                String e= f.next();
                String g= f.next();
            }
          try{
            String a= f.next();
            String b= f.next();
            String c= f.next();
            String d= f.next();
            String e= f.next();
            String g= f.next();

            System.out.println("\n"+i +":");
            System.out.println("Title: "+a+"\nDescription: "+b+"\nType: "+c+"\nURL or Location: "+d+"\nDate and Time: "+e+"\nPlace Limitation: "+g);
            i++;
            openFile3();
            addRecords3(a,b,c,d,e,g);
            closeFile3();
        }
          catch(Exception e){

          };

        }
        i=1;
    }
    public void closeFile2(){
        f.close();
    }


    public void manualOpen(){
        try{
            f= new Scanner(new File("BookingEdit.txt"));
        }
        catch(Exception e){
            System.out.println("You have an error");
        }
    }
    public void manualRead(){
        try {
            while (f.hasNext()) {
                String a = f.next();
                String b = f.next();
                String c = f.next();
                String d = f.next();
                String e = f.next();
                String g = f.next();
                manualOpen3();
                manualReplace(a,b,c,d,e,g);
                manualClose3();
            }
        }
        catch (Exception e){

        }
    }
    public void manualClose(){
        f.close();
    }

    public void manualOpen2(){
        try{

            x = new Formatter("Booking.txt");
        }
        catch(Exception e){
            System.out.println("You have an error");
        }
    }
    public void manualBlank(){
        x.format("%s%n", " ");
    }
    public void manualClose2(){
        x.close();
    }

    public void manualOpen3(){
        try{

            FileWriter k= new FileWriter("Booking.txt",true);
            x = new Formatter(k);
        }
        catch(Exception e){
            System.out.println("You have an error");
        }
    }
    public void manualReplace(String a, String b,String c, String d, String e, String f){
        x.format("%s%s%s%s%s%s%s%s%s%s%s%s", a," ",b," ",c," ",d," ",e," ",f," ");
        x.format("%s%n", " ");

    }
    public void manualClose3(){
        x.close();
    }

    public void eventBook(){
        String t,d,ty,ul,dt,l;
        Scanner sc= new Scanner(System.in);
        System.out.println("Don't use any space");
        System.out.println("Enter Title: ");
        t=sc.next();
        System.out.println("Don't use any space");
        System.out.println("Enter description: ");
        d=sc.next();
        System.out.println("Don't use any space");
        System.out.println("Enter type (Online or offline): ");
        ty=sc.next();
        System.out.println("Don't use any space");
        System.out.println("Enter URL or Location: ");
        ul=sc.next();
        System.out.println("Don't use any space");
        System.out.println("Enter date and time");
        dt=sc.next();
        System.out.println("Don't use any space");
        System.out.println("Enter place limitation");
        l=sc.next();
        openFile();
        addRecords(t,d,ty,ul,dt,l);
        closeFile();
        System.out.println("Information saved");
        choose();
    }
    public void showEvents(){
        openFile2();
        readFile();
        closeFile2();
        System.out.println();
        choose();

    }
    public void delete(){
        openFile4();
        addRecords4();
        closeFile4();
        int xh;
        Scanner sc=new Scanner(System.in);
        openFile2();
        readFile();
        closeFile2();
        System.out.println("Enter event number to delete / Edit: ");
        xh= sc.nextInt();
        openFile2();
        readFile2(xh);
        closeFile2();
        manualOpen2();
        manualBlank();
        manualClose2();

        manualOpen();
        manualRead();
        manualClose();
        System.out.println();
        System.out.println();
        chooseD();
    }
    public void choose(){
        int cc;
        Scanner sc = new Scanner(System.in);
        System.out.println("Press 1 to book event");
        System.out.println("Press 2 to exit to menu");
        cc= sc.nextInt();
        if(cc==1){
            eventBook();
        }
        if(cc==2){
        Students std = new Students();
        std.login();
    }
    }
    public void chooseD(){
        System.out.println("Event deleted");
        int cc;
        Scanner sc = new Scanner(System.in);
        System.out.println("Press 1 to delete more");
        System.out.println("Press 2 to exit to menu");
        cc= sc.nextInt();
        if(cc==1){
            delete();
        }
        if(cc==2){
            Students std = new Students();
            std.login();
        }
    }
}
