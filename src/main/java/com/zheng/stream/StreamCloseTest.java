package com.zheng.stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.junit.Test;

import com.google.common.base.Charsets;
import com.google.common.io.ByteSink;
import com.google.common.io.ByteSource;
import com.google.common.io.CharSink;
import com.google.common.io.CharSource;
import com.google.common.io.Files;

public class StreamCloseTest {

	/**
	 * 传统的stream处理关闭方式，如果在finally块中处理流close的时候发生错误，
	 * 那么之前在try块中发生的异常信息将会被finally中的异常信息替换掉，这样会导致
	 * 用户无法排查具体出错原因
	 *
	 * @author zhenglian
	 * @data 2017年1月20日 下午2:20:34
	 * @throws Exception
	 */
	@Test
	public void testTraditionalClose() throws Exception {
		File from = new File("D:/cPix.ini");
		File to = new File("D:/test.ini");
		
		InputStream input = null;
		OutputStream output = null;
		try {
			input = new FileInputStream(from);
			output = new FileOutputStream(to);
			int len = -1;
			byte[] bytes = new byte[1024];
			while((len = input.read(bytes)) != -1) {
				output.write(bytes, 0, len);
			}
		} finally {
			if(null != input) {
				input.close();
			}
			
			if(null != output) {
				output.close();
			}
		}
	}
	
	/**
	 * 通过try-with-resource的方式来处理流数据，流会自动关闭，如果出现多个流处理异常，
	 * 这些异常信息将会与其他流信息压缩在一起，并通过trace的方式显示出来
	 *
	 * @author zhenglian
	 * @data 2017年1月20日 下午2:14:00
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	@Test
	public void testClose() throws FileNotFoundException, IOException {
		File from = new File("D:/cPix.ini");
		File to = new File("D:/test.ini");
		
		try(InputStream input = new FileInputStream(from);
				OutputStream output = new FileOutputStream(to);) {
			int len = -1;
			byte[] bytes = new byte[1024];
			while((len = input.read(bytes)) != -1) {
				output.write(bytes, 0, len);
			}
		}
	}
	
	/**
	 * 通过ByteSource / ByteSink 的方式来处理文件
	 *
	 * @author zhenglian
	 * @throws IOException 
	 * @data 2017年1月20日 下午2:29:32
	 */
	@Test
	public void testByteSourceByteSink() throws IOException {
		File from = new File("D:/cPix.ini");
		File to = new File("D:/test.ini");
		ByteSink bsink = Files.asByteSink(to); //没有添加FileWriteMode就是覆盖，如果添加了FileWriteMode.APPEND就是追加
		ByteSource bsource = Files.asByteSource(from);
		bsource.copyTo(bsink);
	}
	
	@Test
	public void testCharSourceCharSink() throws IOException {
		File from = new File("D:/cPix.ini");
		File to = new File("D:/test.ini");
		
		CharSource csource = Files.asCharSource(from, Charsets.UTF_8);
		CharSink csink = Files.asCharSink(to, Charsets.UTF_8);
		csource.copyTo(csink);
	}
}
