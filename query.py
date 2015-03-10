#!/usr/bin/python
# -*- coding: utf-8 -*-
print "Cache-Control:no-store, no-cache, must-revalidate"
import cgi,cgitb,Cookie,os,connection, footer
from jinja2 import Template, Environment, FileSystemLoader 
cgitb.enable()
templateLoader = FileSystemLoader( searchpath="/" )
templateEnv = Environment( loader=templateLoader )
form = cgi.FieldStorage() 
email = form.getvalue('email')
query  = form.getvalue('query')
st="insert into contact_us(email_id, query) values('{0}','{1}')".format(str(email),str(query))
connection.cursor.execute(st)
connection.db.commit()
print "Content-Type: text/html\n\n"
TEMPLATE_FILE = "/var/www/html/redirect.html" 
template = templateEnv.get_template( TEMPLATE_FILE )
print template.render()
