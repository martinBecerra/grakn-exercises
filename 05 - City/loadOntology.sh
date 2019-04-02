 #!/bin/bash

graql=/media/martin/BlackData/Development/Grakn/linux/grakn-core-1.4.3/graql

$graql console -f city-ontology.gql -k city
$graql console -f city-rules.gql    -k city
