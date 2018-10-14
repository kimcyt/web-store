package webstore.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * to demonstrate some usages and mark down some notes
 */
@WebServlet("/NoteServlet")
public class NoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	////////////differeces between redirection and request-redirection
	/*
	 * redirection: 
	 * -send request to servlet-1, which tells browser to send request to servlet-2
	 * -browser sends two requests
	 * -the url address will change
	 * 
	 * request-redirection:
	 * -browser sends request to servlet-1, which redirects the request to servlet-2 directly, without
	 * telling the browser
	 * -browser sends request once
	 * -the url address is still the url of servlet-1
	 * -the request objects are not the same one, but the first one passes all it info
	 * to the second one in the forward(), it can store things as the servletContext
	 * and be shared among all servlets who got this request
	 * -!!!for server request, the relative path is webContent, and for browser request, the relative path is the jsp file
	 * so if server redirect to jsp, need to change css/references path to find the resources. To make sure it is correct,
	 * use absolute path instead
	 * -implementation:
	 *  -request.getRequesrDispatcher(String path of servlet-2)
	 *  -rqd.forward(req, res); 
	 * 
	 */
	
	//////////////////////two ways to get resource path:
	/*
	1. through context(context is shared among the webapp,
	can store key-object, through get/set/removeAttribute(key))
	-get context through the init method
	ServletContext sc = this.getServletContext();
	-this path got will concat the file path with the root path of the webapp(webapps/app-name)
	String realPath = sc.getRealPath("path to file");
	2. use classLoader to load resources from bytecode in the classes folder
	String path = LoginServlet.class.getClassLoader().getResource("file path").getPath();
	 */

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//when service is present, doGet/Post won't be called
		
		//////////////////////////////////write an image to response
		/*
		 * String path = this.getServletContext().getRealPath("png");
		 * ServletOutputStream out = response.getOutputStream();
		 * 
		 * FileInputStream in = new FileInputStream(path);
		 * byte[] buffer = new byte[1024];
		 * int len=0;
		 * while((len=in.read(buffer))!=-1){
		 *     out.write(buffer, 0, len);
		 * }
		 */
		
		////////////////////////////file download through request to servlet
		/*-send request through a/form/... tag
		 * <a href="/webapp/downloadServlet?filename=123.png">
		 * 
		 *-receive request in servlet, and write response
		 *  String filename = request.getParameter("filename");
		 *  //!! if the parameter is chinese, server encodes it using ISO by default
		 *  //need to convert it to UTF-8
		 *  Byte[] bytes = filename.getBytes("ISO8859-1");
		 *  filename = new String(bytes, "UTF-8");
		 *  //get the full path of the required file
		 *  String path = this.getServletContext().getRealPath("download/"+filename);
		 *  //get response writer
		 *  ServletOutputStream out = response.getOutputStream();
		 *  //load the file
		 *  FileInputStream in = new FileInputStream();
		 *  byte[] buffer = new byte[1024];
		 *  int len=0;
		 *  while((len=in.read(buffer))!=-1){
		 *      //write to response
		 *      out.write(buffer, 0, len);
		 *  }
		 *  
		 * !!if encounter error 3986, see lesson 62 
		 *-tell the browser do not interpret the file content
		 *  //get MIME type of the file
		 *  String mimeType = this.getServletCOntext().getMimeType(filename);
		 *  //set type
		 *  response.setContentType(mimeType); //the mapping of types can be found in server web.xml
		 *  //tell browser do not interpret, open as attachment
		 *  //if the name is in chinese and unrecognized, convert it(see lesson 63)
		 *  response.setHeader("Content-Dispsition", "attachment;filename="+filename);
		 */
		
		
		////////////////////////////////check code implementation
		/*
		 * -use the checkcode servlet from online sources 
		 *   -load check codes into array
		 *   -randomly gets one checkcode from array
		 *   -store in session
		 *   -generate image from the checkcode, write to response
		 *   -verify 
		 * -display it on website
		 *   -<img src="/webapp/checkcodeServlet">
		 * -click img to change checkcode
		 *   -<img register onclick function change(this){obj.src = "/webapp/checkcodeServlet?"+new Date().getTime();
		 *   //must change the scr everytime so that the url is different and a new request is sent
		 *   //if the url is the same as last time, browser doesn't resend request
		 */
		
		
		////////////////////////////add cookie
		/*
		 * 1. create cookie
		 * Cookie cookie = new Cookie(key, value);
		 * 2. add to response header
		 * response.addCookie(cookie);
		 *  -age: by default, they are session cookies-destoried as browser closes
		 *       -set maxAge: cookie.setMaxAge(secs)-saved to disk and auto destoried when expired
		 *  -carried when: by default, if the path of the request is the same(only differ at the last part)
		 *     as the path in which the cookie was created, then these requests carry the cookie
		 *     -set carry path: cookie.setPath(servlet/app/root path);
		 * 3. when the browser receives the response, it saves the cookie to staging, and
		 * attach the cookie to next request to all resources of the same app
		 * 4. remove cookie
		 * set cookie of the same name with maxAge 0
		 * 5. get cookie
		 * request.getCookies() get all cookies, traverse and check name cookie.getName()  
		 * 6. get last visit time
		 *  -store new Date() in cookie
		 */
		
		
		////////////////////add session
		/*
		 * create a session for every client, write the session id to client 
		 * via session cookie(no expiration time by default) at creation, which will disappear 
		 * when browser closes
		 * -to change the max age of cookie to keep the session regardless of browser close:
		 * eg. cookie = new Cookie("JSESSIONID", session.getId())
		 *     cookie.setMaxAge(s)
		 *     response.addCookie(cookie)
		 * client needs to carry id to get its own session
		 * 
		 * 1. get session
		 * if the client does not have session(determined by whether it carries session id), 
		 * create one, return the session otherwise
		 * HttpSession session = request.getSession()
		 * 2.store/retrive info
		 * session.set/getAttribute(key, value) //path by default is the whole app
		 * 3.life cycle
		 * -created at the first getSession()
		 * -destoried at expiration (30mins by default from the last request)/server close/
		 * session.invalidate()
		 * -set Age
		 * add <session-config> - <session-timeout> in mins in web.xml  
		 * edit in server web.xml applies to all apps 
		 */
		
		
		//////////////////////////////////////set header
		/*
		 * -set status code: if not set and responded, set 200 by default
		 * response.setStatus(200);
		 * 
		 * -add
		 * response.addHeader("some", "thing");//addInt/DateHeader
		 * 
		 * -set
		 * response.setHeader("some", "how");//setInt/DateHeader
		 * 
		 * -redirect: the first response tells browser to go to the second address, browser requests twice 
		 * --redirected immediately: response.setHeader("location", "/webstore/loginuser") 
		 * or use response.sendRedirect(url);
		 * --redirect after a set time
		 * response.setHeader("refresh", "2;url=/webstore/loginuser") // 2 is the seconds to be waited
		 * response.setStatus(302); //set by default; 
		 */
		
		
		///////////////////////////////set body
		/*
		 * -write: response.getWriter().write(html/string) 
		 *  //if write chinese, the buffer stores it with iso8859 by default, need to set to UTF-8
		 *  -response.setCharacterEncoding("UTF-8")
		 *  //this setting is applied to the tomcat engine, but not the browser
		 *  -response.setHeader("Content-Type", "text/html;charset=UTF-8"); 
		 *  //shorthand: response.setContentType("text/html;charset=UTF-8"); 
		 * 
		 */
		
		//////////////////////////////load files, must use absolute path
		/*
		 * new FileInputStream(path);
		 * -read one per time
		 * in.read(); //get the bytecode of the first content, when all read, return -1
		 * in.close();
		 * -read into a buffer(array of byte[1024]) //if buffer full, overwrite from the start
		 * int len = in.read(buffer)
		 */
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
