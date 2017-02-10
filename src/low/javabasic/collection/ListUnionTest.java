package low.javabasic.collection;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * FileName ListUnionTest.java 
 * @Description TODO
 * 
 * @author hzhuolirong
 * 2016年12月22日
 */
public class ListUnionTest {
	
	public static void main(String[] args) {
		List<String> a = Lists.newArrayList();
		List<String> b = Lists.newArrayList();
		List<String> c = Lists.newArrayList();
		String abc = "abc";
		
		a.add(abc);b.add(abc);c.add(abc);
		a.add("cde");b.add("cde");
		a.add("xyz");
		b.add("rmp");
		
//		System.out.println(a);
//		System.out.println(b);
//		guavaCollectionUtils(a, b);
		System.out.println(a.toString());
		System.out.println(abc);
		System.out.println(c.toString());
		
		Map<String, String> maps = Maps.newHashMap();
		maps.put(abc, abc);
		maps.put(c.toString(), c.toString());
		System.out.println(maps);
	}
	
	public static void normalMethod(List<String> a, List<String> b){
		System.out.println(a);
		System.out.println(b);
		
//		System.out.println(a.addAll(b));
//		System.out.println(a);
//		System.out.println(a.removeAll(b));
//		System.out.println(a);
		System.out.println(a.retainAll(b));
		System.out.println(a);
	}
	
	public static void guavaCollectionUtils(List<String> a, List<String> b){
		System.out.println(CollectionUtils.union(a, b));
		System.out.println(a);
		System.out.println(b);
		
		a = (List<String>) CollectionUtils.union(a, b);
		System.out.println(a);
	}
}
