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

submit_list = ""
i=0
r = ""
if c['type'].value == "teacher":
	sql = "SELECT problem_id from assignment_mcq WHERE assignment_id = {0}".format(int(aid)) 
	cursor.execute(sql) 
	problems = cursor.fetchall()
	x = cursor.rowcount
	answer = []
	p = []
	
	for row in problems:
		sql = "SELECT answer FROM problem_mcq WHERE problem_id = {0}".format(int(row[0]))
		cursor.execute(sql)
		d = cursor.fetchall()
		answer.append(d[0][0])
		p.append(row[0])
		
		
	sql = "SELECT DISTINCT(email) FROM submission_mcq WHERE assignment_id = {0}".format(int(aid))
	cursor.execute(sql)
	data = cursor.fetchall()
	
	
	for row in data:
		sql = "SELECT rno FROM student WHERE email_id = '{0}'".format(str(row[0]))
		cursor.execute(sql)
		reg_no = cursor.fetchall()
		
		sql = "SELECT result FROM result WHERE assignment_id = {0} and student_id = '{1}'".format(int(aid), str(row[0]))
		cursor.execute(sql)
		result = cursor.fetchall()
		p = tuple(p)
		#print p
		for i in range(0,x-1):
			#print p[i]
			#print ""
			sql="SELECT answer FROM submission_mcq WHERE assignment_id = {0} and email = '{1}' and problem_id = {2}".format(int(aid), str(row[0]), int(p[i]))
			cursor.execute(sql)
			ans = cursor.fetchall()
			#print ans
			#=print answer[0]
			
			if answer[i] == ans[0][0]:
				r = r + str(i+1)+". <span style='color:#00ff00;' class=' glyphicon glyphicon-ok '></span>&nbsp;&nbsp;"
			else:
				r = r + str(i+1) +". <span style='color:#ff0000;' class=' glyphicon glyphicon-remove '></span>&nbsp;&nbsp;"	
			
		submit_list = submit_list + "<div class='row'><div class='col-sm-3'>"+str(reg_no[0][0]).upper() +"</div>"+ "<div class='col-sm-7'>"+str(r) + "</div>"+"<div class='col-sm-2'>"+str(result[0][0])+"%</div></div><hr/>"
		r = ""
	print submit_list
	#print "Error"
else:
	print "Error"
	
