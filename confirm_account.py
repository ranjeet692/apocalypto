#!/usr/bin/python
print "Cache-Control:no-store, no-cache, must-revalidate"
print "Content-Type: text/html\n\n"

import cgi,cgitb
from connection import cursor, db

data= cgi.FieldStorage()
code=data.getvalue("var")
email=data.getvalue("email")

sql = "SELECT * from confirmation where email_id = '{0}'".format(email)
cursor.execute(sql)
data = cursor.fetchall()

if (data[0][4] == code):
	sql = "insert into user(email_id,password,type,name) values('{0}','{1}','{2}','{3}')".format(str(data[0][0]),str(data[0][1]),str(data[0][2]),str(data[0][3]))
	cursor.execute(sql)
	db.commit()
	sql="DELETE FROM confirmation WHERE email_id = '{0}'".format(email)
	cursor.execute(sql)
	db.commit()
	print "<html><head><title>Account has been confirmed</title></head><body><center><strong>Your account is confirmed. please <a href='http://www.neoscript.in/'>login</a> to view your account.</strong></center></body></html>"
else:
	print "Error"		
