package com.macgarcia.github.rinha2024.repository;

import com.macgarcia.github.rinha2024.entity.Cliente;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
