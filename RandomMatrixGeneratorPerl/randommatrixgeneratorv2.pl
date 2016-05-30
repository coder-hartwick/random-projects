#/usr/bin/perl

use strict;
use warnings;

################################################################################
# Created by: Jordan Hartwick
# Date: May 29, 2016 @ 11:21 PM
# Usage: perl randommatrixgeneratorv2.pl rows columns maxvalue
#
# Purpose: Prints a matrix with a specified amount of rows and columns where all 
# values are less than the max argument.
#
# Test Run
################################################################################
# perl randommatrixgeneratorv2.pl 2 3 6
# [3,0,2]
# [5,0,1]
################################################################################

# Use the command line arguments to get the dimensions of the array and the max
# value.
for(my $i = 0; $i < $ARGV[0]; $i++) {

	print "[";
	for(my $j = 0; $j < $ARGV[1]; $j++) {
		if($j == $ARGV[1]-1) {
			print int rand($ARGV[2]);
		} else {
			printf("%d,",int rand($ARGV[2]));
		}
	}
	print "]\n";
}
