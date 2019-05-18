 #!/bin/bash

graql=/media/martin/BlackData/Development/Grakn/linux/grakn-core-1.4.3/graql

$graql console -f movies-ontology.gql -k movies
$graql console -f movies-rules.gql -k movies
