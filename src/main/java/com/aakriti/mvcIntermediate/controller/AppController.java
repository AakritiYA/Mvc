package com.aakriti.mvcIntermediate.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.aakriti.mvcIntermediate.api.EmailDTO;
import com.aakriti.mvcIntermediate.api.RegisterDTO;
import com.aakriti.mvcIntermediate.api.UserInfoDTO;
import com.aakriti.mvcIntermediate.service.AppEmailServiceImpl;
import com.aakriti.mvcIntermediate.service.AppServiceImpl;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@SessionAttributes("user")
public class AppController {

	@Autowired
	private AppEmailServiceImpl appEmailServiceImplobj;
	
	@Autowired
	private AppServiceImpl appServiceImpl;
	
	@RequestMapping("/")
	public String showHomePage(Model model) {
		UserInfoDTO userDto = new UserInfoDTO();
		model.addAttribute("user",userDto);
		return "home-page";
	}

	@RequestMapping("/processhomepage")
	public String processhomepage(@Valid @ModelAttribute("user") UserInfoDTO userDto,BindingResult result, HttpServletRequest request, Model model) {
//		here we create a reference of UserInfoDTO so that we can feed the data to view page
		
//		model.addAttribute("user", userDto); // here we have give only reference name and then in view page we have
//		write to access those variable which is in another view page
//		if i want this if block run properly then i have to use modelattribute not model only
		if(result.hasErrors()) {
			System.out.println("error");
			return "home-page";
		}
		
//		creating session
//		HttpSession session = request.getSession();
//		session.setAttribute("myusername", userDto.getUsername());  // setAttribute is key value pair, now we session where we need it
		
//	write a service which will calculate the love % between user and the crush name
		String res = appServiceImpl.calculateLove(userDto.getUsername(), userDto.getLovername());
		userDto.setRes(res);
		
		return "processpage";
	}

	

//	in this method we use requestparam but what if i want 20 data then we have use 20 requestparam so to avoid that we try some another method to get that
//	  @RequestMapping("/processhomepage") 
//	  public String processhomepage(@RequestParam String username,@RequestParam String lovername,
//	  Model model){ // through model we send the data to view, username means it
////	  holds the actual data and input name will helps to reference name in view
////	  through which we get the value 
//		  model.addAttribute("user", username);
//	  //username and input parameter name should be the same
//	  model.addAttribute("lover", lovername);
//	  
//	  return "processpage"; }
	 

	@RequestMapping("/register")
	public String register() {
		return "registeration";
	}

	@RequestMapping("/rprocess")
	public String registerProcess(@Valid @ModelAttribute("data") RegisterDTO registerDTO, BindingResult result) {
		
		if(result.hasErrors()) {
			System.out.println("error");
			return "registeration";
		}
		
		return "registerprocess";
	}
	


	@RequestMapping("/emailpage")
	public String email() {
		return "emailsending";
	}
	
	@RequestMapping("/mailsuccess")
	public String emailsended(@ModelAttribute("user") UserInfoDTO userDto, @ModelAttribute("emailDto") EmailDTO emailDTO ) {
		appEmailServiceImplobj.sendMail(userDto.getLovername(), emailDTO.getUserEmail(), userDto.getRes());
		return "emailsuccessful";
	}
	
	
//	cookie
	
	
//	@RequestMapping("/home")
//	public String showHomePage(@ModelAttribute("user") UserInfoDTO userDto, HttpServletRequest request) {
//		
////		creating an array for cookie
//		Cookie[]  cookies = request.getCookies();	
////		there are many cookie we search for one specific one
//		for(Cookie temp: cookies) {
//			if("app.userName".equals(temp.getName())) {
////				when we get that cookie fetch the value and store in myusername variable
//				String myusername = temp.getValue();
////				here we set the value so that in homepage we can see if already any available
//				userDto.setUsername(myusername);
//			}
//		}
//		
//		return "home-page";
//	}
	
//	@RequestMapping("/processhomepage")
//	public String processhomepage(@Valid @ModelAttribute("user") UserInfoDTO userDto,BindingResult result) {// HttpServletResponse response) { 
////		here we create a reference of UserInfoDTO so that we can feed the data to view page
//		
////		model.addAttribute("user", userDto); // here we have give only reference name and then in view page we have
////		write to access those variable which is in another view page
////		if i want this if block run properly then i have to use modelattribute not model only
//		if(result.hasErrors()) {
//			System.out.println("error");
//			return "home-page";
//		}
//		
////		create a cookie for the user name
//		Cookie thecookie = new Cookie("app.userName", userDto.getUsername()); //always have key value pair
//		thecookie.setMaxAge(60*60*24);
////		add cookie to response 
//		response.addCookie(thecookie);
//		
////		write a service which will calculate the love % between user and the crush name
//		return "processpage";
//	}
	
	
	
//	InitBinder
	
//	@InitBinder
//	public void initBinder(WebDataBinder binder) {
//		StringTrimmerEditor editor = new StringTrimmerEditor(true); //this is a build in property editor
//		binder.registerCustomEditor(String.class, "name", editor);
//		
//		//my own property editor
//		//register a custom editor for the name field which is in DTO
//		NameEditor nameEditor = new NameEditor();
//		binder.registerCustomEditor(String.class, nameEditor);
//	}
	
//	some property editor are build in like StringTrimmerEditor and some we can create according to our need. 
//	Spring uses property editors to convert strings to object type and object type to string type.
//	binder.registerCustomEditor(String.class, "name", editor); String.class is name of "data type of DTO property name"
//	and name is DTO class property name and editor is reference name of property editor
	
	
	
}
