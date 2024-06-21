package riwi.Biblioteca.Api.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import riwi.Biblioteca.Api.Dto.Request.UserRequest;
import riwi.Biblioteca.Api.Dto.Response.UserResponse;
import riwi.Biblioteca.Infraestructure.Services.AbstractService.IUserService;
import riwi.Biblioteca.Utils.Enums.SortType;

import java.util.Objects;

@RestController
@RequestMapping(path = "/user")
@AllArgsConstructor
public class UserController {
    private final IUserService userService;

    @GetMapping
    public ResponseEntity<Page<UserResponse>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestHeader(required = false) SortType sortType) {
        if (Objects.isNull(sortType))
            sortType = SortType.NONE;

        return ResponseEntity.ok(this.userService.getAll(page - 1, size, sortType));
    }

    @PostMapping
    public ResponseEntity<UserResponse> insert(
            @Validated @RequestBody UserRequest request) {
        return ResponseEntity.ok(this.userService.create(request));
    }



}
