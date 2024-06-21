package com.biblio.biblio.Infraestructure;

import com.biblio.biblio.Api.Dto.Request.UserRequest;
import com.biblio.biblio.Api.Dto.Response.UserResponse;

import java.util.List;

public interface IUserService extends CrudService<UserRequest, UserResponse, Long>{
}
