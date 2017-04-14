package tools;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

public class CurrencyParser {
	private final String path = "/resources/config/adapter.xml";

	public double getRate(String type) {
		String xmlpath = System.getProperty("user.dir") + path;
		double rate = 1;
		try {
			xmlpath = URLDecoder.decode(xmlpath, "utf-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}

		SAXBuilder builder = new SAXBuilder(false);
		try {
			Document doc = builder.build(xmlpath);
			Element root = doc.getRootElement();
			String strRate = root.getChildTextTrim(type);
			rate = Double.parseDouble(strRate);
			return rate;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 1;
	}
}
