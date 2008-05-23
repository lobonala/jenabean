package test.fieldaccess;

import thewebsemantic.RdfProperty;

public class FatAlbert {
	
	@RdfProperty("http://weird/url/goes/here/")
	private String name = "fatalbert";

	public String toString() {
		return name;
	}
	
	public String name() {
		return name;
	}
}