package ru.vl7sha.testmediasoftacademia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vl7sha.testmediasoftacademia.model.entity.Goods;

import java.util.UUID;

@Repository
public interface GoodsRepository extends JpaRepository<Goods, UUID> {
}
