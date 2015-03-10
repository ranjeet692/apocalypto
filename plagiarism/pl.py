#!/usr/bin/python
# -*- coding: utf-8 -*-
import subprocess,os
import sys,glob
import cgi,cgitb
import connection,problem_connect
from jinja2 import Template, Environment, FileSystemLoader
from cookie import c,load_cookie
templateLoader = FileSystemLoader( searchpath="/" )
templateEnv = Environment( loader=templateLoader )
sys.path.append('/var/www/html/')
import shutil,connection
data=cgi.FieldStorage()
cgitb.enable()
assignment_id=data.getvalue('aid')
problem_id=data.getvalue('pid')
query="select assignment_id,problem_id,student.email_id,file_name,rno from submission_code,student where problem_id='{0}' and assignment_id='{1}' and submission_code.email_id=student.email_id".format(str(problem_id),str(assignment_id))
connection.cursor.execute(query)
data=connection.cursor.fetchall()
pld='/var/www/html/plagiarism/'+str(data[0][0])+'/'+str(data[0][1])+'/'
if not os.path.exists(pld):
	os.makedirs(pld)
for row in data:
	src='/var/www/html/submission/'+str(row[2])+'/'+str(row[0])+'/'+str(row[3])		
	dst='/var/www/html/plagiarism/'+str(row[0])+'/'+str(row[1])+'/'+str(row[4])+'.java'
	shutil.copyfile(src,dst)
src='/var/www/html/plagiarism/sherlock'			
dst='/var/www/html/plagiarism/'+str(data[0][0])+'/'+str(data[0][1])+'/sherlock'
shutil.copy(src,dst)
cwd=os.getcwd()
os.chdir(pld)
fd=open(str(data[0][1])+'.txt',"w")
subprocess.call(['./sherlock']+glob.glob('*.java'),shell=False,stdout=fd)
fd.close()
os.chdir(cwd)
query="insert into plagiarism (assignment_id,problem_id) values ('{0}','{1}')".format(str(assignment_id),str(problem_id))
connection.cursor.execute(query)
connection.db.commit()
print "Content-Type: text/html\n\n"
TEMPLATE_FILE = "/var/www/html/plagiarism/redirect.html" 
template = templateEnv.get_template( TEMPLATE_FILE )
print template.render()
