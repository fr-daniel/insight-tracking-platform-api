package br.com.insight.trackingplatform.controller;

import br.com.insight.trackingplatform.exception.InsightTrackingPlatformException;
import br.com.insight.trackingplatform.model.Atividade;
import br.com.insight.trackingplatform.model.Usuario;
import br.com.insight.trackingplatform.service.AtividadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/atividades")
public class AtividadeController {

    @Autowired
    private AtividadeService atividadeService;

    @GetMapping
    public ResponseEntity<List<Map<String, Object>>> listarAtividades() {
        List<Map<String, Object>> atividades = this.atividadeService.buscarAtividades();
        return new ResponseEntity<>(atividades, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> adicionarAtividade(@RequestBody Atividade atividade) throws InsightTrackingPlatformException {
        Map<String, Object> atividadeSalva = atividadeService.salvarAtividade(atividade);
        return new ResponseEntity<>(atividadeSalva, HttpStatus.CREATED);
    }

    @DeleteMapping("/{atividadeId}")
    public ResponseEntity deletarAtividade(@PathVariable("atividadeId") Long atividadeId) throws InsightTrackingPlatformException {
        atividadeService.excluirAtividade(atividadeId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<String> atualizarAtividade(@RequestBody Atividade atividade)  throws InsightTrackingPlatformException {
        atividadeService.atualizarAtividade(atividade);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/add-curriculo/{usuarioId}")
    public ResponseEntity<Atividade> adicionarAtividadeCurriculo(@PathVariable("usuarioId") Usuario usuario, @RequestBody Atividade atividade) throws InsightTrackingPlatformException {
        Atividade atividadeAdicionada = atividadeService.adicionarAtividadeAoCurriculo(usuario, atividade);
        return new ResponseEntity<>(atividadeAdicionada, HttpStatus.OK);
    }

    @DeleteMapping("/remover-curriculo/{usuarioId}")
    public ResponseEntity<Atividade> removerAtividadeCurriculo(@PathVariable("usuarioId") Usuario usuario, @RequestBody Atividade atividade) throws InsightTrackingPlatformException {
        Atividade atividadeRemovida = atividadeService.removerAtividadeDoCurriculo(usuario, atividade);
        return new ResponseEntity<>(atividadeRemovida, HttpStatus.OK);
    }

    @GetMapping("/{atividadeId}/usuarios")
    public ResponseEntity<List<Usuario>> buscarUsuariosPorAtividade(@PathVariable("atividadeId") Long atividadeId) throws InsightTrackingPlatformException {
        List<Usuario> usuarios = atividadeService.buscarUsuariosPorAtividade(atividadeId);
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }
}
