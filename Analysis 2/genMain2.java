 	package analysis2;
 	
 	import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;
    
    public class genMain2{
        
      public static void main(String[] args) throws Exception {
        JobConf job = new JobConf(genMain.class);
        job.setJobName("genRentTrend");
        
        // deleting extra zip codes to make equal number of rows for both files to be merged
        
        MergeGenAndRentAvg m = new MergeGenAndRentAvg();
        m.mergeFiles();
        
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);
 
        job.setInputFormat(TextInputFormat.class);
        job.setOutputFormat(TextOutputFormat.class);
     
        job.setMapperClass(genMapper3.class);
        job.setReducerClass(genReducer3.class);
    
        FileInputFormat.setInputPaths(job, new Path("conf/mergedmaxyearandavg.txt"));
        FileOutputFormat.setOutputPath(job, new Path("conf/mr3output"));
 
        JobClient.runJob(job);  
      }
    }