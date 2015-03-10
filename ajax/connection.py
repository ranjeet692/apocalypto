#this file just opens a connection with the database
import MySQLdb
db=MySQLdb.connect("localhost","abcd","abcd","abcd")
cursor=db.cursor()

