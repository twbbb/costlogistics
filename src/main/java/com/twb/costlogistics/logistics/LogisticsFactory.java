package com.twb.costlogistics.logistics;

import com.twb.costlogistics.entity.LogisticsCost;
import com.twb.costlogistics.logistics.yanwen.YanwenLogistics;

public class LogisticsFactory
{

	public static Logistics createLogistics( LogisticsCost lc,double weight)
	{
		return new YanwenLogistics(lc, weight);
		
	}
}
