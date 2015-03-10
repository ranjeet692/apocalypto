#!/usr/bin/python
print "Content-Type: text/html\n\n"
import c_compile,java_compile
import cgi, os,Cookie
import cgitb; cgitb.enable()
import requests
from connection import cursor, db

try: # Windows needs stdio set for binary mode.
    import msvcrt
    msvcrt.setmode (0, os.O_BINARY) # stdin  = 0
    msvcrt.setmode (1, os.O_BINARY) # stdout = 1
except ImportError:
    message = 'Error'
lan = []
time=[]
r=0
st=""
tm=1
form = cgi.FieldStorage()
ppid=form.getvalue("ppid")
language = form.getvalue("l")
if ppid==None:
	problem_id= form.getvalue("pid")
	assignment_id=form.getvalue("aid")
if 'HTTP_COOKIE' in os.environ:
	cookie_string=os.environ.get('HTTP_COOKIE')
	c=Cookie.SimpleCookie()
	c.load(cookie_string)
	student_id = c["uid"].value
# A nested FieldStorage instance holds the file
fileitem = form['file']

# Test if the file was uploaded
if fileitem.filename:	
	   
    #strip leading path from file name to avoid directory traversal attacks
	if ppid==None:	
		if not os.path.exists("/var/www/html/submission/"+c['uid'].value+"/"+assignment_id+"/"):
			os.makedirs("/var/www/html/submission/"+c['uid'].value+"/"+assignment_id+"/")
			os.chmod("/var/www/html/submission/"+c['uid'].value+"/"+assignment_id+"/", 0755)
		#os.chmod(fileitem.filename, 0o755)
		fn = os.path.basename(fileitem.filename)
  		open('/var/www/html/submission/'+c["uid"].value+'/'+assignment_id+'/'+fn, 'wb').write(fileitem.file.read())
  		dest_dir = '/var/www/html/submission/'+c["uid"].value+'/'+assignment_id+'/'
  		#os.rename(dest_dir + fn, dest_dir + problem_id+'.'+language)	
		#sql = "INSERT INTO submission_code(assignment_id,problem_id, email_id) VALUES('{0}','{1}','{2}')".format(str(assignment_id),str(problem_id), str(student_id))
		sql = "select * from submission_code where assignment_id = '{0}' and problem_id = '{1}' and email_id = '{2}'".format(str(assignment_id),str(problem_id), str(student_id))
		cursor.execute(sql)
		if(cursor.rowcount > 0):
			sql = "UPDATE submission_code SET time = now(),file_name='{3}' WHERE assignment_id = '{0}' and problem_id = '{1}' and email_id = '{2}'".format(str(assignment_id),str(problem_id), str(student_id),str(fn))
		else:	
			sql = "INSERT INTO submission_code(assignment_id,problem_id, email_id,file_name) VALUES('{0}','{1}','{2}','{3}')".format(str(assignment_id),str(problem_id), str(student_id),str(fn))
		cursor.execute(sql)
		db.commit()
		if language=='c':
			c_compile.check_code(problem_id,assignment_id,fn)
			save_result="update submission_code set tc1='{0}',tc2='{1}',tc3='{2}',tc4='{3}',tc5='{4}' where assignment_id='{5}' and problem_id='{6}' and email_id='{7}'".format(str(c_compile.re[0]),str(c_compile.re[1]),str(c_compile.re[2]),str(c_compile.re[3]),str(c_compile.re[4]),str(assignment_id),str(problem_id),str(student_id))
			for i in range(5):
				if c_compile.re[i]==True:
					r=r+1
				lan.append(c_compile.re[i])
				time.append(c_compile.t[i])
				time[i]=str(time[i])[:7]
			r=(float(r)/5)*100
			st=c_compile.sti
			tm=c_compile.tm
			score="update submission_code set score='{0}' where assignment_id='{1}' and problem_id='{2}' and email_id='{3}'".format(str(r),str(assignment_id),str(problem_id),str(student_id))
		else:	
			if language=='java':
				java_compile.check_code(problem_id,assignment_id,fn)	
				save_result="update submission_code set tc1='{0}',tc2='{1}',tc3='{2}',tc4='{3}',tc5='{4}' where assignment_id='{5}' and problem_id='{6}' and email_id='{7}'".format(str(java_compile.re[0]),str(java_compile.re[1]),str(java_compile.re[2]),str(java_compile.re[3]),str(java_compile.re[4]),str(assignment_id),str(problem_id),str(student_id))
				for i in range(5):
					if java_compile.re[i]==True:
						r=r+1
					lan.append(java_compile.re[i])
					time.append(java_compile.t[i])
					time[i]=str(time[i])[:7]	
				if r!=0:
					r=(float(r)/5)*100
				score="update submission_code set score='{0}' where assignment_id='{1}' and problem_id='{2}' and email_id='{3}'".format(str(r),str(assignment_id),str(problem_id),str(student_id))
				st=java_compile.sti
				tm=java_compile.tm
		if tm == 1:
			cursor.execute(save_result)			
			cursor.execute(score)
			db.commit()
			message = 'The file "' + fn + '" was uploaded successfully'
			print '''<div class="panel-heading">Test Cases</div>
					<div class="panel-body">
					<!-- Table -->
						<table class="table">
							<tr>
								<th>#</th><th>Time</th><th>Result</th>
							</tr>
							<tr>
								<td>1</td><td>'''+str(time[0])+'''</td><td>'''+str(lan[0])+'''</td>
							</tr>
							<tr>
								<td>2</td><td>'''+str(time[1])+'''</td><td>'''+str(lan[1])+'''</td>
							</tr>
							<tr>
								<td>3</td><td>'''+str(time[2])+'''</td><td>'''+str(lan[2])+'''</td>
							</tr>
							<tr>
								<td>4</td><td>'''+str(time[3])+'''</td><td>'''+str(lan[3])+'''</td>	
							</tr>
							<tr>
								<td>5</td><td>'''+str(time[4])+'''</td><td>'''+str(lan[4])+'''</td>
							</tr>
							<tr>
								<td>Your Score for the problem is '''+str(r)+'''%</td>
							<tr/>		
						</table>
					</div>'''
		else:
			print st
	else:
		if not os.path.exists("/var/www/html/submission/"+c['uid'].value+"/p_problem/"):
			os.makedirs("/var/www/html/submission/"+c['uid'].value+"/p_problem/")
			os.chmod("/var/www/html/submission/"+c['uid'].value+"/p_problem/", 0755)
		#os.chmod(fileitem.filename, 0o755)
		fn = os.path.basename(fileitem.filename)
  		open('/var/www/html/submission/'+c["uid"].value+'/p_problem/'+fn, 'wb').write(fileitem.file.read())
  		dest_dir = '/var/www/html/submission/'+c["uid"].value+'/p_problem/'
  		#os.rename(dest_dir + fn, dest_dir + problem_id+'.'+language)	
		#sql = "INSERT INTO submission_code(assignment_id,problem_id, email_id) VALUES('{0}','{1}','{2}')".format(str(assignment_id),str(problem_id), str(student_id))
		sql = "select * from practise_submission where ppid = '{0}' and email_id = '{1}'".format(str(ppid),str(student_id))
		cursor.execute(sql)
		if(cursor.rowcount > 0):
			sql = "UPDATE practise_submission SET file_name='{2}' WHERE ppid = '{0}' and email_id = '{1}'".format(str(ppid),str(student_id),str(fn))
		else:	
			sql = "INSERT INTO practise_submission(ppid,email_id,file_name) VALUES('{0}','{1}','{2}')".format(str(ppid),str(student_id),str(fn))
		cursor.execute(sql)
		db.commit()
		if language=='c':
			c_compile.p_check_code(ppid,fn)
			save_result="update practise_submission set tc1='{0}',tc2='{1}',tc3='{2}',tc4='{3}',tc5='{4}' where ppid='{5}' and email_id='{6}'".format(str(c_compile.re[0]),str(c_compile.re[1]),str(c_compile.re[2]),str(c_compile.re[3]),str(c_compile.re[4]),str(ppid),str(student_id))
			for i in range(5):
				if c_compile.re[i]==True:
					r=r+1
				lan.append(c_compile.re[i])
				time.append(c_compile.t[i])
				time[i]=str(time[i])[:7]
			r=(float(r)/5)*100
			score="update practise_submission set score='{0}' where ppid='{1}' and  email_id='{2}'".format(str(r),str(ppid),str(student_id))
			st=c_compile.sti
			tm=c_compile.tm
		else:	
			if language=='java':
				java_compile.p_check_code(ppid,fn)	
				save_result="update practise_submission set tc1='{0}',tc2='{1}',tc3='{2}',tc4='{3}',tc5='{4}' where ppid='{5}' and email_id='{6}'".format(str(java_compile.re[0]),str(java_compile.re[1]),str(java_compile.re[2]),str(java_compile.re[3]),str(java_compile.re[4]),str(ppid),str(student_id))
				for i in range(5):
					if java_compile.re[i]==True:
						r=r+1
					lan.append(java_compile.re[i])
					time.append(java_compile.t[i])
					time[i]=str(time[i])[:7]
				if r!=0:
					r=(float(r)/5)*100
				score="update practise_submission set score='{0}' where ppid='{1}' and  email_id='{2}'".format(str(r),str(ppid),str(student_id))
				st=java_compile.sti
				tm=java_compile.tm
		if tm == 1:
			cursor.execute(save_result)			
			cursor.execute(score)
			db.commit()
			message = 'The file "' + fn + '" was uploaded successfully'
			print '''<div class="panel-heading">Test Cases</div>
					<div class="panel-body">
					<!-- Table -->
						<table class="table">
							<tr>
								<th>#</th><th>Time</th><th>Result</th>
							</tr>
							<tr>
								<td>1</td><td>'''+str(time[0])+'''</td><td>'''+str(lan[0])+'''</td>
							</tr>
							<tr>
								<td>2</td><td>'''+str(time[1])+'''</td><td>'''+str(lan[1])+'''</td>
							</tr>
							<tr>
								<td>3</td><td>'''+str(time[2])+'''</td><td>'''+str(lan[2])+'''</td>
							</tr>
							<tr>
								<td>4</td><td>'''+str(time[3])+'''</td><td>'''+str(lan[3])+'''</td>	
							</tr>
							<tr>
								<td>5</td><td>'''+str(time[4])+'''</td><td>'''+str(lan[4])+'''</td>
							</tr>
							<tr>
								<td>Your Score for the problem is '''+str(r)+'''%</td>
							<tr/>		
						</table>
					</div>'''
		else:
			print st
   
else:
	message = 'No file was uploaded'
   

