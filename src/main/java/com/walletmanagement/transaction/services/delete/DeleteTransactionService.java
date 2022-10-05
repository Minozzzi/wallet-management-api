package com.walletmanagement.transaction.services.delete;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.walletmanagement.bases.services.delete.BaseDeleteService;
import com.walletmanagement.entities.TransactionEntity;
import com.walletmanagement.transaction.TransactionRepository;

@Service
public class DeleteTransactionService extends BaseDeleteService<TransactionEntity>
    implements IDeleteTransactionService {

  private final TransactionRepository transactionRepository;

  public DeleteTransactionService(TransactionRepository transactionRepository) {
    this.transactionRepository = transactionRepository;
  }

  @Override
  protected JpaRepository<TransactionEntity, UUID> getRepository() {
    return transactionRepository;
  }

}
