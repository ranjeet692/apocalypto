import Cookie,os
c=Cookie.SimpleCookie()
def load_cookie():
	if 'HTTP_COOKIE' in os.environ:
		cookie_string=os.environ.get('HTTP_COOKIE')
		c.load(cookie_string)
	
