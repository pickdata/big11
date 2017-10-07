package com.pickdata.job;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.MultipleOutputs;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;


import com.pickdata.TaggedKey.*;
import com.pickdata.mapper.Mapper1T13;
import com.pickdata.mapper.Mapper2C11;
import com.pickdata.mapper.Mapper3C3;
import com.pickdata.mapper.Mapper4C9;
import com.pickdata.mapper.Mapper5I19;
import com.pickdata.reducer.PickReducer;


public class PickdataJob extends Configured implements Tool {
	
	public static void main(String[] args) throws Exception {
		// 하둡 파일 시스템, 잡트레커 위치를 매개변수로 전달
		args = new String[] { "-fs", "hdfs://bigdata01:9000", 
								 "-jt", "bigdata01:9001"	};
		ToolRunner.run(new PickdataJob(), args);
	}
	
	@Override
	public int run(String[] args) throws Exception {
		
//		Configuration conf = getConf();
//		
//		Job job = new Job(conf, "Pickdata");
//		
//		job.setJarByClass(PickdataJob.class);
//		
//		
//
//		// ------------------------ Mapper Setting ---------------------------------- 
//		// T13,C11,C3,C9,I19
//		MultipleInputs.addInputPath(job, new Path("/hdfs 메인 소스.csv 주소 "), 
//				TextInputFormat.class, Mapper1T13.class);
//		
//		MultipleInputs.addInputPath(job, new Path("/hdfs 메인 소스.csv 주소 "), 
//				TextInputFormat.class, Mapper2C11.class);
//		
//		MultipleInputs.addInputPath(job, new Path("/hdfs 메인 소스.csv 주소 "), 
//				TextInputFormat.class, Mapper3C3.class);
//		
//		MultipleInputs.addInputPath(job, new Path("/hdfs 메인 소스.csv 주소 "), 
//				TextInputFormat.class, Mapper4C9.class);
//		
//		MultipleInputs.addInputPath(job, new Path("/hdfs 메인 소스.csv 주소 "), 
//				TextInputFormat.class, Mapper5I19.class);
//		
//		// Mapper 출력 키,밸류 타입 설정 
//		// Reduceside Join 시 필요한 복합키( Key "id,T13" / Text value ) 클래스 정의
//		job.setMapOutputKeyClass(TaggedKey.class);
//		job.setMapOutputValueClass(Text.class);
//		job.setSortComparatorClass(TaggedGroupKeyComparator.class);
//		
//		// -------------------------- Reducer Setting --------------------------------
//		job.setReducerClass(PickReducer.class);
//		
//		// Reducer의 출력 키, 밸류 타입 지정 Text,Text => ( "id" , "총점" 또는 y = 1 or y = 0 )
//		job.setOutputKeyClass(Text.class);
//		job.setOutputValueClass(Text.class);
//		
//		Path outputDir = new Path("/hdfs 리듀스 출력 저장 위치");
//		FileOutputFormat.setOutputPath(job, outputDir);
//		
//		
//		// hdfs 내의 파일이 있을 경우, 삭제 후 저장. (Overwrite) : 출력 파일 존재 시, 에러 발생.
//		FileSystem hdfs = FileSystem.get(conf);
//		hdfs.delete(outputDir, true);
//		hdfs.close();
//		
//		
//		return job.waitForCompletion(true) ? 0 : -1;

		return 0;
	}

}
