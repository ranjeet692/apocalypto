#!/usr/bin/python
# -*- coding: utf-8 -*-
#Description: to save new record in assignment table
#Query String Variables: POST method + cid(course_id)
#flow: new_assignment.html -> save_assignment.py -> assignment.py
#Created On: February 16, 2015
#Last Modified: February 16, 2015
#Author: Optimus Prime

print "Content-Type: text/html\n\n"

import cgi,cgitb,Cookie, os
from connection import db, cursor
cgitb.enable() 
data = cgi.FieldStorage()
course_id = data.getvalue('cid')
title = data.getvalue('title')
startdate = data.getvalue('start-date-time')
enddate = data.getvalue('end-date-time')
ptype = data.getvalue('type')
assignment_id = data.getvalue('aid')

#check whether is teacher type or not.
if 'HTTP_COOKIE' in os.environ:
	cookie_string=os.environ.get('HTTP_COOKIE')
	c=Cookie.SimpleCookie()
	c.load(cookie_string)

if c['type'].value == "teacher":
	if int(assignment_id) > 0:
		#first check whether assignment id exist or not.
		#if exist then update the values else return a error message
		sql = "SELECT * FROM assignment WHERE assignment_id = {0}".format(assignment_id)
		cursor.execute(sql)
		if(cursor.rowcount > 0):
			sql = "UPDATE assignment SET title = '{0}', startdate = '{1}', enddate = '{2}', type = '{3}' WHERE assignment_id = {4}".format(title,startdate,enddate,ptype,int(assignment_id))	
			cursor.execute(sql)
			db.commit()
			print "<div class='alert alert-success' role='alert'>Updated Successfully.</div>"
		else:
			print "<div class='alert alert-danger' role='alert'>Record not found in database.</div>"	
	else:
		#insert a a new assignment	
		sql="INSERT INTO assignment(title, startdate, enddate, course_id, type) VALUES('{0}','{1}','{2}','{3}','{4}')".format(title, startdate, enddate, course_id, ptype)
		cursor.execute(sql)
		db.commit()
		print "<div class='alert alert-success' role='alert'>New assignment has been created.</div>"

else:
	print "<div class='alert alert-danger' role='alert'>Your are not authenticated to do this task.</div>"
