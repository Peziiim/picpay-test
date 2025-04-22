package executor.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import executor.domain.transaction.Transaction;



public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
