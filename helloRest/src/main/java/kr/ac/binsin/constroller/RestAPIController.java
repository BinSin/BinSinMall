package kr.ac.binsin.constroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

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
	
	// Create User
	@RequestMapping(value="/users", method=RequestMethod.POST) // json파일의 request body 부분에 정보가 담긴다. 
	public ResponseEntity<Void> createUser(@RequestBody User user,
											UriComponentsBuilder ucBuilder) { // 새롭게 생성되는 사용자의 URI를 헤더 정보에 담는다.
		
		if(userService.isUserExist(user)) {
			// to do list : exception
		}
		
		userService.saveUser(user);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/users/{id}").buildAndExpand(user.getId()).toUri());
		
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	// Update User
	@RequestMapping(value="/users/{id}", method=RequestMethod.PUT)
	public ResponseEntity<User> updateUser(@PathVariable("id") long id,
											@RequestBody User user) {
		
		User currentUser = userService.findById(id);
		
		if(currentUser == null) {
			// to do list : exception
		}
		
		currentUser.setName(user.getName());
		currentUser.setAge(user.getAge());
		currentUser.setSalary(user.getSalary());
		
		userService.updateUser(currentUser);
		
		return new ResponseEntity<User>(currentUser, HttpStatus.OK);
	}
	
	// Delete a User
	@RequestMapping(value="/users/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<User> deleteUser(@PathVariable("id") long id) {
		
		User user = userService.findById(id);
		if(user == null) {
			// to do list : exception
		}
		
		userService.deleteUserById(id);
		
		return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	}
	
	// Delete All Users
	@RequestMapping(value="/users", method=RequestMethod.DELETE)
	public ResponseEntity<User> deleteAllUsers() {
		
		userService.deleteAlllUsers();
		
		return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	}
	
}
