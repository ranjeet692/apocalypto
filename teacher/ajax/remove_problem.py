#!/usr/bin/python
# -*- coding: utf-8 -*-

print "Content-Type: text/html\n\n"

import cgi,cgitb,Cookie, os
from connection import db, cursor

data = cgi.FieldStorage()
assignment_id = data.getvalue('aid')
problem_id = data.getvalue('pid')

if 'HTTP_COOKIE' in os.environ:
	cookie_string=os.environ.get('HTTP_COOKIE')
	c=Cookie.SimpleCookie()
	c.load(cookie_string)

if c['type'].value == "teacher":
	sql = "SELECT type FROM assignment WHERE assignment_id = {0}".format(assignment_id)
	cursor.execute(sql)
	data = cursor.fetchall()

	if data[0][0] == "MCQ":
		sql="DELETE FROM assignment_mcq WHERE assignment_id = {0} and problem_id = {1}".format(assignment_id, problem_id)
		cursor.execute(sql)
		db.commit()
		print "Removed"
	elif data[0][0] == "code":
		sql = "DELETE FROM assignment_code WHERE assignment_id = {0} and problem_id = {1}".format(assignment_id, problem_id)
		cursor.execute(sql)
		db.commit()
		print "Removed"
	else:
		print "error"
else:
	print "Error"		
