package Adapter;

public class Adapter {

	public Object getRate(String input){
		return null;
	}
	
	public final Adapter getAapter(String type){
		Class<?> objClass;
		try {
			objClass = Class.forName(type);
			Adapter adapter = (Adapter) objClass.newInstance();
			return adapter;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
