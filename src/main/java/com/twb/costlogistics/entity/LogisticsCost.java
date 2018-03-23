package com.twb.costlogistics.entity;


import javax.persistence.*;

//使用JPA注解配置映射关系
@Entity //告诉JPA这是一个实体类（和数据表映射的类）
@Table(name = "logistics_cost") //@Table来指定和哪个数据表对应;如果省略默认表名就是user；
public class LogisticsCost {

    @Id //这是一个主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)//自增主键
    private Integer id;

    @Column(name = "logistics_company",length = 20) //物流公司
    private String logisticsCompany;
  
    
    @Column(name = "Logistics_type",length = 20) //物流运输类型
    private String LogisticType;
    
    
    @Column //省略默认列名就是属性名
    private float price; //价格
    
    @Column (name = "handling_fee") //处理费
    private float handlingFee;

    @Column(name = "trigger_condition",length = 100) //触发条件
    private String triggerCondition;
    
    @Column(name = "weight_count",length = 100) //重量计算
    private String weightCount;
    
    @Column(name = "destination",length = 20) //目的地
    private String destination;

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getLogisticsCompany()
	{
		return logisticsCompany;
	}

	public void setLogisticsCompany(String logisticsCompany)
	{
		this.logisticsCompany = logisticsCompany;
	}



	public String getLogisticType()
	{
		return LogisticType;
	}

	public void setLogisticType(String logisticType)
	{
		LogisticType = logisticType;
	}

	public float getPrice()
	{
		return price;
	}

	public void setPrice(float price)
	{
		this.price = price;
	}

	public float getHandlingFee()
	{
		return handlingFee;
	}

	public void setHandlingFee(float handlingFee)
	{
		this.handlingFee = handlingFee;
	}

	public String getTriggerCondition()
	{
		return triggerCondition;
	}

	public void setTriggerCondition(String triggerCondition)
	{
		this.triggerCondition = triggerCondition;
	}

	

	public String getDestination()
	{
		return destination;
	}

	public void setDestination(String destination)
	{
		this.destination = destination;
	}

	public String getWeightCount()
	{
		return weightCount;
	}

	public void setWeightCount(String weightCount)
	{
		this.weightCount = weightCount;
	}

    
    
    

}
