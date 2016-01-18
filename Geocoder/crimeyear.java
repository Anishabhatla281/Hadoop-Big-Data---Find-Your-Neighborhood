import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.StringTokenizer;

public class crimeyear {

	
	public static void main (String[] args ) throws IOException {
		
		  FileReader inputFile = new FileReader("script/crimedate.txt");

          //Instantiate the BufferedReader Class
          BufferedReader bufferReader = new BufferedReader(inputFile);


  		FileWriter fw = new FileWriter("script/clean1.txt");
  		
  		BufferedWriter output = new BufferedWriter(fw);
  		//Scanner scanner = new Scanner(new File(Filename));
  		PrintStream out = new PrintStream(new File("script/clean1.txt"));
          
  		 	String line;

         
   		
 		while( ( line = bufferReader.readLine() )!= null)
 		{
 			
 		
 			System.out.println(line);
 			line=line.trim();
 		
 			StringTokenizer t = new StringTokenizer(line);
 			int a=t.countTokens();
 			while (t.hasMoreTokens())
 			{
 				
 			
 			String one = t.nextToken();
 			if (one.contains("/"))
 		
 			{
 				System.out.println(one);
 				StringTokenizer p = new StringTokenizer(one, "/");
 				String w1  = p.nextToken();
 				System.out.println(w1);
 				p.nextToken();
 			String last = p.nextToken();
 			System.out.println(last);
 			one = last;
 			}
		
	}}
	}
	
	
}
