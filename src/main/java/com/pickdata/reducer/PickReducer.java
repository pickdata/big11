package com.pickdata.reducer;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import com.pickdata.TaggedKey.TaggedKey;

public class PickReducer extends Reducer<TaggedKey, Text, Text, Text> {

	Text outputKey = new Text();
	Text outValue = new Text();
	
	@Override
	protected void reduce(TaggedKey key, Iterable<Text> values, Context context)
			throws IOException, InterruptedException {
		
		// id 가 같은 값들끼리 리듀스 입력으로 들어옴.
		// " id 1,map 1, T13 Score" 
		// " id 1,map 2, C11 Score"
		// " id 1,map 3, C3 Score"
		// " id 1,map 4, C9 Score"
		// " id 1,map 5, I19 Score"
		// " id 2,map 1, T13 Score"
		// " id 2,map 2, C11 Score"
		// " id 2,map 3, C3 Score"
		// " id 2,map 4, C9 Score"
		// " id 2,map 5, I19 Score"
		
		// 첫번째 있는 레코드의 id를 조회
		Iterator<Text> iterator = values.iterator();

		// id가 같은 나머지 레코드를 조회
		String[] columnScore ={};
		int sum = 0;
		while(iterator.hasNext()){
			Text record = iterator.next();
			// id,column,Score
			// columns
			// 1,T13,800
			columnScore = record.toString().split(",");
			
			// y = t13
			// y = t13 + c11
			// y = t13 + c11 + c3
			// y = t13 + c11 + c3 + c9
			// y = t13 + c11 + c3 + c9 + i19
			sum += Integer.parseInt(columnScore[2]);
		}

		outputKey.set(key.getId());
		outValue.set(sum+"");
		context.write(outputKey, outValue);
		
	}

}
