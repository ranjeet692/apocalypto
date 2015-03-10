#!/usr/bin/python
print "Content-Type: text/html\n\n"
import cgi, os,Cookie
import cgitb; cgitb.enable()
import requests
from connection import cursor, db

form = cgi.FieldStorage()
assignment_id=form.getvalue("aid")
cid = form.getvalue("cid")
correct = 0
if 'HTTP_COOKIE' in os.environ:
	cookie_string=os.environ.get('HTTP_COOKIE')
	c=Cookie.SimpleCookie()
	c.load(cookie_string)
	student_id = c['uid'].value	

sql = "select * from submission_mcq where assignment_id = '{0}' and email = '{1}'".format(str(assignment_id), str(student_id))
cursor.execute(sql)
x = cursor.rowcount
		
sql = "SELECT problem_id from assignment_mcq WHERE assignment_id = '{0}' ".format(str(assignment_id))
cursor.execute(sql) 
data = cursor.fetchall()

for i in range(len(data)):
	answer = form.getvalue(str(data[i][0]))
	#fo = open("foo.txt","a+")
	#fo.write(answer)
	#fo.close()
	sql = "SELECT answer FROM problem_mcq WHERE problem_id = '{0}'".format(str(data[i][0]))
	cursor.execute(sql)
	data1 = cursor.fetchall()
	if data1[0][0] == answer:
		correct = correct + 1
	if(x > 0):
		#sql = "UPDATE submission_mcq SET answer = '{0}', timestamp = now() WHERE assignment_id = '{1}' and problem_id = '{2}' and email = '{3}'".format(str(answer), str(assignment_id),str(data[i][0]), str(student_id))
		response = "You have already submitted your answer. Multiple attempts are not allowed."
	else:	
		sql = "INSERT INTO submission_mcq(assignment_id,problem_id, email, answer ) VALUES('{0}','{1}','{2}','{3}')".format(str(assignment_id),str(data[i][0]), str(student_id),str(answer))
		cursor.execute(sql)
		db.commit() 	
		response = "Your answers are successfully recorded in database."

result = (correct*100)/(i+1)
sql = "SELECT * FROM result WHERE assignment_id = '{0}' and student_id = '{1}'".format(str(assignment_id), str(student_id))
cursor.execute(sql)
if cursor.rowcount > 0:
	pass
	#sql = "UPDATE result SET result = '{0}' WHERE assignment_id = '{1}' and student_id = '{2}'".format(str(result), str(assignment_id), str(student_id))
else:
	sql = "INSERT INTO result(course_id, assignment_id, student_id, result) VALUES('{0}', '{1}', '{2}', {3})".format(str(cid), str(assignment_id), str(student_id), str(result))	
cursor.execute(sql)
db.commit()
print "<h2>"+response +"</h2>"+ "<br/><br/><h4>Your score is {0}</h4><p>{1} correct out of {2}".format(result, correct, (i+1))
