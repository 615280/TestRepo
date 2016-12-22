package low.javabasic.test;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

public class MainTest {
	public static void main(String[] args) {
		MainTest mt = new MainTest();
		mt.mapAddDuplicatedKey();
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
