package utfpr.arq.Order.Serivce.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import utfpr.arq.Order.Serivce.management.model.ServicesModel;

public interface ServicesRepository extends JpaRepository<ServicesModel, Integer> {
}