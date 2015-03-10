#this file just opens a connection with the problem database
import MySQLdb
db=MySQLdb.connect("localhost","root","MySql56@Sun","problems")
cursor=db.cursor()
