package model;

import java.io.UnsupportedEncodingException;

//import utils.SystemParas;
import com.sun.jna.Library;
import com.sun.jna.Native;

// 中科院分词系统

public class Nlp {

	private static String absPath = "D:\\eclipse\\workspaceJava\\";
	// 定义接口CLibrary，继承自com.sun.jna.Library
	public interface CLibrary extends Library {
		// 定义并初始化接口的静态变量，用于加载NLPIR.dll，路径指向文件NLPIR.dll，但不加后缀dll
		CLibrary Instance = (CLibrary) Native.loadLibrary(absPath + "ChineseNLP\\file\\win64\\NLPIR", CLibrary.class);
		
		// 初始化函数声明：sDataPath是初始化路径地址，包括核心词库和配置文件的路径，encoding为输入字符的编码格式
		public int NLPIR_Init(String sDataPath, int encoding,String sLicenceCode);
		
		// 分词函数声明：sSrc为待分字符串，bPOSTagged=0表示不进行词性标注，bPOSTagged=1表示进行词性标注  		
		public String NLPIR_ParagraphProcess(String sSrc, int bPOSTagged);
		
		// 词频统计功能，sText为字符串文本  
        public String NLPIR_WordFreqStat(String sText);
        
		// nMaxKeyLimit限制关键词个数
		public String NLPIR_GetKeyWords(String sLine, int nMaxKeyLimit,
				boolean bWeightOut);
		public String NLPIR_GetFileKeyWords(String sLine, int nMaxKeyLimit,
				boolean bWeightOut);
		
		public int NLPIR_AddUserWord(String sWord);//add by qp 2008.11.10
		public int NLPIR_DelUsrWord(String sWord);//add by qp 2008.11.10
		
		// 获取最后一个错误信息的函数声明  
		public String NLPIR_GetLastErrorMsg();
		
		// 退出函数声明  
		public void NLPIR_Exit();
	}

