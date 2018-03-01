import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * @author - Duy Pham
 * @version - 1.01 - 02/20/2014
 * @assignment.number - A19006
 * @prgm.usage Stations
 * @see <a href='http://jcouture.net/cisc190/A19006.php'>Program Specification</a>
 * @see <br><a href='http://docs.oracle.com/javase/7/docs/api/javax/swing/JOptionPane.html'>Javadoc Documentation</a>
 * @email pnad0911@gmail.com
 */
public class Stations
{
    ArrayList<String> staList = new ArrayList<String>();
    ArrayList<String> staIndex = new ArrayList<String>();
    String strFilePath;

    /**
     * Constructor
     * constructor that will accept a string representing the full path to the FBIN.txt file
     * store it in an instance variable called strFilePath
     * read the file record by record and add each station weather string to the staList
     * store the corresponding station ID to the staIndex array list.
     * @param strVar - a string representing the full path to the FBIN.txt file
     * @throws Exception
     */
    public Stations(String strVar) throws Exception
    {
        //declare variable
        strFilePath=strVar;
        String strRecord;
        File myFile=new File(strFilePath);
        if(myFile.exists())
        {
            Scanner inputFile= new Scanner(myFile);
            int intCount=0;
            while(inputFile.hasNext())
            {
                strRecord= inputFile.nextLine();
                //skip line
                if(intCount>6)
                {
                    //store the station weather in staList
                    staList.add(strRecord);
                    //store the first three characters in staIndex
                    staIndex.add(strRecord.substring(0,3));
                }
                intCount++;
            }
            inputFile.close();
        }
    }

    /**
     * length() function that will return the number of stations stored in the arraylist
     * @return - the number of stations stored in the arraylist
     */
    public int length()
    {
        return staList.size();
    }

    /**
     * a getStaWea(strStationID) function that will accept the station id as a parameter and return the full station weather as a string
     * @param strStaID - the station id
     * @return - the full station weather as a string
     */
    public String getStaWea(String strStaID)
    {

        String strRet="N/A";
        if(exists(strStaID)) strRet=staList.get(staIndex.indexOf(strStaID));
        return strRet;
    }

    /**
     * exists(strStationID) function that checks to see if the station ID exists in the staIndex arraylist
     * @param strStaID - the station ID
     * @return- boolean
     */
    public Boolean exists(String strStaID)
    {
        Boolean blnRet=false;
        int intPos=0;
        String strRet;
        //look up the station Id in staIndex
        intPos=staIndex.indexOf(strStaID);
        //If indexOf return a -1 it did not find it
        if(intPos<0)
        {
            blnRet=false;
        }else
        {
            blnRet= true;
        }
        return blnRet;
    }
}
