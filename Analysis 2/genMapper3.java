package analysis2;
import java.io.IOException;
import java.util.StringTokenizer;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;
 
    public class genMapper3 extends MapReduceBase implements Mapper<LongWritable, Text, Text, Text> {
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
              
    	public static int isInteger(String str)
    	{int d=0;
    		try {
    			 d = Integer.parseInt(str);
    		}
    			catch(NumberFormatException nfe)
    		{
    			return -1;		
    		}
    		return d;
    		}
              
        public void map(LongWritable key, Text value, OutputCollector<Text, Text> output, Reporter reporter) throws IOException {

            StringTokenizer tokenizer = new StringTokenizer(value.toString(), ",");
            String key1 = "";
            int index=0;
            float sumofbefore5 = 0;
            float sumofafter5 = 0;
          
            if(tokenizer.countTokens()!=0)
            {
            String[] data = new String[tokenizer.countTokens()];            
            int i=0;
            while(tokenizer.hasMoreTokens())
            { 
                data[i]=tokenizer.nextToken();
                i++;
            }
            key1=data[0];
            int category =0,f=0;
            int d = isInteger(data[1]);
            if(d>1996 && d<2015){
            if((d >= 2001) && (d <= 2014)){
            index = d%100;
            f = 22-(15-index)-1;
            }
            else if((d>=1997) && (d<=1999)){
            	index = 100-(d%100);
                f = 22-(15+index)-1;
                }
            if(f>=6&&f<=16)
            	category =0;
            else if(f==17)
            	category=1;
            else if(f==18)
            	category =2;
            else if(f==19)
            	category=3;
            else if(f==20)
            	category=4;
            else if(f==3)
            	category = 4;
            else if(f==4)
            	category = 3;
            else if(f==5)
            	category = 2;
            else if(f==6)
            	category=1;
           for(i=(f-5+category);i<f;i++){
            	float a=isNumeric(data[i]);
            	sumofbefore5 += a;
            }
            for(i=(f+5-category);i>f;i--){
            	float b = isNumeric(data[i]);
            	sumofafter5 += b;            
            }            
            output.collect(new Text(key1), new Text(sumofbefore5 +","+ sumofafter5));
            }           
            }        
        }
       }