package Adapter;

import tools.CurrencyParser;

public class EuroAdapter extends Adapter {
	private final String type = "euro";

	private EuroAdapter(){};
	
	@Override
	public Object getRate(String input) {
		CurrencyParser currency = new CurrencyParser();
		double rate = currency.getRate(type);
		return rate;
	}
}
