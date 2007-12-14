package example;

import static java.lang.System.out;
import static thewebsemantic.RdfBean.load;
import java.util.Collection;
import thewebsemantic.binding.Jenabean;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.ModelFactory;

public class GeonamesExample {
	
	/**
	 * load up all the cities from capitals.rdf, based on ontology
	 * defined in geonames.owl.
	 * 
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		
		//prepare the jena model
		OntModel m = ModelFactory.createOntologyModel();
		m.read("file:src/example/geonames.owl");
		m.read("file:src/example/capitals.rdf");
		
		//setup binding
		Jenabean b = Jenabean.instance();
		b.bind(m);
		b.bind(GeonamesVocabulary.Feature).to(City.class);
		Collection<City> cities = load(City.class);
		out.println("Cities in rdf triple store: " + cities.size());
		for (City city : cities) {
			city.fill("alternateNames");
			out.println('\n' + city.getName() + " pop. " + city.getPopulation());
			out.println("\turi: " + city.getUri());
			out.println("\tnumber of translations: " + 
					city.getAlternateNames().size());
		}
	}
}
