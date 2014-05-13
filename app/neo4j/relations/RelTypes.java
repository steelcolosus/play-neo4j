package neo4j.relations;

import org.neo4j.graphdb.RelationshipType;

public enum RelTypes implements RelationshipType {
	REACHABLE_BY_ROCKET,
	HAS_FACET,
	LIVES_ON
}