package by.bsac.adpee.lab1;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
* Servlet implementation class ServletExample
*/
@WebServlet("/ServletExample")
public class ServletExample extends HttpServlet {
public static String GENDER_MALE = "male";
public static String GENDER_FEMALE = "female";
private static final long serialVersionUID = 1L;
/**
* @see HttpServlet#HttpServlet()
*/
public ServletExample() {
super();
}
/**
* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
* response)
*/
protected void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
// Set response content type
response.setContentType("text/html");
PrintWriter out = response.getWriter();
String title = "Using " + request.getMethod() + " Method to Read Form Data";
// опеределение пола - обработка radio button
String genderHtml =
(request.getParameter("gender").equalsIgnoreCase(GENDER_MALE))
? ("<li><b>Gender:</b>" + GENDER_MALE + "</li>") :
("<li><b>Gender:</b> " + GENDER_FEMALE + "</li>");
String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " +
"transitional//en\">\n";
out.println(docType + "<html>\n" + "<head><title>" + title + "</title></head>\n"
+ "<body bgcolor=\"#f0f0f0\">\n" + "<h1 align=\"center\">" + title
+ "</h1>\n" + "<ul>\n"
+ " <li><b>First Name</b>: " +
request.getParameter("first_name") + "\n" + " <li><b>Last Name</b>: "
+ request.getParameter("last_name") + "\n" +
// определение пола
genderHtml + "\n" +
// определение пола
// обработка checkbox
" <li><b>Student : </b> " + request.getParameter("student") + "\n"
+ " <li><b>Employee: </b> "
+ request.getParameter("employee") + "\n" + "<li><b>Other:</b>" + request.getParameter("other")
+ "\n</ul>\n");
// вывести все параметры - начало
out.println("<table width=\"100%\" border=\"1\" align=\"center\">\n" + "<trbgcolor=\"#949494\">\n"
+ "<th>Param Name</th><th>Param Value(s)</th>\n" +
"</tr>\n");
Enumeration paramNames = request.getParameterNames();
while (paramNames.hasMoreElements()) {
String paramName = (String) paramNames.nextElement();
out.print("<tr><td>" + paramName + "</td>\n<td>");
String[] paramValues = request.getParameterValues(paramName);
// Read single valued data
if (paramValues.length == 1) {
String paramValue = paramValues[0];
if (paramValue.length() == 0)
out.println("<i>No Value</i>");
else
out.println(paramValue);
} else {
// Read multiple valued data
out.println("<ul>");
for (int i = 0; i < paramValues.length; i++) {
out.println("<li>" + paramValues[i]);
}
out.println("</ul>");
}
}
out.println("</tr>\n</table>\n");
// вывести все параметры - конец
out.println("</body></html>");
}
/**
* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
* response)
*/
protected void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
doGet(request, response);
}
}