#!/usr/bin/env bash

curl -i -X POST -H "Content-Type: application/json" --data-binary "@./src/main/resources/AR-Report-10.txt" localhost:8080/schedule