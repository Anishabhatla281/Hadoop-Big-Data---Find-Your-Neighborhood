package analysis2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.StringTokenizer;

public class findPercentageIncrease {

	public static Double isDouble(String str)
	{double d=0;
		try {
			 d = Double.parseDouble(str);
		}
			catch(NumberFormatException nfe)
		{
			return 0.0;		
		}
		return d;
		}
	public static void main(String[] args){
		 try{
			 FileReader inputFile = new FileReader("conf/crimesumm33/part-00000");
			 BufferedReader bufferReader = new BufferedReader(inputFile);

		FileWriter fw = new FileWriter("conf/crimePercentageIncreaseTrends.txt");		
		BufferedWriter output = new BufferedWriter(fw);
	    String line;
	    
       while(( line = bufferReader.readLine() )!= null)
       {         		
      	StringTokenizer t = new StringTokenizer(line, "  \t");
      	String zip = t.nextToken();
      	double rentbefore5 = Double.parseDouble(t.nextToken());
      	double rentafter5 = Double.parseDouble(t.nextToken());
      	double percentageOutput = 0.0;
      	if(rentbefore5>rentafter5){
      		percentageOutput = ((rentbefore5 - rentafter5)/rentafter5) * 100;
      	}
      	else{
      		percentageOutput = ((rentafter5 - rentbefore5)/rentbefore5) * 100;
      	}
      	String value = t.nextToken();
      	output.write(zip + " "+percentageOutput + " "+value+"\n");     
	}
    output.close();
	bufferReader.close();
}
	catch(Exception e){
          System.out.println("Error while reading file line by line:" + e.getMessage());                      
       }
	}
}
