package low.javabasic.collection;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;

/**
 * @Description TODO
 * 
 * @author hzhuolirong
 * 2016年12月27日 下午4:45:01
 */
public class MainTest {
	public static void main(String[] args) {
		ListSizeZero();
		System.out.println(new Timestamp(System.currentTimeMillis()));
	}
	
	public static void ListSizeZero(){
		List<String> list = Lists.newArrayList();
		for (String string : list) {
			System.out.println(string);
		}
		
		List<Map<?, ?>> mapList = Lists.newArrayList();
		for (Map<?, ?> map : mapList) {				//并不会报错
			System.out.println(map);
		}
		System.out.println("end");
	}
	
	public static void testSyso(){
		List<String> a = Lists.newArrayList();
		for(int i=0; i<10; i++){
			a.add("test" + i);
		}
		
		for(final String result : a){
			System.out.println(result);
		}
	}
}
