#!/bin/bash

set -o errexit
set -o nounset

SCRIPT=$(readlink -f "$0")

# Color modifiers
HF="\e[33m" #Highlight foreground
DF="\e[0m" #Default foregroud

##########################################
# Set the environment variables
##########################################
export M2_HOME=/opt/cdba/maven  #$M2_HOME #"$BASEDIR/../maven"
export M2=$M2_HOME/bin
export PATH="$M2:$PATH"
export ACTIVEPIVOT_LICENSE=/cdbashare/ActivePivot.lic.21127 #"$BASEDIR/../license"
export MVN_REPO=/cdbashare/activeviam/maven/repo #"$BASEDIR/../maven_repository"
export MVN_SETTINGS=/cdbashare/activeviam/maven/settings.xml
export JAVA_HOME=/usr/lib/jvm/java-1.8.0 #"$BASEDIR/../java"
export HOSTNAME=`hostname` #"quartet1.atc-hp.com"



echo "Recompiling project"
#mvn -s $MVN_SETTINGS test # Enough for having the classes in target
mvn -s $MVN_SETTINGS -o install



