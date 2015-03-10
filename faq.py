#!/usr/bin/python
# -*- coding: utf-8 -*-
print "Cache-Control:no-store, no-cache, must-revalidate"
import cgi,cgitb,cookie,footer
from jinja2 import Template, Environment, FileSystemLoader 
print "Content-Type: text/html\n\n"
cgitb.enable()
cookie.load_cookie()
templateLoader = FileSystemLoader( searchpath="/" )
templateEnv = Environment( loader=templateLoader )
TEMPLATE_FILE = "/var/www/html/faq.html" 
templateVars = { "name" :cookie.c['name'].value,"footer": footer.html}
template = templateEnv.get_template( TEMPLATE_FILE )
print template.render(templateVars)
