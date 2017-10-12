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
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.SequenceFileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

import com.pickdata.mapper.PickdataMapper;
import com.pickdata.reducer.PickdataReducer;
import com.pickdata.taggedKey.GroupKeyPartitioner;
import com.pickdata.taggedKey.TaggedGroupKeyComparator;
import com.pickdata.taggedKey.TaggedKey;

//import old.pickdata.mapper.PickdataMapper;

public class PickdataJob extends Configured implements Tool {

	static Log log = LogFactory.getLog(PickdataJob.class);

	public static void main(String[] args) throws Exception {

		ToolRunner.run(new PickdataJob(), args);
	}

	@Override
	public int run(String[] arg0) throws Exception {
		
		Job job = Job.getInstance(getConf(),"Pickdata MapReduce");
		job.setJarByClass(PickdataJob.class);
		
		//input 파일 설정
		Path inpath = new Path("/home/java/pickdata/sample/Data_set.csv");
		FileInputFormat.setInputPaths(job, inpath);

		//mapper 설정
		job.setMapperClass(PickdataMapper.class);
		job.setMapOutputKeyClass(TaggedKey.class);
		job.setMapOutputValueClass(DoubleWritable.class);
		
		//groupkey 설정
		job.setGroupingComparatorClass(TaggedGroupKeyComparator.class);
		job.setPartitionerClass(GroupKeyPartitioner.class);
		
		//reducer 설정
		job.setNumReduceTasks(1);
		job.setReducerClass(PickdataReducer.class);
		job.setOutputKeyClass(TaggedKey.class);
		job.setOutputValueClass(DoubleWritable.class);
		
		//SequenceFile 설정
		job.setOutputFormatClass(SequenceFileOutputFormat.class);
		SequenceFileOutputFormat.setCompressOutput(job, true);
		SequenceFileOutputFormat.setOutputCompressorClass(job, GzipCodec.class);
		SequenceFileOutputFormat.setOutputCompressionType(job, CompressionType.BLOCK);	//압축 단위 설정
		
		//최종 출력 파일 설정
		Path outputDir = new Path("/home/java/pickdata/sample/job/all");
		FileOutputFormat.setOutputPath(job, outputDir);

		FileSystem hdfs = FileSystem.get(getConf());
		hdfs.delete(outputDir, true);
		
		job.waitForCompletion(true);
		
		return 0;
	}

}
