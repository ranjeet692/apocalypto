#!/usr/bin/python
print "Content-Type: text/plain\n\n"

from connection import cursor, db
import cgi, cgitb
data = cgi.FieldStorage()
email_id = data.getvalue('email')

sql = "SELECT * FROM user WHERE email_id='{0}'".format(str(email_id))
cursor.execute(sql)
if cursor.rowcount > 0:
	print 1
else:
	print 0
