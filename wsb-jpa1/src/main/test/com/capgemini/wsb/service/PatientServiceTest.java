package com.capgemini.wsb.service;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.persistence.dao.DoctorDao;
import com.capgemini.wsb.persistence.dao.VisitDao;
import com.capgemini.wsb.persistence.entity.DoctorEntity;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientServiceTest {
    @Autowired
    private PatientService patientService;


    // do sprawdzenia poprawności działania serwisu PatientService używam innych dao
    @Autowired
    private DoctorDao doctorDao;

    @Autowired
    private VisitDao visitDao;

    @Test
    @Transactional
    public void testShouldRemovePatient() {
        // given
        PatientTO patientBefore = patientService.findById(1L);
        List<VisitEntity> visitsBefore = patientBefore.getVisits();
        List<DoctorEntity> doctorsBefore = new ArrayList<>();
        for(VisitEntity v: visitsBefore) {
            doctorsBefore.add(v.getDoctor());
        }

        // when
        patientService.deleteById(1L);
        // then
        assertThat(patientBefore).isNotNull();

        PatientTO patientAfter = patientService.findById(1L);
        assertThat(patientAfter).isNull();

        List<VisitEntity> visitsAfter = new ArrayList<>();
        for(VisitEntity v : visitsBefore) {
            VisitEntity visit  = visitDao.findOne(v.getId());
            if(visit != null) visitsAfter.add(visit);

        }

        List<DoctorEntity> doctorsAfter = new ArrayList<>();
        for(DoctorEntity d : doctorsBefore) {
            DoctorEntity doctor  = doctorDao.findOne(d.getId());
            if(doctor != null) doctorsAfter.add(doctor);
        }

        assertThat(visitsAfter).isEmpty();
        assertThat(doctorsAfter.size()).isEqualTo(doctorsBefore.size());
    }

    @Test
    public void testShouldFindPatient() {
        PatientTO patient = patientService.findById(1L);
        assertThat(patient.getId()).isEqualTo(1);
        assertThat(patient.getDateOfBirth().toString()).isEqualTo("1999-02-17");
        assertThat(patient.getEmail()).isEqualTo("tomasz.kosakowski@test.com");
        assertThat(patient.getFirstName()).isEqualTo("Tomasz");
        assertThat(patient.getLastName()).isEqualTo("Kosakowski");
        assertThat(patient.getPatientNumber()).isEqualTo("564");
        assertThat(patient.getTelephoneNumber()).isEqualTo("893849839");
        assertThat(patient.getAddress().getId()).isEqualTo(3);
        assertThat(patient.getAge()).isEqualTo(20);
    }

    @Test
    public void testShouldFindVisitsByPatientId() {
        ///given
        //when
        List<VisitTO> visits = patientService.findVisitsByPatientId(1L);
        //then
        assertThat(visits.size()).isEqualTo(2);
    }
}
