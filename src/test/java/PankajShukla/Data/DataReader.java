package PankajShukla.Data;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.core.type.TypeReference;



public class DataReader {

	
	public List<HashMap<String, String>> getDataToMap(String filepath) throws IOException
	{
		
		String jsonContent= FileUtils.readFileToString(new File(filepath), StandardCharsets.UTF_8);
		
		System.getProperty("user.dir");
		
		ObjectMapper obj=new ObjectMapper();
		List<HashMap<String,String>> data=obj.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>(){
			
		});
		return data;
	}		
		
}
