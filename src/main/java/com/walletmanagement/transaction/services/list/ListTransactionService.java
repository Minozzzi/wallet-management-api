package com.walletmanagement.transaction.services.list;

import org.springframework.stereotype.Service;

import com.walletmanagement.bases.repositories.IBaseRepository;
import com.walletmanagement.bases.services.list.BaseListService;
import com.walletmanagement.bases.specification.BaseSpecification;
import com.walletmanagement.entities.TransactionEntity;
import com.walletmanagement.transaction.TransactionRepository;
import com.walletmanagement.transaction.dto.ListTransactionDto;
import com.walletmanagement.transaction.dto.ListTransactionResponseDto;

@Service
public class ListTransactionService
    extends BaseListService<TransactionEntity, ListTransactionDto, ListTransactionResponseDto>
    implements IListTransactionService {

  private final TransactionRepository transactionRepository;
  private final BaseSpecification<TransactionEntity, ListTransactionDto> baseSpecification;

  public ListTransactionService(TransactionRepository transactionRepository,
      BaseSpecification<TransactionEntity, ListTransactionDto> baseSpecification) {
    super(ListTransactionResponseDto.class);
    this.transactionRepository = transactionRepository;
    this.baseSpecification = baseSpecification;
  }

  @Override
  protected IBaseRepository<TransactionEntity> getRepository() {
    return transactionRepository;
  }

  @Override
  protected BaseSpecification<TransactionEntity, ListTransactionDto> getSpecification() {
    return baseSpecification;
  }

}
