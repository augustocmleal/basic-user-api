package br.com.augustoleal.basic_user_api.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.augustoleal.basic_user_api.constants.Constants;
import br.com.augustoleal.basic_user_api.controller.to.response.GenericRestResponse;
import br.com.augustoleal.basic_user_api.controller.to.response.ListCargoRestResponse;
import br.com.augustoleal.basic_user_api.model.Cargo;
import br.com.augustoleal.basic_user_api.service.CargoService;

@RestController
@RequestMapping("/cargo")
public class CargoController extends AbstractController {

    private static Logger logger = LoggerFactory.getLogger(CargoController.class);

    @Autowired
    private CargoService cargoService;

    @PostMapping
    public GenericRestResponse addCargo(@RequestBody Cargo cargo) {
	logger.info("------ Início do método - addCargo() ------");
	cargoService.addCargo(cargo);
	logger.info("------ Fim do método - addCargo() ------");
	return new GenericRestResponse(generateSuccess(Constants.MSG_SUCCESS));

    }

    @GetMapping
    public ListCargoRestResponse listCargos() {
	logger.info("------ Início do método - listCargos() ------");
	List<Cargo> cargos = cargoService.listCargo();
	logger.info("------ Fim do método - listCargos() ------");
	return new ListCargoRestResponse(generateSuccess(Constants.MSG_SUCCESS), cargos);
    }
}
