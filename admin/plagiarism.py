#!/usr/bin/python
# -*- coding: utf-8 -*-
import cgi,cgitb
import connection,problem_connect,os
print "Cache-Control:no-store, no-cache, must-revalidate"
from jinja2 import Template, Environment, FileSystemLoader
from cookie import c,load_cookie
cgitb.enable()
print "Content-Type: text/html\n\n"
templateLoader = FileSystemLoader( searchpath="/" )
templateEnv = Environment( loader=templateLoader )
load_cookie()
query="select a.assignment_id,problem_id,title,startdate,enddate,course_id from assignment_code as a,assignment as b where a.assignment_id=b.assignment_id and problem_id not in (select problem_id from plagiarism)"
connection.cursor.execute(query)
data=connection.cursor.fetchall()
TEMPLATE_FILE = "/var/www/html/admin/plagiarism.html" 
templateVars = { "name" : c['name'].value,"data": data}
template = templateEnv.get_template( TEMPLATE_FILE )
print template.render(templateVars)
