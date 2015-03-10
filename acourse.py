#!/usr/bin/python
# -*- coding: utf-8 -*-
import cgi,cgitb,connection
from jinja2 import Template, Environment, FileSystemLoader 
print "Content-Type: text/html\n\n"
cgitb.enable()
templateLoader = FileSystemLoader( searchpath="/" )
templateEnv = Environment( loader=templateLoader )
acourse="select * from courses"
connection.cursor.execute(acourse)
all_courses=connection.cursor.fetchall()
TEMPLATE_FILE = "/var/www/html/acourse.html" 
templateVars = { "all_courses":all_courses}
template = templateEnv.get_template( TEMPLATE_FILE )
print template.render(templateVars)
