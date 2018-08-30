package dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class ReadFile {
	
	public static ArrayList<String> readFile(String path) throws Exception{
		BufferedReader wordFile = new BufferedReader(new InputStreamReader(new FileInputStream(new File(path)),"utf-8"));		
		//�������ͣ�ô�/�ؼ��ʵļ���  
	    ArrayList<String> wordMap = new ArrayList<String>();
	    
	    //���绯ͣ�ôʼ�  
	    String word = null;  
	    for(; (word = wordFile.readLine()) != null;){
	    	//if(word.length() > 10) {
	    	wordMap.add(word);
	    	//}
//	    	if(wordMap.size() == 10)
//	    		break;
	    }
	    return wordMap;
	}
	/*
	public static void main(String[] args) throws Exception{
        HashMap<String, Integer> wordMap = ReadFile.readFile("G:\\zWeiboPre\\featureWord5000.txt");
		if(wordMap.containsKey("�й�")){
			System.out.print(wordMap.get("�й�"));
		}
		else System.out.print(0);
	}*/
	
}
