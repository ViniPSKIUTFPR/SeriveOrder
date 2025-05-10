package utfpr.arq.Order.Serivce.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import utfpr.arq.Order.Serivce.management.model.ServiceOrderModel;

@Repository
public interface ServiceOrderRepository extends JpaRepository<ServiceOrderModel, Integer> {
    
}
