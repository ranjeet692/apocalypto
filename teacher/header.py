#!/usr/bin/python
# -*- coding: utf-8 -*-

print "Content-Type: text/html\n\n"

from connection import cursor, db
import cgi, cgitb,Cookie,os
data = cgi.FieldStorage()
cid = data.getvalue("cid")
#cid = 1
#title = "Java Programming"
title=""
sql = "select "
name = ""
if 'HTTP_COOKIE' in os.environ:
	cookie_string=os.environ.get('HTTP_COOKIE')
	c=Cookie.SimpleCookie()
	c.load(cookie_string)
	name = c['name'].value

print '''
<link rel="icon" href="http://www.neoscript.in/favicon.ico">
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="../">&lt;NeoScript/&gt; &nbsp;'''+title+'''</a>
            </div>
            <!-- /.navbar-header -->

            <ul class="nav navbar-top-links navbar-right">
            	 <li>
                    <a href="../">
                        <span style="color:#aaa;">Home</span>
                    </a>
                    
                </li>
                
               
               
               
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                       <span style="color:#aaa;"> <i class="fa fa-user fa-fw"></i> '''+name+'''&nbsp;<i class="fa fa-caret-down"></i></span>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        
                        <li class="divider"></li>
                        <li><a href="./logout.py"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                        </li>
                    </ul>
                    <!-- /.dropdown-user -->
                </li>
                <!-- /.dropdown -->
            </ul>
            <!-- /.navbar-top-links -->

            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        
                        <li>
                            <a href="home.py?cid='''+str(cid)+'''"> Dashboard</a>
                        </li>
                        <li>
                            <a href="assignment.py?cid='''+str(cid)+'''">Assignment</a>
                        </li>
                       <li>
                            <a href="submission.py?cid='''+str(cid)+'''">Code Submission</a>
                       </li>
                       <li>
                            <a href="submission_mcq.py?cid='''+str(cid)+'''">MCQ Submission</a>
                       </li>
                       <li>
                            <a href="report.py?cid='''+str(cid)+'''">Report</a>
                       </li>
                       <li>
                            <a href="notice.py?cid='''+str(cid)+'''">Notice Board</a>
                       </li> 
                       <li>
                            <a href="document.py?cid='''+str(cid)+'''">Documents</a>
                       </li>
                       <li>
                            <a href="timeline.py?cid='''+str(cid)+'''">Timeline</a>
                       </li>
                       <li>
                            <a href="syllabus.py?cid='''+str(cid)+'''">Syllabus</a>
                       </li> 
                       <li>
                       		<a href="enroll_request.py?cid='''+str(cid)+'''">Enrollment</a>
                       </li>
			<li>
				<a href="problem_upload.py?cid='''+str(cid)+'''">Problem Upload</a>
			</li>
                       <li>
                            <a href="feedback.py?cid='''+str(cid)+'''"></i>Feedback</a>
                       </li>
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>
		<nav class="navbar navbar-inverse navbar-satic-top topnav" role="navigation">
    	</nav>
'''
