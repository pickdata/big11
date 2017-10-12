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

		double sum = 0;
		for (DoubleWritable v : values) {
			sum += v.get();
		}
		log.info("-----------------------------------------");
		log.info("sum = "+sum);
		log.info("-----------------------------------------");
		outValue.set(sum);
		outputKey.setId(key.getId());
		outputKey.setTag("");
		context.write(outputKey, outValue);
	}

}