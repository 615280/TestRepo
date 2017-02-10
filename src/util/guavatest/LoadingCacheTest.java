package util.guavatest;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

/**
 * FileName LoadingCacheTest.java
 * 
 * @Description loadingCache的使用
 * 
 * @author hzhuolirong 2016年12月22日
 */
public class LoadingCacheTest {

	public static LoadingCache<String, String> cache = CacheBuilder.newBuilder().maximumSize(2).recordStats()
			.build(new CacheLoader<String, String>() {
				@Override
				public String load(String key) throws Exception {
					return key;
				}
			});
	
	public static Cache<Object, Object> callableCache = CacheBuilder.newBuilder()
			.maximumSize(2).build();

	public static void main(String[] args) throws ExecutionException {
//		cache.put("a", "aaatest");
//		
//		System.out.println(cache.getUnchecked("a"));
//		System.out.println(cache.getUnchecked("b"));
//		try {
//			System.out.println(cache.get("a"));
//			System.out.println(cache.get("b"));
//		} catch (ExecutionException e) {
//			e.printStackTrace();
//		}
//		
//		cache.put("c", "ccctest");
//		System.out.println(cache.getUnchecked("c"));
//		System.out.println(cache.getUnchecked("a"));

		//**************************************//
		
//		cache.put("a", "aaatest");
//		
//		try {
//			System.out.println(LoadingCacheTest.get("a"));
//			System.out.println(LoadingCacheTest.get("b"));
//			System.out.println(LoadingCacheTest.get("c"));
//		} catch (ExecutionException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		
		//**************************************//
		
		callableCache.get("a", new Callable<Object>() {
			@Override
			public Object call() throws Exception {
				String a = new String();
				return a;
			}
		});
		
		Object a = new Object();
		a = callableCache.getIfPresent("a");
		System.out.println(callableCache.getIfPresent("a"));
	}
	
	public static Object get(String key) throws ExecutionException{
		String var = cache.get(key);
		System.out.println(var);
		
		if(var.equals(key)){
			System.out.println("不在cache中？");
			cache.put(key, "testString");
		} else {
			System.out.println("在cache中哦。。。");
		}
		return cache.get(key);
	}
}
