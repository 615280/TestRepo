package util.gson;

import java.lang.reflect.Constructor;
import java.util.Set;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.ValueFilter;

/**
 * @Description TODO
 * 
 * @author hzhuolirong
 * 2017年1月3日 下午7:24:07
 */
public class ValueFilterTest {
	static final String JSONObject = "JSONObject";
	static final String JSONArray = "JSONArray";
	
	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
//		String json = "{'name':'angui','age':'23','like':'吃水果'}";
//		String json2 = "{\"success\":true,\"errorCode\":0,\"message\":null,\"relatedObject\":{\"activeUsersToday\":\"85327\",\"activeUsersYesterDay\":\"300281\",\"activeUsersMinToday\":[{\"00:05\":\"12647\"},{\"00:10\":\"12222\"},{\"00:15\":\"11552\"},{\"00:20\":\"11484\"},{\"00:25\":\"11022\"},{\"00:30\":\"10667\"},{\"00:35\":\"10203\"},{\"00:40\":\"9874\"},{\"00:45\":\"9616\"},{\"00:50\":\"8821\"},{\"00:55\":\"8496\"},{\"01:00\":\"1\"},{\"01:05\":\"7350\"},{\"01:10\":\"7107\"},{\"01:15\":\"6985\"},{\"01:20\":\"6464\"},{\"01:25\":\"6141\"},{\"01:30\":\"5915\"},{\"01:35\":\"5625\"},{\"01:40\":\"5217\"},{\"01:45\":\"5002\"},{\"01:50\":\"4900\"},{\"01:55\":\"313\"},{\"02:00\":\"3986\"},{\"02:05\":\"4093\"},{\"02:10\":\"3886\"},{\"02:15\":\"3553\"},{\"02:20\":\"3454\"},{\"02:25\":\"3313\"},{\"02:30\":\"2891\"},{\"02:35\":\"2877\"},{\"02:40\":\"2697\"},{\"02:45\":\"2460\"},{\"02:50\":\"2466\"},{\"02:55\":\"2358\"},{\"03:00\":\"2326\"},{\"03:05\":\"2105\"},{\"03:10\":\"2097\"},{\"03:15\":\"2018\"},{\"03:20\":\"1791\"},{\"03:25\":\"1711\"},{\"03:30\":\"1703\"},{\"03:35\":\"1587\"},{\"03:40\":\"1534\"},{\"03:45\":\"1475\"},{\"03:50\":\"1415\"},{\"03:55\":\"1491\"},{\"04:00\":\"1355\"},{\"04:05\":\"1335\"},{\"04:10\":\"1355\"},{\"04:15\":\"1290\"},{\"04:20\":\"1241\"},{\"04:25\":\"1189\"},{\"04:30\":\"1214\"},{\"04:35\":\"1184\"},{\"04:40\":\"1109\"},{\"04:45\":\"1115\"},{\"04:50\":\"1134\"},{\"04:55\":\"1064\"},{\"05:00\":\"1064\"},{\"05:05\":\"1194\"},{\"05:10\":\"1080\"},{\"05:15\":\"1123\"},{\"05:20\":\"1143\"},{\"05:25\":\"1132\"},{\"05:30\":\"1171\"},{\"05:35\":\"1361\"},{\"05:40\":\"1310\"},{\"05:45\":\"1476\"},{\"05:50\":\"1549\"},{\"05:55\":\"1608\"},{\"06:00\":\"1762\"},{\"06:05\":\"2294\"},{\"06:10\":\"2249\"},{\"06:15\":\"2401\"},{\"06:20\":\"2529\"},{\"06:25\":\"2973\"},{\"06:30\":\"3105\"},{\"06:35\":\"3743\"},{\"06:40\":\"3800\"},{\"06:45\":\"3809\"},{\"06:50\":\"4062\"},{\"06:55\":\"4173\"},{\"07:00\":\"4302\"},{\"07:05\":\"4745\"},{\"07:10\":\"4389\"},{\"07:15\":\"4690\"},{\"07:20\":\"4800\"},{\"07:25\":\"4850\"},{\"07:30\":\"5032\"},{\"07:35\":\"5476\"},{\"07:40\":\"5542\"},{\"07:45\":\"5687\"},{\"07:50\":\"5603\"},{\"07:55\":\"5897\"},{\"08:00\":\"5786\"},{\"08:05\":\"6331\"},{\"08:10\":\"3017\"},{\"08:15\":\"6208\"},{\"08:20\":\"6429\"},{\"08:25\":\"6484\"},{\"08:30\":\"6604\"},{\"08:35\":\"6668\"},{\"08:40\":\"6686\"},{\"08:45\":\"6790\"},{\"08:50\":\"6744\"},{\"08:55\":\"6903\"},{\"09:00\":\"6792\"},{\"09:05\":\"7044\"},{\"09:10\":\"6995\"},{\"09:15\":\"6874\"},{\"09:20\":\"7105\"},{\"09:25\":\"7145\"},{\"09:30\":\"7258\"},{\"09:35\":\"7296\"},{\"09:40\":\"7002\"},{\"09:45\":\"6725\"},{\"09:50\":\"6765\"},{\"09:55\":\"6737\"},{\"10:00\":\"6870\"},{\"10:05\":\"6836\"},{\"10:10\":\"6445\"},{\"10:15\":\"6456\"},{\"10:20\":\"6576\"},{\"10:25\":\"6542\"},{\"10:30\":\"6553\"},{\"10:35\":\"6832\"},{\"10:40\":\"6493\"},{\"10:45\":\"6596\"},{\"10:50\":\"6652\"},{\"10:55\":\"6674\"},{\"11:00\":\"6701\"},{\"11:05\":\"6752\"},{\"11:10\":\"5650\"},{\"11:15\":\"5469\"},{\"11:20\":\"5158\"},{\"11:25\":\"4556\"}],\"activeUsersMinYesterday\":[{\"00:05\":\"1224\"},{\"00:10\":\"1167\"},{\"00:15\":\"1129\"},{\"00:20\":\"1097\"},{\"00:25\":\"1066\"},{\"00:30\":\"1050\"},{\"00:35\":\"973\"},{\"00:40\":\"936\"},{\"00:45\":\"933\"},{\"00:50\":\"803\"},{\"00:55\":\"876\"},{\"01:00\":\"740\"},{\"01:05\":\"793\"},{\"01:10\":\"731\"},{\"01:15\":\"774\"},{\"01:20\":\"683\"},{\"01:25\":\"613\"},{\"01:30\":\"608\"},{\"01:35\":\"562\"},{\"01:40\":\"581\"},{\"01:45\":\"484\"},{\"01:50\":\"503\"},{\"01:55\":\"416\"},{\"02:00\":\"421\"},{\"02:05\":\"401\"},{\"02:10\":\"362\"},{\"02:15\":\"377\"},{\"02:20\":\"339\"},{\"02:25\":\"316\"},{\"02:30\":\"270\"},{\"02:35\":\"289\"},{\"02:40\":\"229\"},{\"02:45\":\"230\"},{\"02:50\":\"248\"},{\"02:55\":\"241\"},{\"03:00\":\"238\"},{\"03:05\":\"196\"},{\"03:10\":\"175\"},{\"03:15\":\"149\"},{\"03:20\":\"201\"},{\"03:25\":\"160\"},{\"03:30\":\"162\"},{\"03:35\":\"157\"},{\"03:40\":\"148\"},{\"03:45\":\"145\"},{\"03:50\":\"147\"},{\"03:55\":\"138\"},{\"04:00\":\"109\"},{\"04:05\":\"121\"},{\"04:10\":\"120\"},{\"04:15\":\"90\"},{\"04:20\":\"117\"},{\"04:25\":\"116\"},{\"04:30\":\"77\"},{\"04:35\":\"91\"},{\"04:40\":\"78\"},{\"04:45\":\"89\"},{\"04:50\":\"67\"},{\"04:55\":\"83\"},{\"05:00\":\"85\"},{\"05:05\":\"87\"},{\"05:10\":\"96\"},{\"05:15\":\"107\"},{\"05:20\":\"102\"},{\"05:25\":\"125\"},{\"05:30\":\"97\"},{\"05:35\":\"100\"},{\"05:40\":\"86\"},{\"05:45\":\"100\"},{\"05:50\":\"97\"},{\"05:55\":\"102\"},{\"06:00\":\"118\"},{\"06:05\":\"122\"},{\"06:10\":\"134\"},{\"06:15\":\"109\"},{\"06:20\":\"126\"},{\"06:25\":\"129\"},{\"06:30\":\"122\"},{\"06:35\":\"145\"},{\"06:40\":\"163\"},{\"06:45\":\"167\"},{\"06:50\":\"158\"},{\"06:55\":\"189\"},{\"07:00\":\"171\"},{\"07:05\":\"225\"},{\"07:10\":\"234\"},{\"07:15\":\"239\"},{\"07:20\":\"287\"},{\"07:25\":\"298\"},{\"07:30\":\"314\"},{\"07:35\":\"410\"},{\"07:40\":\"389\"},{\"07:45\":\"391\"},{\"07:50\":\"370\"},{\"07:55\":\"401\"},{\"08:00\":\"432\"},{\"08:05\":\"370\"},{\"08:10\":\"448\"},{\"08:15\":\"475\"},{\"08:20\":\"499\"},{\"08:25\":\"505\"},{\"08:30\":\"493\"},{\"08:35\":\"682\"},{\"08:40\":\"702\"},{\"08:45\":\"586\"},{\"08:50\":\"656\"},{\"08:55\":\"607\"},{\"09:00\":\"653\"},{\"09:05\":\"738\"},{\"09:10\":\"728\"},{\"09:15\":\"748\"},{\"09:20\":\"679\"},{\"09:25\":\"759\"},{\"09:30\":\"802\"},{\"09:35\":\"814\"},{\"09:40\":\"771\"},{\"09:45\":\"832\"},{\"09:50\":\"812\"},{\"09:55\":\"812\"},{\"10:00\":\"873\"},{\"10:05\":\"845\"},{\"10:10\":\"806\"},{\"10:15\":\"812\"},{\"10:20\":\"820\"},{\"10:25\":\"860\"},{\"10:30\":\"860\"},{\"10:35\":\"867\"},{\"10:40\":\"866\"},{\"10:45\":\"960\"},{\"10:50\":\"963\"},{\"10:55\":\"808\"},{\"11:00\":\"863\"},{\"11:05\":\"860\"},{\"11:10\":\"897\"},{\"11:15\":\"838\"},{\"11:20\":\"842\"},{\"11:25\":\"858\"},{\"11:30\":\"878\"},{\"11:35\":\"882\"},{\"11:40\":\"912\"},{\"11:45\":\"901\"},{\"11:50\":\"948\"},{\"11:55\":\"902\"},{\"12:00\":\"888\"},{\"12:05\":\"861\"},{\"12:10\":\"862\"},{\"12:15\":\"907\"},{\"12:20\":\"810\"},{\"12:25\":\"823\"},{\"12:30\":\"891\"},{\"12:35\":\"920\"},{\"12:40\":\"886\"},{\"12:45\":\"890\"},{\"12:50\":\"939\"},{\"12:55\":\"866\"},{\"13:00\":\"905\"},{\"13:05\":\"926\"},{\"13:10\":\"876\"},{\"13:15\":\"717\"},{\"13:20\":\"760\"},{\"13:25\":\"729\"},{\"13:30\":\"794\"},{\"13:35\":\"760\"},{\"13:40\":\"814\"},{\"13:45\":\"704\"},{\"13:50\":\"831\"},{\"13:55\":\"1048\"},{\"14:00\":\"1517\"},{\"14:05\":\"1484\"},{\"14:10\":\"1632\"},{\"14:15\":\"2041\"},{\"14:20\":\"3135\"},{\"14:25\":\"4288\"},{\"14:30\":\"5057\"},{\"14:35\":\"5326\"},{\"14:40\":\"5329\"},{\"14:45\":\"5081\"},{\"14:50\":\"5251\"},{\"14:55\":\"5277\"},{\"15:00\":\"5325\"},{\"15:05\":\"6335\"},{\"15:10\":\"6289\"},{\"15:15\":\"6270\"},{\"15:20\":\"6194\"},{\"15:25\":\"6382\"},{\"15:30\":\"6985\"},{\"15:35\":\"7073\"},{\"15:40\":\"7863\"},{\"15:45\":\"7824\"},{\"15:50\":\"8169\"},{\"15:55\":\"8386\"},{\"16:00\":\"8607\"},{\"16:05\":\"8984\"},{\"16:10\":\"9593\"},{\"16:15\":\"9682\"},{\"16:20\":\"9344\"},{\"16:25\":\"10019\"},{\"16:30\":\"11103\"},{\"16:35\":\"10988\"},{\"16:40\":\"10990\"},{\"16:45\":\"10982\"},{\"16:50\":\"11190\"},{\"16:55\":\"11143\"},{\"17:00\":\"11156\"},{\"17:05\":\"11129\"},{\"17:10\":\"10977\"},{\"17:15\":\"10866\"},{\"17:20\":\"11312\"},{\"17:25\":\"11132\"},{\"17:30\":\"11237\"},{\"17:35\":\"11101\"},{\"17:40\":\"11239\"},{\"17:45\":\"11297\"},{\"17:50\":\"11283\"},{\"17:55\":\"11157\"},{\"18:00\":\"11357\"},{\"18:05\":\"11302\"},{\"18:10\":\"11392\"},{\"18:15\":\"11286\"},{\"18:20\":\"11193\"},{\"18:25\":\"11031\"},{\"18:30\":\"11130\"},{\"18:35\":\"11196\"},{\"18:40\":\"11000\"},{\"18:45\":\"11122\"},{\"18:50\":\"11225\"},{\"18:55\":\"11093\"},{\"19:00\":\"11068\"},{\"19:05\":\"11016\"},{\"19:10\":\"10830\"},{\"19:15\":\"10571\"},{\"19:20\":\"10209\"},{\"19:25\":\"10255\"},{\"19:30\":\"10387\"},{\"19:35\":\"10436\"},{\"19:40\":\"10541\"},{\"19:45\":\"10309\"},{\"19:50\":\"10388\"},{\"19:55\":\"10688\"},{\"20:00\":\"10600\"},{\"20:05\":\"10693\"},{\"20:10\":\"10462\"},{\"20:15\":\"10692\"},{\"20:20\":\"10753\"},{\"20:25\":\"10456\"},{\"20:30\":\"10919\"},{\"20:35\":\"11040\"},{\"20:40\":\"11146\"},{\"20:45\":\"10958\"},{\"20:50\":\"11233\"},{\"20:55\":\"11540\"},{\"21:00\":\"11442\"},{\"21:05\":\"11777\"},{\"21:10\":\"11523\"},{\"21:15\":\"11553\"},{\"21:20\":\"11671\"},{\"21:25\":\"11875\"},{\"21:30\":\"12145\"},{\"21:35\":\"12339\"},{\"21:40\":\"12714\"},{\"21:45\":\"12649\"},{\"21:50\":\"12977\"},{\"21:55\":\"12809\"},{\"22:00\":\"13501\"},{\"22:05\":\"13586\"},{\"22:10\":\"13763\"},{\"22:15\":\"13734\"},{\"22:20\":\"14598\"},{\"22:25\":\"14508\"},{\"22:30\":\"14881\"},{\"22:35\":\"14697\"},{\"22:40\":\"14857\"},{\"22:45\":\"14960\"},{\"22:50\":\"14907\"},{\"22:55\":\"15355\"},{\"23:00\":\"15330\"},{\"23:05\":\"14769\"},{\"23:10\":\"15262\"},{\"23:15\":\"15024\"},{\"23:20\":\"14919\"},{\"23:25\":\"14771\"},{\"23:30\":\"14482\"},{\"23:35\":\"14235\"},{\"23:40\":\"14013\"},{\"23:45\":\"13826\"},{\"23:50\":\"13615\"},{\"23:55\":\"13557\"},{\"24:00\":\"13251\"}]}}";
		
//		JSONObject jObject = JSON.parseObject(json2);
//				.getJSONObject("relatedObject").getJSONArray("activeUsersMinYesterday");
//		System.out.println(jObject);
//		System.out.println(jObject.getClass().getSimpleName());
//		System.out.println(jObject.get(0).getClass().getSimpleName());
		
//		Method method = jObject.getClass().getMethod("JSONArray", null);
//		Constructor<? extends JSONArray> a = jObject.getClass().getConstructor(null);
//		System.out.println(method.getReturnType());
//		System.out.println(a.get);
		
//		JSONObject jObj = jObject.getJSONObject(0);
//		System.out.println(jObj.values().getClass().getSimpleName());
		
//		SerializeFilter filter = new ValueFilter() {
//			@Override
//			public Object process(Object object, String name, Object value) {
//				if("00:05".equals(name)){
//					return value + "test";
//				}
//				return value;
//			}
//		}; 
//		System.out.println(JSON.toJSONString(jObject, filter));
		
//		JSONObject result = decodeJSONObject(JSON.parseObject(json2));
////		decodeJSONArray(jObject);
//		System.out.println(result);
		
	}
	
	static JSONObject decodeJSONObject(JSONObject jObject){
		Set<String> keys = jObject.keySet();
		for (String key : keys) {
			Object o = jObject.get(key);
			if(o instanceof JSONObject){
				JSONObject jo = (JSONObject) o;
				if(jo.keySet().size() > 0){
					decodeJSONObject(jo);
				}
			} else if(o instanceof JSONArray){
				JSONArray jArr = (JSONArray) o;
				if(jArr.size() > 0){
					decodeJSONArray(jArr);
				}
			} else {
//				System.out.println(key + " : " + o);
				jObject.put(key, "hhhh");
				System.out.println(jObject);
			}
		}
		return jObject;
	}
	
	static void decodeJSONArray(JSONArray jArray){
		for (Object o : jArray) {
			if(o instanceof JSONObject){
				JSONObject jo = (JSONObject) o;
				if(jo.keySet().size() > 0){
					decodeJSONObject(jo);
				}
			} else if(o instanceof JSONArray){
				JSONArray jArr = (JSONArray) o;
				if(jArr.size() > 0){
					decodeJSONArray(jArr);
				}
			} else {
				System.out.println(o + "=================================================");
			}
		}
	}
}
