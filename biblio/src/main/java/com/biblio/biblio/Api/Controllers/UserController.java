package com.biblio.biblio.Api.Controllers;

import com.biblio.biblio.Api.Dto.Request.UserRequest;
import com.biblio.biblio.Api.Dto.Response.UserResponse;
import com.biblio.biblio.Infraestructure.IUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/api/users")
public class UserController {

    private final IUserService iUserService;

    @Autowired
    public UserController(IUserService iUserService) {
        this.iUserService = iUserService;
    }
    @PostMapping
    public ResponseEntity<UserResponse> create(@Valid @RequestBody UserRequest requestDTO) {
        UserResponse responseDTO = iUserService.create(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> get(@PathVariable Long id) {
        UserResponse user = iUserService.get(id);
        return ResponseEntity.ok(user);
    }
    @GetMapping
    public Page<UserResponse> getAllUsers() {
        return iUserService.getAll();
    }
    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> update(
            @PathVariable Long id,
            @Valid @RequestBody UserRequest requestDTO
    ) {
        UserResponse updatedUser = iUserService.update(requestDTO, id);
        return ResponseEntity.ok(updatedUser);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        iUserService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
