#!/usr/bin/python
# -*- coding: utf-8 -*-

print "Cache-Control:no-store, no-cache, must-revalidate"
print "Content-Type: text/html\n\n"

import cgi, cgitb
from connection import cursor

data = cgi.FieldStorage()

assignment_id = data.getvalue("aid")
options = ""
sql = "SELECT problem_id FROM assignment_code WHERE assignment_id = '{0}'".format(str(assignment_id))
cursor.execute(sql)
data = cursor.fetchall()

for row in data:
	sql = "SELECT title FROM problem_code WHERE problem_id = '{0}'".format(str(row[0]))
	cursor.execute(sql)
	data1 = cursor.fetchall()
	for row1 in data1:
		options = options + "<option value="+row[0]+">"+row1[0]+"</option>"
		
print options		
