package com.example.pickdata;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

import com.pickdata.beta.Score;
import com.pickdata.parser.BigContestParser;
import com.pickdata.taggedKey.TaggedKey;

public class Mapper5I19 implements Mapper<LongWritable, Text, TaggedKey, DoubleWritable> {

	TaggedKey outputKey = new TaggedKey();
   DoubleWritable outValue = new DoubleWritable();
   Score scoreClass = new Score();
   String[] columnName = {"i19","c11"};
   double score;

   @Override
   public void map(LongWritable key, Text value, OutputCollector<TaggedKey, DoubleWritable> output, Reporter reporter)
         throws IOException {

      BigContestParser parser = new BigContestParser(value);
      
      for (int i=0;i<columnName.length;i++){
	      String customerValue = (String) parser.map.get(columnName[i]);
	      System.out.println("customerValue = " + customerValue);
	
	      score = scoreClass.scoreCal(columnName[i], customerValue);
	
	      //key set
	      outputKey.setId(Integer.parseInt(parser.map.get("id")));
	      outputKey.setTag(columnName[i]);
	      System.out.println("id = " + parser.map.get("id") + "");
	      
	      //value set
	      outValue.set(score);
	      System.out.println("Score = " + scoreClass.scoreCal(columnName[i], customerValue) + "");
	
	      output.collect(outputKey, outValue);
	      System.out.println("##########");
      }
   }
   @Override
   public void configure(JobConf arg0) {

   }

   @Override
   public void close() throws IOException {

   }
}