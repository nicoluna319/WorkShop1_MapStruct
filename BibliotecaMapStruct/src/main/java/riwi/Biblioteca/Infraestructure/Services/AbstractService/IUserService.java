package riwi.Biblioteca.Infraestructure.Services.AbstractService;

import riwi.Biblioteca.Api.Dto.Request.UserRequest;
import riwi.Biblioteca.Api.Dto.Response.UserResponse;

public interface IUserService  extends CrudService<UserRequest, UserResponse, Long> {

    public String FIELD_BY_SORT = "username";
}
