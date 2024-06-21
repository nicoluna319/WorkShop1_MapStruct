package com.biblio.biblio.Infraestructure.Services;
import com.biblio.biblio.Api.Dto.Request.UserRequest;
import com.biblio.biblio.Api.Dto.Response.UserResponse;
import com.biblio.biblio.Domain.Entity.User;
import com.biblio.biblio.Domain.Repository.UserRepository;
import com.biblio.biblio.Infraestructure.IUserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService implements IUserService {

    private UserRepository userRepository;
    private ModelMapper modelMapper;
    @Override
    public UserResponse create(@Valid UserRequest request) {
        User user = modelMapper.map(request, User.class);
        User savedUser = userRepository.save(user);
        return modelMapper.map(savedUser, UserResponse.class);
    }
    @Override
    public Page<UserResponse> getAll() {
        List<User> users = userRepository.findAll();
        List<UserResponse> userResponses = users.stream()
                .map(user -> modelMapper.map(user, UserResponse.class))
                .collect(Collectors.toList());
        return new PageImpl<>(userResponses);
    }
    @Override
    public UserResponse get(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado con ID: " + id));
        return modelMapper.map(user, UserResponse.class);
    }
    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
    @Override
    public UserResponse update(UserRequest request, Long id) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado con ID: " + id));
        modelMapper.map(request, existingUser);
        User updatedUser = userRepository.save(existingUser);
        return modelMapper.map(updatedUser, UserResponse.class);
    }
}
