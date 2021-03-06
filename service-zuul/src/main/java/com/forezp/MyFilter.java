package com.forezp;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class MyFilter
  extends ZuulFilter
{
  private static Logger log = LoggerFactory.getLogger(MyFilter.class);
  
  public String filterType()
  {
    return "pre";
  }
  
  public int filterOrder()
  {
    return 0;
  }
  
  public boolean shouldFilter()
  {
    return true;
  }
  
  public Object run()
  {
    RequestContext ctx = RequestContext.getCurrentContext();
    HttpServletRequest request = ctx.getRequest();
    log.info(String.format("%s >>> %s", new Object[] { request.getMethod(), request.getRequestURL().toString() }));
    Object accessToken = request.getParameter("token");
    if (accessToken == null)
    {
      log.warn("token is empty");
      ctx.setSendZuulResponse(false);
      ctx.setResponseStatusCode(401);
      try
      {
        ctx.getResponse().getWriter().write("token is empty");
      }
      catch (Exception localException) {}
      return null;
    }
    log.info("ok");
    return null;
  }
}
