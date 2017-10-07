package com.pickdata.mapper;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapreduce.Mapper;

import com.pickdata.beta.Score;
import com.pickdata.parser.BigContestParser;

public class Mapper2C11 extends Mapper<LongWritable, Text, Text, Text> {

	Text outputKey = new Text();
	Text outValue = new Text();
	Score scoreClass = new Score();
	String columnName = "c11";
	

	@Override
	protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		
		BigContestParser parser = new BigContestParser(value);
		String customerValue = (String) parser.map.get(columnName);

		outputKey.set(parser.map.get("id") + "");
		outValue.set(scoreClass.scoreCal(columnName, customerValue) + "");

		context.write(outputKey, outValue);
	}
	
}
