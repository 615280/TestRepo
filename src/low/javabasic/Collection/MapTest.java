package low.javabasic.Collection;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
	
	/**
	 * 测试map重复添加相同key的结果
	 * 
	 * @Result 33
	 * */
	public static void addRepeatedKey(){
		Map<String, Integer> map = new HashMap<>();
		map.put("a", 13);
		map.put("b", 23);
		map.put("a", 33);
		
		System.out.println(map.get("a"));
	}
}
