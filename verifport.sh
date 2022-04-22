#!/bin/sh
val=$(lsof -i:$1);
if [ -z "$val" ]
then
      echo "0";
else
      echo "1";
fi
