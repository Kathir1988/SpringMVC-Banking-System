package controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomMapEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.DeferredResultMethodReturnValueHandler;

import com.bank.entity.Customer;
import com.bank.entity.Transaction;
import com.bank.service.BankServiceInterface;


@Controller
public class BankController {

	@Autowired
	BankServiceInterface bsi;
	
	@RequestMapping("signin")
	public ModelAndView cookieLogin(@ModelAttribute Customer customer, Transaction trans, @CookieValue(value="customer", required=false) String username){
		ModelAndView model = null;
		System.out.println("Cookie value"+username);
		if(username != null){
			customer.setUsername(username);
			double balance = bsi.getTransaction(trans,customer);
			List<Transaction> tr = bsi.listTransaction(trans, customer);
			double monthdebit = bsi.getMonthDefensive(trans,customer);
			double datedebit = bsi.getDateDefensive(trans,customer);
			System.out.println("Cookies Login!!!");
			model = new ModelAndView("View");
			model.addObject("customername",customer.getUsername());
			model.addObject("balance",balance);
			model.addObject("transactions",tr);
			model.addObject("monthdedits",monthdebit);
			model.addObject("datedebits",datedebit);
			
		}
		else{
			model = new ModelAndView("Login");
		}
		return model;
	}
	
	@RequestMapping("addCustomer")
	public String Register() {
		return "Register";
	}
	
	@RequestMapping("checkEmail")
	@ResponseBody
	public String checkEmail(@RequestParam String email, @ModelAttribute Customer customer){
		System.out.println("Email Check: "+email);
		customer.setEmail(email);
		Customer emailcheck = bsi.checkEmail(customer);
		if(emailcheck != null){
			return "already taken!";
		}else
		{
			return "available!";
		}
		
	}
	
	@RequestMapping("checkUsername")
	@ResponseBody
	public String checkUsername(@RequestParam String username, @ModelAttribute Customer customer){
		System.out.println("Username Check: "+username);
		customer.setUsername(username);
		Customer cus = bsi.checkUsername(customer);
		if(cus != null){
			return "already taken! choose another username!!";
		}else
		{
			return "username available!!!";
		}
		
	}
	
	@RequestMapping("saveRegister")
	public ModelAndView createCustomer(@ModelAttribute Customer customer){
		bsi.createCustomer(customer);
		return new ModelAndView("Login");
	}
	
	@RequestMapping(value="/checkLogin", method = RequestMethod.POST)
	public ModelAndView checkLogin(HttpServletResponse response, @ModelAttribute Customer customer, Transaction trans){
		Customer cust = bsi.getCustomer(customer);
		ModelAndView model = null;
		if(cust==null){
			model = new ModelAndView("Login");
			model.addObject("login_failed","Invalid username & password");
			return model;
		}
		else{
			System.out.println(cust.getUsername()+" "+cust.getPassword());
			Cookie ck = new Cookie("customer",cust.getUsername());
			ck.setMaxAge(2592000);
			response.addCookie(ck);
			model = new ModelAndView("View");
			double balance = bsi.getTransaction(trans,cust);
			List<Transaction> tr = bsi.listTransaction(trans, customer);
			double monthdebit = bsi.getMonthDefensive(trans,customer);
			double datedebit = bsi.getDateDefensive(trans,customer);
			System.out.println("Login Successfully!!!");
			model.addObject("customername",cust.getUsername());
			model.addObject("balance",balance);
			model.addObject("transactions",tr);
			model.addObject("monthdedits",monthdebit);
			model.addObject("datedebits",datedebit);
			return model;
		}
		
	}
	
	@RequestMapping("logout")
	public ModelAndView deleteCookie(HttpServletResponse response, @ModelAttribute Customer cust){
		Cookie ck = new Cookie("customer",cust.getUsername());
		ck.setMaxAge(0);
		response.addCookie(ck);
		return new ModelAndView("Login");
	}
	
	@RequestMapping("credit")
	public ModelAndView viewCredit(){
		return new ModelAndView("Credit");
	}
	
	@RequestMapping("debit")
	public ModelAndView viewDebit(){
		return new ModelAndView("Debit");
	}
	
	@RequestMapping("view")
	public ModelAndView viewTransaction(@ModelAttribute Customer customer, Transaction trans, @CookieValue("customer") String username){
		ModelAndView model = new ModelAndView("View");
		customer.setUsername(username);
		double balance = bsi.getTransaction(trans,customer);
		List<Transaction> tr = bsi.listTransaction(trans, customer);
		double monthdebit = bsi.getMonthDefensive(trans,customer);
		double datedebit = bsi.getDateDefensive(trans,customer);
		model.addObject("customername",customer.getUsername());
		model.addObject("balance",balance);
		model.addObject("transactions",tr);
		model.addObject("monthdebits",monthdebit);
		model.addObject("datedebits",datedebit);
		return model;
	}
	
	@RequestMapping("transaction")
	public ModelAndView createTransaction(@ModelAttribute Customer customer, Transaction trans,@CookieValue("customer") String username){
		customer.setUsername(username);
		bsi.createTransaction(trans,customer);
		ModelAndView model = new ModelAndView("View");
		double balance = bsi.getTransaction(trans,customer);
		List<Transaction> tr = bsi.listTransaction(trans, customer);
		double monthdebit = bsi.getMonthDefensive(trans,customer);
		double datedebit = bsi.getDateDefensive(trans,customer);
		model.addObject("customername",customer.getUsername());
		model.addObject("balance",balance);
		model.addObject("transactions",tr);
		model.addObject("monthdedits",monthdebit);
		model.addObject("datedebits",datedebit);
		return model;
	}
	
	@RequestMapping("search")
	public ModelAndView createExport(@ModelAttribute Transaction trans, Customer customer, @CookieValue("customer") String username){
		
		customer.setUsername(username);
		ModelAndView model = new ModelAndView("Export");
		List<Transaction> tr = bsi.listTransaction(trans, customer);
		model.addObject("customername",customer.getUsername());
		model.addObject("transactions",tr);
		return model;
	}
	
	@RequestMapping("export")
	public ModelAndView viewExport(@RequestParam("export") String date, @CookieValue("customer") String username){
		Customer cust = new Customer();
		cust.setUsername(username);
		Transaction trans= new Transaction();
		ModelAndView model = new ModelAndView("Export");
		List<Transaction> tr = bsi.listExViTransaction(cust,trans,date);
		model.addObject("customername",cust.getUsername());
		model.addObject("transactions",tr);
		return model;
	}
	
}
	