package com.capgemini.wsb.persistence.dao.impl;

import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PatientDaoImpl extends AbstractDao<PatientEntity, Long> implements PatientDao
{
    public List<PatientEntity> findByLastName(String lastName){
        return entityManager.createQuery("from PatientEntity where lastName =:lastName").setParameter("lastName", lastName).getResultList();
    }

    @Override
    public List<PatientEntity> findByVisitsNumber(int x) {
        return entityManager.createNativeQuery("SELECT p.* FROM patient p join visit v on p.patient_id = v.patient_id group by p.patient_id having count(*) > :x").setParameter("x",x).getResultList();
    }

    @Override
    public List<PatientEntity> findOlderThanAge(int age) {
        return entityManager.createQuery("from PatientEntity where age >:age").setParameter("age", age).getResultList();
    }


}
