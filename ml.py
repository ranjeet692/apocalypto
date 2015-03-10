#!/usr/bin/python
# -*- coding: utf-8 -*-
import cgi,cgitb,connection
print "Content-Type: text/html\n\n"
import smtplib 
from jinja2 import Template, Environment, FileSystemLoader
templateLoader = FileSystemLoader( searchpath="/" )
templateEnv = Environment( loader=templateLoader )
#cgitb.enable()
form = cgi.FieldStorage() 
email = form.getvalue('email')
to = email
query="select * from user where email_id='{0}'".format(str(email))
connection.cursor.execute(query)
data=connection.cursor.fetchone()
gmail_user = 'abcd@gmail.com'
gmail_pwd = 'abcd'
smtpserver = smtplib.SMTP("smtp.gmail.com",587)
smtpserver.ehlo()
smtpserver.starttls()
smtpserver.ehlo
smtpserver.login(gmail_user, gmail_pwd)
if connection.cursor.rowcount > 0:
	header = 'To:' + to + '\n' + 'From: ' + gmail_user + '\n' + 'Subject:Forgot Password@NeoScript.in \n'
	msg = header + '\n Your Password is :: ' +str(data[1])
else:
	sql = "SELECT email_id,code FROM confirmation WHERE email_id = '{0}'".format(str(email))
	connection.cursor.execute(sql)
	if connection.cursor.rowcount > 0:
		data = connection.cursor.fetchone()
		header = 'To:'+to+'\n'+'From: '+ gmail_user + '\n' + 'Subject: Account Confirmation Pending | Forgot Password\n'
		msg = header + '\n Your account confirmation is still pending please first activate your account using this link \n http://www.neoscript.in/confirm_account.py?var='+str(data[0][1])+'&email='+to+'\nif you have forgot your password then use forgot password option after activating your account\n\nRegards \n Team NeoScript'
	else:
		header = 'To:'+to+'\n'+'From: '+ gmail_user + '\n' + 'Subject: Register a new account \n'
		msg = header + '\nYou are not registered in NeoScript. \nFollow this link to register :: http://www.neoscript.in/register.html\n\nRegards\n Team NeoScript'
smtpserver.sendmail(gmail_user, to, msg)
smtpserver.close()
TEMPLATE_FILE = "/var/www/html/redirect.html" 
template = templateEnv.get_template( TEMPLATE_FILE )
print template.render( )
