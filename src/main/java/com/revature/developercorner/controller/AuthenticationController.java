package com.revature.developercorner.controller;

import com.revature.developercorner.dto.ResponseDto;
import com.revature.developercorner.entity.User;
import com.revature.developercorner.session.SessionRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// AuthenticationController Class
// This class will handle the HTTP Requests for the API/resource paths associated with Authentication and login for
//  users in the application.
@RestController
@RequestMapping("/login")
public class AuthenticationController {

    @Autowired
    public AuthenticationManager authenticationManager;

    @Autowired
    public SessionRegistry sessionRegistry;

    // PostMapping to submit a login request to sign the user into the application:
    @PostMapping("")
    public ResponseEntity<ResponseDto> login(@RequestBody User user) {

        // Call the AuthenticationManager to authenticate the user with a new token by supplying the username and
        //  password of the supplied User.
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
        );

        // Call the SessionRegistry to create and register a new session for the given User by supplying it the
        //  User object's username and store that as a session id variable:
        final String session_id = sessionRegistry.registerSession(user.getUsername());

        // Create a new ResponseDto object and set the session id of it with the new session id:
        ResponseDto response = new ResponseDto();
        response.setSession_id(session_id);

        // Call the ResponseEntity to create a response with the status code 'OK' and supply the ResponseDto object
        //  to it, and return it:
        return ResponseEntity.ok(response);
    }
}
