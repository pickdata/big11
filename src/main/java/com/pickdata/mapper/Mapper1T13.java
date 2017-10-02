package com.pickdata.mapper;


import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import com.pickdata.TaggedKey.TaggedKey;
import com.pickdata.beta.Score;
import com.pickdata.parser.BigContestParser;


public class Mapper1T13 extends Mapper<Text, Text, Text,Text> {
	
	@Override
	protected void map(Text key, Text value, Context context)
			throws IOException, InterruptedException {
		Text outputkey = new Text();
		Text outValue = new Text();
		Score scoreClass = new Score();
		String columnName = "T13";
		BigContestParser parser = new BigContestParser(value);
		
		String customerValue = (String)parser.map.get(columnName);
		
		outputkey.set(parser.map.get("id") + "");
		
		outValue.set(scoreClass.scoreCal("T13",customerValue) + "");
	
		context.write(outputkey, outValue);
	}
	
	
}
