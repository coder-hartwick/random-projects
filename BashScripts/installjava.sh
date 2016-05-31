#!/bin/bash
#
################################################################################
# Author: Jordan Hartwick
# Date: March 27, 2016 @ 1:09 PM
# Usage: installjava "jdk compressed archive" "jdk version"
# Examples: 
#			installjava jdk1.8.0_77.tar.gz jdk1.8.0_77
#
# Purpose: To install the java development kit in Kali Linux.
# ------------------------------------------------------------------------------
# To make this a system wide script, remove the ".sh" file extension and move it
# to the directory /usr/bin.
# 
# Here are the commands to copy the file to /usr/bin:
# mv installjava.sh installjava
# chmod +x installjava
# sudo cp installjava /usr/bin
# ------------------------------------------------------------------------------
# If you want to move the installjava file to /usr/bin, use the mv command 
# instead of the cp command.
#
# This was tested on the 64 bit OS Kali Linux on March 27, 2016.
################################################################################
if [ "$1" == "" ]; then
	echo "Usage: installjava <java zip package> <jdk version>"
	exit 0
fi
tar -xzvf $1
mv $2 /opt
cd /opt/$2
update-alternatives --install /usr/bin/java java /opt/$2/bin/java 1
update-alternatives --install /usr/bin/javac javac /opt/$2/bin/javac 1
update-alternatives --install /usr/lib/mozilla/plugins/libjavaplugin.so mozilla-javaplugin.so /opt/$2/jre/lib/amd64/libnpjp2.so 1
update-alternatives --set java /opt/$2/bin/java
update-alternatives --set javac /opt/$2/bin/javac
update-alternatives --set mozilla-javaplugin.so /opt/$2/jre/lib/amd64/libnpjp2.so
java -version
javac -version
