package br.com.insight.trackingplatform.repository;

import br.com.insight.trackingplatform.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Usuario findByEmail(String email);

    @Query("SELECT u.id as id, u.nome as nome, u.email as email, u.telefone as telefone FROM Usuario u WHERE u.id = :id")
    Map<String, Object> dadosUsuario(@Param("id") Integer id);

    @Query("SELECT u.id as id, u.nome as nome, u.email as email, u.telefone as telefone FROM Usuario u")
    List<Map<String, Object>> findAllUsuariosView();

}
