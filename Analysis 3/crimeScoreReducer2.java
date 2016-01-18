package analysis3;
import java.io.IOException;
import java.util.Iterator;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;
 
      public class crimeScoreReducer2 extends MapReduceBase implements Reducer<Text, Text, Text, IntWritable> {
    	  public static float isNumeric(String str)
      	{float d=0;
      		try {
      			 d = Float.parseFloat(str);
      		}
      			catch(NumberFormatException nfe)
      		{
      			return 0;		
      		}
      		return d;
      		}
          public void reduce(Text key, Iterator<Text> values, OutputCollector<Text, IntWritable> output, Reporter reporter) throws IOException {
            
        	  StringTokenizer token = new StringTokenizer(values.next().toString(),",");
        	  float sumbefore5 = isNumeric(token.nextToken());
        	  float sumafter5 = isNumeric(token.nextToken());
        	  String key1 = key.toString() + " " + sumbefore5 + " " + sumafter5;
        	  if(sumbefore5 < sumafter5)
        		  output.collect(new Text(key1), new IntWritable(1));
        	  else
        		  output.collect(new Text(key1), new IntWritable(-1));
       } 
      }