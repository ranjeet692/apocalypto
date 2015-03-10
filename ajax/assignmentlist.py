#!/usr/bin/python

print "Content-Type: text/plain\n"

import cgi, cgitb
from connection import cursor, db
from cookie import c,load_cookie
import datetime
s=datetime.datetime.now()
year=s.year
month=s.month
day=s.day
d=datetime.date(year,month,day)
data= cgi.FieldStorage()
load_cookie()
course_id = data.getvalue("course_id")
#course_id = 1
coding_problem=''
sql = "SELECT * from assignment where course_id = {0} ORDER BY startdate DESC".format(str(course_id))
cursor.execute(sql)
data = cursor.fetchall()
count = len(data)
assignment_id=""
for i in range(len(data)):
	if data[i][3]>=s and data[i][2]<=s:
	#assignment type checking, mcq for MCQ problems and 1 for Coding Problem
		if data[i][5] == 'MCQ':
			refer_page = '<a href="problem_mcq.py?var='+str(data[i][0])+'&cid='+str(course_id)+'">'
			tag=' <small>(click here)</small></a>'
			coding_problem = ''
			visi="hidden"
		else:
			visi="show"
			refer_page = '<p>'
			tag='</p>'
			sql1 = "SELECT problem_id from assignment_code where assignment_id = '{0}'".format(str(data[i][0]))
			cursor.execute(sql1)
			data1 = cursor.fetchall()
			for j in range(len(data1)):
				sql2 = "SELECT title from problem_code where problem_id = '{0}'".format(str(data1[j][0]))
				cursor.execute(sql2)
				data2 = cursor.fetchall()	
				for row in data2:
				#	coding_problem = ""
					rs="select * from submission_code where email_id='{0}' and problem_id='{1}' and assignment_id='{2}'".format(str(c['uid'].value),str(data1[j][0]),str(data[i][0]))
					cursor.execute(rs)
					if cursor.rowcount !=0 :
						data4=cursor.fetchone()
						result=data4[10]
					else:
						result=""
					coding_problem = '<h5><strong><a href="problem_code.py?pid='+str(data1[j][0])+'&aid='+str(data[i][0])+'&cid='+str(course_id)+'">'+str(row[0])+' <small>(click here)</small><p align="right">'+str(result)+'</p></a></strong></h5>' + coding_problem
			coding_problem = coding_problem + '<hr>'		
		assignment_id=data[i][0]
		store="select * from result where course_id='{0}' and assignment_id='{1}' and student_id='{2}'".format(str(course_id),str(assignment_id),str(c['uid'].value))
		cursor.execute(store)
		if cursor.rowcount !=0 :
			data3=cursor.fetchone()
			result=data3[4]
		else:
			result=""
		aid = str(data[i][0])	
		print '<div class="panel panel-primary">' \
					'<div class="panel-heading">Assignment # <span id="aid">'+ str(count) + '</span></div>' \
					'<div class="panel-body">' \
						'<h4><strong>'+ refer_page+str(data[i][1])+tag+'</strong></h4>' \
						'<hr/>' \
						'<p>'+coding_problem+'</p>'\
						'<h5>Due Date : <span id="due">'+ str(data[i][3]) +'</span> </h5>' \
						'<hr/><h5><strong>Result : <p align="right"id="final_result'+str(data[i][0])+'">'+str(result)+'</strong></p></h5>' \
						'<h5><button id="code_submit" class="btn btn-primary" onclick="code_submit('+str(aid)+')" style="visibility:'+visi+';" >Submit</button></h5>' \
					'</div>' \
				'</div>'
		count = count - 1
		#print data[i][0]
	

