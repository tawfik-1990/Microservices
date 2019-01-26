package com.microservices.user.dbservice.resource;


import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.microservices.user.dbservice.model.Users;
import com.microservices.user.dbservice.repository.UserRepositry;



@RestController
@RequestMapping("/rest/db")
public class DbServiceResource {
	
	
	private UserRepositry userRepositry;
	
	
	public DbServiceResource(UserRepositry userRepositry) {
        this.userRepositry = userRepositry;
    }

	@GetMapping("/")
	public ResponseEntity<List<Users>> getUsers() {
		return new ResponseEntity<>(userRepositry.findAll(), HttpStatus.OK);
	}
		
	
	
	
	@PostMapping("/add")
	public ResponseEntity<?> addUser(@RequestBody Users user) {
		return new ResponseEntity<>(userRepositry.save(user), HttpStatus.CREATED);
	}
	
	
	@GetMapping("/{username}")
	public ResponseEntity <List<Users>> getUser(@PathVariable String username) {
		List<Users> user = userRepositry.findByName(username);

		if (user != null) {
			return new ResponseEntity<>(userRepositry.findByName(username), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	@Transactional
	@RequestMapping(value = "/{username}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteUser(@PathVariable String username) {
		userRepositry.deleteByName(username);

		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}


