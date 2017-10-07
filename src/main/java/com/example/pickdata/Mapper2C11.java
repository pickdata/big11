package com.example.pickdata;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;
import org.apache.hadoop.io.LongWritable;
//import org.apache.hadoop.mapreduce.Mapper;

import com.pickdata.beta.Score;
import com.pickdata.parser.BigContestParser;

public class Mapper2C11 implements Mapper<LongWritable, Text, Text, Text> {

	Text outputKey = new Text();
	Text outValue = new Text();
	Score scoreClass = new Score();
	String columnName = "c11";
	
	@Override
	public void configure(JobConf arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void close() throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void map(LongWritable key, Text value, OutputCollector<Text, Text> output, Reporter reporter) throws IOException {

		BigContestParser parser = new BigContestParser(value);
		String customerValue = (String) parser.map.get(columnName);

		outputKey.set(parser.map.get("id") + "");
		outValue.set(scoreClass.scoreCal(columnName, customerValue) + "");

		output.collect(outputKey, outValue);
	}
		

	/*
	@Override
	protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		
		BigContestParser parser = new BigContestParser(value);
		String customerValue = (String) parser.map.get(columnName);

		outputKey.set(parser.map.get("id") + "");
		outValue.set(scoreClass.scoreCal(columnName, customerValue) + "");

		context.write(outputKey, outValue);
	}
*/

	
}
