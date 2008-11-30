package test.thing;

import java.util.Collection;
import thewebsemantic.Namespace;

@Namespace("http://www.w3.org/2000/01/rdf-schema#")
public interface RdfsVocab {
	interface Class extends RdfsVocab {}
	interface Resource extends RdfsVocab {}
	
	RdfsVocab comment(Object o);
	Collection<String> comment();
	RdfsVocab label(Object o);
	Collection<String> label();
}
