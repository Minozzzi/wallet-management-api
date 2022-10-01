package com.walletmanagement.category;

import org.springframework.stereotype.Repository;

import com.walletmanagement.bases.repositories.IBaseRepository;
import com.walletmanagement.entities.CategoryEntity;

@Repository
public interface CategoryRepository extends IBaseRepository<CategoryEntity> {
}
