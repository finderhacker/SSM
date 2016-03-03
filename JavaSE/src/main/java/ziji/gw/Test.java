package ziji.gw;

import java.util.ArrayList;
import java.util.List;

import com.jd.fastjson.JSON;

import corejava.chapt12.generic.Pair;

public class Test {

	public static void main(String[] args) {
		
		
		Object parse = JSON.parse("");
		System.out.printf("%s", parse);
		
		parse = JSON.parse(null);
		System.out.printf("%s", parse);
		
		Person parseObject = JSON.parseObject("{\"1\":[\"a\",123], \"name\":\"123\"}", Person.class);
		System.out.printf("%s", parseObject);
	}
	
}




class Person{
	String name;
	Integer age;
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the age
	 */
	public Integer getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(Integer age) {
		this.age = age;
	}
	
	
}