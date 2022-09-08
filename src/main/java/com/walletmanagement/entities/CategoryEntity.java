package com.walletmanagement.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.walletmanagement.entities.base.BaseEntity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@RequiredArgsConstructor
@Entity(name = "category")
public class CategoryEntity extends BaseEntity {
  
  @Column
  private String name;

}
