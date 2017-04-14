package tools;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

public class FactoryParser {

	public String getFactory(String path) {
		String xmlpath = System.getProperty("user.dir") + path;

		try {
			xmlpath = URLDecoder.decode(xmlpath, "utf-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}

		SAXBuilder builder = new SAXBuilder(false);
		try {
			Document doc = builder.build(xmlpath);
			Element root = doc.getRootElement();
			String factory = root.getChildTextTrim("factory");
			return factory;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
