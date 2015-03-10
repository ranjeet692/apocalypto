#!/usr/bin/python

print "Content-Type: text/html\n"

import cgi, cgitb
from connection import cursor, db
import problem_connect
data= cgi.FieldStorage()
pid = data.getvalue("pid")
query="select * from problem_upload where problem_id='{0}'".format(str(pid))
problem_connect.cursor.execute(query)
data=problem_connect.cursor.fetchone()
io=[]
for i in range(7,17):
	f=open(data[i],'r')
	io.append(f.read())
	f.close()	
print '''<div class="modal-header">
        	<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>	
		<h4 class="modal-title" id="exampleModalLabel">Problem Id <span id='pid'>'''+str(data[0])+'''</span></h4>
	 </div>
      	<div class="modal-body">
		<div class="panel panel-default">
  	<!-- Default panel contents -->
  			<div class="panel-heading">Problem Statement</div>
  				<div class="panel-body">
    					<p>'''+str(data[1])+'''</p>
  				</div>				
 					 <ul class="list-group">
					    <li class="list-group-item"><span class="badge">'''+str(data[4])+'''</span>Difficulty</li>
    					    <li class="list-group-item"><span class="badge">'''+str(data[5])+'''</span>Topic</li>
					    <li class="list-group-item"><span class="badge">'''+str(data[17])+'''</span>Author</li>
    					</ul>
					<div class="panel-heading">Sample IO</div>
		  				<div class="panel-body">
		    					<p>'''+str(data[2])+'''</p>
	  				</div>				
					<div class="panel-heading">Boundary</div>
  						<div class="panel-body">
    							<p>'''+str(data[3])+'''</p>
  						</div>				
					<div class="panel-heading">Input Test Case 1</div>
  						<div class="panel-body">
    							<p>'''+str(io[0])+'''</p>
  						</div>				
					<div class="panel-heading">Input Test Case 2</div>
  						<div class="panel-body">
    							<p>'''+str(io[1])+'''</p>
  						</div>
					<div class="panel-heading">Input Test Case 3</div>
  						<div class="panel-body">
    							<p>'''+str(io[2])+'''</p>
  						</div>				
					<div class="panel-heading">Input Test Case 4</div>
  						<div class="panel-body">
    							<p>'''+str(io[3])+'''</p>
  						</div>				
					<div class="panel-heading">Input Test Case 5</div>
  						<div class="panel-body">
    							<p>'''+str(io[4])+'''</p>
  						</div>				
					<div class="panel-heading">Output For Test Case 1</div>
  						<div class="panel-body">
    							<p>'''+str(io[5])+'''</p>
  						</div>				
					<div class="panel-heading">Output For Test Case 2</div>
  						<div class="panel-body">
    							<p>'''+str(io[6])+'''</p>
  						</div>				
					<div class="panel-heading">Output For Test Case 3</div>
  						<div class="panel-body">
    							<p>'''+str(io[7])+'''</p>
  						</div>				
					<div class="panel-heading">Output For Test Case 4</div>
  						<div class="panel-body">
    							<p>'''+str(io[8])+'''</p>
  						</div>				
					<div class="panel-heading">Output For Test Case 9</div>
  						<div class="panel-body">
    							<p>'''+str(io[9])+'''</p>
  						</div>				
					
					<!--    <li class="list-group-item">'''+str(data[4])+'''</li>
						<li class="list-group-item">'''+str(data[5])+'''</li>
						    <li class="list-group-item">'''+str(io[0])+'''</li>
						<li class="list-group-item">'''+str(io[1])+'''</li>
						<li class="list-group-item">'''+str(io[2])+'''</li>
						<li class="list-group-item">'''+str(io[3])+'''</li>
						<li class="list-group-item">'''+str(io[4])+'''</li>
						<li class="list-group-item">'''+str(io[5])+'''</li>
						<li class="list-group-item">'''+str(io[6])+'''</li>
						<li class="list-group-item">'''+str(io[7])+'''</li>
						<li class="list-group-item">'''+str(io[8])+'''</li>
						<li class="list-group-item">'''+str(io[9])+'''</li>
						<li class="list-group-item">'''+str(data[16])+'''</li>
					  </ul>-->
				</div>
      </div>
	<div class="modal-footer">
	<form action="approve.py" method="POST">
	<input type="hidden" name="pid" value='''+str(data[0])+'''></input>
        <button type="submit" class="btn btn-default" id="approve" >Approve</button>
	</form>
	<form action="reject.py" method="POST">	
	<input type="hidden" name="pid" value='''+str(data[0])+'''></input>
        <button type="submit" class="btn btn-default">Reject</button>
	</form >      
	</div>'''

