/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.37
 * Generated at: 2018-11-24 16:54:45 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import lv.javaguru.java2.buisnesslogic.trip.get.GetTripResponse;
import lv.javaguru.java2.web.dtos.TripDTO;

public final class vehicle_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/WEB-INF/jsp/style.css", Long.valueOf(1543078466069L));
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fspring_005furl_0026_005fvalue_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fspring_005furl_0026_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fspring_005furl_0026_005fvalue_005fnobody.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("\r\n");
      out.write("<style>");
      out.write("table {\r\n");
      out.write("    width: 100%;\r\n");
      out.write("\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("th {\r\n");
      out.write("    height: 50px;\r\n");
      out.write("    text-align: left;\r\n");
      out.write("}\r\n");
      out.write("a {\r\n");
      out.write("    text-decoration: none;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("body {background-color: #e6dee6;\r\n");
      out.write("    font-family: 'Open Sans', 'sans-serif';}\r\n");
      out.write("h1   {color: black;}\r\n");
      out.write("p    {color: black;}\r\n");
      out.write("title   {color: #5a12ff;}\r\n");
      out.write("a { color: #5a0d77;}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("#box-one {\r\n");
      out.write("    background-color: rgba(91, 19, 255, 0.16);\r\n");
      out.write("    border-radius: 5px;\r\n");
      out.write("    border: #1f0756;\r\n");
      out.write("    margin-outside: 20px;\r\n");
      out.write("    grid-gap: 10px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".wrapper {\r\n");
      out.write("    display: grid;\r\n");
      out.write("    grid-template-columns: 100px 100px 100px;\r\n");
      out.write("    grid-gap: 10px;\r\n");
      out.write("    background-color: rgba(251, 225, 241, 0.25);\r\n");
      out.write("    color: rgb(0, 0, 0);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".box {\r\n");
      out.write("    background-color: rgba(202, 233, 255, 0.51);\r\n");
      out.write("    color: #3a98df;\r\n");
      out.write("    border-radius: 5px;\r\n");
      out.write("    padding: 20px;\r\n");
      out.write("    font-size: 14px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("*, *:before, *:after {\r\n");
      out.write("    box-sizing: border-box;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("body {\r\n");
      out.write("    margin: 40px;\r\n");
      out.write("    font-family: Arial;\r\n");
      out.write("    background-color: rgba(207, 192, 255, 0.15);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("h1, p {\r\n");
      out.write("    margin: 0 0 1em 0;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* no grid support? */\r\n");
      out.write(".sidebar {\r\n");
      out.write("    float: left;\r\n");
      out.write("    width: 19.1489%;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".content {\r\n");
      out.write("    float: right;\r\n");
      out.write("    width: 79.7872%;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* make a grid */\r\n");
      out.write(".wrapper {\r\n");
      out.write("    max-width: 940px;\r\n");
      out.write("    margin: 0 auto;\r\n");
      out.write("    display: grid;\r\n");
      out.write("    grid-template-columns: 1fr 3fr;\r\n");
      out.write("    grid-gap: 10px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".wrapper > * {\r\n");
      out.write("    background-color: #cfc0ff;\r\n");
      out.write("    color: #b588ff;\r\n");
      out.write("    border-radius: 5px;\r\n");
      out.write("    padding: 20px;\r\n");
      out.write("    font-size: 150%;\r\n");
      out.write("    /* needed for the floated layout*/\r\n");
      out.write("    margin-bottom: 10px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".header, .footer {\r\n");
      out.write("    grid-column: 1 / -1;\r\n");
      out.write("    /* needed for the floated layout */\r\n");
      out.write("    clear: both;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("/* We need to set the widths used on floated items back to auto, and remove the bottom margin as when we have grid we have gaps. */\r\n");
      out.write("@supports (display: grid) {\r\n");
      out.write("    .wrapper > * {\r\n");
      out.write("        width: auto;\r\n");
      out.write("        margin: 0;\r\n");
      out.write("    }\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("    <title>Vehicle Info</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<a href=\"");
      if (_jspx_meth_spring_005furl_005f0(_jspx_page_context))
        return;
      out.write("\">Let's Ride</a>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"wrapper\">\r\n");
      out.write("    <header class=\"header\">\r\n");
      out.write("        <h1><a href=\"");
      if (_jspx_meth_spring_005furl_005f1(_jspx_page_context))
        return;
      out.write("\">Let's ride</a></h1>\r\n");
      out.write("    </header>\r\n");
      out.write("\r\n");
      out.write("    <aside class=\"sidebar\">\r\n");
      out.write("        <div id=\"box-one\">\r\n");
      out.write("            <a href=\"trips\">View All Trips</a>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div id=\"box-one\">\r\n");
      out.write("            <a href=\"");
      if (_jspx_meth_spring_005furl_005f2(_jspx_page_context))
        return;
      out.write("\">Add Vehicle</a>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div id=\"box-one\">\r\n");
      out.write("            <a href=\"");
      if (_jspx_meth_spring_005furl_005f3(_jspx_page_context))
        return;
      out.write("\">Add trip</a>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div id=\"box-one\">\r\n");
      out.write("            <a href=\"");
      if (_jspx_meth_spring_005furl_005f4(_jspx_page_context))
        return;
      out.write("\">Logout</a>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("    </aside>\r\n");
      out.write("\r\n");
      out.write("    <article class=\"content\">\r\n");
      out.write("        <h1>Vehicle information</h1>\r\n");
      out.write("        <table >\r\n");
      out.write("            <tr>\r\n");
      out.write("                <th>Model</th>\r\n");
      out.write("                <th>Year</th>\r\n");
      out.write("                <th>Color</th>\r\n");
      out.write("                <th>Registration number</th>\r\n");
      out.write("            </tr>\r\n");
      out.write("\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${car.getModel()}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</td>\r\n");
      out.write("                <td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${car.getYear()}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</td>\r\n");
      out.write("                <td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${car.getColor()}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</td>\r\n");
      out.write("                <td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${car.getRegNumber()}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</td>\r\n");
      out.write("            </tr>\r\n");
      out.write("        </table >\r\n");
      out.write("    </article>\r\n");
      out.write("\r\n");
      out.write("    <footer class=\"footer\">My footer</footer>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_spring_005furl_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  spring:url
    org.springframework.web.servlet.tags.UrlTag _jspx_th_spring_005furl_005f0 = (org.springframework.web.servlet.tags.UrlTag) _005fjspx_005ftagPool_005fspring_005furl_0026_005fvalue_005fnobody.get(org.springframework.web.servlet.tags.UrlTag.class);
    _jspx_th_spring_005furl_005f0.setPageContext(_jspx_page_context);
    _jspx_th_spring_005furl_005f0.setParent(null);
    // /WEB-INF/jsp/vehicle.jsp(15,9) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_spring_005furl_005f0.setValue("/index");
    int[] _jspx_push_body_count_spring_005furl_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_spring_005furl_005f0 = _jspx_th_spring_005furl_005f0.doStartTag();
      if (_jspx_th_spring_005furl_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_spring_005furl_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_spring_005furl_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_spring_005furl_005f0.doFinally();
      _005fjspx_005ftagPool_005fspring_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_spring_005furl_005f0);
    }
    return false;
  }

  private boolean _jspx_meth_spring_005furl_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  spring:url
    org.springframework.web.servlet.tags.UrlTag _jspx_th_spring_005furl_005f1 = (org.springframework.web.servlet.tags.UrlTag) _005fjspx_005ftagPool_005fspring_005furl_0026_005fvalue_005fnobody.get(org.springframework.web.servlet.tags.UrlTag.class);
    _jspx_th_spring_005furl_005f1.setPageContext(_jspx_page_context);
    _jspx_th_spring_005furl_005f1.setParent(null);
    // /WEB-INF/jsp/vehicle.jsp(21,21) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_spring_005furl_005f1.setValue("/index");
    int[] _jspx_push_body_count_spring_005furl_005f1 = new int[] { 0 };
    try {
      int _jspx_eval_spring_005furl_005f1 = _jspx_th_spring_005furl_005f1.doStartTag();
      if (_jspx_th_spring_005furl_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_spring_005furl_005f1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_spring_005furl_005f1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_spring_005furl_005f1.doFinally();
      _005fjspx_005ftagPool_005fspring_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_spring_005furl_005f1);
    }
    return false;
  }

  private boolean _jspx_meth_spring_005furl_005f2(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  spring:url
    org.springframework.web.servlet.tags.UrlTag _jspx_th_spring_005furl_005f2 = (org.springframework.web.servlet.tags.UrlTag) _005fjspx_005ftagPool_005fspring_005furl_0026_005fvalue_005fnobody.get(org.springframework.web.servlet.tags.UrlTag.class);
    _jspx_th_spring_005furl_005f2.setPageContext(_jspx_page_context);
    _jspx_th_spring_005furl_005f2.setParent(null);
    // /WEB-INF/jsp/vehicle.jsp(29,21) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_spring_005furl_005f2.setValue("/vehicles/addVehicle");
    int[] _jspx_push_body_count_spring_005furl_005f2 = new int[] { 0 };
    try {
      int _jspx_eval_spring_005furl_005f2 = _jspx_th_spring_005furl_005f2.doStartTag();
      if (_jspx_th_spring_005furl_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_spring_005furl_005f2[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_spring_005furl_005f2.doCatch(_jspx_exception);
    } finally {
      _jspx_th_spring_005furl_005f2.doFinally();
      _005fjspx_005ftagPool_005fspring_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_spring_005furl_005f2);
    }
    return false;
  }

  private boolean _jspx_meth_spring_005furl_005f3(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  spring:url
    org.springframework.web.servlet.tags.UrlTag _jspx_th_spring_005furl_005f3 = (org.springframework.web.servlet.tags.UrlTag) _005fjspx_005ftagPool_005fspring_005furl_0026_005fvalue_005fnobody.get(org.springframework.web.servlet.tags.UrlTag.class);
    _jspx_th_spring_005furl_005f3.setPageContext(_jspx_page_context);
    _jspx_th_spring_005furl_005f3.setParent(null);
    // /WEB-INF/jsp/vehicle.jsp(33,21) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_spring_005furl_005f3.setValue("/trips/addTrip");
    int[] _jspx_push_body_count_spring_005furl_005f3 = new int[] { 0 };
    try {
      int _jspx_eval_spring_005furl_005f3 = _jspx_th_spring_005furl_005f3.doStartTag();
      if (_jspx_th_spring_005furl_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_spring_005furl_005f3[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_spring_005furl_005f3.doCatch(_jspx_exception);
    } finally {
      _jspx_th_spring_005furl_005f3.doFinally();
      _005fjspx_005ftagPool_005fspring_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_spring_005furl_005f3);
    }
    return false;
  }

  private boolean _jspx_meth_spring_005furl_005f4(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  spring:url
    org.springframework.web.servlet.tags.UrlTag _jspx_th_spring_005furl_005f4 = (org.springframework.web.servlet.tags.UrlTag) _005fjspx_005ftagPool_005fspring_005furl_0026_005fvalue_005fnobody.get(org.springframework.web.servlet.tags.UrlTag.class);
    _jspx_th_spring_005furl_005f4.setPageContext(_jspx_page_context);
    _jspx_th_spring_005furl_005f4.setParent(null);
    // /WEB-INF/jsp/vehicle.jsp(37,21) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_spring_005furl_005f4.setValue("/logout");
    int[] _jspx_push_body_count_spring_005furl_005f4 = new int[] { 0 };
    try {
      int _jspx_eval_spring_005furl_005f4 = _jspx_th_spring_005furl_005f4.doStartTag();
      if (_jspx_th_spring_005furl_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_spring_005furl_005f4[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_spring_005furl_005f4.doCatch(_jspx_exception);
    } finally {
      _jspx_th_spring_005furl_005f4.doFinally();
      _005fjspx_005ftagPool_005fspring_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_spring_005furl_005f4);
    }
    return false;
  }
}
