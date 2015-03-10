#!/usr/bin/python
# -*- coding: utf-8 -*-
import cgi,cgitb
print "Content-Type: text/html\n\n"
from cookie import c,load_cookie
import connection
data=cgi.FieldStorage()
cgitb.enable()
assignment_id=data.getvalue('aid')
course_id=data.getvalue('cid')
test_id=""
load_cookie()
query="select * from submission_code where email_id='{0}' and assignment_id='{1}'".format(str(c['uid'].value),str(assignment_id))
connection.cursor.execute(query)
data=connection.cursor.fetchall()
r=0
i=0
for row in data:
	r=r+row[10]
	i=i+1
if i!=0:
	r=r/i
store="select * from result where course_id='{0}' and assignment_id='{1}' and student_id='{2}'".format(str(course_id),str(assignment_id),str(c['uid'].value))
connection.cursor.execute(store)
data=connection.cursor.fetchall()
if data:
	store="update result set result='{0}' where course_id='{1}' and student_id='{2}' and assignment_id='{3}'".format(str(r),str(course_id),str(c['uid'].value),str(assignment_id))
else:
	store="insert into result values('{0}','{1}','{2}','{3}','{4}')".format(str(course_id),str(assignment_id),str(c['uid'].value),test_id,str(r))
connection.cursor.execute(store)
connection.db.commit()
print r
#templateVars = { "r" : r}
#print template.render( templateVars )
	
