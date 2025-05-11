package utfpr.arq.Order.Service.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import utfpr.arq.Order.Service.management.model.ServicesModel;

public interface ServicesRepository extends JpaRepository<ServicesModel, Integer> {
}