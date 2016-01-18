package analysis3;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;

public class crimeScoreMain{
    
  public static void main(String[] args) throws Exception {
    JobConf job = new JobConf(crimeScoreMain.class);
    job.setJobName("crimeScore");
    
    job.setOutputKeyClass(Text.class);
    job.setOutputValueClass(IntWritable.class);

    job.setInputFormat(TextInputFormat.class);
    job.setOutputFormat(TextOutputFormat.class);
 
    job.setOutputKeyClass(Text.class);
    job.setOutputValueClass(IntWritable.class);

    job.setMapperClass(crimeScoreMapper.class);
    job.setReducerClass(crimeScoreReducer.class);

    FileInputFormat.setInputPaths(job, new Path("conf/merged(1).txt"));
    FileOutputFormat.setOutputPath(job, new Path("conf/crimesumm22"));

    JobClient.runJob(job);
    crimeTrends c = new crimeTrends();
    c.getCrimeTrends();
    
  }
}