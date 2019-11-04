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
import br.com.augustoleal.basic_user_api.controller.to.response.ListPerfilRestResponse;
import br.com.augustoleal.basic_user_api.model.Perfil;
import br.com.augustoleal.basic_user_api.service.PerfilService;

@RestController
@RequestMapping("/perfil")
public class PerfilController extends AbstractController {

    private static Logger logger = LoggerFactory.getLogger(PerfilController.class);

    @Autowired
    private PerfilService perfilService;

    @PostMapping
    public GenericRestResponse addPerfil(@RequestBody Perfil perfil) {
	logger.info("------ Início do método - addPerfil() ------");
	perfilService.addPerfil(perfil);
	logger.info("------ Fim do método - addPerfil() ------");
	return new GenericRestResponse(generateSuccess(Constants.MSG_SUCCESS));

    }

    @GetMapping
    public ListPerfilRestResponse listPerfis() {
	logger.info("------ Início do método - listPerfis() ------");
	List<Perfil> perfis = perfilService.listPerfil();
	logger.info("------ Fim do método - listPerfis() ------");
	return new ListPerfilRestResponse(generateSuccess(Constants.MSG_SUCCESS), perfis);
    }

}
