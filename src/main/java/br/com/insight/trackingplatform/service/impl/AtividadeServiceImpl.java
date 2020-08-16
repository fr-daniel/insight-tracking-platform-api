package br.com.insight.trackingplatform.service.impl;

import br.com.insight.trackingplatform.exception.InsightTrackingPlatformException;
import br.com.insight.trackingplatform.model.Atividade;
import br.com.insight.trackingplatform.model.Usuario;
import br.com.insight.trackingplatform.repository.AtividadeRepository;
import br.com.insight.trackingplatform.service.AtividadeService;
import br.com.insight.trackingplatform.service.UsuarioService;
import br.com.insight.trackingplatform.util.Messages;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class AtividadeServiceImpl implements AtividadeService {

    @Autowired
    private AtividadeRepository atividadeRepository;

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public List<Map<String, Object>> buscarAtividades() {
        return atividadeRepository.findAllAtividadesView();
    }

    @Override
    public Map<String, Object> salvarAtividade(Atividade atividade) throws InsightTrackingPlatformException {
        Atividade atividadeSalva = atividadeRepository.save(atividade);
        return atividadeRepository.dadosAtividade(atividadeSalva.getId());
    }

    @Override
    public void atualizarAtividade(Atividade atividade) throws InsightTrackingPlatformException {
        try {
            Atividade atividadeBd = atividadeRepository.getOne(atividade.getId());
            BeanUtils.copyProperties(atividade, atividadeBd, "id");

            atividadeRepository.save(atividadeBd);
        } catch (DataAccessException e){
            throw new InsightTrackingPlatformException(Messages.ATIVIDADE_NAO_CADASTRADA);
        }
    }

    @Override
    public void excluirAtividade(Long id) throws InsightTrackingPlatformException {
        try {
            this.atividadeRepository.deleteById(id);
        } catch (DataAccessException e) {
            throw new InsightTrackingPlatformException(Messages.ATIVIDADE_NAO_CADASTRADA);
        }
    }

    public Atividade buscarAtividadePeloId(Long id) throws  InsightTrackingPlatformException {
        Optional<Atividade> atividadeBd = atividadeRepository.findById(id);
        if (!atividadeBd.isPresent()) {
            throw new InsightTrackingPlatformException(Messages.ATIVIDADE_NAO_CADASTRADA);
        }
        return atividadeBd.get();
    }

    @Override
    public Atividade adicionarAtividadeAoCurriculo(Usuario usuario, Atividade atividade) throws InsightTrackingPlatformException {
        Optional<Atividade> atividadeOptional = atividadeRepository.findById(atividade.getId());
        Atividade atividadeBd;

        if(atividadeOptional.isPresent())
            atividadeBd = atividadeOptional.get();
        else
            atividadeBd = atividadeRepository.save(atividade);

        usuarioService.addAtividade(usuario, atividadeBd);
        return atividadeBd;
    }

    @Override
    public Atividade removerAtividadeDoCurriculo(Usuario usuario, Atividade atividade) throws  InsightTrackingPlatformException {
        Atividade atividadeBd = buscarAtividadePeloId(atividade.getId());

        usuarioService.removerAtividade(usuario, atividadeBd);
        return  atividadeBd;
    }

    @Override
    public List<Usuario> buscarUsuariosPorAtividade(Long id) throws InsightTrackingPlatformException {
        Atividade atividade = buscarAtividadePeloId(id);

        return atividade.getUsuarios();
    }

}
