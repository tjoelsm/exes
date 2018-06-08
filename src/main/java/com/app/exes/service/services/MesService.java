package com.app.exes.service.services;

import com.app.exes.entities.dao.Meses;

public interface MesService {

    Iterable<Meses> getAllMonths();
    Meses getMonthByName(String mes);

}
