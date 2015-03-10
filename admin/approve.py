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
query1="insert into problem_checked (problem_id,status) values ('{0}','approved')".format(str(pid))
problem_connect.cursor.execute(query)
data=problem_connect.cursor.fetchone()
problem_connect.cursor.execute(query1)
problem_connect.db.commit()
query2="INSERT INTO problem_code(problem_id, statement, sample_io, boundary, difficulty, topic, title, tc1, tc2, tc3, tc4, tc5, tc6, tc7, tc8, tc9, tc10) VALUES ('{0}','{1}','{2}','{3}','{4}','{5}','{6}','{7}','{8}','{9}','{10}','{11}','{12}','{13}','{14}','{15}','{16}')".format(str(data[0]),str(data[1]),str(data[2]),str(data[3]),str(data[4]),str(data[5]),str(data[6]),str(data[7]),str(data[8]),str(data[9]),str(data[10]),str(data[11]),str(data[12]),str(data[13]),str(data[14]),str(data[15]),str(data[16]))
connection.cursor.execute(query2)
connection.db.commit()
query="select * from problem_upload where problem_id not in (select problem_id from problem_checked)"
problem_connect.cursor.execute(query)
data=problem_connect.cursor.fetchall()
TEMPLATE_FILE = "/var/www/html/admin/home.html" 
templateVars = { "name" : c['name'].value,"data": data}
template = templateEnv.get_template( TEMPLATE_FILE )
print template.render(templateVars)
