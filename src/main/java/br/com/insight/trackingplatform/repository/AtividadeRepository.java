package br.com.insight.trackingplatform.repository;

import br.com.insight.trackingplatform.model.Atividade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface AtividadeRepository extends JpaRepository<Atividade, Long> {

    @Query("SELECT  a.id as id, a.titulo as titulo, a.descricao as descricao, a.local as local FROM Atividade a WHERE a.id = :id")
    Map<String, Object> dadosAtividade(@Param("id") Long id);

    @Query("SELECT a.id as id, a.titulo as titulo, a.descricao as descricao, a.local as local FROM Atividade a")
    List<Map<String, Object>> findAllAtividadesView();

}
