package com.capgemini.wsb.service;


import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.dto.VisitTO;

import java.util.List;

public interface PatientService {
    public PatientTO findById(final Long id);
    public void deleteById(final Long id);

    public List<VisitTO> findVisitsByPatientId(final Long id);
}
