package service;

import parse.Parser;

public abstract class HTMLFactory {

	public abstract Parser getParser(String parserName);
}
