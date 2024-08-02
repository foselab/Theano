#!/bin/bash

brew install gnu-sed

mvn eclipse:clean

mvn eclipse:eclipse

# remove path from .classpath
gsed -i '/src\/main\/java\/generated/d' ./.classpath

