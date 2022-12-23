#!/bin/sh
for ((i=0; i<=1000; i++)); do
  echo "Número: $i"

  curl -X 'GET' \
    'http://localhost:8080/api/friend/v1' \
    -H 'accept: application/json'

done