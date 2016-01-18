import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;

public class test {
	public static void main ( String[] args) throws IOException {
		
		try{
	   	  
	        FileReader inputFile = new FileReader("script/test.txt");
	        BufferedReader bufferReader = new BufferedReader(inputFile);
	 		FileWriter fw = new FileWriter("script/clean.txt");
	 		BufferedWriter output = new BufferedWriter(fw);
	 		PrintStream out = new PrintStream(new File("script/clean.txt"));
	        String line;      
	         		
	       while( ( line = bufferReader.readLine() )!= null)
	       {       			
	       		
	       	line=line.trim();
	       		
			
			String lastWord = line.substring(line.lastIndexOf(" ")+1);
			System.out.println(lastWord);
		
			if(!lastWord.equals("Nothing"))
			{
				output.write(line+"\n");
			}
			else {
				
			}
			}
		 
		output.close();
		out.close();
		bufferReader.close();

	}
		catch(Exception e){
	          System.out.println("Error while reading file line by line:" + e.getMessage());                      
	       }
}
}