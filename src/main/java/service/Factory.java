package service;

import edu.uci.ics.crawler4j.crawler.WebCrawler;
import parse.Parser;

public abstract class Factory {

	public abstract WebCrawler getCrawler();
	
	public abstract Parser getParser();
}
