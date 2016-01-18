import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.StringTokenizer;

public class refine {
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
         FileReader inputFile = new FileReader("conf/new(1).csv");
         BufferedReader bufferReader = new BufferedReader(inputFile);

 		FileWriter fw = new FileWriter("conf/cleanppty1.txt");
 		
 		BufferedWriter output = new BufferedWriter(fw);
 	    String line;
         
        while( ( line = bufferReader.readLine() )!= null)
        {         		
       	line=line.trim();       		
		StringTokenizer t = new StringTokenizer(line,",");
		String a = "";
		a=t.nextToken().trim();
		int n = 0;
		String b = t.nextToken().trim();
		String c = "";
		c=t.nextToken().trim();
			if(!b.startsWith("606"))
			{		n = isNumeric(b);
			if(n!=-1)
			{
				n = 60600 + n;
				b = ""+n+"";
			}
			}
			if(!c.startsWith("20") 
					&& !c.startsWith("19"))
			{
				n = isNumeric(c);
				if(n!=-1)
				{
					if(n<50)
					{
						n = 2000 + n;
					}
					else
					{
						n = 1900+n;
					}
					c = ""+n+"";
					
				}
			}
			String l = a + "," + b + "," + c;
			output.write(l + "\n");
		}
			output.close();
    		bufferReader.close();
    	}
    		catch(Exception e){
    	          System.out.println("Error while reading file line by line:" + e.getMessage());                      
    	       }
    }
    }