package com.walletmanagement.modules.transaction.services.listAll;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.walletmanagement.bases.services.listAll.BaseListAllService;
import com.walletmanagement.entities.TransactionEntity;
import com.walletmanagement.modules.transaction.TransactionRepository;
import com.walletmanagement.modules.transaction.dto.ListAllTransactionResponseDto;

@Service
public class ListAllTransactionService extends BaseListAllService<TransactionEntity, ListAllTransactionResponseDto>
    implements IListAllTransactionService {

  private final TransactionRepository transactionRepository;

  public ListAllTransactionService(TransactionRepository transactionRepository) {
    super(ListAllTransactionResponseDto.class);
    this.transactionRepository = transactionRepository;
  }

  @Override
  protected JpaRepository<TransactionEntity, UUID> getRepository() {
    return transactionRepository;
  }

}
