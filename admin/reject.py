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
data = cgi.FieldStorage()
pid=data.getvalue('pid')
query="select * from problem_upload where problem_id='{0}'".format(str(pid))
query1="insert into problem_checked (problem_id,status) values ('{0}','rejected')".format(str(pid))
problem_connect.cursor.execute(query)
data=problem_connect.cursor.fetchone()
problem_connect.cursor.execute(query1)
problem_connect.db.commit()
query="select * from problem_upload where problem_id not in (select problem_id from problem_checked)"
problem_connect.cursor.execute(query)
data=problem_connect.cursor.fetchall()
TEMPLATE_FILE = "/var/www/html/admin/home.html" 
templateVars = { "name" : c['name'].value,"data": data}
template = templateEnv.get_template( TEMPLATE_FILE )
print template.render(templateVars)
