package com.example.pickdata;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;
//import org.apache.hadoop.mapreduce.Mapper;

import com.pickdata.beta.Score;
import com.pickdata.parser.BigContestParser;

public class Mapper5I19 implements Mapper<LongWritable, Text, Text, Text> {
	// public class Mapper5I19 extends Mapper<Text, Text, Text, Text> {

	Text outputKey = new Text();
	Text outValue = new Text();
	Score scoreClass = new Score();
	String columnName = "i19";
	double score;

	@Override
	public void configure(JobConf arg0) {

	}

	@Override
	public void close() throws IOException {

	}

	@Override
	public void map(LongWritable key, Text value, OutputCollector<Text, Text> output, Reporter reporter)
			throws IOException {

		BigContestParser parser = new BigContestParser(value);
		
		String customerValue = (String) parser.map.get(columnName);
//		if("0".equals(customerValue))
//			customerValue = "0.0";
		
		System.out.println("id = " + parser.map.get("id") + "");
		System.out.println("customerValue = " + customerValue);
		System.out.println("Score = " + scoreClass.scoreCal(columnName, customerValue) + "");
		
		score = scoreClass.scoreCal(columnName, customerValue);

		outputKey.set(parser.map.get("id") + "");
		outValue.set(score + "");

		output.collect(outputKey, outValue);
	}

	/*
	 * @Override protected void map(Text key, Text value, Context context)
	 * throws IOException, InterruptedException { BigContestParser parser = new
	 * BigContestParser(value);
	 * 
	 * // Paser를 통해 고객의 i19번째 범주값을 구한다. String customerValue = (String)
	 * parser.map.get(columnName);
	 * 
	 * // 고객의 id를 매퍼의 출력 키에 입력한다. outputKey.set(parser.map.get("id") + ""); //
	 * 고객의 점수를 점수클래스의 메소드를 호출하여 점수를 받아서 입력한다. // 옵셋 계산을 위한 컬럼명과, 고객의 범주값을 매개변수로
	 * 넘겨준다. outValue.set(scoreClass.scoreCal(columnName,customerValue) + "");
	 * 
	 * context.write(outputKey, outValue); }
	 */
}