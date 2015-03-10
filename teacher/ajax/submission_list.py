#!/usr/bin/python
print "Cache-Control:no-store, no-cache, must-revalidate"
print "Content-Type: text/html\n\n"

import cgi, cgitb
from connection import cursor

data = cgi.FieldStorage()

problem_id = data.getvalue("pid")
assignment_id = data.getvalue("aid")
#problem_id = 4
#assignment_id = 4
list = ""
sql = "SELECT email_id, tc1,tc2,tc3,tc4,tc5,score, file_name FROM submission_code WHERE assignment_id = {0} and problem_id = {1}".format(int(assignment_id), int(problem_id))
cursor.execute(sql)
data = cursor.fetchall()
for row in data:
	sql = "SELECT rno, name FROM student WHERE email_id = '{0}'".format(str(row[0]))
	cursor.execute(sql)
	data1 = cursor.fetchall()
	e = "'" + str(row[0]) + "'"
	f = "'" + str(row[7]) + "'"
	n = "'" + str(data1[0][1]) + "'"
	l = "load_code("+e+","+f+","+n+")"
	
	for row1 in data1:
		if(row[0] is not None and row[1] is not None and row[2] is not None and row[3]  is not None and row[4] is not None and row[5] is not None):
			list = list + '<a href="#" class="list-group-item" onclick= "'+l+'")"><strong>'+str(row1[0]).upper()+'</strong> &nbsp; &nbsp;&nbsp;&nbsp;<span style="align=right;">'+str(row[1])[0:1]+', '+str(row[2])[0:1]+', '+str(row[3])[0:1]+', '+str(row[4])[0:1]+','+str(row[5])[0:1]+'</span></a>'

print list		
