package analysis3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class crimeTrends {
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
	void getCrimeTrends(){
		 try{
	         FileReader inputFile = new FileReader("conf/crimesumm22/part-00000");
	         BufferedReader bufferReader = new BufferedReader(inputFile);
	        FileWriter fw = new FileWriter("conf/crimeTrends.txt");
	 		ArrayList<String> lineString = new ArrayList<String>();
	 		BufferedWriter output = new BufferedWriter(fw);
	 	    String line1;
	 	    int i=0,j=0;
	 	    int count=0;
	 	    while((line1=bufferReader.readLine())!=null)
	 	    {
	 	    	lineString.add(line1);
	 	    	count++;	 	    
	 	    }
	 	   int[][] array = new int[count][16];
	 	   int flag=0;
		   for(String line : lineString)
	        {         		
	       	line=line.trim();   		
			StringTokenizer token = new StringTokenizer(line,",\t");
			int zip = isNumeric(token.nextToken());
			int year = isNumeric(token.nextToken());
			int score = isNumeric(token.nextToken());
			year = year%100;
			for(j=0;j<i;j++)
				if(array[j][0]==zip)
					{
						array[j][year]=score;
						flag=1;
					}
			if(flag==0)
				{
				array[i][0] = zip;
				array[i][year]=score;
				i++;				
				}
			flag=0;
			}
	        for(i=0;i<count;i++)
	        	{
	        	for( j=0;j<16;j++)
	        		{
	        		if(j==15){
	        			output.write(array[i][j] + " ");
	        		}
	        		else{
	        		output.write(array[i][j] +",");
	        		}
	        		}	        		
	        	output.write("\n");
	        	}
	        output.close();
	        bufferReader.close();
		 }
    		catch(Exception e){
    	          System.out.println("Error while reading file line by line:" + e.getMessage());                      
    	       }
    }
    }