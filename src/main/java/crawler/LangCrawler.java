package crawler;

import java.util.Iterator;
import java.util.regex.Pattern;

import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.url.WebURL;
import parse.Parser;
import parse.Product;
import service.Dispatcher;
import tools.FactoryParser;
import tools.VisitParser;
import update.Update;

public class LangCrawler extends WebCrawler{
	private final String path = "/resources/config/langlang.xml";
    private final static Pattern FILTERS = Pattern.compile(".*(\\.(css|js|gif|jpg"
            + "|png|mp3|mp3|zip|gz))$");
    
	@SuppressWarnings("rawtypes")
	@Override
    public boolean shouldVisit(Page referringPage, WebURL url) {
        String href = url.getURL().toLowerCase();
        VisitParser visit = new VisitParser();
        Iterator visitList = visit.getVisit(path);
        
        boolean should = false;
        while(visitList.hasNext()){
        	String shouldVisit = (String) visitList.next();
        	Pattern pattern = Pattern.compile(shouldVisit);
        	if(pattern.matcher(href).matches()){
        		should = true;
        		break;
        	}
        }
        return !FILTERS.matcher(href).matches()&&should;
    }

    /**
     * This function is called when a page is fetched and ready
     * to be processed by your program.
     */
    @Override
    public void visit(Page page) {
        if (page.getParseData() instanceof HtmlParseData) {
            HtmlParseData htmlParseData = (HtmlParseData) page.getParseData();
            String html = htmlParseData.getHtml();
            
            //构造HTML解析器
            FactoryParser fparser = new FactoryParser();
            String factoryName = fparser.getFactory(path);
            Dispatcher dispatcher = new Dispatcher();
            Parser parser = dispatcher.getParser(factoryName);
            Iterator<Product> itr = parser.getProduct(html);
            
            Update update = new Update();
            update.update(itr);
        }
   }
}