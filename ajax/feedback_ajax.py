#!/usr/bin/python

print "Content-Type: text/plain\n"

import Cookie, os
import cgi, cgitb

from connection import cursor, db

email_id = ''
if 'HTTP_COOKIE' in os.environ:
	cookie_string=os.environ.get('HTTP_COOKIE')
	c=Cookie.SimpleCookie()
	c.load(cookie_string)
	email_id = c["uid"].value

data= cgi.FieldStorage()

course_id = data.getvalue("cid")
comment = data.getvalue("commentbox")

sql = "insert into feedback(course_id, email_id, comment) values('{0}','{1}','{2}')" .format(str(course_id), str(email_id), str(comment))
cursor.execute(sql)
db.commit()

print course_id +" " + email_id + " " + comment
