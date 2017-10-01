package com.pickdata.TaggedKey;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

import com.pickdata.*;

public class TaggedGroupKeyComparator extends WritableComparator{

	protected TaggedGroupKeyComparator() {
		super(TaggedKey.class,true);

	}
	@Override
	public int compare(WritableComparable a, WritableComparable b) {
		TaggedKey key1 = (TaggedKey)a;
		TaggedKey key2 = (TaggedKey)b;

		return key1.getId().compareTo(key2.getId());
		
	}
}
