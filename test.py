#!/usr/bin/python
from connection import cursor, db

answer = "option2"
correct =0
sql = "SELECT answer FROM problem_mcq WHERE problem_id = '{0}'".format("1")
cursor.execute(sql)
data1 = cursor.fetchall()
if data1[0][0] == answer:
	correct = correct + 1
print correct		
