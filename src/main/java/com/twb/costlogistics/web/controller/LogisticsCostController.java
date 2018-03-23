package com.twb.costlogistics.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.twb.costlogistics.entity.InData;
import com.twb.costlogistics.entity.OutData;
import com.twb.costlogistics.service.LogisticsCostService;

@Controller
public class LogisticsCostController
{

	private static final Logger logger = LoggerFactory.getLogger(LogisticsCostController.class);

	@Autowired
	private LogisticsCostService logisticsCostServiceImpl;

	@RequestMapping(value = "logisticsCost1")
	public OutData logisticsCost1(@RequestBody InData inData)
	{

		OutData outData = new OutData();
		try
		{
			if (inData != null && inData.getInmap() != null)
			{
				Map inMap = inData.getInmap();

				outData = logisticsCostServiceImpl.listCost(inMap);

			}
			else
			{
				outData.setReturncode("false");
				outData.setReturnmsg("数据为空");
			}
		}
		catch (Exception e)
		{
			outData.setReturncode("false");
			outData.setReturnmsg(e.getMessage());
		}

		return outData;
	}

	@RequestMapping("/logisticsCost")
	public String logisticsCost(@RequestParam("destination") String destination, @RequestParam("weight") String weight,
			Model model)
	{
		Map inMap = new HashMap();
		inMap.put("destination", destination);
		inMap.put("weight", weight);
		OutData outData = new OutData();
		try
		{
			outData = logisticsCostServiceImpl.listCost(inMap);
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 放在请求域中
		model.addAttribute("outData", outData);
		model.addAttribute("destination", destination);
		model.addAttribute("weight", weight);
		// thymeleaf默认就会拼串
		// classpath:/templates/xxxx.html
		return "list";
	}
	
	

}
