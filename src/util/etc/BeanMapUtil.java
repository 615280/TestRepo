/**
 * 
 */
package util.etc;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.google.common.collect.Maps;

/**
 * @Description Bean与map的转换
 * @author hzhuolirong
 * 
 */
public class BeanMapUtil {
	public static Map<String, Object> transBean2Map(Object obj){
		if(obj == null){
			return null;
		}
		
		Map<String, Object> map = Maps.newHashMap();
		BeanInfo beanInfo;
		try {
			beanInfo = Introspector.getBeanInfo(obj.getClass());
			PropertyDescriptor[] descriptors = beanInfo.getPropertyDescriptors();
			for (PropertyDescriptor propertyDescriptor : descriptors) {
				String key = propertyDescriptor.getName();
				
				if(!"class".equals(key)){
					Method getter = propertyDescriptor.getReadMethod();
					Object value = getter.invoke(obj);
					map.put(key, value);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("transBeanToMap error" + e.getMessage());
		}
		return map;
	}
	
	public static Object transMap2Bean(Map<String, Object> map, Object obj){
		if(obj == null || map == null){
			return null;
		}
		
		try {
			BeanUtils.populate(obj, map);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}
}
