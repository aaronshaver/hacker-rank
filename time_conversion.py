#!/bin/python3

import sys

time = input().strip()
time_parts = time.split(':')

# a if condition else b

numeric_hour = int(time_parts[0])
hour_24_format = "00" if (numeric_hour == 12 and "AM" in time_parts[2]) else str(numeric_hour + 12)
time_parts[0] = hour_24_format

time_parts[2] = time_parts[2][:2]

print(":".join(time_parts))