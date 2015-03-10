#!/usr/bin/python
# -*- coding: utf-8 -*-

print "Cache-Control:no-store, no-cache, must-revalidate"
print "Content-Type: text/html\n\n"
from cookie import c,load_cookie

from jinja2 import Template, Environment, FileSystemLoader
from connection import cursor, db
import cgi, cgitb,Cookie,os
import footer
data = cgi.FieldStorage()

cid = data.getvalue("cid")
#if 'HTTP_COOKIE' in os.environ:
#	cookie_string=os.environ.get('HTTP_COOKIE')
#	c=Cookie.SimpleCookie()
#	c.load(cookie_string)
load_cookie()
templateLoader = FileSystemLoader( searchpath="/" )
templateEnv = Environment( loader=templateLoader )
if c:
#fetching data from a table class
	sql = "SELECT course_id, name, description from courses WHERE course_id = '{0}'".format(str(cid)) 
	cursor.execute(sql)
	data = cursor.fetchall()
	for row in data:
		title = row[1]
		description = row[2]

	
	TEMPLATE_FILE = "/var/www/html/course.html"
	template = templateEnv.get_template( TEMPLATE_FILE )
	templateVars = { "title" : title, "description" :  description, "cid":cid,"name":c['name'].value, "footer": footer.html }
	print template.render( templateVars )
else:
	TEMPLATE_FILE = "/var/www/html/redirect.html"
	template = templateEnv.get_template( TEMPLATE_FILE )
	print template.render(  )
