package com.pickdata.mapper;


import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import com.pickdata.TaggedKey.TaggedKey;


public class Mapper5I19 extends Mapper<Text, Text, TaggedKey, Text> {
	
	@Override
	protected void map(Text key, Text value, Context context)
			throws IOException, InterruptedException {
		
//		context.write(key, value);
	}
	
}