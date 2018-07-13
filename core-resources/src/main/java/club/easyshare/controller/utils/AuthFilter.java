package club.easyshare.controller.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.protocol.HTTP;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

/**
 * @author huyuyang@lxfintech.com
 * @Title: AuthFilter
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-07-13 13:56:56
 */
public class AuthFilter implements Filter {

    private static final Boolean isOpenAutoFilter = Boolean.valueOf(System.getProperty("isOpenAutoFilter", "true"));

    /**
     * 公共能够访问的url
     **/
    private static final Set<String> commonUrlSet = new HashSet<String>() {
        {
            add("/front/resource/category");
            add("/front/resource/queryOrderByViewCount");
            add("/front/resource/queryOrderByCreateTime");
            add("/front/resource/queryOrderByRand");
            add("/front/resource/view");
            add("/user");
            add("/error");
        }
    };

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        /** 不需要验证访问权限 **/
        if (!isOpenAutoFilter) {
            filterChain.doFilter(httpServletRequest, servletResponse);
            return;
        }

        /** 静态资源跳过 **/
        if (this.isStaticResource(httpServletRequest)) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        /** 不需要登陆的请求跳过 **/
        if (this.isUnLoginUrl(httpServletRequest)) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        //公共访问的url跳过
        if (this.isCommonUrl(httpServletRequest)) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        //如果已经登录，跳过
        if (SessionUtils.isLogin(httpServletRequest)) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        //跳转到首页
        handleNotLogin(httpServletRequest, httpServletResponse);
    }

    @Override
    public void destroy() {

    }

    /**
     * 判断是否是静态资源
     *
     * @param request
     * @return
     */
    private boolean isStaticResource(HttpServletRequest request) {
        String url = this.getRequestUrl(request);
        if (url.endsWith(".html") || url.endsWith(".action")) {
            return false;
        }
        return true;
    }

    /**
     * 判断是否是不需要登陆可以访问的url
     *
     * @param request
     * @return
     */
    private boolean isUnLoginUrl(HttpServletRequest request) {
        String url = this.getRequestUrl(request);
        if (url.indexOf("/nologin/") > -1) {
            return true;
        }
        return false;
    }

    /**
     * 是公共访问的url
     *
     * @param request
     * @return
     */
    private boolean isCommonUrl(HttpServletRequest request) {
        String url = this.getRequestUrl(request);
        if("/".equals(url)||"/index.html".equals(url)){
            return true;
        }
        for (String commonUrl : commonUrlSet) {
            if (url.indexOf(commonUrl) > -1) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断是否是ajax请求
     *
     * @param request
     * @return
     */
    private boolean isAjaxRequest(HttpServletRequest request) {
        String value = request.getHeader("X-Requested-With");
        if (StringUtils.isBlank(value)) {
            return false;
        }
        if (value.equals("XMLHttpRequest")) {
            return true;
        }
        return false;
    }

    /**
     * 处理未登录情况
     *
     * @param request
     * @param response
     */
    private void handleNotLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (this.isAjaxRequest(request)) {
            response.setHeader("sessionStatus", "timeout");
        } else {
            goToLoginPage(request, response);
        }
    }


    /**
     * 跳转到到首页
     *
     * @param request
     * @param response
     */
    private void goToLoginPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            PrintWriter out = response.getWriter();
            out.println("<html>");
            out.println("<script>");
            out.println("window.open ('" + getLoginUrl(request) + "','_parent')");
            out.println("</script>");
            out.println("</html>");
        } catch (IOException e) {
            e.printStackTrace();
            response.sendRedirect(getLoginUrl(request));
        }
    }

    /**
     * 首页url
     *
     * @param request
     * @return
     */
    private String getLoginUrl(HttpServletRequest request) {
        return "/";
    }

    private String getRequestUrl(HttpServletRequest request) {
        return request.getRequestURI();
    }

}
