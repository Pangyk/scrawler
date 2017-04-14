package service;

import crawler.LangCrawler;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import parse.LangParser;
import parse.Parser;

public class LangFactory extends Factory{

	@Override
	public WebCrawler getCrawler() {
		return new LangCrawler();
	}

	@Override
	public Parser getParser() {
		return new LangParser();
	}
}
