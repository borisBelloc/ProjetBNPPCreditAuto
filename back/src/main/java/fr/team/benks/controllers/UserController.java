package fr.team.benks.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import fr.team.benks.model.User;
import fr.team.benks.services.UserService;

@Controller
@RequestMapping("/api/users")
@ResponseBody
public class UserController {
	
	@Autowired
	private UserService us;
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@RequestBody User resource){
		
		us.save(resource);
		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Optional<User> findById(@PathVariable Long id) {
		
		return us.get(id);
		
	}

}