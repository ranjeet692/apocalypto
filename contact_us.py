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
	TEMPLATE_FILE = "/var/www/html/contact_us.html" 
	templateVars = { "name" : c['name'].value,"footer": footer.html}
	template = templateEnv.get_template( TEMPLATE_FILE )
	print template.render(templateVars)
