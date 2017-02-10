package util.fastjson;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.ValueFilter;
import com.google.common.collect.Maps;
import com.google.gson.Gson;

/**
 * @Description TODO
 * 
 * @author hzhuolirong
 * 2017年1月13日 下午4:19:45
 */
public class JSONParseTest {
	public static void main(String[] args) {
		sequenceOut();
	}
	
	public static void sequenceOut(){
		Map<String, String> normalMap = Maps.newHashMap();
		Map<String, String> sequMap = Maps.newLinkedHashMap();
		
		normalMap.put("b", "bbbbb");
		normalMap.put("a", "aaaaa");
		normalMap.put("c", "ccccc");
		
		sequMap.put("b", "bbbbb");
		sequMap.put("a", "aaaaa");
		sequMap.put("c", "ccccc");
		
		String normal = new Gson().toJson(normalMap);
		String sequ = new Gson().toJson(sequMap);
		System.out.println(normal);
		System.out.println(sequ);
		
		Object o1 = JSON.parse(normal);
		Object o2 = JSON.parse(sequ, Feature.OrderedField);
		System.out.println(o1);
		System.out.println(o2);
		
		SerializeFilter f = new ValueFilter() {
			@Override
			public Object process(Object object, String name, Object value) {
				return value;
			}
		};
		String o1_str = JSON.toJSONString(o1, f, SerializerFeature.SortField);
		String o2_str = JSON.toJSONString(o2, f, SerializerFeature.SortField);
		System.out.println(o1_str);
		System.out.println(o2_str);
	}
}
