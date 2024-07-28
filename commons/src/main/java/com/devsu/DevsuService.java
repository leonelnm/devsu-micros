package com.devsu;

import java.util.List;

public interface DevsuService<DTO, ENTITY, ID> {

    List<DTO> getAll();

    DTO getById(ID id);

    DTO save(DTO dto);

    DTO update(DTO dto);

    void delete(ID id);

}
