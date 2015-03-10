#!/usr/bin/python
# -*- coding: utf-8 -*-
print "Cache-Control:no-store, no-cache, must-revalidate"
import cgi,cgitb,Cookie,os,connection, footer
from jinja2 import Template, Environment, FileSystemLoader 
print "Content-Type: text/html\n\n"
cgitb.enable()
templateLoader = FileSystemLoader( searchpath="/" )
templateEnv = Environment( loader=templateLoader )
if 'HTTP_COOKIE' in os.environ:
	cookie_string=os.environ.get('HTTP_COOKIE')
	c=Cookie.SimpleCookie()
	c.load(cookie_string)
	TEMPLATE_FILE = "/var/www/html/default.html"
	#check user type modified on 22nd Jan
	#IF YOU ARE SEEING THIS ERROR THEN PLEASE REMOVE ALL COOKIES FOR THIS PAGE AND TRY AGAIN.
	if (c['type'].value == "teacher"):
		sql = "SELECT course_id, name FROM courses WHERE teacher_id = '{0}'".format(str(c['uid'].value))
		connection.cursor.execute(sql)
		courses = connection.cursor.fetchall()
		TEMPLATE_FILE = "/var/www/html/teacher_home.html" 
		templateVars = { "title": "Course List","name" : c['name'].value, "courses": courses,"footer": footer.html}
		template = templateEnv.get_template( TEMPLATE_FILE )
		print template.render(templateVars)
	else:
		course="select email,a.course_id,name from enrolled as a,courses as b where a.course_id=b.course_id and email=('{0}')".format(str(c['uid'].value))
		connection.cursor.execute(course)
		enrolled=connection.cursor.fetchall()
		acourse="select * from courses"
		connection.cursor.execute(acourse)
		all_courses=connection.cursor.fetchall()	
		p_query="select pp.ppid,pc.title,pc.difficulty from practise_problem as pp,problem_code as pc where ppid not in (select ppid from practise_submission where email_id='{0}') and pp.pid=pc.problem_id".format(str(c['uid'].value))
		connection.cursor.execute(p_query)
		p_problem=connection.cursor.fetchall()	
		s_query="select pp.ppid,pc.title,score from problem_code as pc,practise_problem as pp,practise_submission as ps where pp.pid=pc.problem_id and ps.email_id='{0}' and ps.ppid=pp.ppid" .format(str(c['uid'].value))
		connection.cursor.execute(s_query)
		s_problem=connection.cursor.fetchall()	
		TEMPLATE_FILE = "/var/www/html/home.html" 
		templateVars = { "name" :c['name'].value,"enrolled":enrolled,"all_courses":all_courses,"footer":footer.html,"p_problem":p_problem,"s_problem":s_problem}
		template = templateEnv.get_template( TEMPLATE_FILE )
		print template.render(templateVars)
else:
	TEMPLATE_FILE = "/var/www/html/default.html"
	templateVars = { "footer": footer.html}
	template = templateEnv.get_template( TEMPLATE_FILE )
	print template.render(templateVars)
