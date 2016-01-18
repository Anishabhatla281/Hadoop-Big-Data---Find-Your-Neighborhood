package pro;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.StringTokenizer;

public class cleancrime {

	
	public static void main (String[] args) throws IOException
	{	String latitude = new String();
		String longitude  = new String();
		String type = new String();
		String date = new String();
		String year = new String();
	FileWriter fw = new FileWriter("script/crimeoutfile.txt"); 
	BufferedWriter output = new BufferedWriter(fw);
	Scanner scanner = new Scanner(new File("script/more.txt"));
	PrintStream out = new PrintStream(new File("script/crimeoutfile.txt"));
	while(scanner.hasNextLine()){
	    String line = scanner.nextLine();
	
		StringTokenizer t =  new StringTokenizer(line,",");
		while (t.hasMoreTokens())
		{ latitude=t.nextToken();
			longitude = t.nextToken();
			type = t.nextToken();
			date = t.nextToken();
		
		if (date.contains("/"))
			{
				StringTokenizer p = new StringTokenizer(date,"/ ");
				p.nextToken();
				p.nextToken();
				year = p.nextToken();
			}
		String zip = t.nextToken();
		output.write(latitude+","+longitude+ "," + type+","+year+","+zip+"\n");
		System.out.println(latitude+","+longitude+ "," + type+","+year+","+zip);
		
		}
		
		
	}	
	output.close();
	}
}
