package convert;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.Converter;
//ǰ��Ϊ���������   ����Ϊת���������
public class Consertvert implements Converter<String,Date>{

	@Override
	public Date convert(String resource) {
		
		try{
			
			if(resource!=null||resource.equals(""))
			{
			SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd");
			return s.parse(resource);
			}
			
			
		}
		catch(Exception e)
		{
			
			
			
			
		}
		
		
		
		// TODO Auto-generated method stub
		return null;
	}

	

	




	
}
