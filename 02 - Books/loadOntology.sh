 #!/bin/bash

graql=/media/martin/BlackData/Development/Grakn/linux/grakn-core-1.4.3/graql

$graql console -f book-ontology.gql -k books
$graql console -f book-rules.gql -k books
$graql console -f book-data.gql  -k books
