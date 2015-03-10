#!/usr/bin/python
# -*- coding: utf-8 -*-
import cgi,cgitb
import connection,problem_connect,os
print "Cache-Control:no-store, no-cache, must-revalidate"
from jinja2 import Template, Environment, FileSystemLoader
from cookie import c,load_cookie
cgitb.enable()
templateLoader = FileSystemLoader( searchpath="/" )
templateEnv = Environment( loader=templateLoader )
load_cookie()
form = cgi.FieldStorage() 
tc=[]
op=[]
difficulty = form.getvalue('difficulty')
topic  = form.getvalue('topic')
title = form.getvalue('title')
for i in range(1,6):
	tc.append(str(form.getvalue('tc'+str(i))))
for i in range(1,6):
	op.append(str(form.getvalue('op'+str(i))))
query="select max(problem_id) from problem_upload"
problem_connect.cursor.execute(query)
data=problem_connect.cursor.fetchone()
pid=str(data[0]+1)
f="/var/www/html/input/"+str(pid)+"/"
if not os.path.exists(f):
	os.makedirs(f,0775)
for i in range(1,6):
	inp="/var/www/html/input/"+str(pid)+"/"+str(i)+".txt"
#	act="/var/www/html/teacher/problem_create/tc"+str(i)+".txt"
	f1=open(inp,"w+")
#	f2=open(act,"r")
#	s=f2.read()
#	f2.close()
#	open(act, 'w').close()
	f1.write(tc[i-1])
	f1.close()
f="/var/www/html/output/"+str(pid)+"/"
if not os.path.exists(f):
	os.makedirs(f,0775)
for i in range(1,6):
	inp="/var/www/html/output/"+str(pid)+"/"+str(i)+".txt"
#	act="/var/www/html/teacher/problem_create/op"+str(i)+".txt"
	f1=open(inp,"w+")
#	f2=open(act,"r")
#	s=f2.read()
#	f2.close()
#	open(act, 'w').close()
	f1.write(op[i-1])
	f1.close()
act="/var/www/html/teacher/problem_create/ps1.txt"
f2=open(act,"r")
statement=f2.read()
f2.close()
open(act, 'w').close()
act="/var/www/html/teacher/problem_create/ps2.txt"
f2=open(act,"r")
sio=f2.read()
f2.close()
open(act, 'w').close()
act="/var/www/html/teacher/problem_create/ps3.txt"
f2=open(act,"r")
boundary=f2.read()
f2.close()
open(act, 'w').close()
tc1='/var/www/html/input/'+str(pid)+'/1.txt'
tc2='/var/www/html/input/'+str(pid)+'/2.txt'
tc3='/var/www/html/input/'+str(pid)+'/3.txt'
tc4='/var/www/html/input/'+str(pid)+'/4.txt'
tc5='/var/www/html/input/'+str(pid)+'/5.txt'
op1='/var/www/html/output/'+str(pid)+'/1.txt'
op2='/var/www/html/output/'+str(pid)+'/2.txt'
op3='/var/www/html/output/'+str(pid)+'/3.txt'
op4='/var/www/html/output/'+str(pid)+'/4.txt'
op5='/var/www/html/output/'+str(pid)+'/5.txt'
query="INSERT INTO problem_upload(problem_id,statement, sample_io, boundary, difficulty, topic,title, tc1, tc2, tc3, tc4, tc5, op1, op2, op3, op4, op5, uid) VALUES ('{0}','{1}','{2}','{3}','{4}','{5}','{6}','{7}','{8}','{9}','{10}','{11}','{12}','{13}','{14}','{15}','{16}','{17}')".format(str(pid),statement,sio,boundary,difficulty,topic,title,tc1,tc2,tc3,tc4,tc5,op1,op2,op3,op4,op5,str(c['uid'].value))
problem_connect.cursor.execute(query)
problem_connect.db.commit()
print "Content-Type: text/html\n\n"
TEMPLATE_FILE = "/var/www/html/teacher/redirect.html"
template = templateEnv.get_template( TEMPLATE_FILE )
#templateVars = { "title" : title, "cid":cid,"name":c['name'].value,"footer": footer.html }
print template.render()

