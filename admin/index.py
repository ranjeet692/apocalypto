#!/usr/bin/python
# -*- coding: utf-8 -*-
import cgi,cgitb
import problem_connect,os,connection
print "Cache-Control:no-store, no-cache, must-revalidate"
from jinja2 import Template, Environment, FileSystemLoader
import Cookie,os
cgitb.enable()
templateLoader = FileSystemLoader( searchpath="/" )
templateEnv = Environment( loader=templateLoader )
c=Cookie.SimpleCookie()
if 'HTTP_COOKIE' in os.environ:
	cookie_string=os.environ.get('HTTP_COOKIE')
	c.load(cookie_string)
	if c['type'].value =='admin':
		query="select * from problem_upload where problem_id not in (select problem_id from problem_checked)"
		problem_connect.cursor.execute(query)
		data=problem_connect.cursor.fetchall()
		print "Content-Type: text/html\n\n"			
		TEMPLATE_FILE = "/var/www/html/admin/home.html" 
		templateVars = { "name" : c['name'].value,"data": data}
		template = templateEnv.get_template( TEMPLATE_FILE )
		print template.render(templateVars)
	else:	
		#c['name']['expires']='Thu, 01 Jan 1970 00:00:00 GMT'
		#c['type']['expires']='Thu, 01 Jan 1970 00:00:00 GMT'
		#c['uid']['expires']='Thu, 01 Jan 1970 00:00:00 GMT'
		#print c.output()
		print "Content-Type: text/html\n\n"
		print ""
		print ""		
		TEMPLATE_FILE = "/var/www/html/admin/login.html" 
		template = templateEnv.get_template( TEMPLATE_FILE )
		print template.render()
else:
	print "Content-Type: text/html\n\n"
	TEMPLATE_FILE = "/var/www/html/admin/login.html" 
	template = templateEnv.get_template( TEMPLATE_FILE )
	print template.render()

