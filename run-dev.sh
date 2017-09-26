#!/usr/bin/env bash

set -e

cd config-service
#mvn spring-boot:stop
mvn spring-boot:run
cd ..

cd eureka-service
#mvn spring-boot:stop
mvn spring-boot:run
cd ..


