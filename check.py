import filecmp
if(filecmp.cmp('1.txt','./output/1/1.txt')):
	print "True"
else:	
	print "false"
