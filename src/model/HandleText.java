package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dao.ReadFile;
import dao.Unicode;

public class HandleText {
	
	// 过滤一些杂七杂八的东西，可以根据自己的情况用正则表达式修改。（下面过滤的内容是根据新浪微博的）
	public String filterContent(String content){//
			String regex = "@[^:]*? |@[\\w\\W]*?:|O网页链接|﻿O网页链接|O找不到网页|﻿O找不到网页|¡查看图片|O[\\w\\W]*秒拍视频|O[\\w\\W]*秒拍视频|L[\\w\\W]*?秒拍视频|L微博视频|#微博爆料#|#搞笑幽默#|\\[[\\w\\W]*\\]|【|】|#|°|️|「|」|☞|✔ |❓|•|。﻿|⋯|展开全文|转发|转需|转|回复|http://([\\w-]+\\.)+[\\w-]+(/[\\w-\\./?%&=]*)?|/";//|[a-zA-z]*
			content = content.replaceAll("/?/@[\\w\\W]*?:", " ");
			content = content.replaceAll(regex, " ");
			content = content.replaceAll("[A-Za-z]", "");
			content = content.replaceAll("[\\s]+", " ");
			content = content.replaceAll("[.]", " ");
			//过滤类似于表情的符号
			String p = "[\ud83c\udc00-\ud83c\udfff]|[\ud83d\udc00-\ud83d\udfff]|[\u2600-\u27ff]|" + Unicode.pat;
			Pattern emoji = Pattern.compile (p, Pattern.UNICODE_CASE | Pattern.CASE_INSENSITIVE ) ;
	        Matcher emojiMatcher = emoji.matcher(content);
	        if (emojiMatcher.find()){
	            content = emojiMatcher.replaceAll(" ");
	        }
	        content = content.replaceAll("[\\s]+", " ");
			return content;			
	}
	
	//去停用词
    public String removeStopWord(String content) throws Exception{
    	// D:\\MyEclipse\\MyEclipse 10\\workspaceJava\\
    	String stopWordPath = "ChineseNLP\\file\\stopwords.dat";
    	BufferedReader stopWordFile = new BufferedReader(new InputStreamReader(new FileInputStream(new File(stopWordPath))));
    	
    	//用来存放停用词的集合  
        Set<String> stopWordSet = new HashSet<String>();
        
        //初如化停用词集  
        String stopWord = null;  
        for(; (stopWord = stopWordFile.readLine()) != null;){  
            stopWordSet.add(stopWord);  
        }
        //resultArray存放分词结果
        String[] resultArray = content.split(" ");
        
        // 去停用词
        for(int i = 0; i<resultArray.length;i++){
        	//System.out.println(resultArray[i].trim());
        	if(stopWordSet.contains(resultArray[i].trim())){
        		resultArray[i]=null;
        	}
        }
        
        //finalStr存放去停用词后的句子
        StringBuffer finalStr = new StringBuffer();
        for(int i = 0; i<resultArray.length;i++){
        	if(resultArray[i] != null){
        		finalStr = finalStr.append(resultArray[i] + " ");
        	}
        }
        
        String t = finalStr.toString().replaceAll("\\s+", " ");
    	return t.trim();
    	
    }
	
	public void handle(String dataFile, String segWordFile, String wordFreFile) throws Exception {
		//中科院分词系统
		Nlp nlp = new Nlp();
		
		String textSeg = null;
		String strStop = null;
		
		//wholeText存放所有去停用词后的结果
		String wholeText = null;
		String wholeTextFre = null;
		
		// 存放分词以及去停用词后的内容, 以追加的形式写入文件
		FileWriter textfile = new FileWriter(segWordFile, true); 
		BufferedWriter writerText  = new BufferedWriter(textfile);		
		
		// 读取需要分词的文件
		ArrayList<String> allText = ReadFile.readFile(dataFile);
		System.out.println("内容获取完成，共"+Integer.toString(allText.size()));
		
		for(String text: allText) {
			String t = filterContent(text.trim());
			textSeg = nlp.wordSeg(t);
			//去停用词后的单词
			strStop = removeStopWord(textSeg);
			writerText.write(strStop);
			writerText.newLine();
			
			//wholeText存放所有去停用词后的结果
			wholeText = wholeText + strStop + " ";			
		}
		
		writerText.flush();
		writerText.close();
		textfile.close();
		
		System.out.println("开始全部数据分词与词频统计");
		//去除wholeText中的\xc2\xa0，即" "（并非为空格）
		//wholeText = wholeText.replaceAll(" |　"," ");
		wholeTextFre = nlp.wordFre(wholeText);
		
		FileWriter tofile = new FileWriter(wordFreFile, true); 
		BufferedWriter writer  = new BufferedWriter(tofile);
		for(String result: wholeTextFre.split("#")){
			writer.write(result);
			writer.newLine();
		}
		System.out.println("全部数据分词与词频统计完成");
		writer.flush();
		writer.close();
		tofile.close();
		
	}
	
	public static void main(String[] args) throws Exception {
		// 需要分词的文件，utf8编码
		String dataFile = "data.txt";
		// 存放分词以及去停用词后的内容
		String segWordFile = "result.txt";
		// 存放全部数据的分词与词频统计
		String wordFreFile = "wordFre.txt";
		HandleText h = new HandleText();
		h.handle(dataFile, segWordFile, wordFreFile);				
	}
}


