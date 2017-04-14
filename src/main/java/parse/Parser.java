package parse;

import java.util.Iterator;

public abstract class Parser {

	public abstract Iterator<Product> getProduct(String html);
}
