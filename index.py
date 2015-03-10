#!/usr/bin/python
# -*- coding: utf-8 -*-
print "Cache-Control:no-store, no-cache, must-revalidate"
import cgi,cgitb,Cookie,sha,time,os
import connection
import footer
#import session
from jinja2 import Template, Environment, FileSystemLoader
#for error reporting
cgitb.enable()
#what is the use of this line
templateLoader = FileSystemLoader( searchpath="/" )
templateEnv = Environment( loader=templateLoader )
# Create instance of FieldStorage 
form = cgi.FieldStorage() 
email = form.getvalue('email')
password  = form.getvalue('password')
login="select * from user"
connection.cursor.execute(login)
data=connection.cursor.fetchall()
reg=False
for row in data:
	if(row[0]==email and row[1]==password):
			reg=True
			name=row[3]
			type=row[2]
			break;	
if(reg==False):
	print "Content-Type: text/html\n\n"
	message="Wrong Details"
	TEMPLATE_FILE = "/var/www/html/default.html" 
	template = templateEnv.get_template( TEMPLATE_FILE )
	templateVars={"message":message}	
	print template.render( templateVars )

if(reg==True):	
	cookie = Cookie.SimpleCookie()
   	cookie['name'] = name
   	cookie['name']['expires'] = 12 * 30 * 24 * 60 * 60
	cookie['uid']=email
	cookie['uid']['expires'] = 12 * 30 * 24 * 60 * 60	
	#set cookie for login type
	cookie['type'] = type
	cookie['type']['expires'] = 12 * 30 * 24 * 60 * 60
	#modified on 22 jan
	print cookie.output()
	print "Content-Type: text/html\n\n"
	#if user is a teacher 
	#IF YOU ARE SEEING THIS ERROR THEN PLEASE REMOVE ALL COOKIES FOR THIS PAGE AND TRY AGAIN.
	if(type == "teacher"):
		sql = "SELECT course_id, name FROM courses WHERE teacher_id = '{0}'".format(str(cookie['uid'].value))
		connection.cursor.execute(sql)
		courses = connection.cursor.fetchall()
		TEMPLATE_FILE = "/var/www/html/teacher_home.html" 
		templateVars = { "title": "Course List","name" : cookie['name'].value, "courses": courses,"footer": footer.html}
		template = templateEnv.get_template( TEMPLATE_FILE )
		print template.render(templateVars)
	else:	
		course="select email,a.course_id,name from enrolled as a,courses as b where a.course_id=b.course_id and email='{0}'".format(str(email))
		connection.cursor.execute(course)
		enrolled=connection.cursor.fetchall()
		acourse="select * from courses"
		connection.cursor.execute(acourse)
		all_courses=connection.cursor.fetchall()
		p_query="select pp.ppid,pc.title,pc.difficulty from practise_problem as pp,problem_code as pc where ppid not in (select ppid from practise_submission where email_id='{0}') and pp.pid=pc.problem_id".format(str(email))
		s_query="select pp.ppid,pc.title,score from problem_code as pc,practise_problem as pp,practise_submission as ps where pp.pid=pc.problem_id and ps.email_id='{0}' and ps.ppid=pp.ppid" .format(str(email))
		connection.cursor.execute(p_query)
		p_problem=connection.cursor.fetchall()
		connection.cursor.execute(s_query)
		s_problem=connection.cursor.fetchall()		
		TEMPLATE_FILE = "/var/www/html/home.html" 
		template = templateEnv.get_template( TEMPLATE_FILE )
		templateVars = { "name" : name, "enrolled":enrolled,"all_courses":all_courses, "footer": footer.html,"p_problem":p_problem,"s_problem":s_problem}
		print template.render( templateVars )


