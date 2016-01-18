package analysis2;
import java.io.IOException;
import java.util.StringTokenizer;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;
 
    public class genMapper extends MapReduceBase implements Mapper<LongWritable, Text, Text, IntWritable> {
              
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
            String key1 = data[1]+","+data[2];
            output.collect(new Text(key1), new IntWritable(1));
        }
        }
       }