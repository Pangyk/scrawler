package crawler;

import java.util.Iterator;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;

public class CrawlerController {
	private final int numberOfCrawlers = 5;
	
	@SuppressWarnings("rawtypes")
	public void execute(Iterator seed,WebCrawler crawler,String filePath) throws Exception {
        CrawlConfig config = new CrawlConfig();
        config.setCrawlStorageFolder(filePath);
        config.setPolitenessDelay(200);

        /*
         * Instantiate the controller for this crawl.
         */
        PageFetcher pageFetcher = new PageFetcher(config);
        RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
        RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
        CrawlController controller = new CrawlController(config, pageFetcher, robotstxtServer);
        
        while(seed.hasNext()){
        	String ip = (String) seed.next();
        	controller.addSeed(ip);
        }
        controller.start(crawler.getClass(), numberOfCrawlers);
    }
}
