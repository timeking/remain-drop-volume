#!/usr/bin/env bash
docker build -t ${project.name} .
docker run -p 8080:8080 ${project.name}