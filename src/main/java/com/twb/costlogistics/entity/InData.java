package com.twb.costlogistics.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @Class 	InData.java
 * @Author 	作者姓名:田文彬
 * @Version	1.0
 * @Date	创建时间：2017年3月21日 上午9:16:11
 * @Copyright Copyright by 智多星
 * @Direction 接口入参数
 */
public class InData implements Serializable{
	
	private static final long serialVersionUID = 7754908913247118188L;
	
	//单行参数
	private Map<String,Object> inmap;
	//多行数数
	private List<Map<String,Object>> inlist;
	
	public Map<String, Object> getInmap() {
		return inmap;
	}
	public void setInmap(Map<String, Object> inmap) {
		this.inmap = inmap;
	}
	public List<Map<String, Object>> getInlist() {
		return inlist;
	}
	public void setInlist(List<Map<String, Object>> inlist) {
		this.inlist = inlist;
	}
	
}
