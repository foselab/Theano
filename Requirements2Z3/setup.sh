#!/bin/bash

mvn eclipse:clean

mvn eclipse:eclipse

# remove path from .classpath
sed -i '/src\/main\/java\/generated/d' .classpath

