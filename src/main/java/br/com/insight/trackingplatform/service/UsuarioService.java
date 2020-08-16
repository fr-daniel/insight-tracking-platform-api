package br.com.insight.trackingplatform.service;

import br.com.insight.trackingplatform.exception.InsightTrackingPlatformException;
import br.com.insight.trackingplatform.model.Atividade;
import br.com.insight.trackingplatform.model.Usuario;

import java.util.List;
import java.util.Map;

public interface UsuarioService {

    List<Usuario> buscarUsuarios();
    Map<String, Object> salvarUsuario(Usuario usuario) throws InsightTrackingPlatformException;

    void atualizarUsuario(Usuario usuario) throws InsightTrackingPlatformException;

    void excluirUsuario(Integer id) throws InsightTrackingPlatformException;

    Usuario buscarUsuarioPeloId(Integer id) throws  InsightTrackingPlatformException;

    Usuario addAtividade(Usuario usuario, Atividade atividade) throws  InsightTrackingPlatformException;

    Usuario removerAtividade(Usuario usuario, Atividade atividade) throws  InsightTrackingPlatformException;
}
