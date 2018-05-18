package br.com.netodevel.loggerservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.netodevel.loggerservice.domain.Logger;

public interface LoggerRepository extends JpaRepository<Logger, Integer>{

}
