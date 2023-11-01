package com.inops.computation.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;

@Entity
@NamedStoredProcedureQuery(name = "autometicComputeAll", procedureName = "autometicComputeAll")

public class Muster {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

}
