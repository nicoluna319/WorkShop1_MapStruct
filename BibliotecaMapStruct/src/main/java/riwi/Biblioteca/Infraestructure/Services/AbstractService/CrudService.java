package riwi.Biblioteca.Infraestructure.Services.AbstractService;

import org.springframework.data.domain.Page;
import riwi.Biblioteca.Utils.Enums.SortType;

public interface CrudService<RQ,RS,ID>{
    public RS create(RQ request);
    public Page<RS> getAll(int page, int size, SortType sortType);
    public RS get(ID id);
    public void delete(ID id);
    public RS update(RQ request, ID id);


}
