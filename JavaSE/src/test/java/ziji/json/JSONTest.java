package ziji.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;




import com.jd.fastjson.JSONObject;

import ziji.a.A;
import ziji.a.b.A2;

public class JSONTest {

	@Test
	@Ignore
	public void test(){
//		JSONObject json = new JSONObject();
//		json.put("name", "[123]");
//		JSONArray arr = new JSONArray();
//		arr.add("\"[123]\"");
//		arr.add("\"{456}\"");
//		arr.add("789");
//		json.put("desc", arr);
//		
//		JSONObject json1 = new JSONObject();
//		json1.put("name", "[Bottom]");
//		JSONArray arr1 = new JSONArray();
//		arr1.add("[abc]");
//		arr1.add("{def}");
//		arr1.add("hij");
//		json1.put("desc", arr1);
//		
//		JSONArray arr2 = new JSONArray();
//		arr2.add(json1);
//		json.put("bottom", arr2);
//		
//		System.out.println(json);
//		
//		Map<String, Class<?>> cmap = new HashMap<String, Class<?>>();
//		cmap.put("bottom", Bottom.class);
//		Top bean = (Top) net.sf.json.JSONObject.toBean(json, Top.class, cmap);
//		System.out.println(bean);
		
		
		/*String str1="{\"name\":\"[a123]\" , \"desc\":[\"[123]\", \"{456}\", \"789\"]}" ;
		JSONObject message1=	JSONObject.fromObject(str1);
		Top bean = (Top) JSONObject.toBean(message1, Top.class);
		System.out.println(bean);
		
		String str2="{\"name\":\"[123]\" , \"desc\":[\"[123]\", \"{456}\", \"789\"]}" ;
		JSONObject message2=	JSONObject.fromObject(str2);
		Top bean2 = (Top) JSONObject.toBean(message2, Top.class);
		System.out.println(bean2);
		
		
		JSONObject json = new JSONObject();
		String oo = "\"[123]\"";
		json.put("name", oo);
		Top bean3 = (Top) JSONObject.toBean(json, Top.class);
		System.out.println(bean3);*/
		
		
		Top top = new Top();
		top.setTopname("[123]");
		
		Bottom bottom = new Bottom();
		bottom.setName("[123]");
		top.setBottom(bottom);

		
		System.out.println(JSONObject.toJSONString(top)) ;
		
		String json = JSONObject.toJSONString(top).toString();
		JSONObject message=	JSONObject.parseObject(json);
		
		Top bean2 = JSONObject.parseObject(json, Top.class);
		System.out.println(bean2);

		
		json="{\"bottom\":{\"name\":\"[123]\"},\"topname\":\"[123]\"}";
		Top parseObject = JSONObject.parseObject(json, Top.class);
		System.out.println(parseObject);
	}
	
	@Test
	public void b(){
		System.out.printf("123");
	}
}
