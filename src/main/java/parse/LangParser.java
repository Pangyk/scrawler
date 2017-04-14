package parse;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class LangParser extends Parser {

	public Iterator<Product> getProduct(String html) {
		List<Product> list = new ArrayList<Product>();
		Document doc = Jsoup.parse(html);
		Elements links = doc.getElementsByClass("fn");

		String product = null;
		for (Element e : links) {
			product = e.text();
		}
		if(product==null){
			return list.iterator();
		}

		String img = "";
		try {
			Element link1 = doc.getElementById("preview").child(0).child(0);
			img = link1.attr("src");
		} catch (Exception e) {
		}

		String des = "";
		Elements link2 = doc.getElementsByClass("label");
		for (Element e : link2) {
			des += e.text();
			des += e.parent().text();
		}
		
		String value="0";
		Elements link3 = doc.getElementsByClass("num");
		for (Element e : link3) {
			value = e.text();
		}
		
		Product pro = new Product("",product,1,0,"","","0",img,0,des,value);
		list.add(pro);
		
		try {
		Elements link4 = doc.getElementsByClass("boxMidRt boxOBPad");
		for (Element e : link4) {
			Elements link5 = e.child(0).child(0).children();
			int index=0;
			for(Element e1 : link5){
				if(index==0){
					index++;
					continue;
				}
				String imgUrl = e1.child(0).child(0).attr("src");
				String name = e1.child(1).child(0).text();
				String s = e1.child(2).child(1).text();
				String price = e1.child(4).child(0).text();
				String sUrl = e1.child(2).child(1).html();
				
				int start,end = 0;
				start = sUrl.indexOf("\"");
				end = sUrl.indexOf("\"",10);
				if(end>start+1&&start>0){
					sUrl = sUrl.substring(start+1, end);
				}else{
					sUrl = "";
				}
				
				Product proElement = new Product(name,product,0,0,s,sUrl,price,imgUrl,0,"","");
				list.add(proElement);
			}
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list.iterator();
	}
}
