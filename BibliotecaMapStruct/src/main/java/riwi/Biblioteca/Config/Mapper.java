package riwi.Biblioteca.Config;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;
import riwi.Biblioteca.Api.Dto.Request.UserRequest;
import riwi.Biblioteca.Api.Dto.Response.UserResponse;
import riwi.Biblioteca.Domain.Entity.User;

@org.mapstruct.Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface Mapper {

    @Mappings({
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "username", source = "username"),
            @Mapping(target = "email", source = "email"),
            @Mapping(target = "fullName", source = "fullName"),
            @Mapping(target = "role", source = "role")
    })
    User requestUser(UserRequest user);

    UserResponse userResponse(User user);

}

