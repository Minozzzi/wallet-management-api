package com.walletmanagement.bases.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.walletmanagement.entities.base.BaseEntity;

public interface IBaseRepository<E extends BaseEntity>
    extends JpaRepository<E, UUID>, JpaSpecificationExecutor<E> {
}
