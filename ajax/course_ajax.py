#!/usr/bin/python

print "Content-Type: text/html\n"

import cgi, cgitb
from connection import cursor, db

data= cgi.FieldStorage()

course_id = data.getvalue("course_id")
field = data.getvalue("field")

#print classid
#print field

sql = "SELECT {0} from courses WHERE course_id = '{1}' ".format(str(field), str(course_id))
cursor.execute(sql)
data = cursor.fetchall()
for row in data:
	timeline = row[0] 
	
print timeline
