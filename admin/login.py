#!/usr/bin/python
# -*- coding: utf-8 -*-
import cgi,cgitb
print "Cache-Control:no-store, no-cache, must-revalidate"
import connection,problem_connect,os
from jinja2 import Template, Environment, FileSystemLoader
import Cookie
cgitb.enable()
form = cgi.FieldStorage()
email=form.getvalue('email')
password=form.getvalue('password')
templateLoader = FileSystemLoader( searchpath="/" )
templateEnv = Environment( loader=templateLoader )
query="select * from user where email_id='{0}' and password='{1}'".format(str(email),str(password))
problem_connect.cursor.execute(query)
data=problem_connect.cursor.fetchone()
name=''
if data is None:
	print "Content-Type: text/html\n\n"
	TEMPLATE_FILE = "/var/www/html/admin/login.html" 
	template = templateEnv.get_template( TEMPLATE_FILE )
	print template.render()
else:
	name=data[2]
	cookie = Cookie.SimpleCookie()
   	cookie['name'] = data[2]
   	cookie['name']['expires'] = 12 * 30 * 24 * 60 * 60
	cookie['uid']=email
	cookie['uid']['expires'] = 12 * 30 * 24 * 60 * 60	
	#set cookie for login type
	cookie['type'] = 'admin'
	cookie['type']['expires'] = 12 * 30 * 24 * 60 * 60
	print cookie.output()
	print "Content-Type: text/html\n\n"
	print ""
	print ""
	query="select * from problem_upload where problem_id not in (select problem_id from problem_checked)"
	problem_connect.cursor.execute(query)
	data=problem_connect.cursor.fetchall()
	TEMPLATE_FILE = "/var/www/html/admin/home.html" 
	templateVars = { "name" : name,"data": data}
	template = templateEnv.get_template( TEMPLATE_FILE )
	print template.render(templateVars)
