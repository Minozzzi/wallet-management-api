package com.walletmanagement.bases.controllers;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.walletmanagement.bases.services.create.IBaseCreateService;
import com.walletmanagement.bases.services.delete.IBaseDeleteService;
import com.walletmanagement.bases.services.list.IBaseListService;
import com.walletmanagement.bases.services.listAll.IBaseListAllService;
import com.walletmanagement.bases.services.update.IBaseUpdateService;
import com.walletmanagement.shared.dto.PaginationDto;
import com.walletmanagement.shared.dto.PaginationResponseDto;

public abstract class BaseController<DC, RC, DL, RL, RLA> {

  protected abstract IBaseCreateService<DC, RC> getCreateService();

  protected abstract IBaseUpdateService<DC> getUpdateService();

  protected abstract IBaseListService<DL, RL> getListService();

  protected abstract IBaseListAllService<RLA> getListAllService();

  protected abstract IBaseDeleteService getDeleteService();

  @PostMapping
  public ResponseEntity<RC> create(@Valid @RequestBody DC dto) {
    return ResponseEntity.status(HttpStatus.CREATED).body(getCreateService().execute(dto));
  }

  @PatchMapping("{id}")
  public ResponseEntity<Void> update(@PathVariable UUID id, @Valid @RequestBody DC dto) {
    getUpdateService().execute(id, dto);
    return ResponseEntity.noContent().build();
  }

  @GetMapping
  public ResponseEntity<PaginationResponseDto<RL>> list(PaginationDto pagination, DL filters) {
    return ResponseEntity.ok(getListService().execute(pagination, filters));
  }

  @GetMapping("all")
  public ResponseEntity<List<RLA>> listAll() {
    return ResponseEntity.ok(getListAllService().execute());
  }

  @DeleteMapping("{id}")
  public ResponseEntity<Void> delete(@PathVariable UUID id) {
    getDeleteService().execute(id);
    return ResponseEntity.noContent().build();
  }

}
