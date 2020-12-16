package org.safeNature.theyMatter.demo.repository;

import org.safeNature.theyMatter.demo.model.PedidosTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidosRepository extends JpaRepository<PedidosTable, Long>{
    
}
