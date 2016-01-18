package analysis3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.StringTokenizer;

public class crimeResult {
	public static int isNumeric(String str)
	{int d=-1;
		try {
			 d = Integer.parseInt(str);
		}
			catch(NumberFormatException nfe)
		{
			return -1;		
		}
		return d;
		}
	public static void main(String[] args){
		try{
		FileReader inputFile = new FileReader("conf/crimesumm33/part-00000");
        BufferedReader bufferReader = new BufferedReader(inputFile);

		FileWriter fw = new FileWriter("conf/analysis3result");
		
		BufferedWriter output = new BufferedWriter(fw);
	    String line;
	    int positive=0,negative=0;;
        
       while((line = bufferReader.readLine())!= null)
       {         		
      	line=line.trim();     
      	output.write(line + "\n");
      	StringTokenizer token = new StringTokenizer(line,"\t");
     	token.nextToken();
      	int lasttoken = 0;
      	lasttoken=isNumeric(token.nextToken());
      	if(lasttoken > 0)
			positive +=1;
		else
			negative +=1;
	}	
       System.out.println("Positive: "+positive);
       System.out.println("Negative: "+negative);
       output.write("Positive: "+positive + "\n");
       output.write("Negative: "+negative + "\n");
       output.close();
       bufferReader.close();    
}
	catch(Exception e){
          System.out.println("Error while reading file line by line:" + e.getMessage());                      
       }
}
}