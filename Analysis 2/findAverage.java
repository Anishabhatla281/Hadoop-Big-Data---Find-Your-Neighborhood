package analysis2;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class findAverage {
 public static void main(String[] args)
 {
     try{
    	    
         FileReader inputFile = new FileReader("conf/filteredZillow.txt");

         BufferedReader bufferReader = new BufferedReader(inputFile);

         String line="";
         double sum=0, avg = 0;
         double[][] average = new double[54][21]; 
         int i=0, j=0;
         int w=14;
         int zip =0, year=1;
         for(int m=0;m<54;m++)
         {   
             line = bufferReader.readLine();
             sum=0;
             avg=0;
             year =1;
             int count =18;
            StringTokenizer t = new StringTokenizer(line, ",");
            ArrayList<String> l = new ArrayList<String>();
            while(t.hasMoreTokens())
                l.add(t.nextToken());
            for(i=5;i<14;i++)
                {
                    sum += Double.parseDouble(l.get(i));
                }
            avg = sum/9.0;
            average[zip][0]=Double.parseDouble(l.get(0));
            average[zip][year++] = (double)Math.round(avg*10)/10;
            w=14;
            for(int k=0;k<count;k++)
            {    sum=0; avg=0;
                for(i = 0;i<12;i++){
                sum += Double.parseDouble(l.get(w++));
                }
                avg = sum/12.0;
                average[zip][year++]=(double)Math.round(avg*10)/10;
            }
            sum=0; avg=0;
            for(int o=230;o<=238;o++)
            {
                sum += Double.parseDouble(l.get(w++));
            }   
            avg = sum/9.0;
            average[zip++][year]=(double)Math.round(avg*10)/10;
         }
        bufferReader.close();
        PrintStream out = new PrintStream(new File("conf/outputt.txt"));
         for(i=0;i<54;i++)
            {
             for(j=0;j<21;j++)            
            {
                if(j==20)
                    out.print(average[i][j]);
                else
                    out.print(average[i][j]+ ", ");
            }
             out.println();
            }
         out.close();
     }
          catch(Exception e){
              System.out.println("Error while reading file line by line:" + e.getMessage());                     
             
          }
 }
}