import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.StringTokenizer;

public class filecorect {
public static boolean isNumeric(String str)
{	//double d=0.0;
	try {
		Double.parseDouble(str);
	}
		catch(NumberFormatException nfe)
	{
		return false;
	
	}
	return true;
	}

	
	public static void main (String[] args) throws IOException {
		FileWriter fw = new FileWriter("script/outfile.txt"); 
		BufferedWriter output = new BufferedWriter(fw);
		Scanner scanner = new Scanner(new File("script/part-m-00000"));
		PrintStream out = new PrintStream(new File("script/outfile.txt"));
		while(scanner.hasNextLine()){
		String line = scanner.nextLine();
		StringTokenizer t = new StringTokenizer(line);
		if(isNumeric(t.nextToken()))
		 {	
		   line = line.trim();
		   
		   if(line.length() > 0 )
		   {
		   	output.write(line+"\n");
		   }
		   } 	   	
		}
		output.close();	
		scanner.close();
		out.close();
	}
	
}

