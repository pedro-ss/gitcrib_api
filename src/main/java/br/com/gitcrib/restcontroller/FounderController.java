package br.com.gitcrib.restcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.gitcrib.dto.FounderDTO;
import br.com.gitcrib.model.Founder;
import br.com.gitcrib.service.FounderService;

@RestController
@RequestMapping("/founder")
public class FounderController {

    @Autowired
    private FounderService founderService;

    @PostMapping("/save-founder")
    @ResponseBody
    public FounderDTO cadastrarFounder(@RequestBody FounderDTO founder) {
        return founderService.cadastrarFounder(founder);
    }

    @GetMapping("/find-founder")
    @ResponseBody
    public Optional<FounderDTO> consultarFounder(@RequestBody FounderDTO founder) {
        return founderService.consultarFounder(founder.getFounderId());
    }

    @GetMapping("/list-founders")
    @ResponseBody
    public List<FounderDTO> consultarFounders() {
        return founderService.consultarFounders();
    }

    @DeleteMapping("/delete-founder")
    @ResponseBody
    public void deletarFounder(@RequestBody FounderDTO founder) {
        founderService.deletarFounder(founder.getFounderId());
    }

    @PutMapping("/update-founder")
    @ResponseBody
    public FounderDTO alterarFounder(@RequestBody FounderDTO founder) {
        return founderService.alterarFounder(founder);
    }

}
