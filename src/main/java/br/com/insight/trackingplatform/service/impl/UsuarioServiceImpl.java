package br.com.insight.trackingplatform.service.impl;

import br.com.insight.trackingplatform.exception.InsightTrackingPlatformException;
import br.com.insight.trackingplatform.model.Atividade;
import br.com.insight.trackingplatform.model.Usuario;
import br.com.insight.trackingplatform.repository.UsuarioRepository;
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
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> buscarUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Map<String, Object> salvarUsuario(Usuario usuario) throws InsightTrackingPlatformException {
        if (usuario.getEmail() != null && usuarioRepository.findByEmail(usuario.getEmail()) != null) {
            throw new InsightTrackingPlatformException(Messages.ERRO_EMAIL_CADASTRADO);
        }

        Usuario usuarioSalvo = usuarioRepository.save(usuario);
        return usuarioRepository.dadosUsuario(usuarioSalvo.getId());
    }

    @Override
    public void atualizarUsuario(Usuario usuario) throws InsightTrackingPlatformException {
        try {
            Usuario usuarioBd = usuarioRepository.getOne(usuario.getId());
            BeanUtils.copyProperties(usuario, usuarioBd, "id", "email", "atividades");

            if(usuario.getEmail() != null && !usuario.getEmail().isEmpty())
                usuarioBd.setEmail(usuario.getEmail());

            usuarioRepository.save(usuarioBd);
        } catch (DataAccessException e){
            throw new InsightTrackingPlatformException(Messages.USUARIO_NAO_CADASTRADO);
        }
    }

    @Override
    public void excluirUsuario(Integer id) throws InsightTrackingPlatformException {
        try {
            this.usuarioRepository.deleteById(id);
        } catch (DataAccessException e) {
            throw new InsightTrackingPlatformException(Messages.USUARIO_NAO_CADASTRADO);
        }
    }

    @Override
    public Usuario buscarUsuarioPeloId(Integer id) throws  InsightTrackingPlatformException {
        Optional<Usuario> usuarioSalvo = usuarioRepository.findById(id);
        if (usuarioSalvo.isPresent())
            return usuarioSalvo.get();
        throw new InsightTrackingPlatformException(Messages.USUARIO_NAO_CADASTRADO);
    }

    @Override
    public Usuario addAtividade(Usuario usuario, Atividade atividade) throws  InsightTrackingPlatformException {
        Usuario usuarioBD = buscarUsuarioPeloId(usuario.getId());
        usuarioBD.getAtividades().add(atividade);

        try {
            return usuarioRepository.save(usuarioBD);
        } catch (DataAccessException e) {
            throw new InsightTrackingPlatformException(Messages.ATIVIDADE_CADASTRADA_NO_CURRICULO);
        }

    }

    @Override
    public Usuario removerAtividade(Usuario usuario, Atividade atividade) throws  InsightTrackingPlatformException {
        Usuario usuarioBD = buscarUsuarioPeloId(usuario.getId());
        usuarioBD.getAtividades().remove(atividade);

        try {
            return usuarioRepository.save(usuarioBD);
        } catch (DataAccessException e) {
            throw new InsightTrackingPlatformException(Messages.ATIVIDADE_CADASTRADA_NO_CURRICULO);
        }

    }

}
