package com.pickdata.reducer;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.mapreduce.Reducer;

import com.pickdata.taggedKey.TaggedKey;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PickdataReducer3 extends Reducer<TaggedKey, DoubleWritable, TaggedKey, DoubleWritable> {

	static Log log = LogFactory.getLog(PickdataReducer3.class);

	// 리듀스 출력 key, value
	private TaggedKey outputKey = new TaggedKey();
	private DoubleWritable outValue = new DoubleWritable();

	@Override
	protected void reduce(TaggedKey key, Iterable<DoubleWritable> values, Context context)
			throws IOException, InterruptedException {

		double totalSum = 0;
		String nextColumn = key.getTag();
		for (DoubleWritable v : values) {

			if (nextColumn != key.getTag()) {
				totalSum += v.get();
				outValue.set(totalSum);
				outputKey.setId(key.getId());
				outputKey.setTag("");
				log.info("-----------------------------------------");
				log.info("totalSum = "+totalSum);
				log.info("-----------------------------------------");
				
				context.write(outputKey, outValue);
			}
			totalSum += v.get();
			System.out.println(v.get());
			nextColumn = key.getTag();
			System.out.println(key.getTag());
		}

	}

}