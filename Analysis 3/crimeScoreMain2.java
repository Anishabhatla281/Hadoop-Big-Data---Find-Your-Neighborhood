package analysis3;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;

public class crimeScoreMain2{
    
  public static void main(String[] args) throws Exception {
    JobConf job = new JobConf(crimeScoreMain.class);
    
    // deleting extra zip codes to make equal number of rows for both files to be merged
    
    mergeGenAndCrime m = new mergeGenAndCrime();
    m.getMergedFile();
    job.setJobName("crimeAnalysis");
    
    job.setOutputKeyClass(Text.class);
    job.setOutputValueClass(Text.class);

    job.setInputFormat(TextInputFormat.class);
    job.setOutputFormat(TextOutputFormat.class);
    
    job.setMapperClass(crimeScoreMapper2.class);
    job.setReducerClass(crimeScoreReducer2.class);

    FileInputFormat.setInputPaths(job, new Path("conf/mergedmaxyearandcrimetrends.txt"));
    FileOutputFormat.setOutputPath(job, new Path("conf/crimesumm33"));

    JobClient.runJob(job);    
  }
}