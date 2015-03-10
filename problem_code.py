#!/usr/bin/python
print "Cache-Control:no-store, no-cache, must-revalidate"
print "Content-Type: text/html\n\n"

from jinja2 import Template, Environment, FileSystemLoader
from connection import cursor, db
import Cookie,os
import cgi, cgitb
import footer
from connection import cursor, db
if 'HTTP_COOKIE' in os.environ:
	cookie_string=os.environ.get('HTTP_COOKIE')
	c=Cookie.SimpleCookie()
	c.load(cookie_string)
data= cgi.FieldStorage()
ppid=data.getvalue("ppid")
if ppid==None:
	problem_id = data.getvalue("pid")
	assignment_id = data.getvalue("aid")
	course_id = data.getvalue("cid")
	#problem_id = 1
	#assignment_id = 1
	
	sql = "SELECT title, statement, sample_io, boundary, difficulty, topic from problem_code WHERE problem_id = {0}".format(str	(problem_id))
	cursor.execute(sql)
	data = cursor.fetchall()
	
	templateLoader = FileSystemLoader( searchpath="/" )
	templateEnv = Environment( loader=templateLoader )
	TEMPLATE_FILE = "/var/www/html/problem_code.html"
	template = templateEnv.get_template( TEMPLATE_FILE )

	templateVars = { "title" : data[0][0], "description": data[0][1] + '<br><hr><strong>Sample Input/Output</strong><br><br>'+data[0][2] + '<br><hr><strong>Limits</strong><br><br>' +data[0][3],"name":c['name'].value, "pid":problem_id, "aid":assignment_id, "footer":footer.html, "cid":course_id }
	print template.render( templateVars )

else:
	sql = "SELECT title, statement, sample_io, boundary, difficulty, topic from practise_problem as pp,problem_code as pc WHERE pp.ppid = '{0}' and pc.problem_id=pp.pid".format(str(ppid))
	cursor.execute(sql)
	data = cursor.fetchall()
	
	templateLoader = FileSystemLoader( searchpath="/" )
	templateEnv = Environment( loader=templateLoader )
	TEMPLATE_FILE = "/var/www/html/practise_code.html"
	template = templateEnv.get_template( TEMPLATE_FILE )

	templateVars = { "title" : data[0][0], "description": data[0][1] + '<br><hr><strong>Sample Input/Output</strong><br><br>'+data[0][2] + '<br><hr><strong>Limits</strong><br><br>' +data[0][3],"name":c['name'].value, "ppid":ppid, "footer":footer.html}
	print template.render( templateVars )


































