package com.pickdata.seq;

import java.util.Arrays;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.SequenceFile.CompressionType;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.compress.GzipCodec;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.SequenceFileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

import com.pickdata.mapper.Mapper1T13;
import com.pickdata.mapper.Mapper4C9;

public class SequenceFileCreatorMap4C9 extends Configured implements Tool {

	static Log log = LogFactory.getLog(SequenceFileCreatorMap4C9.class);
	
	public static void main(String[] args) throws Exception {
		if(args.length == 0){
			ToolRunner.printGenericCommandUsage(System.out);
		
			args = new String[] {"-fs", "hdfs://bigdata01:9000",
									"-jt", "bigdata01:9001"
						};
			
			System.out.println(Arrays.toString(args));
			log.info(Arrays.toString(args));
	
		}
		//분산 캐시 역할
		ToolRunner.run(new SequenceFileCreatorMap4C9(), args);

	}

	@Override
	public int run(String[] arg0) throws Exception {
		
		Job job = Job.getInstance(getConf(),"SequenceFileCreator");
		
		job.setJarByClass(SequenceFileCreatorMap4C9.class);
		FileInputFormat.setInputPaths(job, "/home/java/pickdata/sample/sample_data.csv");

		job.setInputFormatClass(TextInputFormat.class);
		
		
		/////////////////////////맵리듀스/////////////////////
		job.setMapperClass(Mapper4C9.class);
		
			//노리듀서 맵리듀스프로그램
		job.setNumReduceTasks(0);

			//no reduce이기 때문에 출력 key-value 정의
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Text.class);
		/////////////////////////맵리듀스/////////////////////
		
		//sequence file로 출력: binary 형태
		job.setOutputFormatClass(SequenceFileOutputFormat.class);
		
		Path outputDir = new Path("/home/java/pickdata/sample/sequence/c9");
		FileOutputFormat.setOutputPath(job, outputDir);
		
		
		/*
		 * 시퀀스 파일 압축
		 *  압축할 job, 코덱 클래스, 압축 단위 지정
		 */
		SequenceFileOutputFormat.setCompressOutput(job, true);
		SequenceFileOutputFormat.setOutputCompressorClass(job, GzipCodec.class);
		SequenceFileOutputFormat.setOutputCompressionType(job, CompressionType.BLOCK);	//압축 단위 설정
				
		FileSystem hdfs = FileSystem.get(getConf());
		hdfs.delete(outputDir, true);
		
		job.waitForCompletion(true);
		
		return 0;
	}

}
