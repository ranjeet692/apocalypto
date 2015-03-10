#!/usr/bin/python
# -*- coding: utf-8 -*-

print "Content-Type: text/html\n\n"

import cgi,cgitb,Cookie, os
from connection import db, cursor
from jinja2 import Template, Environment, FileSystemLoader
import footer
import datetime

data = cgi.FieldStorage()
assignment_id = data.getvalue('aid')
course_id = data.getvalue('cid')
option = data.getvalue('option')

templateLoader = FileSystemLoader( searchpath="/" )
templateEnv = Environment( loader=templateLoader )

if 'HTTP_COOKIE' in os.environ:
	cookie_string=os.environ.get('HTTP_COOKIE')
	c=Cookie.SimpleCookie()
	c.load(cookie_string)
	
now = datetime.datetime.now()

if c['type'].value == "teacher":
	sql = "SELECT enddate, type FROM assignment WHERE assignment_id = {0}".format(assignment_id)
	cursor.execute(sql)
	data = cursor.fetchall()
	if data[0][1] == "code" and data[0][0] > now:
		sql = "SELECT problem_id, statement, sample_io, boundary, difficulty, topic, title FROM problem_code"
		cursor.execute(sql)
		data = cursor.fetchall()
		TEMPLATE_FILE = "/var/www/html/teacher/add_problem.html"
		template = templateEnv.get_template( TEMPLATE_FILE )
		templateVars = { "name":c['name'].value, "footer": footer.html, "plist": data, "aid":assignment_id,"cid":course_id, "option":option }
		print template.render( templateVars )
	elif data[0][1] == "MCQ" and data[0][0] > now:
		sql = "SELECT * FROM problem_mcq"
		cursor.execute(sql)
		data = cursor.fetchall()
		TEMPLATE_FILE = "/var/www/html/teacher/add_problem_mcq.html"
		template = templateEnv.get_template( TEMPLATE_FILE )
		templateVars = { "name":c['name'].value, "footer": footer.html, "plist": data, "aid":assignment_id,"cid":course_id, "option":option }
		print template.render( templateVars )
	else:
		print "Error"	
		
			
		
