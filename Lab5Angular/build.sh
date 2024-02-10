#!/usr/bin/env bash

main () {
    npm install
    npm run build
    
    title="angular-cameras"
    version="latest"
    docker build \
      -t "${title}":"${version}" .
}

main "$@"
