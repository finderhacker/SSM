package ziji.gw;

import java.util.ArrayList;
import java.util.List;

import com.jd.fastjson.JSON;

import corejava.chapt12.generic.Pair;


//-Xms512m -Xmx7168m
//-Xms7168m -Xmx7168m
public class Test {

	private static int _1MB = 1024*1024;
	
	public static void main(String[] args) {
		System.out.printf("%s", "你好联通移动");
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