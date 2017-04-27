package cn.mldn.demo;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JSONParse {
	public static void main(String[] args) {
		String jsonData = "{\"姓名\":\"张三\",\"年龄\":10,\"收入\":100.9,"
				+ "\"兴趣\":[\"唱歌\",\"跳舞\",\"看书\"],"
				+ "\"拥有图书\":[{\"书名\":\"Java开发 - 0\",\"作者\":\"开发者 - 0\",\"价格\":100},"
				+ "{\"书名\":\"Java开发 - 1\",\"作者\":\"开发者 - 1\",\"价格\":101},"
				+ "{\"书名\":\"Java开发 - 2\",\"作者\":\"开发者 - 2\",\"价格\":102}]}" ;
		// 如果要想解析JSON结构的字符串， 那么可以直接通过JSONObject类处理
		JSONObject obj = JSONObject.fromObject(jsonData) ;	// 解析完成了
		System.out.println(obj.get("姓名"));
		System.out.println(obj.get("年龄"));
		System.out.println(obj.get("收入"));
		JSONArray inst = obj.getJSONArray("兴趣") ;	// 获取数组数据
		for (int x = 0 ; x < inst.size() ; x ++) {
			System.out.print(inst.get(x) + "、");
		}
		System.out.println();
		JSONArray bookArray = obj.getJSONArray("拥有图书") ;
		for (int x = 0 ; x < bookArray.size() ; x ++) {
			JSONObject bookObj = bookArray.getJSONObject(x) ;
			System.out.println(bookObj.get("书名") + "、" + bookObj.getString("作者") + "、" + bookObj.getDouble("价格"));
		}
	}
}
