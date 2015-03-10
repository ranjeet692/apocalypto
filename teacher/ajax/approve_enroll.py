#!/usr/bin/python
# -*- coding: utf-8 -*-

print "Content-Type: text/html\n\n"
from connection import cursor, db
import cgi, cgitb,Cookie,os
import smtplib
data = cgi.FieldStorage()
cid = data.getvalue("cid")
email_id = data.getvalue("id")

to = email_id
gmail_user = 'abcd@gmail.com'
gmail_pwd = 'abcd'

#print cid, email_id
if 'HTTP_COOKIE' in os.environ:
	cookie_string=os.environ.get('HTTP_COOKIE')
	c=Cookie.SimpleCookie()
	c.load(cookie_string)


if c['type'].value == "teacher":
	sql = 'DELETE FROM `enroll_request` WHERE `course_id` = {0} AND `email_id` = "{1}"'.format(cid,str(email_id))
	cursor.execute(sql)
	db.commit()
	
	sql = "INSERT INTO enrolled(course_id,email) VALUES({0}, '{1}')".format(cid,str(email_id))
	cursor.execute(sql)
	db.commit()
	sql = "SELECT name FROM courses WHERE course_id =  {0}".format(cid)
	cursor.execute(sql)
	data = cursor.fetchall()
	smtpserver = smtplib.SMTP("smtp.gmail.com",587)
	smtpserver.ehlo()
	smtpserver.starttls()
	smtpserver.ehlo
	smtpserver.login(gmail_user,gmail_pwd)
	header = 'To:'+to+'\n'+'From:'+gmail_user+'\n'+'Subject: Approved for '+data[0][0]+'\n'
	msg=header + 'Your enrollment for class '+data[0][0]+' has been approved.\n\nRegards\n Team NeoScript'
	smtpserver.sendmail(gmail_user,to,msg)
	smtpserver.close()
	
	print "Approved"
else:
	print "Error"
