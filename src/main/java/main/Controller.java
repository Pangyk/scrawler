package main;

import java.util.Iterator;

import crawler.CrawlerController;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import service.Dispatcher;
import tools.FactoryParser;
import tools.ReadPath;
import tools.SeedParser;
import update.Clear;

public class Controller {
	private static String filePath = System.getProperty("user.dir")+"/resources/data";

	@SuppressWarnings("rawtypes")
	public static void main(String[] args){
		Clear clear = new Clear();
		clear.clear();
		clear.createTable();
		
		ReadPath read = new ReadPath();
		Iterator pathList = read.getConfigPath();
		
		SeedParser sparser = new SeedParser();
		FactoryParser fparser = new FactoryParser();
		Dispatcher dispatch = new Dispatcher();
		
		int index = 0;
		while(pathList.hasNext()){
			String path = (String) pathList.next();
			Iterator slist = sparser.getSeed(path);
			String factory = fparser.getFactory(path);
			WebCrawler c = dispatch.getCrawler(factory);
			CrawlerController controller = new CrawlerController();
			try {
				controller.execute(slist, c,filePath+String.valueOf(index));
			} catch (Exception e) {
				e.printStackTrace();
			}
			index++;
		}
		
	}
}
