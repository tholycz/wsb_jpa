package com.capgemini.wsb.persistance.dao;

import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientDaoTest {
    @Autowired
    PatientDao patientDao;

    @Test
    public void shouldFindPatientByLastName() {
        //given
        //when
        List<PatientEntity> patients = patientDao.findByLastName("Bosak");
        //then
        assertThat(patients.size()).isEqualTo(1);
        assertThat(patients.get(0).getLastName()).isEqualTo("Bosak");
    }

    @Test
    public void shouldFindPatientByVisitsNumber() {
        //given
        //when
        List<PatientEntity> patientsWithMoreThan1Visits = patientDao.findByVisitsNumber(1);
        List<PatientEntity> patientsWithMoreThan2Visits = patientDao.findByVisitsNumber(2);
        List<PatientEntity> patientsWithMoreThan3Visits = patientDao.findByVisitsNumber(3);
        //then
        assertThat(patientsWithMoreThan1Visits.size()).isEqualTo(2);
        assertThat(patientsWithMoreThan2Visits.size()).isEqualTo(1);
        assertThat(patientsWithMoreThan3Visits.size()).isEqualTo(0);
    }

    @Test
    public void shouldFindPatientOlderThanAge() {
        //given
        //when
        List<PatientEntity> patients = patientDao.findOlderThanAge(25);
        //then
        assertThat(patients.size()).isEqualTo(1);
        assertThat(patients.get(0).getAge()).isGreaterThan(25);
    }
}
