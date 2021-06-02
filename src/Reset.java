import java.io.FileWriter;
import java.util.Formatter;

public class Reset {
    private Formatter x;
    public void openFile(){
        try{
            FileWriter k= new FileWriter("Student.txt",false);
            x = new Formatter(k);
        }
        catch(Exception e){
            System.out.println("You have an error");
        }
    }
    public void addRecords(){
        x.format("%s", " ");
    }
    public void closeFile(){
        x.close();
    }
    public void openFile2(){
        try{
            FileWriter k= new FileWriter("Booking.txt",false);
            x = new Formatter(k);
        }
        catch(Exception e){
            System.out.println("You have an error");
        }
    }
    public void addRecords2(){
        x.format("%s", " ");
    }
    public void closeFile2(){
        x.close();
    }
    public void rs(){
         openFile();
         addRecords();
         closeFile();
         openFile2();
         addRecords2();
         closeFile2();
    }
}
