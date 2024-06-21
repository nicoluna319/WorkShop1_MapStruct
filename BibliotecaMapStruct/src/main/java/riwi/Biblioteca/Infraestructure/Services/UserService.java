package riwi.Biblioteca.Infraestructure.Services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import riwi.Biblioteca.Api.Dto.Request.UserRequest;
import riwi.Biblioteca.Api.Dto.Response.UserResponse;
import riwi.Biblioteca.Config.Mapper;
import riwi.Biblioteca.Domain.Entity.User;
import riwi.Biblioteca.Domain.Repository.UserRepository;
import riwi.Biblioteca.Infraestructure.Services.AbstractService.IUserService;
import riwi.Biblioteca.Utils.Enums.SortType;

@Service
@AllArgsConstructor
public class UserService implements IUserService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Mapper mapper;

    @Override
    public UserResponse create(UserRequest request) {
        User user = mapper.requestUser(request);
        userRepository.save(user);
        return mapper.userResponse(user);
    }

    @Override
    public Page<UserResponse> getAll(int page, int size, SortType sortType) {
        if (page <0) page = 0;

        PageRequest pagination = null;

        switch (sortType) {
            case NONE -> pagination = PageRequest.of(page, size);
            case ASC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).ascending());
            case DESC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).descending());
        }

        return this.userRepository.findAll(pagination)
                .map(user -> this.mapper.userResponse(user));
    }

    @Override
    public UserResponse get(Long aLong) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public UserResponse update(UserRequest request, Long aLong) {
        return null;
    }
}
