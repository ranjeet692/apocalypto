#!/usr/bin/python
print "Content-Type: text/html\n\n"
import cgi, cgitb
import os, Cookie	

form = cgi.FieldStorage()
ppid=form.getvalue("ppid")
if ppid==None:
	problem_id= form.getvalue("pid")
	assignment_id=form.getvalue("aid")
filename  = form.getvalue("file")
print filename
if 'HTTP_COOKIE' in os.environ:
	cookie_string=os.environ.get('HTTP_COOKIE')
	c=Cookie.SimpleCookie()
	c.load(cookie_string)

if ppid==None:
	contents = open("/var/www/html/submission/"+ c['uid'].value + "/" + assignment_id + "/" + filename).read()
else:
	contents = open("/var/www/html/submission/"+ c['uid'].value + "/p_problem" + "/" + filename).read()
print contents
