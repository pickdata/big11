package com.pickdata.reducer;

import java.io.IOException;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

import com.example.pickdata.ColumnList;
import com.pickdata.taggedKey.TaggedKey;

public class PickReducer2 implements Reducer<TaggedKey, DoubleWritable, Text, DoubleWritable> {

	static Log log = LogFactory.getLog(PickReducer2.class);

	// 리듀스 출력 key, value
	private TaggedKey outputKey = new TaggedKey();
	private DoubleWritable outValue = new DoubleWritable();

	private Integer id = null;
	private Integer nextId = null;

	private double totalSum = 0;

	@Override
	public void reduce(TaggedKey key, Iterator<DoubleWritable> values, OutputCollector<Text, DoubleWritable> output,
			Reporter reporter) throws IOException {

		if (getId() == null) {
			setId(key.getId());
			setTotalSum(values.next().get());
			log.info(getId() + ", totalsum = " + totalSum);

		} else {
			setNextId(key.getId());

			if (getId().equals(getNextId())) {
				setTotalSum(getTotalSum() + values.next().get());


			} else {
				log.info("#################");
				log.info("output : " + getId() + ", totalsum = " + totalSum);
				log.info("#################");
				output.collect(new Text(getId() + ""), new DoubleWritable(getTotalSum()));
				setId(getNextId());
				setTotalSum(values.next().get());
			}
		}
		if (key.getId() == 102252
				&& key.getTag().equals(ColumnList.columnName[ColumnList.columnName.length - 1])) {
			log.info("#################");
			log.info("output : " + getId() + ", totalsum = " + totalSum);
			log.info("#################");
			output.collect(new Text(getId() + ""), new DoubleWritable(getTotalSum()));
		}

	}

	@Override
	public void configure(JobConf job) {

	}

	@Override
	public void close() throws IOException {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getTotalSum() {
		return totalSum;
	}

	public void setTotalSum(double totalSum) {
		this.totalSum = totalSum;
	}

	public Integer getNextId() {
		return nextId;
	}

	public void setNextId(Integer nextId) {
		this.nextId = nextId;
	}
}