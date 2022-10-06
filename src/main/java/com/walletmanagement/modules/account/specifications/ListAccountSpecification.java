package com.walletmanagement.modules.account.specifications;

import static org.springframework.data.jpa.domain.Specification.where;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.walletmanagement.bases.specification.BaseSpecification;
import com.walletmanagement.entities.AccountEntity;
import com.walletmanagement.entities.enums.AccountTypeEnum;
import com.walletmanagement.modules.account.dto.ListAccountDto;

@Component
public class ListAccountSpecification extends BaseSpecification<AccountEntity, ListAccountDto> {

  @Override
  public Specification<AccountEntity> getFilter(ListAccountDto filters) {
    return (root, query, cb) -> {
      query.distinct(true);
      return where(
          bankingCodeContains(filters.getBankingCode()))
          .and(descriptionContains(filters.getDescription()))
          .and(typeContains(filters.getType()))
          .and(includeInDashboardContains(filters.getIncludeInDashboard()))
          .toPredicate(root, query, cb);
    };
  }

  private Specification<AccountEntity> bankingCodeContains(String bankingCode) {
    return this.entityAttributeContains("bankingCode", bankingCode);
  }

  private Specification<AccountEntity> descriptionContains(String description) {
    return this.entityAttributeContains("description", description);
  }

  private Specification<AccountEntity> typeContains(AccountTypeEnum type) {
    return this.entityAttributeContains("type", type);
  }

  private Specification<AccountEntity> includeInDashboardContains(Boolean includeInDashboard) {
    return this.entityAttributeContains("includeInDashboard", includeInDashboard);
  }

}
