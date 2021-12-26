package br.com.gitcrib.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gitcrib.dao.FounderDao;
import br.com.gitcrib.model.Founder;

@Service
public class FounderService {
    
    @Autowired
    private FounderDao founderDao;

    public Founder cadastrarFounder(Founder founder) {
        return founderDao.save(founder);
    }

    public Optional<Founder> consultarFounder(Integer founderId) {
        return founderDao.findById(founderId);
    }

    public void deletarFounder(Integer founderId) {
        founderDao.deleteById(founderId);
    }

    public List<Founder> consultarFounders() {
        return founderDao.findAll();
    }

    public Founder alterarFounder(Founder founder) {
        return founderDao.save(founder);
    }
}
