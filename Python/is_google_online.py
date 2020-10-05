#!/usr/bin/python

# *************************************************************************
#
#     This is a online verification code.
#
#     @ecwolf
#
# *************************************************************************

from scapy.all import *
import socket

google = "8.8.8.8"  # destination IP

#Senging pakets
TIMEOUT = 2
conf.verb = 0
for i in range (0,101):
    packet = IP(dst=google, ttl=20)/ICMP()
    reply = sr1(packet, timeout=TIMEOUT)
    if not (reply is None):
	#Print the replied data
        print "online"
    else:
        print "Timeout waiting for %s" % packet[IP].dst
