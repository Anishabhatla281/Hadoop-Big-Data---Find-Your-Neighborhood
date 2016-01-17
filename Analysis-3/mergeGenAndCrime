package analysis3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.StringTokenizer;

public class mergeGenAndCrime {

	void getMergedFile(){
		 try{
			 FileReader inputFile = new FileReader("conf/mr2output/part-00000");
			 BufferedReader bufferReader = new BufferedReader(inputFile);
			 FileReader inputFile2 = new FileReader("conf/crimeTrends.txt");
			 BufferedReader bufferReader2 = new BufferedReader(inputFile2);

		FileWriter fw = new FileWriter("conf/mergedmaxyearandcrimetrends.txt");
		
		BufferedWriter output = new BufferedWriter(fw);
	    String line, line2;
	    int i=0,j=0;
        String[][] array = new String[57][17];
        
       while(( line = bufferReader.readLine() )!= null && (line2 = bufferReader2.readLine())!=null)
       {         		
      	StringTokenizer t = new StringTokenizer(line, "\t");
      	t.nextToken();
      	String year = t.nextToken();
      	StringTokenizer t2 = new StringTokenizer(line2,",");
      	
      	for(j=0;j<17;j++)
      	{
      		if(j==1)
      			array[i][j] = year;
      		else
      			array[i][j] = t2.nextToken();      		
      	}
      	i++;      	
	}
    for(i=0;i<57;i++)
    {	for(j=0;j<17;j++)
    		if(j==16)
    			output.write(array[i][j]);
    		else
    			output.write(array[i][j]+",");
    output.write("\n");
    }
    output.close();
	bufferReader.close();
	bufferReader2.close();
}
	catch(Exception e){
          System.out.println("Error while reading file line by line:" + e.getMessage());                      
       }
}
}

