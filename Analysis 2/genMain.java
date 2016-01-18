 	package analysis2;
 	
 	import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;
    
    public class genMain{
        
      public static void main(String[] args) throws Exception {
        JobConf job = new JobConf(genMain.class);
        job.setJobName("genCountYear");
        
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
 
        job.setInputFormat(TextInputFormat.class);
        job.setOutputFormat(TextOutputFormat.class);
     
        job.setMapperClass(genMapper.class);
        job.setReducerClass(genReducer.class);
    
        FileInputFormat.setInputPaths(job, new Path("conf/storesforCrime"));
        FileOutputFormat.setOutputPath(job, new Path("conf/mr1output"));
 
        JobClient.runJob(job);        
        job.setJobName("genMaxYear");
        
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);
 
        job.setInputFormat(KeyValueTextInputFormat.class);
        job.setOutputFormat(TextOutputFormat.class);
     
        job.setMapperClass(genMapper2.class);
        job.setReducerClass(genReducer2.class);
    
        FileInputFormat.setInputPaths(job, new Path("conf/mr1output/part-00000"));
        FileOutputFormat.setOutputPath(job, new Path("conf/mr2output"));
 
        JobClient.runJob(job);  
        }
    }