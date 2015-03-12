package org.fit.layout.eswc.vocabulary;

import org.openrdf.model.URI;
import org.openrdf.model.ValueFactory;
import org.openrdf.model.impl.ValueFactoryImpl;

/**
 * Updated version of the swrc ontology (v0.7.1) based on the original
 * swrc ontology. Responsible ontology engineer: Philipp Zaltenbach.
 * Date: 22.06.2007. Contributions made by: Olivier Dameron..
 * <p>
 * Namespace SWRC.
 * Prefix: {@code <http://swrc.ontoware.org/ontology-07>}
 */
public class SWRC {

	/** {@code http://swrc.ontoware.org/ontology-07} **/
	public static final String NAMESPACE = "http://swrc.ontoware.org/ontology-07";

	/** {@code swrc} **/
	public static final String PREFIX = "swrc";

	static {
		ValueFactory factory = ValueFactoryImpl.getInstance();

	}

	private SWRC() {
		//static access only
	}

}
