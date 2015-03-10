#!/usr/bin/python
# -*- coding: utf-8 -*-

print "Cache-Control:no-store, no-cache, must-revalidate"
print "Content-Type: text/html\n\n"


from connection import cursor, db
import cgi, cgitb,Cookie,os

data = cgi.FieldStorage()
aid = data.getvalue("aid")

if 'HTTP_COOKIE' in os.environ:
	cookie_string=os.environ.get('HTTP_COOKIE')
	c=Cookie.SimpleCookie()
	c.load(cookie_string)

questions = ""
i=0
if c['type'].value == "teacher":
	sql = "SELECT problem_id from assignment_mcq WHERE assignment_id = {0}".format(int(aid)) 
	cursor.execute(sql) 
	data = cursor.fetchall()
	for row in data:
		sql = "SELECT * FROM problem_mcq WHERE problem_id = {0}".format(int(row[0]))
		cursor.execute(sql)
		data1 = cursor.fetchall()
		questions = questions+'''
					<p>'''+str(i+1)+'''. '''+data1[0][1]+'''</p>
					<p>option1 : '''+data1[0][2]+'''</p>
					<p>option2 : '''+data1[0][3]+'''</p>
					<p>option3 : '''+data1[0][4]+'''</p>
					<p>option4 : '''+data1[0][5]+'''</p>
					<p>Answer : '''+data1[0][6]+'''</p>
					<hr/>
		''' 
		i=i+1
	print questions
else:
	print "Error"
	
