package com.facundo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.facundo.domain.Message;
import com.facundo.websocket.MessageBroker;
/**
 * @author facundo.ferro
 */
@Controller
public class AppController {
	
	@Autowired
	 MessageBroker broker; 
	
	 @RequestMapping(value ="/", method = RequestMethod.GET)
		public String app(Model model) {
			return "app";
		}
	 
	  @RequestMapping(value="/message", method={RequestMethod.POST},  headers ="Accept=application/json")
	    @ResponseBody
	    @ResponseStatus(HttpStatus.CREATED)
	    public String saveGuest( @RequestBody Message message){
	        broker.notifyArrival(message.getMessage());
	        return message.getMessage();
	    }


}
