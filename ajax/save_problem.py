#!/usr/bin/python
# -*- coding: utf-8 -*-

print "Cache-Control:no-store, no-cache, must-revalidate"
print "Content-Type: text/html\n\n"

import cgi, cgitb,os, Cookie
from cookie import c,load_cookie

load_cookie()
if c['type'].value == "teacher":
	data = cgi.FieldStorage()
	filename = data.getvalue("file")
	content = data.getvalue("content")


	#content load from file
	#os.chmod("/var/www/html/codemafia/course/"+str(cid) + "/" +str(filename) + ".txt", 0o777)
	f = open("/var/www/html/teacher/problem_create/"+str(filename) + ".txt", "w")
	f.write(str(content).lstrip(' '))
	f.close()
	
	print "Content is updated.Close the window to see the changes."
else:
	print "error occured while updating content"	

