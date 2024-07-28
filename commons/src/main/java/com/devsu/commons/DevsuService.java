package com.devsu.commons;

import java.util.List;

public interface DevsuService<inDTO, outDTO, ID> {

    List<outDTO> getAll();

    outDTO getById(ID id);

    outDTO save(inDTO dto);

    outDTO update(Long id, inDTO dto);

    void delete(ID id);

}
