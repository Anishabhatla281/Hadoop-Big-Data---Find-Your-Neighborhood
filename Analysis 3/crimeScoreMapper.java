package analysis3;

import java.io.IOException;
import java.util.StringTokenizer;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;
 
    public class crimeScoreMapper extends MapReduceBase implements Mapper<LongWritable, Text, Text, IntWritable> {
              
        public void map(LongWritable key, Text value, OutputCollector<Text, IntWritable> output, Reporter reporter) throws IOException {

            StringTokenizer tokenizer = new StringTokenizer(value.toString(), ",");
            if(tokenizer.countTokens()!=0)
            {
            String[] data = new String[tokenizer.countTokens()];            
            int i=0;
            while(tokenizer.hasMoreTokens())
            { 
                data[i]=tokenizer.nextToken();
                i++;
            }
            String type = data[2];
            type = type.trim();
            int weight = 0;            
            if(type.equalsIgnoreCase("arson"))
           	{
            	weight = 2;
            }
            else if(type.equalsIgnoreCase("theft"))
            {
            	weight = 3;            	
            }
            else if(type.equalsIgnoreCase("assault"))
            {
            	weight = 2;
            }
            else if(type.equalsIgnoreCase("battery"))
            {
            	weight = 4;            	
            }
            else if(type.equalsIgnoreCase("robbery"))
            {
            	weight = 3;            	
            }
            else if(type.equalsIgnoreCase("burglary"))
            {
            	weight = 3;            	
            }
            else if(type.equalsIgnoreCase("gambling"))
            {
            	weight = 1;            	
            }
            else if(type.equalsIgnoreCase("homicide"))
            {
            	weight = 4;            	
            }
            else if(type.equalsIgnoreCase("stalking"))
            {
            	weight = 1;            	
            }
            else if(type.equalsIgnoreCase("narcotics"))
            {
            	weight = 2;            	
            }
            else if(type.equalsIgnoreCase("obscenity"))
            {
            	weight = 1;            	
            }
            else if(type.equalsIgnoreCase("kidnapping"))
            {
            	weight = 3;            	
            }
            else if(type.equalsIgnoreCase("sex offense"))
            {
            	weight = 3;            	
            }
            else if(type.equalsIgnoreCase("intimidation"))
            {
            	weight = 2;            	
            }
            else if(type.equalsIgnoreCase("non - criminal"))
            {
            	weight = 1;            	
            }
            else if(type.equalsIgnoreCase("prostitution"))
            {
            	weight = 2;            	
            }
            else if(type.equalsIgnoreCase("other offense"))
            {
            	weight = 1;            	
            }
            else if(type.equalsIgnoreCase("non-criminal"))
            {
            	weight = 1;            	
            }
            else if(type.equalsIgnoreCase("criminal damage"))
            {
            	weight = 2;            	
            }
            else if(type.equalsIgnoreCase("public indecency"))
            {
            	weight = 2;            	
            }
            else if(type.equalsIgnoreCase("criminal trespass"))
            {
            	weight = 2;            	
            }
            else if(type.equalsIgnoreCase("human trafficking"))
            {
            	weight = 3;            	
            }
            else if(type.equalsIgnoreCase("weapons violation"))
            {
            	weight = 2;            	
            }
            else if(type.equalsIgnoreCase("deceptive practice"))
            {
            	weight = 2;            	
            }
            else if(type.equalsIgnoreCase("crim sexual assault"))
            {
            	weight = 4;            	
            }            
            else if(type.equalsIgnoreCase("motor vehicle theft"))
            {
            	weight = 2;            	
            }
            else if(type.equalsIgnoreCase("liquor law violation"))
            {
            	weight = 1;            	
            }
            else if(type.equalsIgnoreCase("public peace violation"))
            {
            	weight = 1;            	
            }
            else if(type.equalsIgnoreCase("other narcotic violation"))
            {
            	weight = 1;            	
            }
            else if(type.equalsIgnoreCase("offense involving children"))
            {
            	weight = 3;            	
            }
            else if(type.equalsIgnoreCase("interference with public officer"))
            {
            	weight = 1;            	
            }
            else if(type.equalsIgnoreCase("concealed carry license violation"))
            {
            	weight = 2;            	
            }
            
            if(data[3].trim().startsWith("60"))
            	output.collect(new Text(data[3].trim()), new IntWritable(weight));
            else
            	output.collect(new Text(data[4].trim() +"," + data[3].trim()),new IntWritable(weight));
        }
            else{
            	output.collect(new Text("ProBLEMMMMMMMMMMMMMMMMMMMMM"), new IntWritable(1));
            }
        }
       }