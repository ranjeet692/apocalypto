#!/usr/bin/python

print "Content-Type: text/plain\n"
import cgi, cgitb
from connection import cursor, db

import cgi, cgitb,Cookie,os
data = cgi.FieldStorage()
aid = data.getvalue('aid')
pid = data.getvalue('pid')
email_id = data.getvalue("id")
feedback = data.getvalue('feed')
if 'HTTP_COOKIE' in os.environ:
	cookie_string=os.environ.get('HTTP_COOKIE')
	c=Cookie.SimpleCookie()
	c.load(cookie_string)

if c['type'].value == "teacher":
	sql = "INSERT INTO problem_feedback(assignment_id, problem_id, student_id, feedback) VALUES({0},{1},'{2}','{3}')".format(aid, pid, str(email_id), str(feedback))
	cursor.execute(sql)
	db.commit()
	print 'done!'
else:
	print 'error'
