package com.example.pickdata;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.LongWritable;
//import org.apache.hadoop.mapreduce.Mapper;

import com.pickdata.beta.Score;
import com.pickdata.parser.BigContestParser;

public class Mapper2C11 implements Mapper<LongWritable, Text, Text, DoubleWritable> {

	Text outputKey = new Text();
	DoubleWritable outValue = new DoubleWritable();
	Score scoreClass = new Score();
	String columnName = "c11";
	Double score;


	@Override
	public void map(LongWritable key, Text value, OutputCollector<Text, DoubleWritable> output, Reporter reporter) throws IOException {

		BigContestParser parser = new BigContestParser(value);
		String customerValue = (String) parser.map.get(columnName);

		//key set
		outputKey.set(parser.map.get("id") + ","+ columnName);
		System.out.println("c11 id = " + parser.map.get("id"));

		//value set
		score = scoreClass.scoreCal(columnName, customerValue);
		outValue.set(score);
		System.out.println("c11  customerValue" + customerValue);

		output.collect(outputKey, outValue);
	}
	
	@Override
	public void configure(JobConf arg0) {
		
	}

	@Override
	public void close() throws IOException {
		
	}
	
}
