package br.com.insight.trackingplatform.service;

import br.com.insight.trackingplatform.exception.InsightTrackingPlatformException;
import br.com.insight.trackingplatform.model.Atividade;
import br.com.insight.trackingplatform.model.Usuario;

import java.util.List;
import java.util.Map;

public interface AtividadeService {

    List<Map<String, Object>> buscarAtividades();
    Map<String, Object> salvarAtividade(Atividade atividade) throws InsightTrackingPlatformException;

    void atualizarAtividade(Atividade atividade) throws InsightTrackingPlatformException;

    void excluirAtividade(Long id) throws InsightTrackingPlatformException;

    Atividade buscarAtividadePeloId(Long id) throws  InsightTrackingPlatformException;

    Atividade adicionarAtividadeAoCurriculo(Usuario usuario, Atividade atividade) throws InsightTrackingPlatformException;

    Atividade removerAtividadeDoCurriculo(Usuario usuario, Atividade atividade) throws  InsightTrackingPlatformException;

    List<Usuario> buscarUsuariosPorAtividade(Long id) throws InsightTrackingPlatformException;
}
