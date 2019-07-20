package com.app.exes.service.impl;

import com.app.exes.entities.dao.Banco;
import com.app.exes.repositories.BancoRepository;
import com.app.exes.service.BancoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class BancoImpl implements BancoService {

    @Autowired
    private BancoRepository repository;


    @Override
    public List<Banco> getAllBanks() {
        Iterable<Banco> resultList = repository.findAll();
        Iterator<Banco> result = resultList.iterator();
        List<Banco> model = new ArrayList<>();
        while (result.hasNext()){
            model.add(result.next());
        }

        return model;
    }
}
