#!/usr/bin/python

print "Content-Type: text/plain\n"
import cgi, cgitb
from connection import cursor, db
from cookie import c,load_cookie
import datetime
data= cgi.FieldStorage()
load_cookie()
course_id = data.getvalue("course_id")
query="select distinct(r.assignment_id),title,result from result as r,assignment as a where r.assignment_id=a.assignment_id and student_id='{0}' and r.course_id='{1}' ".format(str(c['uid'].value),str(course_id))
cursor.execute(query)
data=cursor.fetchall()

#getting feebback of assignments
sql = "SELECT a.assignment_id, a.problem_id,a.feedback, b.title FROM problem_feedback as a, problem_code as b WHERE a.problem_id=b.problem_id and student_id = '{0}'".format(str(c['uid'].value))
cursor.execute(sql)
f = cursor.fetchall()

#getting assignment no from feedback table for current logged in student
x = zip(*f)
if x:
	x= list(x[0])

print '<div>'\
	'<ul class="list-group">'\
	  '<li class="list-group-item active">'\
	    '<span class="badge">Result</span>Assignment Name'\
	  '</li>'
for row in data:
	var=''
	feed = ''
	if int(row[0]) in x:
		var = '<a  data-toggle="collapse" href="#'+str(row[0])+'" aria-expanded="false" aria-controls="collapse"><span style="color:#fff;">Feedback</span></a>'
		feed = ''
		for row1 in f:
			if int(row1[0]) == int(row[0]):
				
				feed = feed + '<strong>'+str(row1[3])+' : </strong><p>'+row1[2]+'</p><br/>' 
	print '''<li class="list-group-item">
	    <span class="badge">'''+str(row[2])+'''</span><span class="badge">'''+str(var)+'''</span>'''+str(row[1])+'''
	  
	<div class="collapse" id="'''+str(row[0])+'''">
  		<div class="well">
    			'''+feed+'''
  		</div>
	</div></li>	
'''
print '</ul></div>'
	
