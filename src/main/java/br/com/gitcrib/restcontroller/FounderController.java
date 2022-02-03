package br.com.gitcrib.restcontroller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.gitcrib.dto.FounderDTO;
import br.com.gitcrib.service.FounderService;

@RestController
@RequestMapping("/founder")
@CrossOrigin(origins = "*")
public class FounderController {

    @Autowired
    private FounderService founderService;

    @PostMapping("/save-founder")
    @ResponseBody
    public ResponseEntity<FounderDTO> cadastrarFounder(@Valid @RequestBody FounderDTO founder) {
        return ResponseEntity.status(HttpStatus.CREATED).body(founderService.cadastrarFounder(founder));
    }

    @GetMapping("/find-founder")
    @ResponseBody
    public ResponseEntity<Optional<FounderDTO>> consultarFounder(@RequestBody FounderDTO founder) {
        return ResponseEntity.ok(founderService.consultarFounder(founder.getFounderId()));
    }

    @GetMapping("/list-founders")
    @ResponseBody
    public ResponseEntity<List<FounderDTO>> consultarFounders() {
        return ResponseEntity.ok(founderService.consultarFounders());
    }

    @DeleteMapping("/delete-founder")
    @ResponseBody
    public ResponseEntity<Void> deletarFounder(@RequestBody FounderDTO founder) {
        founderService.deletarFounder(founder.getFounderId());
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update-founder")
    @ResponseBody
    public ResponseEntity<FounderDTO> alterarFounder(@Valid @RequestBody FounderDTO founder) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(founderService.alterarFounder(founder));
    }
}
