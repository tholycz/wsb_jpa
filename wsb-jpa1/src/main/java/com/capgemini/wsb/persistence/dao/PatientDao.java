package com.capgemini.wsb.persistence.dao;

import com.capgemini.wsb.persistence.entity.AddressEntity;
import com.capgemini.wsb.persistence.entity.PatientEntity;

import java.util.List;

public interface PatientDao extends Dao<PatientEntity, Long>{
    public List<PatientEntity> findByLastName(String lastName);

    public List<PatientEntity> findByVisitsNumber(int x);

    public List<PatientEntity> findOlderThanAge(int age);
}
