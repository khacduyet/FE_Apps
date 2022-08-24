package org.apache.jsp.WEB_002dINF.jsp.Views.Report;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class edit_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_f_form_method_commandName_action;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_f_input_type_placeholder_path_cssClass_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_f_textarea_rows_path_id_cssClass_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_f_checkbox_path_cssClass_nobody;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_f_form_method_commandName_action = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_f_input_type_placeholder_path_cssClass_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_f_textarea_rows_path_id_cssClass_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_f_checkbox_path_cssClass_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_f_form_method_commandName_action.release();
    _jspx_tagPool_f_input_type_placeholder_path_cssClass_nobody.release();
    _jspx_tagPool_f_textarea_rows_path_id_cssClass_nobody.release();
    _jspx_tagPool_f_checkbox_path_cssClass_nobody.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

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
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"row\">\r\n");
      out.write("    <div class=\"col-12\">\r\n");
      out.write("        <div class=\"card\">\r\n");
      out.write("            <div class=\"card-body\">\r\n");
      out.write("                <h3 class=\"header-title\">Input information class</h3>\r\n");
      out.write("\r\n");
      out.write("                <div class=\"row\">\r\n");
      out.write("                    <div class=\"col-lg-2\"></div>\r\n");
      out.write("                    <div class=\"col-lg-6\">\r\n");
      out.write("                        ");
      if (_jspx_meth_f_form_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                    </div> <!-- end col -->\r\n");
      out.write("                    <div class=\"col-lg-4\"></div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <!-- end row-->\r\n");
      out.write("\r\n");
      out.write("            </div> <!-- end card-body -->\r\n");
      out.write("        </div> <!-- end card -->\r\n");
      out.write("    </div><!-- end col -->\r\n");
      out.write("</div>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_f_form_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  f:form
    org.springframework.web.servlet.tags.form.FormTag _jspx_th_f_form_0 = (org.springframework.web.servlet.tags.form.FormTag) _jspx_tagPool_f_form_method_commandName_action.get(org.springframework.web.servlet.tags.form.FormTag.class);
    _jspx_th_f_form_0.setPageContext(_jspx_page_context);
    _jspx_th_f_form_0.setParent(null);
    _jspx_th_f_form_0.setAction("edit.htm");
    _jspx_th_f_form_0.setMethod("POST");
    _jspx_th_f_form_0.setCommandName("c");
    int[] _jspx_push_body_count_f_form_0 = new int[] { 0 };
    try {
      int _jspx_eval_f_form_0 = _jspx_th_f_form_0.doStartTag();
      if (_jspx_eval_f_form_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("<!--                            <div class=\"mb-3\" hidden=\"\">\r\n");
          out.write("                                <label class=\"form-label\">Id</label>\r\n");
          out.write("                                ");
          if (_jspx_meth_f_input_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_f_form_0, _jspx_page_context, _jspx_push_body_count_f_form_0))
            return true;
          out.write("\r\n");
          out.write("                            </div>-->\r\n");
          out.write("\r\n");
          out.write("<!--                            <div class=\"mb-3\">\r\n");
          out.write("                                <label for=\"note\" class=\"form-label\">Content Report</label>\r\n");
          out.write("                                ");
          if (_jspx_meth_f_textarea_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_f_form_0, _jspx_page_context, _jspx_push_body_count_f_form_0))
            return true;
          out.write("\r\n");
          out.write("                            </div>-->\r\n");
          out.write("<!--\r\n");
          out.write("                            <div class=\"mb-3\">\r\n");
          out.write("                                <div class=\"form-check\">\r\n");
          out.write("                                    ");
          if (_jspx_meth_f_checkbox_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_f_form_0, _jspx_page_context, _jspx_push_body_count_f_form_0))
            return true;
          out.write("\r\n");
          out.write("                                    <label class=\"form-check-label\" for=\"customCheck1\">Status (Show/Hiden)</label>\r\n");
          out.write("                                </div>\r\n");
          out.write("                            </div>-->\r\n");
          out.write("<!--                            <div class=\"mb-3\">\r\n");
          out.write("                                <button type=\"submit\" class=\"btn btn-primary\">Submit</button>\r\n");
          out.write("                                <a href=\"/FE_ExamApplication/report.htm\" class=\"btn btn-danger\">Back</a>\r\n");
          out.write("                            </div>-->\r\n");
          out.write("                        ");
          int evalDoAfterBody = _jspx_th_f_form_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_f_form_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_f_form_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_f_form_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_f_form_0.doFinally();
      _jspx_tagPool_f_form_method_commandName_action.reuse(_jspx_th_f_form_0);
    }
    return false;
  }

  private boolean _jspx_meth_f_input_0(javax.servlet.jsp.tagext.JspTag _jspx_th_f_form_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_f_form_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  f:input
    org.springframework.web.servlet.tags.form.InputTag _jspx_th_f_input_0 = (org.springframework.web.servlet.tags.form.InputTag) _jspx_tagPool_f_input_type_placeholder_path_cssClass_nobody.get(org.springframework.web.servlet.tags.form.InputTag.class);
    _jspx_th_f_input_0.setPageContext(_jspx_page_context);
    _jspx_th_f_input_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_f_form_0);
    _jspx_th_f_input_0.setPath("id");
    _jspx_th_f_input_0.setDynamicAttribute(null, "type", new String("text"));
    _jspx_th_f_input_0.setCssClass("form-control");
    _jspx_th_f_input_0.setDynamicAttribute(null, "placeholder", new String("id"));
    int[] _jspx_push_body_count_f_input_0 = new int[] { 0 };
    try {
      int _jspx_eval_f_input_0 = _jspx_th_f_input_0.doStartTag();
      if (_jspx_th_f_input_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_f_input_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_f_input_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_f_input_0.doFinally();
      _jspx_tagPool_f_input_type_placeholder_path_cssClass_nobody.reuse(_jspx_th_f_input_0);
    }
    return false;
  }

  private boolean _jspx_meth_f_textarea_0(javax.servlet.jsp.tagext.JspTag _jspx_th_f_form_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_f_form_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  f:textarea
    org.springframework.web.servlet.tags.form.TextareaTag _jspx_th_f_textarea_0 = (org.springframework.web.servlet.tags.form.TextareaTag) _jspx_tagPool_f_textarea_rows_path_id_cssClass_nobody.get(org.springframework.web.servlet.tags.form.TextareaTag.class);
    _jspx_th_f_textarea_0.setPageContext(_jspx_page_context);
    _jspx_th_f_textarea_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_f_form_0);
    _jspx_th_f_textarea_0.setPath("content");
    _jspx_th_f_textarea_0.setCssClass("form-control");
    _jspx_th_f_textarea_0.setId("example-textarea");
    _jspx_th_f_textarea_0.setRows("5");
    int[] _jspx_push_body_count_f_textarea_0 = new int[] { 0 };
    try {
      int _jspx_eval_f_textarea_0 = _jspx_th_f_textarea_0.doStartTag();
      if (_jspx_th_f_textarea_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_f_textarea_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_f_textarea_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_f_textarea_0.doFinally();
      _jspx_tagPool_f_textarea_rows_path_id_cssClass_nobody.reuse(_jspx_th_f_textarea_0);
    }
    return false;
  }

  private boolean _jspx_meth_f_checkbox_0(javax.servlet.jsp.tagext.JspTag _jspx_th_f_form_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_f_form_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  f:checkbox
    org.springframework.web.servlet.tags.form.CheckboxTag _jspx_th_f_checkbox_0 = (org.springframework.web.servlet.tags.form.CheckboxTag) _jspx_tagPool_f_checkbox_path_cssClass_nobody.get(org.springframework.web.servlet.tags.form.CheckboxTag.class);
    _jspx_th_f_checkbox_0.setPageContext(_jspx_page_context);
    _jspx_th_f_checkbox_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_f_form_0);
    _jspx_th_f_checkbox_0.setPath("status");
    _jspx_th_f_checkbox_0.setCssClass("form-check-input");
    int[] _jspx_push_body_count_f_checkbox_0 = new int[] { 0 };
    try {
      int _jspx_eval_f_checkbox_0 = _jspx_th_f_checkbox_0.doStartTag();
      if (_jspx_th_f_checkbox_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_f_checkbox_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_f_checkbox_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_f_checkbox_0.doFinally();
      _jspx_tagPool_f_checkbox_path_cssClass_nobody.reuse(_jspx_th_f_checkbox_0);
    }
    return false;
  }
}
