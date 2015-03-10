#!/usr/bin/python
# -*- coding: utf-8 -*-

print "Cache-Control:no-store, no-cache, must-revalidate"
print "Content-Type: text/html\n\n"

from jinja2 import Template, Environment, FileSystemLoader
from connection import cursor, db
import cgi, cgitb,Cookie,os
import footer
data = cgi.FieldStorage()
cid = data.getvalue("cid")
title = "NeoScript | Report"

if 'HTTP_COOKIE' in os.environ:
	cookie_string=os.environ.get('HTTP_COOKIE')
	c=Cookie.SimpleCookie()
	c.load(cookie_string)

templateLoader = FileSystemLoader( searchpath="/" )
templateEnv = Environment( loader=templateLoader )
if c['type'].value == "teacher":
	TEMPLATE_FILE = "/var/www/html/teacher/feedback.html"
	template = templateEnv.get_template( TEMPLATE_FILE )
	templateVars = { "title" : title,  "cid":cid,"name":c['name'].value, "footer": footer.html }
	print template.render( templateVars )
else:
	TEMPLATE_FILE = "/var/www/html/redirect.html"
	template = templateEnv.get_template( TEMPLATE_FILE )
	print template.render(  )
