#!/usr/bin/python
# -*- coding: utf-8 -*-

print "Cache-Control:no-store, no-cache, must-revalidate"
print "Content-Type: text/html\n\n"
from jinja2 import Template, Environment, FileSystemLoader
import cgi, cgitb,os
data = cgi.FieldStorage()
filename = data.getvalue("edit")
content = ""
#content load from file
f = open("/var/www/html/teacher/problem_create/"+str(filename) + ".txt", "r")
content = str(f.read())
f.close()
templateLoader = FileSystemLoader( searchpath="/" )
templateEnv = Environment( loader=templateLoader )
TEMPLATE_FILE = "/var/www/html/teacher/problem_editor.html"
template = templateEnv.get_template( TEMPLATE_FILE )
templateVars = { "content" :  content, "file": str(filename)}
print template.render( templateVars )
