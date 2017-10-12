package com.pickdata.mapper;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import com.pickdata.beta.Beta;
import com.pickdata.columns.ColumnList;
import com.pickdata.parser.BigContestParser;
import com.pickdata.taggedKey.TaggedKey;

import lombok.extern.java.Log;

@Log
public class PickdataMapper extends Mapper<LongWritable, Text, TaggedKey, DoubleWritable> {

	TaggedKey outputKey = new TaggedKey();
	DoubleWritable outValue = new DoubleWritable();
	String[] columnName = ColumnList.columnName;
	double score;

	@Override
	protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

		Beta bt = new Beta();
		BigContestParser parser = new BigContestParser(value);

		for (int i = 0; i < columnName.length; i++) {
			String customerValue = (String) parser.map.get(columnName[i]);
			System.out.println("customerValue = " + customerValue);

			score = bt.score(columnName[i], customerValue);

			// key set
			outputKey.setId(Integer.parseInt(parser.map.get("id")));
			outputKey.setTag(columnName[i]);
			System.out.println("id = " + parser.map.get("id") + "");
			log.info("id = " + parser.map.get("id"));

			// value set
			outValue.set(score);
			System.out.println("Score = " + bt.score(columnName[i], customerValue) + "");

			context.write(outputKey, outValue);
			System.out.println("##########");
		}
	}
}