package cn.mldn.demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import cn.mldn.vo.Dept;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JSONCreateVO {
	public static void main(String[] args) {
		// 1、通过业务层取得了全部的部门信息
		List<Dept> all = new ArrayList<Dept>() ;
		for (int x = 0 ; x < 10 ; x ++) {
			Dept vo = new Dept() ;
			vo.setDeptno(x);
			vo.setDname("部门 - " + x);
			all.add(vo) ;
		}
		// 2、将集合变为JSON数据
		JSONObject obj = new JSONObject() ;
		JSONArray arr = new JSONArray() ;
		Iterator<?> iter = all.iterator() ;
		while (iter.hasNext()) {
			arr.add(iter.next()) ;
		}
		obj.put("allDepts", arr) ;
		System.out.println(obj);
	}
}
