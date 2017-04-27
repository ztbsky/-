package cn.mldn.demo;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JSONCreateDemo {
	public static void main(String[] args) {
		JSONObject obj = new JSONObject() ;	// 创建一个JSON的数据对象
		obj.put("姓名", "张三") ;
		obj.put("年龄", 10) ;
		obj.put("收入", 100.9) ;
		JSONArray array = new JSONArray() ;
		array.add("唱歌") ;
		array.add("跳舞") ;
		array.add("看书") ;
		obj.put("兴趣", array) ;
		JSONArray bookArray = new JSONArray() ;
		for (int x = 0 ; x < 3 ; x ++) {
			JSONObject temp = new JSONObject() ;
			temp.put("书名", "Java开发 - " + x) ;
			temp.put("作者" , "开发者 - " + x) ;
			temp.put("价格", 100.0 + x) ;
			bookArray.add(temp) ;	// 追加数据到数组之中
		}
		obj.put("拥有图书", bookArray) ;
		System.out.println(obj);
	}
}
