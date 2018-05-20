package br.com.netodevel.loggerservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.netodevel.loggerservice.domain.Logger;

public interface LoggerRepository extends JpaRepository<Logger, Integer>{

	List<Logger> findByProductId(Integer productId);

	List<Logger> findByClientId(Integer customerId);

}
