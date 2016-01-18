package analysis2;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;
 
      public class genReducer2 extends MapReduceBase implements Reducer<Text, Text, Text, IntWritable> {
             
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
          public void reduce(Text key, Iterator<Text> values, OutputCollector<Text, IntWritable> output, Reporter reporter) throws IOException {
         
         int count = 0, i=0,j=0;
         ArrayList<String> valList = new ArrayList<String>();
         while(values.hasNext()){
         valList.add(values.next().toString());
         count++;
         }
         int[][] array = new int[count][2];
         for(i=0;i<count;i++)
    	 { 
        	 StringTokenizer token = new StringTokenizer(valList.get(i),",");
        	 while(token.hasMoreTokens()){
        		 for(j=0;j<2;j++)
            	 { 
        		int d = isNumeric(token.nextToken());
        		array[i][j]=d;        	 
        	 }
        	 }
         }
         int max = array[0][1];
         int maxyear = array[0][0];
         for(i=0;i<count;i++)
        	 if(array[i][1]>max)
        	 {	 max=array[i][1];
        	 	 maxyear = array[i][0];
        	 }
         output.collect(key, new IntWritable(maxyear));
       } 
      }