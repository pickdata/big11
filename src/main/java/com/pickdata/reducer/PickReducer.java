package com.pickdata.reducer;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

public class PickReducer implements Reducer<Text, DoubleWritable, Text, DoubleWritable> {

	// 리듀스 출력 key, value
	private Text outputKey = new Text();
	private DoubleWritable outValue = new DoubleWritable();

	private String id = "";
	private String nextId = "";

	private double totalSum = 0;

	@Override
	public void reduce(Text key, Iterator<DoubleWritable> values, OutputCollector<Text, DoubleWritable> output,
			Reporter reporter) throws IOException {

		if (getId() == null) {
			String[] columns = key.toString().split(",");
			setId(columns[0]);
			setTotalSum(values.next().get());
			System.out.println(getId() + ", totalsum = " + totalSum);
		} else {
			String[] columns = key.toString().split(",");
			setNextId(columns[0]);
			if (getId().equals(getNextId())) {
				setTotalSum(getTotalSum() + values.next().get());
			} else {
				if (values.hasNext()) {
					setId(getNextId());
					setTotalSum(0);
				}
			}
		}
	}

	@Override
	public void configure(JobConf job) {

	}

	@Override
	public void close() throws IOException {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getTotalSum() {
		return totalSum;
	}

	public void setTotalSum(double totalSum) {
		this.totalSum = totalSum;
	}

	public String getNextId() {
		return nextId;
	}

	public void setNextId(String nextId) {
		this.nextId = nextId;
	}
}