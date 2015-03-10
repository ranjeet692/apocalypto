import filecmp,subprocess,os,sys
from connection import cursor,db
from cookie import c,load_cookie
import stat
import timeit
re=[]
sti=""
tm=1
ret=0
t=[]
def check_code(pid,assignmnt_id,fn):
	global re,sti,tm,ret,t
	load_cookie()
	test_case="select * from problem_code where problem_id={0}".format(str(pid))
	cursor.execute(test_case)
	data=cursor.fetchone()
	sub_location='/var/www/html/submission/'+c['uid'].value+'/'+str(assignmnt_id)+'/'+str(fn)
	output_location='/var/www/html/temp/'+c['uid'].value+'/'+str(assignmnt_id)+'/'+str(pid)
	fi=open("temp.txt","w+")
	if os.path.exists(output_location):
		a=[]
		#subprocess.call(['chmod','-r','777','/var/www/html/codemafia/temp/'])	
	else:	
		os.makedirs(output_location, 0o777)
	try:
		ret=subprocess.call(['javac',sub_location,'-d',output_location+'/'],stderr=fi)		
	except subprocess.CalledProcessError:
		print sti
	fi.seek(0)
	sti=fi.read()
	if sti == "":
		fn=fn[:len(fn)-5]
		st = os.stat(output_location+'/'+'')
		os.chmod(output_location,st.st_mode | stat.S_IWGRP | stat.S_IWOTH)
		#os.chmod('/var/www/html/temp/'+c['uid'].value+'/'+str(assignmnt_id)+'/'+str(pid)+'/'+str(fn),stat.S_IXUSR)
		curr_working_path=os.getcwd()
		rel_path='/var/www/html/temp/'+c['uid'].value+'/'+str(assignmnt_id)+'/'+str(pid)+'/'
		os.chdir(rel_path)
		tc=1
		j=1
		for i in range(7,12):
			ofname=str(j)+'.txt'
			fdw=open(str(j)+'.txt',"w")
			st = os.stat(output_location+'/'+str(j)+'.txt')
			os.chmod(output_location+'/'+str(j)+'.txt',st.st_mode | stat.S_IWGRP | stat.S_IWOTH)
			fdw.close()
			setup='''import subprocess,os;fdr=open("'''+data[i]+'''","r");fdw=open("'''+ofname+'''","w")'''
			stmt='''subprocess.call(['java',"'''+str(fn)+'''"],stdin=fdr,stdout=fdw)'''				
			t.append(timeit.timeit(stmt,setup,number=1))						
			tc=tc+1
			j=j+1
		os.chdir(curr_working_path)
		tc=1
		for i in range(12,17):
			output_file=output_location+'/'+str(tc)+'.txt'
			re.append(filecmp.cmp(output_file,data[i]))
			tc=tc+1
	else:
		for i in range(12,17):
			re.append(False)
			t.append(str(0))			
			tm=0

	#print tm
def p_check_code(ppid,fn):
	global re,sti,tm,ret,t
	load_cookie()
	test_case="select * from problem_code as pc,practise_problem as pp where pc.problem_id=pp.pid and pp.ppid='{0}'".format(str(ppid))
	cursor.execute(test_case)
	data=cursor.fetchone()
	sub_location='/var/www/html/submission/'+c['uid'].value+'/p_problem/'+str(fn)
	output_location='/var/www/html/temp/'+c['uid'].value+'/p'+str(ppid)+'/'
	fi=open("temp.txt","w+")
	if os.path.exists(output_location):
		a=[]
		#subprocess.call(['chmod','-r','777','/var/www/html/codemafia/temp/'])	
	else:	
		os.makedirs(output_location, 0o777)
	try:
		ret=subprocess.call(['javac',sub_location,'-d',output_location+'/'],stderr=fi)		
	except subprocess.CalledProcessError:
		print sti
	fi.seek(0)
	sti=fi.read()
	if sti == "":
		fn=fn[:len(fn)-5]
		st = os.stat(output_location+'/'+'')
		os.chmod(output_location,st.st_mode | stat.S_IWGRP | stat.S_IWOTH)
		#os.chmod('/var/www/html/codemafia/temp/'+c['uid'].value+'/'+str(assignmnt_id)+'/'+str(pid)+'/'+str(fn),stat.S_IXUSR)
		curr_working_path=os.getcwd()
		rel_path='/var/www/html/temp/'+c['uid'].value+'/p'+str(ppid)+'/'
		os.chdir(rel_path)
		uid=c['uid'].value		
		tc=1
		j=1
		for i in range(7,12):
			ofname=str(j)+'.txt'
			fdw=open(str(j)+'.txt','w')			
			st = os.stat(output_location+str(j)+'.txt')
			os.chmod(output_location+'/'+str(j)+'.txt',st.st_mode | stat.S_IWGRP | stat.S_IWOTH)
			fdw.close()			
			setup='''import subprocess,os;fdr=open("'''+data[i]+'''","r");fdw=open("'''+ofname+'''","w")'''
			stmt='''subprocess.call(['java',"'''+str(fn)+'''"],stdin=fdr,stdout=fdw)'''	
			#fwrite=data[i]			
			t.append(timeit.timeit(stmt,setup,number=1))			
			tc=tc+1
			j=j+1
		#os.chdir(curr_working_path)
		tc=1
		for i in range(12,17):
			output_file=output_location+'/'+str(tc)+'.txt'
			re.append(filecmp.cmp(output_file,data[i]))
			tc=tc+1
	else:
		for i in range(12,17):
			re.append(False)
			t.append(str(0))			
			tm=0
		#print tm		
#check_code('2','1','abc.java')
