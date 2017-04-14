package service;

import crawler.SummCrawler;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import parse.Parser;
import parse.SummParser;

public class SummFactory extends Factory{

	@Override
	public WebCrawler getCrawler() {
		return new SummCrawler();
	}

	@Override
	public Parser getParser() {
		return new SummParser();
	}
}
