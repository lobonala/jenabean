package example.transitive;

import static com.hp.hpl.jena.ontology.OntModelSpec.OWL_MEM_MICRO_RULE_INF;
import thewebsemantic.Bean2RDF;
import thewebsemantic.RDF2Bean;

import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.ModelFactory;

public class Main {

	/**
	 * 
	 */
	public static void main(String[] args) {
		//OntModel m = ModelFactory.createOntologyModel(OWL_MEM_MICRO_RULE_INF); 
		OntModel m = ModelFactory.createOntologyModel();
		Bean2RDF writer = new Bean2RDF(m);
		
		init(writer);
		//writer.n3();

		RDF2Bean reader = new RDF2Bean(m);
		City sfo = reader.load(City.class, "SFO");

		System.out.println("San Francisco is within the following...");
		for (Location l : sfo.within)
			System.out.println('\t' + l.name + ":" + l.getClass().getSimpleName());

		
		Continent na = reader.load(Continent.class, "NA");
		System.out.println("The following are contained withing North America...");
		for (Location l : na.contains)
			System.out.println('\t' + l.name );
		
	}

	
	private static void init(Bean2RDF writer) {
		
		Continent na = new Continent("NA");
		na.name = "North America";
		
		Country usa = new Country("USA");
		usa.name = "United States of America";
		
		State cali = new State("CA");
		cali.name = "California";
		
		City sanfran = new City("SFO");
		sanfran.name = "San Francisco";
		
		sanfran.within.add(cali);
		cali.within.add(usa);
		usa.within.add(na);
		
		//na.contains.add(sanfran);
		writer.saveDeep(sanfran);
		
		
		
	}

}