package com.capgemini.wsb.mapper;


import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.persistence.entity.VisitEntity;

public class VisitMapper {

    public static VisitTO mapToTO(final VisitEntity visitEntity){
        if (visitEntity == null) return null;
        final VisitTO visitTO = new VisitTO();
        visitTO.setId(visitEntity.getId());
        visitTO.setDescription(visitEntity.getDescription());
        visitTO.setTime(visitEntity.getTime());
        visitTO.setDoctor(visitEntity.getDoctor());
        visitTO.setPatient(visitEntity.getPatient());
        visitTO.setMedicalTreatments(visitEntity.getMedicalTreatments());
        return visitTO;
    }
}
