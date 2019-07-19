package kr.ac.binsin.constroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.ac.binsin.model.User;
import kr.ac.binsin.service.UserService;


@RestController // RestController = Controllelr + ResponseBody
@RequestMapping("/api")
public class RestAPIController {

	@Autowired
	private UserService userService;
	
	// Retrieve All Users
	@RequestMapping(value="/users", method=RequestMethod.GET)
	public ResponseEntity<List<User>> listAllUsers() { // header, body(json), HTTP.status
		List<User> users = userService.findAllUsers();
		
		if(users.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	
	// Retrieve Single User
		@RequestMapping(value="/users/{id}", method=RequestMethod.GET)
		public ResponseEntity<User> getUser(@PathVariable("id") long id) {
			User user = userService.findById(id);
			
			if(user == null) {
				// to do list : exception
			}
			
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}
		
}
