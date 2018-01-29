import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * @author - Duy Pham
 * @version - 1.01 - 02/20/2014
 * @see <br><a href='http://docs.oracle.com/javase/7/docs/api/javax/swing/JOptionPane.html'>Javadoc Documentation</a>
 * @email pnad0911@gmail.com
 */
public class A19006
{
    public static void main(String[] args) throws Exception
    {
        System.out.println("Hello World");
        //Declare a string array called aryAltitudes that contains the nine altitudes as two character strings
        String[] aryAltitudes= {"03","06","09","12","18","24","30","34","39"};
        //Open an output file
        PrintWriter FBOUT = new PrintWriter("data/FBOUT.txt");
        String strStaID;
        String strLine;
        //Instantiate a Stations object called db
        Stations db= new Stations("data/FBIN.txt");
        Boolean strBoo=false;
        while(!strBoo)
        {
            //Prompt for Station ID
                strStaID= JOptionPane.showInputDialog("Enter the station Id");
                strStaID=strStaID.toUpperCase();
            //if exist
            if(db.exists(strStaID)==true){
                strLine=db.getStaWea(strStaID);
                NWSFB05 fb= new NWSFB05(strStaID);
                FBOUT.println("A19006 - by DUY PHAM");
                FBOUT.println("The number of stations in the file "+db.length());
                FBOUT.println("Station Weather for "+strLine);
                FBOUT.println("At 03,000 feet:    Dir= "+fb.getWindDirection(strLine,"3000")+"\t"+"Speed= "+fb.getWindSpeed(strLine,"3000")+"\t"+"Temp= "+fb.getWindTemp(strLine,"3000"));
                FBOUT.println("At 06,000 feet:    Dir= "+fb.getWindDirection(strLine,"6000")+"\t"+"Speed= "+fb.getWindSpeed(strLine,"6000")+"\t"+"Temp= "+fb.getWindTemp(strLine,"6000"));
                FBOUT.println("At 09,000 feet:    Dir= "+fb.getWindDirection(strLine,"9000")+"\t"+"Speed= "+fb.getWindSpeed(strLine,"9000")+"\t"+"Temp= "+fb.getWindTemp(strLine,"9000"));
                FBOUT.println("At 12,000 feet:    Dir= "+fb.getWindDirection(strLine,"12000")+"\t"+"Speed= "+fb.getWindSpeed(strLine,"12000")+"\t"+"Temp= "+fb.getWindTemp(strLine,"12000"));
                FBOUT.println("At 18,000 feet:    Dir= "+fb.getWindDirection(strLine,"18000")+"\t"+"Speed= "+fb.getWindSpeed(strLine,"18000")+"\t"+"Temp= "+fb.getWindTemp(strLine,"18000"));
                FBOUT.println("At 24,000 feet:    Dir= "+fb.getWindDirection(strLine,"24000")+"\t"+"Speed= "+fb.getWindSpeed(strLine,"24000")+"\t"+"Temp= "+fb.getWindTemp(strLine,"24000"));
                FBOUT.println("At 30,000 feet:    Dir= "+fb.getWindDirection(strLine,"30000")+"\t  Speed= "+fb.getWindSpeed(strLine,"30000")+"\t"+"Temp= "+fb.getWindTemp(strLine,"30000"));
                FBOUT.println("At 34,000 feet:    Dir= "+fb.getWindDirection(strLine,"34000")+"\t  Speed= "+fb.getWindSpeed(strLine,"34000")+"\t"+"Temp= "+fb.getWindTemp(strLine,"34000"));
                FBOUT.println("At 39,000 feet:    Dir= "+fb.getWindDirection(strLine,"39000")+"\t  Speed= "+fb.getWindSpeed(strLine,"39000")+"\t"+"Temp= "+fb.getWindTemp(strLine,"39000"));
                strBoo=true;
                FBOUT.close();
            }
        }
    }
}

