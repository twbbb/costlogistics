package com.twb.costlogistics.repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.twb.costlogistics.entity.LogisticsCost;

/**
 * Created by code4wt on 17/8/4.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LogisticsCostRepositoryTest
{

	@Autowired
	private LogisticsCostRepository dao;

	@Test
	public void insert() throws Exception
	{
		// System.out.println("Initial Code: " + dao.insert());
//		LogisticsCost lc = new LogisticsCost();
//		lc.setHandlingFee(10);
//		lc.setDestination("美国");
//		lc.setLogisticsCompany("LogisticsCompany");
//		lc.setLogisticType("logisticTtype");
//		lc.setPrice(20);
//		lc.setTriggerCondition("TriggerCondition");
//		dao.save(lc);
//		System.out.println("SUCCESS");
	}

	@Test
	public void getByDestination() throws Exception
	{

		List<LogisticsCost> list = dao.getByDestination("俄罗斯联邦");
		System.out.println(list);
//		System.out.println(list.get(0));
//		System.out.println("SUCCESS");
	}

	@Test
	public void genSql() throws Exception
	{

		String sql = "INSERT INTO logistics_cost(logistics_company,Logistics_type,destination,price,handling_fee,trigger_condition,weight_count)"
				+ " VALUE('燕文物流华南报价','${1}','${2}',${3},${4},'${5}','${6}');   ";
		String str1 = "国际E邮宝";
		String str5 = "";
		String str6 = "";
		String str2 = "";
		String str3 = "";
		String str4 = "";
		String datapath = System.getProperty("user.dir") + "\\data";
		BufferedReader br = new BufferedReader(new FileReader(datapath));
		String line = br.readLine();

		while (line != null)
		{
			
			String[] lines = line.split("\\s+");
			if (lines.length == 3)
			{
				str2 = lines[0];
				str3 = Double.parseDouble(lines[1])*1000+"";
				str4 = lines[2];
				System.out.println(sql.replace("${1}", str1).replace("${2}", str2).replace("${3}", str3).replace("${4}", str4).replace("${5}", str5).replace("${6}", str6));
			}
			else
			{
				System.err.println("数组长度错误" + line + "," + Arrays.toString(lines));
			}
			line = br.readLine();
		}
		br.close();
	}

}