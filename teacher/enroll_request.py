#!/usr/bin/python
# -*- coding: utf-8 -*-

print "Cache-Control:no-store, no-cache, must-revalidate"
print "Content-Type: text/html\n\n"

from jinja2 import Template, Environment, FileSystemLoader
from connection import cursor, db
import cgi, cgitb,Cookie,os
import footer
data = cgi.FieldStorage()
cid = data.getvalue("cid")
title = "NeoScript | Report"
var = ''

if 'HTTP_COOKIE' in os.environ:
	cookie_string=os.environ.get('HTTP_COOKIE')
	c=Cookie.SimpleCookie()
	c.load(cookie_string)

templateLoader = FileSystemLoader( searchpath="/" )
templateEnv = Environment( loader=templateLoader )
if c['type'].value == "teacher":
	sql = "SELECT email_id FROM enroll_request WHERE course_id = {0}".format(int(cid))
	cursor.execute(sql)
	data = cursor.fetchall()
	l = []
	for row in data:
		sql = "SELECT * FROM student WHERE email_id = '{0}'".format(row[0])
		cursor.execute(sql)
		data1 = cursor.fetchall()
		#print data1
		#l.append(data1[0])
		var=var+'<tr><td>'+str(data1[0][0])+'</td><td>'+str(data1[0][4])+'</td><td>'+str(data1[0][3])+'</td><td>'+str(data1[0][1])+'</td><td>'+str(data1[0][2])+'</td><td><button type="button" class="btn btn-info btn-block" id="'+str(data1[0][1])+'" onclick=approveEnroll(this.id)>Approve</button></td></tr>'

	
	TEMPLATE_FILE = "/var/www/html/teacher/enroll_request.html"
	template = templateEnv.get_template( TEMPLATE_FILE )
	templateVars = { "title" : title,  "cid":cid,"name":c['name'].value, "footer": footer.html,"l":var}
	print template.render( templateVars )
else:
	TEMPLATE_FILE = "/var/www/html/redirect.html"
	template = templateEnv.get_template( TEMPLATE_FILE )
	print template.render(  )
