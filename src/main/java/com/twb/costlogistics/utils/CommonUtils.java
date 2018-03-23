package com.twb.costlogistics.utils;

import java.io.StringReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Class CommonUtils.java
 * @Author 作者姓名:田文彬
 * @Version 1.0
 * @Date 创建时间：2017年3月21日 上午10:32:17
 * @Copyright Copyright by 智多星
 * @Direction 通用方法
 */
public class CommonUtils
{

	private static Logger logger = LoggerFactory.getLogger(CommonUtils.class);



	/**
	 * 
	 * @Title: parserXML
	 * @Description: JAXB解析xml,解析错误返回空
	 * @param @param xml
	 * @param @param cls
	 * @param @return
	 * @return Object
	 * @throws
	 */
	public static Object parserXML(String xml, Class cls)
	{
		if (xml == null || xml.isEmpty())
		{
			return null;
		}

		Object obj = null;
		try
		{
			JAXBContext context = JAXBContext.newInstance(cls);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			obj = unmarshaller.unmarshal(new StringReader(xml));
		}
		catch (JAXBException e)
		{
			obj = null;
			// e.printStackTrace();
		}
		return obj;
	}

	/**
	 * 
	 * @Title: string2Int
	 * @Description: String转int类型
	 * @param @param str
	 * @param @param defaultVal
	 * @param @return
	 * @return int
	 * @throws
	 */
	public static int string2Int(String str, int defaultVal)
	{
		int i;
		try
		{
			i = Integer.parseInt(str);
		}
		catch (NumberFormatException e)
		{
			i = defaultVal;
		}
		return i;
	}
	
	/**
	 * 
	 * @Title: string2Long
	 * @Description: String转long类型
	 * @param @param str
	 * @param @param defaultVal
	 * @param @return
	 * @return long
	 * @throws
	 */
	public static long string2Long(String str, long defaultVal)
	{
		long i;
		try
		{
			i = Long.parseLong(str);
		}
		catch (NumberFormatException e)
		{
			i = defaultVal;
		}
		return i;
	}

	/**
	 * 
	 * @Title: validateMobile
	 * @Description: 检查手机号是否合法
	 * @param @param mobile
	 * @param @return
	 * @return boolean
	 * @throws
	 */
	public static boolean validateMobile(String mobile)
	{
		boolean flag = false;
		if (mobile != null)
		{
			Matcher m = null;
			Pattern p = Pattern.compile("^[1][0-9]{10}$");
			m = p.matcher(mobile);
			flag = m.matches();
		}

		return flag;

	}

	/**
	 * 
	 * @Title: validateNumber
	 * @Description: 检查是否全数字
	 * @param @param number
	 * @param @return
	 * @return boolean
	 * @throws
	 */
	public static boolean validateNumber(String number)
	{
		boolean flag = false;
		if (number != null)
		{
			Matcher m = null;
			Pattern p = Pattern.compile("^[0-9]+(\\.[0-9]+)?$");
			m = p.matcher(number);
			flag = m.matches();
		}

		return flag;

	}
	
	/**
	 * 
	 * @Title: validateNotEmptyNumber
	 * @Description: 检查是否全数字
	 * @param @param number
	 * @param @return
	 * @return boolean
	 * @throws
	 */
	public static boolean validateNotEmptyNumber(String number)
	{
		boolean flag = false;
		if (number != null)
		{
			Matcher m = null;
			Pattern p = Pattern.compile("^[0-9]+$");
			m = p.matcher(number);
			flag = m.matches();
		}

		return flag;

	}
	
	/**
	 * 
	* @Title: generateVerifyCode 
	* @Description: 验证码生成
	* @param @param len
	* @param @param verifyChars
	* @param @return
	* @return String
	* @throws
	 */
	public static String generateVerifyCode(int len, String verifyChars)
	{
		Random random = new Random();
		int charLen = verifyChars.length();
		String value = "";
		for (int i = 0; i < len; ++i)
		{
			int iV = random.nextInt(charLen);
			value = value + verifyChars.charAt(iV);
		}

		return value;
	}


	/**
	 * 
	* @Title: getMd5 
	* @Description: MD5加密
	* @param @param plainText
	* @param @return
	* @return String
	* @throws
	 */
    public static String getMd5(String plainText) {  
        try {  
            MessageDigest md = MessageDigest.getInstance("MD5");  
            md.update(plainText.getBytes());  
            byte b[] = md.digest();  
  
            int i;  
  
            StringBuffer buf = new StringBuffer("");  
            for (int offset = 0; offset < b.length; offset++) {  
                i = b[offset];  
                if (i < 0)  
                    i += 256;  
                if (i < 16)  
                    buf.append("0");  
                buf.append(Integer.toHexString(i));  
            }  
            //32位加密  
            return buf.toString();  
            // 16位的加密  
            //return buf.toString().substring(8, 24);  
        } catch (NoSuchAlgorithmException e) {  
            e.printStackTrace();  
            return null;  
        } 
    }  
    


    public static String toString(Object obj)
    {
    	if(obj==null)
    	{
    		return "";
    	}
    	else if(obj instanceof Timestamp||obj instanceof Date)
    	{
    		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(obj);
    	}
    	else
    	{
    		return obj.toString();
    	}
    	
    }
}
