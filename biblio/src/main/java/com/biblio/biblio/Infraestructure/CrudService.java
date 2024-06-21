package com.biblio.biblio.Infraestructure;

import com.biblio.biblio.Api.Dto.Request.UserRequest;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;

public interface CrudService<RQ,RS,ID>{
    public RS create(RQ request);
    public Page<RS> getAll();
    public RS get(ID id);
    public void delete(ID id);
    public RS update(RQ request, ID id);

}
