package com.pickdata.job;

//import java.util.Arrays;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.SequenceFile.CompressionType;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.compress.GzipCodec;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.SequenceFileOutputFormat;
import org.apache.hadoop.mapred.TextInputFormat;
import org.apache.hadoop.mapred.lib.MultipleInputs;
import org.apache.hadoop.mapred.lib.MultipleOutputs;
import org.apache.hadoop.mapreduce.Job;
//import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
//import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
//import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
//import org.apache.hadoop.mapreduce.lib.output.SequenceFileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

import com.pickdata.mapper.PickdataMapper2;
import com.pickdata.reducer.PickdataReducer;
import com.pickdata.taggedKey.TaggedKey;

//import old.pickdata.mapper.PickdataMapper;

public class PickdataJob extends Configured implements Tool {

	static Log log = LogFactory.getLog(PickdataJob.class);
	
	public static void main(String[] args) throws Exception {
		
		ToolRunner.run(new PickdataJob(), args);
	}
	@Override
	public int run(String[] arg0) throws Exception {
		
		JobConf job = new JobConf(PickdataJob.class);
		
		job.setJobName("Pickdata Job");
		
		Path inpath = new Path("/home/java/pickdata/sample/Data_set.csv");
		
//		MultipleInputs.addInputPath(job, inpath, TextInputFormat.class, PickdataMapper.class);
		MultipleInputs.addInputPath(job, inpath, TextInputFormat.class, PickdataMapper2.class);

		job.setMapOutputKeyClass(TaggedKey.class);
		job.setMapOutputValueClass(DoubleWritable.class);
		
		job.setNumReduceTasks(1);
		job.setReducerClass(PickdataReducer.class);
		
		//출력 키를 id(Text) - 점수(Text)로 설정
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(DoubleWritable.class);
		
		job.setOutputFormat(SequenceFileOutputFormat.class);
		
		Path outputDir = new Path("/home/java/pickdata/sample/sequence/all");
		FileOutputFormat.setOutputPath(job, outputDir);
		
		SequenceFileOutputFormat.setCompressOutput(job, true);
		SequenceFileOutputFormat.setOutputCompressorClass(job, GzipCodec.class);
		SequenceFileOutputFormat.setOutputCompressionType(job, CompressionType.BLOCK);	//압축 단위 설정
				
		FileSystem hdfs = FileSystem.get(getConf());
		hdfs.delete(outputDir, true);
		
		JobClient.runJob(job);
		
		return 0;
	}		
		
	/*

		Job job = Job.getInstance(getConf(),"SequenceFileCreator");
		
		job.setJarByClass(SequenceFileCreatorMap2C11.class);
		FileInputFormat.setInputPaths(job, "/home/java/pickdata/sample/sample_data.csv");

		job.setInputFormatClass(TextInputFormat.class);
		
		
		/////////////////////////맵리듀스/////////////////////
//		job.setMapperClass(Mapper2C11.class);
		
		MultipleInput
		
			//노리듀서 맵리듀스프로그램
		job.setNumReduceTasks(0);

		//출력 키를 id(Text) - 점수(Text)로 설정
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Text.class);
		/////////////////////////맵리듀스/////////////////////
		
		//sequence file로 출력: binary 형태
		job.setOutputFormatClass(SequenceFileOutputFormat.class);
		
		Path outputDir = new Path("/home/java/pickdata/sample/sequence/c11");
		FileOutputFormat.setOutputPath(job, outputDir);
		
		
		/*
		 * 시퀀스 파일 압축
		 *  압축할 job, 코덱 클래스, 압축 단위 지정
		SequenceFileOutputFormat.setCompressOutput(job, true);
		SequenceFileOutputFormat.setOutputCompressorClass(job, GzipCodec.class);
		SequenceFileOutputFormat.setOutputCompressionType(job, CompressionType.BLOCK);	//압축 단위 설정
				
		FileSystem hdfs = FileSystem.get(getConf());
		hdfs.delete(outputDir, true);
		
		job.waitForCompletion(true);
		
		 */


}
