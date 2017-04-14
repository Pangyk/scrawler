package Adapter;

import tools.CurrencyParser;

public class DollarAdapter extends Adapter {
	private final String type = "dollar";

	private DollarAdapter(){}
	
	@Override
	public Object getRate(String input) {
		CurrencyParser currency = new CurrencyParser();
		double rate = currency.getRate(type);
		return rate;
	}
}
