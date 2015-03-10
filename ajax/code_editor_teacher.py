#!/usr/bin/python
print "Content-Type: text/html\n\n"
import cgi, cgitb
import os, Cookie	

form = cgi.FieldStorage()
email_id = form.getvalue("email_id")
problem_id= form.getvalue("pid")
assignment_id=form.getvalue("aid")
filename  = form.getvalue("file")

contents = open("/var/www/html/submission/"+ email_id + "/" + assignment_id + "/" + filename).read()
print contents
