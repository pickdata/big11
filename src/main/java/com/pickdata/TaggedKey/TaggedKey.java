package com.pickdata.TaggedKey;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Objects;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableUtils;


public class TaggedKey implements WritableComparable<TaggedKey>{
	String id;
	Integer tag;
	
	public TaggedKey(){
		
	}
	public TaggedKey(String id, Integer tag){
		this.id = id;
		this.tag = tag;
	}
	
	@Override
	public int hashCode() {
		
		return Objects.hash(id,tag);
	}
	
	@Override
	public String toString() {
		return id + "," + tag;
	}

	@Override
	public void write(DataOutput out) throws IOException {
		WritableUtils.writeString(out, id);
		out.writeInt(tag);
	}

	@Override
	public void readFields(DataInput in) throws IOException {
		id = WritableUtils.readString(in);
		tag = in.readInt();
	}

	@Override
	public int compareTo(TaggedKey o) {
		int cmp = id.compareTo(o.id);
		
		if (cmp==0){
			cmp = tag.compareTo(o.tag);
		}
		
		return cmp;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getTag() {
		return tag;
	}
	public void setTag(Integer tag) {
		this.tag = tag;
	}		
}
