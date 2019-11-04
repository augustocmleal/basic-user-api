package br.com.augustoleal.basic_user_api.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.augustoleal.basic_user_api.model.Cargo;
import br.com.augustoleal.basic_user_api.repository.CargoRepository;

@Service
public class CargoService {

    private static Logger logger = LoggerFactory.getLogger(CargoService.class);

    @Autowired
    private CargoRepository cargoRepository;

    public void addCargo(Cargo cargo) {
	try {
	    cargoRepository.save(cargo);
	} catch (Exception e) {
	    logger.error("Erro no metodo addCargo()", e);
	}
    }

    public List<Cargo> listCargo() {
	return cargoRepository.findAll();
    }

    public Cargo findByNomeIgnoreCase(String nome) {
	return cargoRepository.findByNomeIgnoreCase(nome);
    }

}
