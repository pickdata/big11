package com.pickdata.mapfile;

import java.util.Arrays;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.SequenceFile.CompressionType;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.compress.GzipCodec;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.MapFileOutputFormat;
import org.apache.hadoop.mapred.SequenceFileInputFormat;
import org.apache.hadoop.mapred.SequenceFileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class MapFileCreator2C11 extends Configured implements Tool {

	static Log log = LogFactory.getLog(MapFileCreator2C11.class);

	public static void main(String[] args) throws Exception {
		if (args.length == 0) {

			args = new String[] { "-fs", "hdfs://bigdata01:9000", "-jt", "bigdata01:9001", };
			System.out.println(Arrays.toString(args));
			log.info(Arrays.toString(args));
		}
		ToolRunner.run(new MapFileCreator2C11(), args);
	}

	@Override
	public int run(String[] args) throws Exception {

		JobConf job = new JobConf(getConf());
		job.setJobName("MapFileCreator C11");
//		job.setJarByClass(MapFileCreator2C11.class);

		FileInputFormat.addInputPaths(job, "/home/java/pickdata/sample/sequence/all");
		job.setInputFormat(SequenceFileInputFormat.class);

//		job.setNumReduceTasks(3);
		
		job.setOutputKeyClass(Text.class);
//		job.setOutputValueClass(Text.class);
		/////////////////////////////////////


		// map file로 출력: map 형식으로 저장
		job.setOutputFormat(MapFileOutputFormat.class);
		Path outputDir = new Path("/home/java/pickdata/sample/mapfile/all");
		FileOutputFormat.setOutputPath(job, outputDir);

		/*
		 * 맵파일도 시퀀스로 절절히 두고 검색할 때는 관계형 디비처럼 인덱싱함 출력: sequenceFile로 압축 --> 필수는
		 * 아닌거.. 퍼포먼스 & 효율 고려 ..
		 */
		SequenceFileOutputFormat.setCompressOutput(job, true);
		SequenceFileOutputFormat.setOutputCompressorClass(job, GzipCodec.class);
		SequenceFileOutputFormat.setOutputCompressionType(job, CompressionType.BLOCK);

		FileSystem hdfs = FileSystem.get(getConf());
		hdfs.delete(outputDir, true);

		JobClient.runJob(job);

		hdfs.delete(new Path(outputDir.toString() + "/_SUCCESS"), true);
		hdfs.delete(new Path(outputDir.toString() + "/_logs"), true);

		hdfs.close();
		return 0;
	}
}
