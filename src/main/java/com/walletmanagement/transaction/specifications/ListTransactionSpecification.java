package com.walletmanagement.transaction.specifications;

import static org.springframework.data.jpa.domain.Specification.where;

import java.time.Instant;
import java.util.UUID;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.walletmanagement.bases.specification.BaseSpecification;
import com.walletmanagement.entities.TransactionEntity;
import com.walletmanagement.entities.enums.TransactionTypeEnum;
import com.walletmanagement.transaction.dto.ListTransactionDto;

@Component
public class ListTransactionSpecification extends BaseSpecification<TransactionEntity, ListTransactionDto> {

  @Override
  public Specification<TransactionEntity> getFilter(ListTransactionDto filters) {
    return (root, query, cb) -> {
      query.distinct(true);
      return where(
          this.accountContains(filters.getAccountId()))
          .and(this.categoryContains(filters.getCategoryId()))
          .and(this.dueDateContains(filters.getDueDate()))
          .and(this.paymentDateContains(filters.getPaymentDate()))
          .and(this.amountContains(filters.getAmount()))
          .and(this.amountPaidContains(filters.getAmountPaid()))
          .and(this.descriptionContains(filters.getDescription()))
          .and(this.typeContains(filters.getType()))
          .toPredicate(root, query, cb);
    };
  }

  private Specification<TransactionEntity> accountContains(UUID accountId) {
    return this.entityAttributeContains("account_id", accountId);
  }

  private Specification<TransactionEntity> categoryContains(UUID categoryId) {
    return this.entityAttributeContains("category_id", categoryId);
  }

  private Specification<TransactionEntity> dueDateContains(Instant dueDate) {
    return this.entityAttributeContains("dueDate", dueDate);
  }

  private Specification<TransactionEntity> paymentDateContains(Instant paymentDate) {
    return this.entityAttributeContains("paymentDate", paymentDate);
  }

  private Specification<TransactionEntity> amountContains(Double amount) {
    return this.entityAttributeContains("amount", amount);
  }

  private Specification<TransactionEntity> amountPaidContains(Double amountPaid) {
    return this.entityAttributeContains("amountPaid", amountPaid);
  }

  private Specification<TransactionEntity> descriptionContains(String description) {
    return this.entityAttributeContains("description", description);
  }

  private Specification<TransactionEntity> typeContains(TransactionTypeEnum type) {
    return this.entityAttributeContains("type", type);
  }

}
