package com.walletmanagement.transaction.services.create;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.walletmanagement.account.AccountRepository;
import com.walletmanagement.bases.services.create.BaseCreateWithDependenciesService;
import com.walletmanagement.category.CategoryRepository;
import com.walletmanagement.entities.AccountEntity;
import com.walletmanagement.entities.CategoryEntity;
import com.walletmanagement.entities.TransactionEntity;
import com.walletmanagement.transaction.TransactionRepository;
import com.walletmanagement.transaction.dto.CreateTransactionResponseDto;
import com.walletmanagement.transaction.dto.CreateUpdateTransactionDto;
import com.walletmanagement.transaction.dto.CreateUpdateTransactionWithDependenciesDto;

@Service
public class CreateTransactionService
    extends
    BaseCreateWithDependenciesService<TransactionEntity, CreateUpdateTransactionWithDependenciesDto, CreateUpdateTransactionDto, CreateTransactionResponseDto, UUID>
    implements ICreateTransactionService {

  private final TransactionRepository transactionRepository;
  private final AccountRepository accountRepository;
  private final CategoryRepository categoryRepository;

  public CreateTransactionService(
      TransactionRepository transactionRepository,
      AccountRepository accountRepository,
      CategoryRepository categoryRepository) {
    super(TransactionEntity.class, CreateTransactionResponseDto.class);
    this.transactionRepository = transactionRepository;
    this.accountRepository = accountRepository;
    this.categoryRepository = categoryRepository;
  }

  @Override
  protected JpaRepository<TransactionEntity, UUID> getRepository() {
    return transactionRepository;
  }

  @Override
  protected CreateUpdateTransactionWithDependenciesDto setDependencies(CreateUpdateTransactionDto dto) {
    AccountEntity account = accountRepository.findById(dto.getAccountId()).orElse(null);
    CategoryEntity category = categoryRepository.findById(dto.getCategoryId()).orElse(null);

    return CreateUpdateTransactionWithDependenciesDto.builder()
        .account(account)
        .category(category)
        .dueDate(dto.getDueDate())
        .paymentDate(dto.getPaymentDate())
        .amount(dto.getAmount())
        .amountPaid(dto.getAmountPaid())
        .description(dto.getDescription())
        .type(dto.getType())
        .build();
  }

}
