# forwardproxy

This app is used to fetch data for full text links. It is to be deployed on the host that is whitelisted by publisher. LSDiscovery will embed the full text url in a request which will be sent to <b>address:port</b>/proxy?fullTextString=<fulltexturl>. 
Specify address and port in <b>application.properties</b> file
This will return response to the browser. 

App Config contains config information for this server to use.
RequestHandler contains a method that forwards the request from the current server and return response to the origin server.

Only text/html type response is handled by the method.

<b>user-agent = Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.135 Safari/537.36</b>
