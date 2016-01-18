import java.io.IOException;
import java.util.StringTokenizer;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;
 
    public class serviceRequestMapper extends MapReduceBase implements Mapper<LongWritable, Text, Text, IntWritable> {
              
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
            String zip = data[7];
            zip = zip.trim();
            if(!zip.equals("") && !zip.equals("0"))
            output.collect(new Text(zip), new IntWritable(1));
        }
            else{
            	output.collect(new Text("ProBLEMMMMMMMMMMMMMMMMMMMMM"), new IntWritable(1));
            }
        }
       }