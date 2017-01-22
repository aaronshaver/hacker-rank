#!/bin/python3

import sys

time = input().strip()
time_parts = time.split(':')

hour_is_am = True if "AM" in time_parts[2] else False

numeric_hour = int(time_parts[0])
if numeric_hour == 12 and hour_is_am:
    hour_24_format = "00"
elif numeric_hour < 12 and hour_is_am:
    hour_24_format = str(numeric_hour).zfill(2) # pad hour with zero if needed
elif numeric_hour == 12 and not hour_is_am:
    hour_24_format = numeric_hour
else:
    hour_24_format = numeric_hour + 12

time_parts[0] = str(hour_24_format)

time_parts[2] = time_parts[2][:2]

print(":".join(time_parts))
