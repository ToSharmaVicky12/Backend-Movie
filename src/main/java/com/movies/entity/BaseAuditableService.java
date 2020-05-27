package com.movies.entity;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

import com.movies.service.AuditableEntityService;

public abstract class BaseAuditableService<ENTITY extends AuditableEntity> implements AuditableEntityService<ENTITY> {

    @Autowired
    private EntityManager entityManager;

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }
}
