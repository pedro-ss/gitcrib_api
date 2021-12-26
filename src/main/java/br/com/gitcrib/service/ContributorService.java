package br.com.gitcrib.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gitcrib.dao.ContributorDao;
import br.com.gitcrib.model.Contributor;

@Service
public class ContributorService {
 
    @Autowired
    private ContributorDao contributorDao;

    public Contributor cadastrarContributor(Contributor contributor) {
        return contributorDao.save(contributor);
    }

    public Optional<Contributor> consultarContributor(Integer contributorId) {
        return contributorDao.findById(contributorId);
    }

    public void deletarContributor(Integer contributorId) {
        contributorDao.deleteById(contributorId);
    }

    public List<Contributor> consultarContributors() {
        return contributorDao.findAll();
    }

    public Contributor alterarContributor(Contributor contributor) {
        return contributorDao.save(contributor);
    }

}
