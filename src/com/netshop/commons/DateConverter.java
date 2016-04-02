package com.netshop.commons;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.commons.beanutils.Converter;

/** 
* @ClassName: DateConverter
* @Description:  ��Stringת����java.util.Date������ת����
* @author   hdm
* @date ����ʱ�䣺2016��4��1�� ����5:57:34
* @version=1.0
*/
public class DateConverter implements Converter{
	@SuppressWarnings("rawtypes")
	@Override
	public Object convert(Class type, Object value) {
		if(value == null) return null;//���Ҫת����ֵΪnull����ôֱ�ӷ���null
		if(!(value instanceof String)) {//���Ҫת����ֵ����String����ô�Ͳ�ת���ˣ�ֱ�ӷ���
			return value;
		}
		String val = (String) value;//��ֵת����String
		
		// ʹ��SimpleDateFormat����ת��
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return sdf.parse(val);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}
}
