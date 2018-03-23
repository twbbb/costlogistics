package com.twb.costlogistics.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twb.costlogistics.entity.LogisticsCost;
import com.twb.costlogistics.entity.OutData;
import com.twb.costlogistics.logistics.LogisticsFactory;
import com.twb.costlogistics.repository.LogisticsCostRepository;
import com.twb.costlogistics.service.LogisticsCostService;
import com.twb.costlogistics.utils.CommonUtils;

@Service
public class LogisticsCostServiceImpl implements LogisticsCostService
{

	private static final Logger logger = LoggerFactory.getLogger(LogisticsCostServiceImpl.class);

	@Autowired
	private LogisticsCostRepository logisticsCostRepository;

	public OutData listCost(Map map) throws Exception
	{
		OutData od = new OutData();
		String destination = (String) map.get("destination");
		String weight = (String) map.get("weight");
		if (StringUtils.isEmpty(destination))
		{
			od.setReturncode("false");
			od.setReturnmsg("请输入目的地");
			return od;
		}
		if (!CommonUtils.validateNumber(weight))
		{
			od.setReturncode("false");
			od.setReturnmsg("请输入正确重量:"+weight);
			return od;
		}

		double weightDouble = Double.parseDouble(weight);

		List<LogisticsCost> list = logisticsCostRepository.getByDestination(destination);
		if (list == null && list.isEmpty())
		{
			od.setReturncode("false");
			od.setReturnmsg(destination + ",没有物流送到");
			return od;
		}
		List outList = new ArrayList();
		double cost = 0;
		for (int i = 0; i < list.size(); i++)
		{
			cost = 0;
			LogisticsCost lc = list.get(i);
			try
			{
				
				cost = LogisticsFactory.createLogistics(lc, weightDouble).calculationCost();
			}
			catch (Exception e)
			{
				logger.error(e.toString() + "," + Arrays.toString(e.getStackTrace()));
				e.printStackTrace();
			}
			
			if(cost>0)
			{
				Map outListMap = new HashMap();
				outListMap.put("type", lc.getLogisticsCompany()+"-"+lc.getLogisticType());
				outListMap.put("cost", CommonUtils.toString(cost));
//				outListMap.put("destination", lc.getDestination());
//				outListMap.put("weight", weight);
				
				
				outList.add(outListMap);
			}
			
		}
		if(outList.size()==0)
		{
			od.setReturncode("false");
			od.setReturnmsg(destination + ",没有物流送到。");
			return od;
		}
		Collections.sort(outList, new Comparator(){

			@Override
			public int compare(Object o1, Object o2)
			{
				Map map1 = (Map) o1;
				Map map2 = (Map) o2;
				double d1 = Double.parseDouble((String)map1.get("cost"));
				double d2 = Double.parseDouble((String)map2.get("cost"));
				
				return d1-d2>=0?1:-1;
			}});
		od.setOutlist(outList);
		od.setOutmap(map);
		od.setReturnmsg("");
		od.setReturncode("true");
		return od;
	}

}
