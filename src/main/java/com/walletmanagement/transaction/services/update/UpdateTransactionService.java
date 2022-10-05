package com.walletmanagement.transaction.services.update;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.walletmanagement.bases.services.update.BaseUpdateService;
import com.walletmanagement.entities.TransactionEntity;
import com.walletmanagement.transaction.TransactionRepository;
import com.walletmanagement.transaction.dto.CreateUpdateTransactionDto;

@Service
public class UpdateTransactionService
    extends BaseUpdateService<TransactionEntity, CreateUpdateTransactionDto>
    implements IUpdateTransactionService {

  private final TransactionRepository transactionRepository;

  public UpdateTransactionService(TransactionRepository transactionRepository) {
    super(TransactionEntity.class);
    this.transactionRepository = transactionRepository;
  }

  @Override
  protected JpaRepository<TransactionEntity, UUID> getRepository() {
    return transactionRepository;
  }

}
