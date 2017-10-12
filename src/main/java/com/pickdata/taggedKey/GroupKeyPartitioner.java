package com.pickdata.taggedKey;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.mapreduce.Partitioner;

public class GroupKeyPartitioner extends Partitioner<TaggedKey, DoubleWritable>{

	@Override
	public int getPartition(TaggedKey key, DoubleWritable value, int numPartitions) {
		int hash = key.getId().hashCode();
		int partition = hash % numPartitions;
		
		return partition;
	}

}
