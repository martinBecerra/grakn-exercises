 #!/bin/bash

graql="/Users/martinbecerra/Development/Grakn/core-1.4.3/graql"

$graql console -f patient-ontology.gql -k patients
$graql console -f patient-rules.gql -k patients