	public static String transString(String aidString, String ori_encoding,
			String new_encoding) {
		try {
			return new String(aidString.getBytes(ori_encoding), new_encoding);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

	// 分词，计算词频并按照词频排序
	public String wordFre(String sInput) throws Exception {

		String argu = absPath + "ChineseNLP\\file";  
		//String system_charset = "UTF-8";
		int charset_type = 1;
		// 运行初始化函数，成功则返回1，失败返回0  
		int init_flag = CLibrary.Instance.NLPIR_Init(argu, charset_type, "0");
		String nativeBytes = null;
		 // 初始化失败提示  
		if (0 == init_flag) {
			nativeBytes = CLibrary.Instance.NLPIR_GetLastErrorMsg();
			System.err.println("初始化失败！fail reason is "+nativeBytes);
		}
		try {
			// 词频从高到低排序，包括了分出来的所有词，甚至标点。 
			nativeBytes = CLibrary.Instance.NLPIR_WordFreqStat(sInput);     
			//System.out.println("词频排序结果： " + nativeBytes);
			//词频排序结果： ，/wd/20##/w/16#的/ude1/16#好/a/8#父亲/n/6#视频/n/5#秒/qt/5#拍/v/5#。/wj/5#L/o/5#:/wp/5#///xs/4#！/wt/4#甜/a/3#？/ww/3#是/vshi/3#萌/vg/3#有/vyou/3#都/d/3#了/ule/2#一个/mq/2#《/wkz/2#最/d/2#》/wky/2#来/vf/2#不/d/2#人/n/2#大/a/2#脑/n/2#哈哈哈/o/2#什么/ry/2#爱/v/2#心/n/2#溺/vg/2#屎/n/2#啦/y/2#老/a/2#男孩/n/2#做/v/2#过/uguo/2#疯狂/a/2#点儿/q/2#流/v/1#眼泪/n/1#失去/v/1#后/f/1#张学友/nr/1#让/v/1#自己/rr/1#成为/v/1#如果/c/1#这/rzv/1#算/v/1#才/d/1#父爱/n/1#各/rz/1#路/n/1#大大/d/1#封/q/1#神/n/1#结果/n/1#蹭/vi/1#合影/vi/1#成/v/1#传奇/n/1#微/ag/1#博/ag/1#爆/v/1#料/n/1#触动/vn/1#人心/n/1#许飞/nr/1#动情/vi/1#演绎/v/1#散文诗/n/1#歌词/n/1#好走/a/1#愿/v/1#天下/n/1#善良/a/1#健康/an/1#平安/an/1#幸福/an/1#节/n/1#快乐/a/1#萌/v/1#哒/o/1#民/ng/1#咕咕/o/1#洞/dg/1#趣味/n/1#动画/n/1#短/a/1#片/q/1#Brain/n/1#Divided/vd/1#：/wp/1#约会/vi/1#时候/n/1#男女/n/1#左右/m/1#在/p/1#想/v/1#最后/f/1#一直/d/1#甜蜜/a/1#觉得/v/1#@WLYWLYWLY_/nr/1#他/rr/1#就/d/1#@槊槊的/nr/1#可爱/a/1#@-HIISFIONA/nr/1#可/v/1#愛/w/1#唷/n/1#金/b/1#毛/n/1#一臉寵/m/1#世界/n/1#～/ws/1#@hahaaaaaaa/nr/1#WOW//@Lynn_syn/xe/1#上/f/1#会/v/1#爸爸/n/1#个/q/1#唱歌/vi/1#父/ng/1#摔/v/1#吉他/n/1#跟踪/v/1#狂/d/1#…/ws/1#为了/p/1#我们/rr/1#亲/ng/1#听/v/1#多/a/1#歌/n/1#事/n/1#那些/rz/1#年/qt/1#你/rr/1#家/n/1#做出/v/1#哪些/ry/1#事儿/n/1#快/a/1#跟/v/1#偶/d/1#聊聊/v/1#~/w/1#      /w/1#暖/a/1#小/a/1#喵/o/1#和/cc/1#汪/nr1/1#初/f/1#次/qv/1#见面/vi/1#小心翼翼/dl/1#许/dg/1#好奇/a/1#紧张/a/1#大汪/nr/1#回应/vn/1#一/m/1#脸/q/1#宠/v/1#没有/v/1#能/v/1#拒绝/v/1#香/n/1#煎/v/1#土豆/n/1#丝/q/1#饼/n/1#外/f/1#酥/a/1#里/f/1#嫩/a/1#起来/vf/1#超/v/1#简单/a/1#吃/v/1#货/n/1#get√/n/1#这个/rz/1#水龙头/n/1#设计/vn/1#太/d/1#套路/n/1#了/y/1#
			CLibrary.Instance.NLPIR_Exit();
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		return nativeBytes;
	}
	
	// 分词
	public String wordSeg(String sInput) throws Exception {
		
		// 该路径指向Data文件夹（系统核心词库）  
		String argu = absPath + "ChineseNLP\\file";
		// String system_charset = "GBK";//GBK----0
		// UTF-8编码模式，其它的GBK对应0，BIG5对应2，含繁体字的GBK对应3  
		//String system_charset = "UTF-8";
		int charset_type = 1;
		
		// 运行初始化函数，成功则返回1，失败返回0  
		int init_flag = CLibrary.Instance.NLPIR_Init(argu, charset_type, "0");
		String nativeBytes = null;
        
		 // 初始化失败提示  
		if (0 == init_flag) {
			nativeBytes = CLibrary.Instance.NLPIR_GetLastErrorMsg();
			System.err.println("初始化失败！fail reason is "+nativeBytes);
			//return;
		}

		// 手工输入的字符串sInput  
		//String sInput = "一直觉得，他就是世界上最会唱歌的父 亲，听歌的人不许流眼泪。失去父亲后的#张学友#，让自己成为了一个好父亲。如果这都不算爱，什么才是最好的父爱？ 各路大大来封神，结果一个蹭合影的成了传奇 #微博爆料# 触动人心，许飞动情演绎《 父亲的散文诗 》，歌词好走心。愿天下善良有爱的父亲健康平安幸福！#父亲节#快乐！L秒拍视频 萌萌哒民咕咕 脑洞好大，趣味#动画#短 片《Brain Divided》：约会的时候，男女的左右脑都在想什么？最后哈哈哈L秒拍视频 好甜蜜//@WLYWLYWLY_: 甜甜甜！//@槊槊的: 好可爱//@-HIISFIONA: 好可愛唷金毛一臉寵溺～//@hahaaaaaaa: WOW//@Lynn_syn: 萌屎啦萌屎啦 #爸爸是个老男孩# 摔吉他，跟踪狂…为了我们，父亲做过好多疯狂的事。那些年，你家的老男孩都做出过哪些疯狂的事儿？快来跟偶聊聊 ~      L秒拍视频 好#暖心#，小喵和大汪的初次见面，小心翼翼，有点儿好奇，有点儿紧张。大汪的回应一脸宠溺！L秒拍视频 没有人能拒绝的香煎土豆丝饼，外酥里嫩，做起来超简单，#吃货#get√ 哈哈哈，这个水龙头的设计太#套路#了 L秒拍视频";

		//String nativeBytes = null;
		try {
			// 运行分词函数 
			nativeBytes = CLibrary.Instance.NLPIR_ParagraphProcess(sInput, 0);
            
			//System.out.println("分词结果为： " + nativeBytes);
			/*
			CLibrary.Instance.NLPIR_AddUserWord("要求美方加强对输 n");
			CLibrary.Instance.NLPIR_AddUserWord("华玉米的产地来源 n");
			nativeBytes = CLibrary.Instance.NLPIR_ParagraphProcess(sInput, 1);
			System.out.println("增加用户词典后分词结果为： " + nativeBytes);
			
			CLibrary.Instance.NLPIR_DelUsrWord("要求美方加强对输");
			nativeBytes = CLibrary.Instance.NLPIR_ParagraphProcess(sInput, 1);
			System.out.println("删除用户词典后分词结果为： " + nativeBytes);
			
			
			int nCountKey = 0;
			String nativeByte = CLibrary.Instance.NLPIR_GetKeyWords(sInput, 100,true);

			System.out.println("关键词提取结果是：" + nativeByte);

			nativeByte = CLibrary.Instance.NLPIR_GetFileKeyWords("D:\\NLPIR\\feedback\\huawei\\5341\\5341\\产经广场\\2012\\5\\16766.txt", 10,false);

			System.out.println("关键词提取结果是：" + nativeByte);
            */
			CLibrary.Instance.NLPIR_Exit();

		} catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		return nativeBytes;
	}
	
	public static void main(String[] args){
		Nlp nlp = new Nlp();
		String content = "我今天回家。";
		
		try {
			System.out.println(nlp.wordFre(content));
			System.out.println(nlp.wordSeg(content));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
