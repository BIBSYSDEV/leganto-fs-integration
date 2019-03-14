#!/usr/bin/env bash

java -Dmodels -jar swagger-codegen-cli.jar   generate -i https://api.fellesstudentsystem.no/models/swagger.json -l java  -o ../model -c config.json
