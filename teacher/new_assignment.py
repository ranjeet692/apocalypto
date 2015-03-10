#!/usr/bin/python
# -*- coding: utf-8 -*-
#Description: This script has two parts, one for generate template to create a new assignment, and 2nd is to edit an old assignment based on query string.
#Query String Variables: cid(course_id), option(new or edit), if edit then, aid(assignment_id)
#flow: assignment.html -> new_assignment.py -> new_assignment.html -> if new -> save_assignment.py -> assignment.py
#											                       -> if edit -> save_edit_assignment.py -> assignment.py -> 
#Created on : February 15, 2015
#Last Modified: February 17, 2015
#Auhtor: Optimus Prime

print "Content-Type: text/html\n\n"

from jinja2 import Template, Environment, FileSystemLoader
import cgi,cgitb,Cookie, os

from connection import db, cursor
import footer
import datetime
cgitb.enable() 
data = cgi.FieldStorage()
course_id = data.getvalue('cid')
option = data.getvalue('option')
#option = "edit"
#course_id = "1"
#value="teacher"

if option == "edit":
	assignment_id = data.getvalue('aid')
#assignment_id = 2
if 'HTTP_COOKIE' in os.environ:
	cookie_string=os.environ.get('HTTP_COOKIE')
	c=Cookie.SimpleCookie()
	c.load(cookie_string)

templateLoader = FileSystemLoader( searchpath="/" )
templateEnv = Environment( loader=templateLoader )
TEMPLATE_FILE = "/var/www/html/teacher/new_assignment.html"
template = templateEnv.get_template( TEMPLATE_FILE )

if c['type'].value == "teacher":
	if option == "new":
		submit_button_text = "Create"
		templateVars = { "cid":course_id,"name": c['name'].value, "footer": footer.html,"submit_text":submit_button_text, "aid": str(-1) }
		print template.render(templateVars)
	else:
		now = datetime.datetime.now()
		sql = "SELECT * FROM assignment WHERE assignment_id = {0}".format(assignment_id)
		cursor.execute(sql)
		data = cursor.fetchall()
		title = data[0][1]
		startdate = data[0][2]
		enddate = data[0][3]
		ptype = data[0][5]
		if enddate > now:
			d = ""
		else:
			d = "disabled"
				
		if ptype == "MCQ":
			sql = "SELECT problem_id FROM assignment_mcq WHERE assignment_id = {0}".format(assignment_id)
			cursor.execute(sql)
			data = cursor.fetchall()
			i=0;
			pdata = ''
			for row in data:
				i = i+1
				sql = "SELECT * FROM problem_mcq WHERE problem_id={0}".format(row[0])
				cursor.execute(sql)
				data1 = cursor.fetchall()
				pdata = pdata + '<tr><td>'+str(i)+'</td><td>'+data1[0][1]+'<p><span class="badge">'+data1[0][8]+'</span>&nbsp;<span class="badge">'+data1[0][7]+'</span></p></td><td><button type="button"  id="'+str(row[0])+'" onclick="removeProblem(this.id)" class="btn btn-info btn-block" '+d+'>Remove</button></td></tr>' 
			cselect = ""
			mselect = "selected"
		else:
			sql = "SELECT problem_id FROM assignment_code WHERE assignment_id = {0}".format(assignment_id)
			cursor.execute(sql)
			data = cursor.fetchall()
			i=0;
			pdata = ''
			for row in data:
				i = i+1
				sql = "SELECT * FROM problem_code WHERE problem_id={0}".format(row[0])
				cursor.execute(sql)
				data1 = cursor.fetchall()
				pdata = pdata + '<tr><td>'+str(i)+'</td><td>'+data1[0][6]+'<p><span class="badge">'+data1[0][5]+'</span>&nbsp;<span class="badge">'+data1[0][4]+'</span></p></td><td><button type="button" id="'+str(row[0])+'"   onclick="removeProblem(this.id)" class="btn btn-info btn-block"'+d+'>Remove</button></td></tr>' 
			cselect = "selected"	
			mselect = ""
		submit_button_text = "Update"
		
		table_start = '<div class="table-responsive"><table class="table table-bordered table-striped"><tbody><tr><th>#</th><th>Title</th><th>Operation</th></tr>'
		
		table_end = '</tbody></table><a href="http://www.neoscript.in/teacher/add_problem.py?aid='+assignment_id+'&cid='+course_id+'&option='+option+'" role="button" class="btn btn-primary btn-block " '+d+'>Add Problem</a></div>'
		templateVars = { "cid":course_id,"name": c['name'].value, "footer": footer.html,"submit_text":submit_button_text, "aid": assignment_id,"ptitle": title, "sdate":startdate, "edate": enddate,"cselect":cselect,"mselect":mselect,"d":d,"table_head": table_start, "data": pdata, "table_end": table_end }
		print template.render(templateVars)	
else:
	TEMPLATE_FILE = "/var/www/html/redirect.html"
	template = templateEnv.get_template( TEMPLATE_FILE )
	print template.render()		
		
		
