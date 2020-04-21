package com.example.demo.file;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.Charsets;

public class TFileUtils {

	public void test() {
		
		File file = new File("C:\\Users\\wonkkyuu\\Desktop\\drive-download-20180913T050619Z-001\\centos7_template.txt");
		
		try {
			
			/* file의 내용을 string 으로 변환 */
			String contents = FileUtils.readFileToString(file, Charsets.UTF_8);
//			System.out.println(contents);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
