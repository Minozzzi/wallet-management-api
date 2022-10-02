package com.walletmanagement.transaction.services.create;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.walletmanagement.bases.services.create.BaseCreateService;
import com.walletmanagement.entities.TransactionEntity;
import com.walletmanagement.transaction.TransactionRepository;
import com.walletmanagement.transaction.dto.CreateTransactionResponseDto;
import com.walletmanagement.transaction.dto.CreateUpdateTransactionDto;

@Service
public class CreateTransactionService
    extends BaseCreateService<TransactionEntity, CreateUpdateTransactionDto, CreateTransactionResponseDto, UUID>
    implements ICreateTransactionService {

  private final TransactionRepository transactionRepository;

  public CreateTransactionService(TransactionRepository transactionRepository) {
    super(TransactionEntity.class, CreateTransactionResponseDto.class);
    this.transactionRepository = transactionRepository;
  }

  @Override
  protected JpaRepository<TransactionEntity, UUID> getRepository() {
    return transactionRepository;
  }

}
