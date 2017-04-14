package tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

public class ReadPath {
	private final String filepath="/resources/config/cfg";
	private final String encoding = "UTF-8";

	@SuppressWarnings("rawtypes")
	public Iterator getConfigPath(){
		String path = System.getProperty("user.dir")+filepath;
		File file = new File(path);
		try {
			InputStreamReader read = new InputStreamReader(new FileInputStream(file),encoding);
			ArrayList<String> list = new ArrayList<String>();
			
			BufferedReader bufferedReader = new BufferedReader(read);
			String txt = null;
			while((txt = bufferedReader.readLine()) != null){
				list.add(txt);
			}
			bufferedReader.close();
			
			return list.iterator();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
