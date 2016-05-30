#!/usr/bin/perl

use strict;
use warnings;


################################################################################
# Created by: Jordan Hartwick
# Date: May 29, 2016 @ 11:24 PM
# Usage: perl randommatrixgenerator.pl
#
# Purpose: Prints a matrix with a specified amount of rows and columns where all 
# values are less than the max argument.
#
# Test Run
################################################################################
# perl randommatrixgenerator.pl
# Type first and second dimensions: 2 3
# Type a max value: 10
# [9,5,4]
# [6,4,7]
################################################################################

# The following comment would create an array if uncommented.
# my @matrix

# Get the dimensions of the matrix and put them into an array.
print "Type first and second dimensions: ";
my $dim = <STDIN>;
my @dims = split(/ /, $dim);

# Get the max value that can be generated.
print "Type a max value: ";
my $max = <STDIN>;

# Print out the random numbers in the form of a matrix.
for(my $i=0; $i < $dims[0]; $i++) {

	print "[";
	for(my $j=0; $j < $dims[1]; $j++) {
	
		# The following comment would store a random value in the matrix.
		# $matrix[$i][$j] = int rand($max);
		if($j == $dims[1]-1) {
			print int rand($max);
		} else {
			printf("%d,",int rand($max));
		}
	}
	print "]\n";
}
