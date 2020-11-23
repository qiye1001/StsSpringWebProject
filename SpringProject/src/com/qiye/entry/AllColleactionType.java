package com.qiye.entry;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class AllColleactionType {
	private Map<String, String> map;
	private List<String> list;
	private String[] arr;
	private Properties props;
	private Set<String> set;
	
	public Map<String, String> getMap() {
		return map;
	}
	public void setMap(Map<String, String> map) {
		this.map = map;
	}
	public List<String> getList() {
		return list;
	}
	public void setList(List<String> list) {
		this.list = list;
	}
	public String[] getArr() {
		return arr;
	}
	public void setArr(String[] arr) {
		this.arr = arr;
	}
	public Properties getProps() {
		return props;
	}
	public void setProps(Properties props) {
		this.props = props;
	}
	
	public Set<String> getSet() {
		return set;
	}
	public void setSet(Set<String> set) {
		this.set = set;
	}
	@Override
	public String toString() {
		return "AllColleactionType [map=" + map + ", list=" + list + ", arr=" + Arrays.toString(arr) + ", props="
				+ props + ", set=" + set + "]";
	}
	
	
}
