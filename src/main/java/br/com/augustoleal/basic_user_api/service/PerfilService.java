package br.com.augustoleal.basic_user_api.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.augustoleal.basic_user_api.model.Perfil;
import br.com.augustoleal.basic_user_api.repository.PerfilRepository;

@Service
public class PerfilService {

    private static Logger logger = LoggerFactory.getLogger(PerfilService.class);

    @Autowired
    private PerfilRepository perfilRepository;

    public void addPerfil(Perfil perfil) {
	try {
	    perfilRepository.save(perfil);
	} catch (Exception e) {
	    logger.error("Erro no metodo addPerfil()", e);
	}
    }

    public List<Perfil> listPerfil() {
	return perfilRepository.findAll();
    }

    public Perfil findByNomeIgnoreCase(String nome) {
	return perfilRepository.findByNomeIgnoreCase(nome);
    }

}
