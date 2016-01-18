package analysis2;
import java.io.IOException;
import java.util.StringTokenizer;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;
 
    public class genMapper2 extends MapReduceBase implements Mapper<Text, Text, Text, Text> {
              
        public void map(Text key, Text value, OutputCollector<Text, Text> output, Reporter reporter) throws IOException {
        
        	StringTokenizer tokenizer = new StringTokenizer(key.toString(), ",");
            System.out.println("Token Size:" +tokenizer.countTokens());
            if(tokenizer.countTokens()!=0)
            {
            String[] data = new String[tokenizer.countTokens()];            
            int i=0;
            while(tokenizer.hasMoreTokens())
            { 
                data[i]=tokenizer.nextToken();
                i++;
            }
            String key1 = data[0];
            String value1 = data[1]+","+value.toString();
            output.collect(new Text(key1), new Text(value1));
        }
        }
       }