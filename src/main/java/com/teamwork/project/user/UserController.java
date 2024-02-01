package com.teamwork.project.user;

import com.teamwork.project.pojo.UserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    private final UserService service;

     @Autowired
     UserRepository userRepository;

    @PatchMapping
    public ResponseEntity<?> changePassword(
            @RequestBody ChangePasswordRequest request,
            Principal connectedUser
    ) {
        service.changePassword(request, connectedUser);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/allusers")
    public List<UserDetails> getallusers(){


        List<User> userList = userRepository.findAllUsers();


        return userList.stream()
                .map(user -> {
                    UserDetails userDetails = new UserDetails();
                    userDetails.setFirstname(user.getFirstname());
                    userDetails.setLastname(user.getLastname());
                    userDetails.setEmail(user.getEmail());
                    userDetails.setId(user.getId());
                    // Set other properties as needed
                    return userDetails;
                })
                .collect(Collectors.toList());
    }



}
