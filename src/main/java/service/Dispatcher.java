package service;

import edu.uci.ics.crawler4j.crawler.WebCrawler;
import parse.Parser;

/**
 * 使用反射机制创建factory
 * @author 云奎
 *
 */
public class Dispatcher {
	
	public WebCrawler getCrawler(String factoryName) {
		Class<?> objClass;
		try {
			objClass = Class.forName(factoryName);
			Factory factory = (Factory) objClass.newInstance();
			return factory.getCrawler();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Parser getParser(String factoryName) {
		Class<?> objClass;
		try {
			objClass = Class.forName(factoryName);
			Factory factory = (Factory) objClass.newInstance();
			return factory.getParser();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
