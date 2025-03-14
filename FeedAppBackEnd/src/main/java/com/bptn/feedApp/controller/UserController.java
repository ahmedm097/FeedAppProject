package com.bptn.feedApp.controller;

import static org.springframework.http.HttpStatus.OK;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bptn.feedApp.jpa.Profile;
import com.bptn.feedApp.jpa.User;
import com.bptn.feedApp.service.UserService;
import com.fasterxml.jackson.databind.JsonNode;

@CrossOrigin(exposedHeaders = "Authorization")
@RestController
@RequestMapping("/user")
public class UserController {
	final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	UserService userService;

	@GetMapping("/")
	// public List<UserBean> listUsers() {
	public List<User> listUsers() {
		logger.debug("The listUsers() method was invoked!");
		return this.userService.listUsers();
	}

	@GetMapping("/test")
	public String testController() {
		logger.debug("The testController() method was invoked!");
		return "The FeedApp application is up and running";
	}

	@GetMapping("/{username}")
	// public UserBean findByUsername(@PathVariable String username) {
	public Optional<User> findByUsername(@PathVariable String username) {
		logger.debug("The findByUsername() method was invoked!, username={}", username);
		return this.userService.findByUsername(username);
	}

	@GetMapping("/{first}/{last}/{username}/{password}/{phone}/{emailId}")
	public String createUser(@PathVariable String first, @PathVariable String last, @PathVariable String username,
			@PathVariable String password, @PathVariable String phone, @PathVariable String emailId) {
		// UserBean user = new UserBean();
		User user = new User();
		user.setFirstName(first);
		user.setLastName(last);
		user.setUsername(username);
		user.setPassword(password);
		user.setPhone(phone);
		user.setEmailId(emailId);
		user.setEmailVerified(false);
		user.setCreatedOn(Timestamp.from(Instant.now()));

		logger.debug("The createUser() method was invoked!, user={}", user.toString());

		this.userService.createUser(user);

		return "User Created Successfully";
	}

	@PostMapping("/signup")
	public User signup(@RequestBody User user) {
		logger.debug("Signing up, username: {}", user.getUsername());
		return this.userService.signup(user);
	}

	@GetMapping("/verify/email")
	public void verifyEmail() {

		logger.debug("Verifying Email");

		this.userService.verifyEmail();
	}

	@PostMapping("/login")
	public ResponseEntity<User> login(@RequestBody User user) {

		logger.debug("Authenticating, username: {}, password: {}", user.getUsername(), user.getPassword());

		/* Spring Security Authentication. */
		user = this.userService.authenticate(user);

		/* Generate JWT and HTTP Header */
		HttpHeaders jwtHeader = this.userService.generateJwtHeader(user.getUsername());

		logger.debug("User Authenticated, username: {}", user.getUsername());

		return new ResponseEntity<>(user, jwtHeader, OK);
	}

	@GetMapping("/reset/{emailId}")
	public void sendResetPasswordEmail(@PathVariable String emailId) {

		logger.debug("Sending Reset Password Email, emailId: {}", emailId);

		this.userService.sendResetPasswordEmail(emailId);
	}

	@PostMapping("/reset")
	public void passwordReset(@RequestBody JsonNode json) {

		logger.debug("Resetting Password, password: {}", json.get("password").asText());

		this.userService.resetPassword(json.get("password").asText());
	}

	@GetMapping("/get")
	public User getUser() {

		logger.debug("Getting User Data");

		return this.userService.getUser();
	}

	@PostMapping("/update")
	public User updateUser(@RequestBody User user) {

		logger.debug("Updating User Data");

		return this.userService.updateUser(user);
	}

	@PostMapping("/update/profile")
	public User updateUserProfile(@RequestBody Profile profile) {

		logger.debug("Updating User Profile Data, Profile: {}", profile.toString());

		return this.userService.updateUserProfile(profile);
	}
}