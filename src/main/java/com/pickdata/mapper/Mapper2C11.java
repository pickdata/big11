package com.pickdata.mapper;


import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import com.pickdata.TaggedKey.TaggedKey;


public class Mapper2C11 extends Mapper<Text, Text, TaggedKey,Text> {
	
	TaggedKey outputKey = new TaggedKey();
	Text outValue = new Text();
	
	@Override
	protected void map(Text key, Text value, Context context)
			throws IOException, InterruptedException {
		
		context.write(outputKey, outValue);
	}
	
}
