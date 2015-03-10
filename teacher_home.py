#!/usr/bin/python
print "Cache-Control:no-store, no-cache, must-revalidate"
import cgi,cgitb,Cookie,os, footer
from jinja2 import Template, Environment, FileSystemLoader 
from connection import cursor
print "Content-Type: text/html\n\n"
cgitb.enable()
templateLoader = FileSystemLoader( searchpath="/" )
templateEnv = Environment( loader=templateLoader )
if 'HTTP_COOKIE' in os.environ:
	cookie_string=os.environ.get('HTTP_COOKIE')
	c=Cookie.SimpleCookie()
	c.load(cookie_string)
	teacher_id = c['uid'].value
	name = c['name'].value
	TEMPLATE_FILE = "/var/www/html/default.html"
	sql = "SELECT course_id, name FROM courses WHERE teacher_id = '{0}'".format(str(teacher_id))
	cursor.execute(sql)
	courses = cursor.fetchall()
	
	TEMPLATE_FILE = "/var/www/html/teacher_home.html" 
	templateVars = { "title": "Course List","name" : name, "courses": courses,"footer": footer.html}
	template = templateEnv.get_template( TEMPLATE_FILE )
	print template.render(templateVars)
else:
	TEMPLATE_FILE = "/var/www/html/default.html"
	templateVars = { "footer": footer.html}
	template = templateEnv.get_template( TEMPLATE_FILE )
	print template.render(templateVars)
