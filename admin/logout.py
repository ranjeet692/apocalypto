#!/usr/bin/python
# -*- coding: utf-8 -*-
import cgi,cgitb,Cookie,os
print "Cache-Control:no-store, no-cache, must-revalidate"
#print "Content-Type: text/html\n\n"
#form = cgi.FieldStorage() 
cgitb.enable()
#import session
from jinja2 import Template, Environment, FileSystemLoader
import sys, os
#sys.path.append(os.environ['DOCUMENT_ROOT'])
#sess=form.getvalue('s')
#sess.close()
if 'HTTP_COOKIE' in os.environ:
	cookie_string=os.environ.get('HTTP_COOKIE')
	c=Cookie.SimpleCookie()
	c.load(cookie_string)
	c['name']['expires']='Thu, 01 Jan 1970 00:00:00 GMT'
	c['uid']['expires']='Thu, 01 Jan 1970 00:00:00 GMT'
	#modified on 22nd Jan
	c['type']['expires']='Thu, 01 Jan 1970 00:00:00 GMT'
	print c.output()
	print "Content-Type: text/html\n\n"	
	templateLoader = FileSystemLoader( searchpath="/" )
	templateEnv = Environment( loader=templateLoader )
	TEMPLATE_FILE = "/var/www/html/admin/redirect.html" 	
	template = templateEnv.get_template( TEMPLATE_FILE )
	print template.render()

