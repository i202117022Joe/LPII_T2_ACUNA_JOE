package org.cibertec.solucionT2.service.impl;

import org.cibertec.solucionT2.entity.EspecieEntity;
import org.cibertec.solucionT2.repository.EspecieRepository;
import org.cibertec.solucionT2.service.EspecieService;
import org.springframework.stereotype.Service;

@Service
public class EspecieServiceImpl extends GenericServiceImpl<EspecieEntity, Integer> implements EspecieService {

    public EspecieServiceImpl(EspecieRepository repository) {
        super(repository);
    }
}
