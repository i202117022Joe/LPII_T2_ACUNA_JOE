package org.cibertec.solucionT2.service.impl;

import org.cibertec.solucionT2.entity.ArbolEntity;
import org.cibertec.solucionT2.repository.ArbolRepository;
import org.cibertec.solucionT2.service.ArbolService;
import org.springframework.stereotype.Service;

@Service
public class ArbolServiceImpl extends GenericServiceImpl<ArbolEntity, Integer> implements ArbolService {

    public ArbolServiceImpl(ArbolRepository repository) {
        super(repository);
    }
}
