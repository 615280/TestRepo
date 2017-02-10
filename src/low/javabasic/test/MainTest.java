package low.javabasic.test;

import java.sql.Date;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class MainTest {
	public static void main(String[] args) {
//		MainTest mt = new MainTest();
//		mt.StringArrayToString();
		
//		Object a = "1483672252asdf";
//		try {
//			Long a_long = Long.parseLong(a.toString());
//		} catch (Exception e) {
//			System.out.println("fail");
//		}
		
//		if(a_long instanceof Long){
//			System.out.println("YES, It is long type");
//		} else {
//			System.out.println("nonono");
//		}
		
		Integer a = null;
//		System.out.println(a.getClass());
		System.out.println("a".equals(a));
	}
	
	public void mapGetNoKey(){
		Map<String, String> a = Maps.newHashMap();
		a.put("a", "aaa");
		
		Object c = a.get("c");
		System.out.println(c);;			//null
	}
	
	public void StringArrayToString(){
		String[] array = {"a", "b", "c", "d"};
		System.out.println(array);
		System.out.println(Arrays.toString(array));
		String[] b = {"a"};
		System.out.println(Arrays.toString(b));
	}
	
	public void Object2ListString(){
		List<String> list = Lists.newArrayList();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		
		Object obj = list;
		System.out.println(list);
		System.out.println(obj);
		System.out.println(obj.getClass());
		System.out.println((List<String>)obj);
		System.out.println(obj instanceof List);
	}
	
	/**
	 * 加密 混淆？
	 * 同样的String的hashcode一致
	 * */
	public void encryptionAndObfuscationTest(){
		String a = "ADNASODUJOISADFIO";
		String b = new String("ADNASODUJOISADFIO");
		System.out.println(a);
		String a_hubble = a + "HubbleData";
		System.out.println(a.hashCode() == b.hashCode());
		System.out.println(a.hashCode());
		System.out.println(a_hubble.hashCode());
	}
	
	/**
	 * 测试map重复添加相同key的结果
	 * 
	 * @Result a=33
	 * */
	public void mapAddDuplicatedKey(){
		Map<String, Integer> map = new HashMap<>();
		map.put("a", 13);
		map.put("b", 23);
		map.put("a", 33);
		System.out.println(map.get("a"));
		System.out.println(map.get(null));		//↓3行全部无Exception,结果为null
		System.out.println(map.put("c", null));
		System.out.println(map.get("c"));
	}
	
	public void currentTime(){
		System.out.println(new Date(System.currentTimeMillis()));
	}
	
	public void equalsConstPositionToNPE(){
		//equals中字符串在前的NPE区别
		String a = null;
		try {
			if("a".equals(a)){	//不会报Exception!
				System.out.println("hello");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage()+"1");
		}
		
		try {
			if(a.equals("a")){		//会报Exception!
				System.out.println("hello");	
			}
		} catch (Exception e) {
			System.out.println(e.getMessage()+"2");
		}
	}
}
