import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

	public class ScriptDemo {

		public static void main(String ar[]) throws Exception {
		  ScriptDemo s = new ScriptDemo();
	      String fileName= "script/outfile.txt";
	      //s.formatfile("script/part-m-00000");
	      ArrayList< String> anisha= new ArrayList<String>();
	      try{
	   	  
	         FileReader inputFile = new FileReader(fileName);
	         BufferedReader bufferReader = new BufferedReader(inputFile);
	         String line;
	         for (int j = 0 ; j < 18473 ; j++)
	       	 line = bufferReader.readLine();	        
	       	 for (int i= 0;i < 500; i++)
	       	 {
	       	line = bufferReader.readLine();
	       	line=line.trim();
			
			StringTokenizer t = new StringTokenizer(line);
			String give = t.nextToken() + ", " + t.nextToken();
			String test = (new ScriptDemo().getAddress(give));
			
			String type = "";
			while (t.hasMoreTokens())
				type = type + " " + t.nextToken();
			anisha.add(give  + ", " + type + ", " + test);
	       	 }
		 bufferReader.close();
	         
	      }catch(Exception e){
	          System.out.println("Error while reading file line by line:" + e.getMessage());                      
	       }
		s.formatfile(anisha);
		
		for(int j=0;j<anisha.size();j++)
			
		{
			System.out.println(new ScriptDemo().getAddress(anisha.get(j)));
	}
	}
	public String getAddress(String latlong) throws InterruptedException{

	String address = null;	
	String gURL = "http://maps.google.com/maps/api/geocode/xml?latlng=" + latlong + "&sensor=true";
	try {
	DocumentBuilderFactory df = DocumentBuilderFactory.newInstance();
	DocumentBuilder db = df.newDocumentBuilder();
	Document dom = db.parse(gURL);
	
	Element docEl = dom.getDocumentElement();
	NodeList nl = docEl.getElementsByTagName("result");

	System.out.println("and here");
	if (nl != null && nl.getLength() > 0){
		System.out.println("heree");
	address=((Element)nl.item(0)).getElementsByTagName("formatted_address").item(0).getTextContent();
	
	System.out.println("Address is: "+address);
	TimeUnit.MILLISECONDS.sleep(200);
	}
	
	} catch (Exception ex) {

	   System.out.println("Error"+ex);
	address = "Err";
	}
	ArrayList<String> res = new ArrayList<String>();
	
	if (address != null)
	{
	StringTokenizer tok = new StringTokenizer(address, " ,");
	while (tok.hasMoreTokens())
	{
	
		res.add(tok.nextToken());
	}
	return (res.get(res.size()-2));
			}
	else
	{
		TimeUnit.MILLISECONDS.sleep(1000);//System.out.println(address);
		return "Nothing";
	}
	}
	public String getAddress(String lat, String lon) throws InterruptedException {
	return getAddress(lat+ "," + lon);
	}
	public String getAddress(double lat, double lon) throws InterruptedException {
	return getAddress("" + lat, "" + lon);
	}
	String formatfile (ArrayList<String> anisha) throws IOException
	{
		FileWriter fw = new FileWriter("script/test1.txt");
	
		BufferedWriter output = new BufferedWriter(fw);
		PrintStream out = new PrintStream(new File("script/test1.txt"));
		 for (int j = 0 ; j<anisha.size();j++)
		 {  output.write(anisha.get(j)+"\n");
		 } 	   	
		output.close();
		out.close();
	return "script/test.txt";
	}
	
	}