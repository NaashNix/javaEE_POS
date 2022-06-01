package serverlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/login")
public class GeneralFilter implements Filter {

    public GeneralFilter() {
        System.out.println("Object Created.");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter Created.");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("General Filter Do Filter Method.");
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        httpServletResponse.addHeader("Access-Control-Allow-Origin","*");
        httpServletResponse.addHeader("Access-Control-Allow-Method","DELETE,PUT,POST");
//        httpServletResponse.addHeader("Access-Control-Allow-Headers","Content-Type");
        httpServletResponse.addHeader("Access-Control-Allow-Headers","X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept");

//        servletResponse = httpServletResponse;

    }

    @Override
    public void destroy() {

    }
}
