#!/usr/bin/env bash

# This variable contains absolute path of this `parking_lot` script
DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" >/dev/null && pwd )"

   java -jar -cp $DIR/../target/dkatalis.jar  $1

