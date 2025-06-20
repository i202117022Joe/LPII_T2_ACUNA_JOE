package org.cibertec.solucionT2.service.impl;

import org.cibertec.solucionT2.entity.ResponsableEntity;
import org.cibertec.solucionT2.repository.ResponsableRepository;
import org.cibertec.solucionT2.service.ResponsableService;
import org.springframework.stereotype.Service;

@Service
public class ResponsableServiceImpl extends GenericServiceImpl<ResponsableEntity, Integer> implements ResponsableService {

    public ResponsableServiceImpl(ResponsableRepository repository) {
        super(repository);
    }
}
