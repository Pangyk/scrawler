package tools;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class VisitParser {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Iterator getVisit(String path) {
		List list = new ArrayList();
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
			List tar = root.getChildren("visitgroup");
			for (Iterator iter = tar.iterator(); iter.hasNext();) {
				Element element = (Element) iter.next();
				List visit=element.getChildren("visit");
				for(Iterator itr = visit.iterator(); itr.hasNext();){
					Element e = (Element) itr.next();
					String v = e.getTextTrim();
					list.add(v);
				}
			}
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list.iterator();
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Iterator getUnVisit(String path) {
		List list = new ArrayList();
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
			List tar = root.getChildren("visitgroup");
			for (Iterator iter = tar.iterator(); iter.hasNext();) {
				Element element = (Element) iter.next();
				List visit=element.getChildren("unvisit");
				for(Iterator itr = visit.iterator(); itr.hasNext();){
					Element e = (Element) itr.next();
					String v = e.getTextTrim();
					list.add(v);
				}
			}
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list.iterator();
	}
}
