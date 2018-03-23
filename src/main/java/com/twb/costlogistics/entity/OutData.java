package com.twb.costlogistics.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @Class 	OutData.java
 * @Author 	作者姓名:田文彬
 * @Version	1.0
 * @Date	创建时间：2017年3月21日 上午9:16:11
 * @Copyright Copyright by 智多星
 * @Direction 接口回复参数
 */
public class OutData implements Serializable{

	
	private static final long serialVersionUID = 7924511294861632614L;
	
	//返回状态
	String returncode;
	//返回状态信息
	String returnmsg;
	//单行参数
	private Map<String,Object> outmap;
	//多行数数
	private List<Map<String,Object>> outlist;
	
	public String getReturncode() {
		return returncode;
	}
	public void setReturncode(String returncode) {
		this.returncode = returncode;
	}
	public String getReturnmsg() {
		return returnmsg;
	}
	public void setReturnmsg(String returnmsg) {
		this.returnmsg = returnmsg;
	}
	public Map<String, Object> getOutmap() {
		return outmap;
	}
	public void setOutmap(Map<String, Object> outmap) {
		this.outmap = outmap;
	}
	public List<Map<String, Object>> getOutlist() {
		return outlist;
	}
	public void setOutlist(List<Map<String, Object>> outlist) {
		this.outlist = outlist;
	}
	
	
}
