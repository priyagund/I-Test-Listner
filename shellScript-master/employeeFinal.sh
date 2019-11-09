#! /bin/bash -x
emp=$((RANDOM%3))
if [ $emp == 1 ]
then
	echo employee is present
else
	echo employee is absent
fi
