package com.twb.costlogistics.logistics.yanwen;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.apache.commons.lang3.StringUtils;

import com.twb.costlogistics.entity.LogisticsCost;
import com.twb.costlogistics.logistics.Logistics;

public class YanwenLogistics implements Logistics
{
	LogisticsCost lc;
	double weight;

	@Override
	public double calculationCost() throws Exception
	{
		if (checkTriggerCondition())
		{
			
			return lc.getPrice()*getWeight()+lc.getHandlingFee();
		}
		else
		{
			return -1;
		}
		
	}

	public boolean checkTriggerCondition() throws Exception
	{
		String triggerCondition = lc.getTriggerCondition();
		if (StringUtils.isEmpty(triggerCondition))
		{
			return true;
		}
		// triggerCondition.

		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("js");
		engine.put("weight", weight);
		Boolean result = (Boolean) engine.eval(triggerCondition);

		return result;

	}
	
	public double getWeight() throws Exception
	{
		String weightCount = lc.getWeightCount();
		if(StringUtils.isEmpty(weightCount))
		{
 			return weight;
		}
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("js");
		engine.put("weight", weight);
		Double result = (Double) engine.eval(weightCount);
		return result;
	}

	public YanwenLogistics(LogisticsCost lc, double weight)
	{
		super();
		this.lc = lc;
		this.weight = weight;
	}

	

}
