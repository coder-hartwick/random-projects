#!/bin/bash
#
################################################################################
# Author: Jordan Hartwick
# Date: May 15, 2016 (approximately)
# Usage: mrgvid "first video" "second video" "output file"
# Examples: 
# 			mrgvid "video one.mp4" "video two.mp4" "video one and two.mp4"
#			mrgvid videoone.mp4 videotwo.mp4 videooneandtwo.mp4
#
# Purpose: To merge two videos from the command line.
# ------------------------------------------------------------------------------
# To make this a system wide script, remove the ".sh" file extension and move it
# to the directory /usr/bin.
# 
# Here are the commands to copy the file to /usr/bin:
# mv mrgvid.sh mrgvid
# chmod +x mrgvid
# sudo cp mrgvid /usr/bin
# ------------------------------------------------------------------------------
# If you want to move the mrgvid file to /usr/bin, use the mv command instead of
# the cp command.
#
# This was tested on the 64 bit OS UbuntuMATE on May 15, 2016 (approximately).
################################################################################
if [ "$1" == "" ] || [ "$2" == "" ] || [ "$1" == "--help" ] || [ "$3" == "" ]; then
	echo "Usage: mrgvid <input file one> <input file 2> <output file>"
	exit
fi

ffmpeg -i "$1" -vcodec copy -acodec copy -vbsf h264_mp4toannexb -f mpegts intermediate1.ts
ffmpeg -i "$2" -vcodec copy -acodec copy -vbsf h264_mp4toannexb -f mpegts intermediate2.ts
ffmpeg -i "concat:intermediate1.ts|intermediate2.ts" -vcodec copy -acodec copy -absf aac_adtstoasc "$3"

rm intermediate1.ts
rm intermediate2.ts

echo "Done"
