package com.capgemini.wsb.persistence.entity;

import org.springframework.lang.NonNull;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "VISIT")
public class 	VisitEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "visit_id")
	private Long id;

	private String description;

	@Column(nullable = false)
	private LocalDateTime time;

	@ManyToOne
	@JoinColumn(name = "doctor_id")
	@NonNull
	private DoctorEntity doctor;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "patient_id")
	@NonNull
	private PatientEntity patient;

	@OneToMany(mappedBy = "visit", orphanRemoval = true)
	private List<MedicalTreatmentEntity> medicalTreatments;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	@NonNull
	public DoctorEntity getDoctor() {
		return doctor;
	}

	public void setDoctor(@NonNull DoctorEntity doctor) {
		this.doctor = doctor;
	}

	@NonNull
	public PatientEntity getPatient() {
		return patient;
	}

	public void setPatient(@NonNull PatientEntity patient) {
		this.patient = patient;
	}
}
