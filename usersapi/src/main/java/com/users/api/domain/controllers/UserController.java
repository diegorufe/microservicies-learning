package com.users.api.domain.controllers;

import com.users.api.domain.dto.UserDTO;
import com.users.api.domain.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador de usuarios
 *
 * @author diego
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/create")
    public ResponseEntity<UserDTO> create(@RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(this.userService.create(userDTO));
    }

    @PostMapping("/edit")
    public ResponseEntity<UserDTO> edit(@RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(this.userService.edit(userDTO));
    }

    @PostMapping("/delete")
    public ResponseEntity<Boolean> delete(@RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(this.userService.delete(userDTO));
    }

    @GetMapping("/list")
    public ResponseEntity<List<UserDTO>> list() {
        return ResponseEntity.ok(this.userService.list());
    }
}