package thewebsemantic;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.hp.hpl.jena.datatypes.xsd.XSDDateTime;
import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.rdf.model.Literal;
import com.hp.hpl.jena.rdf.model.RDFNode;

public class JenaHelper {

	public static Date date(Literal l) {
		XSDDateTime date = (XSDDateTime) l.getValue();
		return date.asCalendar().getTime();
	}
	
	public static List<Individual> listAllIndividuals(OntClass c) {
		return (c == null) ? new LinkedList<Individual>()
				: (List<Individual>) c.listInstances().toList();
	}

	public static Literal asLiteral(RDFNode n) {
		return (Literal) n.as(Literal.class);
	}

	public static Individual asIndividual(RDFNode n) {
		return (Individual) n.as(Individual.class);
	}
}
