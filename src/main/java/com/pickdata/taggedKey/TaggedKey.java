package com.pickdata.taggedKey;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Objects;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableUtils;

public class TaggedKey implements WritableComparable<TaggedKey> {

	Integer id;

	// 변수이름
	String tag;

	public TaggedKey() {

	}

	public TaggedKey(Integer id, String tag) {
		this.id = id;
		this.tag = tag;
	}

	@Override
	public int hashCode() {

		return Objects.hash(id, tag);
	}

	@Override
	public String toString() {
		return id + "," + tag;
	}

	@Override
	public void write(DataOutput out) throws IOException {
		out.writeInt(id);
		WritableUtils.writeString(out, tag);
	}

	@Override
	public void readFields(DataInput in) throws IOException {
		id = in.readInt();
		tag = WritableUtils.readString(in);
	}

	@Override
	public int compareTo(TaggedKey o) {
		int cmp = id.compareTo(o.id);

		if (cmp == 0) {
			cmp = tag.compareTo(o.tag);
		}

		return cmp;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}
}