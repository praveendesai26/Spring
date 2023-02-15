package calculator;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Calculator {

	@RequestMapping("add")
	public void Addition( @RequestParam int num1 ,@RequestParam int num2 ,HttpServletResponse response) throws IOException
	{
//	int num1=	Integer.parseInt(request.getParameter("num1"));
//	int num2=	Integer.parseInt(request.getParameter("num2"));
    response.getWriter().print("<h1>The sum of "+num1+" and"+num2+ "is  "+(num1+num2)+"</h1>");
   
	}
	@RequestMapping("sub")
	public ModelAndView Substarction( @RequestParam int num1 ,@RequestParam int num2) 
	{
  //  response.getWriter().print("<h1>The dif of "+num1+" and"+num2+ "is  "+(num1-num2)+"</h1>");
		ModelAndView andView=new ModelAndView();
		andView.addObject("num1",num1);
		andView.addObject("num2",num2);
		andView.addObject("msg","Substraction");
		andView.addObject("result",num1-num2);

		andView.setViewName("Result.jsp");
		return andView;

	}
	@RequestMapping("mul")
	@ResponseBody
	public String  Multiplication( @RequestParam int num1 ,@RequestParam int num2 ) throws IOException
	{
    return "<h1>The mul of "+num1+" and"+num2+ "is  "+(num1*num2)+"</h1>";

	}
	@RequestMapping("div")
	public ModelAndView Division( @RequestParam double num1 ,@RequestParam double num2 ) 
	{
		ModelAndView andView=new ModelAndView();
		andView.addObject("num1",num1);
		andView.addObject("num2",num2);
		andView.addObject("msg","Division");
		andView.addObject("result",num1/num2);

		andView.setViewName("Result.jsp");
		return andView;

	}


}
