package com.app.exes.service;

import com.app.exes.entities.dao.Meses;

public interface MesService {

    Iterable<Meses> getAllMonths();
    Meses getMonthByName(String mes);

}
