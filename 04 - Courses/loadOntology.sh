 #!/bin/bash

graql=/media/martin/BlackData/Development/Grakn/linux/grakn-core-1.4.3/graql

$graql console -f courses-ontology.gql -k courses
$graql console -f courses-rules.gql -k courses
