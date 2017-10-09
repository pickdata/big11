//package com.pickdata.mapper;
//
//
//import java.io.IOException;
//
//import org.apache.hadoop.io.IntWritable;
//import org.apache.hadoop.io.Text;
//import org.apache.hadoop.mapreduce.Mapper;
//
//import com.pickdata.TaggedKey.TaggedKey;
//import com.pickdata.beta.Score;
//import com.pickdata.parser.BigContestParser;
//
//
//public class Mapper3C3 extends Mapper<Text, Text, Text,Text> {
//	
//	Text outputKey = new Text();
//	Text outValue = new Text();
//	Score scoreClass = new Score();
//	String columnName = "c3";
//	
//	@Override
//	protected void map(Text key, Text value, Context context)
//			throws IOException, InterruptedException {
//		BigContestParser parser = new BigContestParser(value);
//		
//		String customerValue = (String)parser.map.get(columnName);
//		
//		outputKey.set(parser.map.get("id") + "");
//		outValue.set(scoreClass.scoreCal(columnName, customerValue) + "");
//		 
//		context.write(outputKey, outValue);
//		
//	}
//	
//}
