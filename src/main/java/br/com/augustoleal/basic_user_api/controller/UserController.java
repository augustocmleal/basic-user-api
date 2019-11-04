package br.com.augustoleal.basic_user_api.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.augustoleal.basic_user_api.commons.enums.StatusEnum;
import br.com.augustoleal.basic_user_api.constants.Constants;
import br.com.augustoleal.basic_user_api.controller.to.response.GenericRestResponse;
import br.com.augustoleal.basic_user_api.controller.to.response.ListPageableUserRestResponse;
import br.com.augustoleal.basic_user_api.controller.to.response.ListUserRestResponse;
import br.com.augustoleal.basic_user_api.model.Cargo;
import br.com.augustoleal.basic_user_api.model.Perfil;
import br.com.augustoleal.basic_user_api.model.User;
import br.com.augustoleal.basic_user_api.service.CargoService;
import br.com.augustoleal.basic_user_api.service.PerfilService;
import br.com.augustoleal.basic_user_api.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController extends AbstractController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private CargoService cargoService;

    @Autowired
    private PerfilService perfilService;

    @PostMapping
    public GenericRestResponse addUser(@Valid @RequestBody User user) {
	logger.info("------ Início do método - addUser() ------");

	User userExists = userService.findByNomeAndCpf(user.getNome(), user.getCpf());

	if (userExists != null) {
	    logger.info("------ Fim do método - addUser() ------");
	    return new GenericRestResponse(generateError(Constants.MSG_ERROR_NOME_CPF_ALREADY_EXISTS));
	}

	userService.addUser(user);
	logger.info("------ Fim do método - addUser() ------");
	return new GenericRestResponse(generateSuccess(Constants.MSG_SUCCESS));

    }

    @PutMapping
    public GenericRestResponse updateUser(@Valid @RequestBody User user) {
	logger.info("------ Início do método - updateUser() ------");
	userService.updateUser(user);
	logger.info("------ Fim do método - updateUser() ------");
	return new GenericRestResponse(generateSuccess(Constants.MSG_SUCCESS));

    }

    @PutMapping("/disable/{id}")
    public GenericRestResponse disableUser(@PathVariable("id") Integer id) {
	logger.info("------ Início do método - disableUser() ------");

	User user = userService.findById(id);

	if (user == null) {
	    logger.info("------ Fim do método - disableUser() ------");
	    return new GenericRestResponse(generateError(Constants.MSG_ERROR_USUARIO_INEXISTENTE));
	} else if (user.getStatus().equals(StatusEnum.INATIVO)) {
	    logger.info("------ Fim do método - disableUser() ------");
	    return new GenericRestResponse(generateError(Constants.MSG_ERROR_USUARIO_INATIVO));
	} else {
	    user.setStatus(StatusEnum.INATIVO);
	    userService.updateUser(user);
	}

	logger.info("------ Fim do método - updateUser() ------");
	return new GenericRestResponse(generateSuccess(Constants.MSG_SUCCESS));

    }

    @GetMapping("/filtered")
    public ListUserRestResponse listUsersWithFilter(@RequestParam(name = "nome", required = false) String nome,
	    @RequestParam(name = "cpf", required = false) String cpf,
	    @RequestParam(name = "cargo", required = false) String cargo,
	    @RequestParam(name = "perfil", required = false) String perfil,
	    @RequestParam(name = "status", required = false) String status) {

	logger.info("------ Início do método - listUsers() ------");

	Cargo cargoToFilter = new Cargo();
	if (cargo != null) {
	    cargoToFilter = cargoService.findByNomeIgnoreCase(cargo);

	    if (cargoToFilter == null) {
		logger.info("------ Fim do método - listUsers() ------");
		return new ListUserRestResponse(generateError(Constants.MSG_ERROR_CARGO_INVALIDO));
	    }
	}
	Perfil perfilToFilter = new Perfil();
	if (perfil != null) {
	    perfilToFilter = perfilService.findByNomeIgnoreCase(perfil);

	    if (perfilToFilter == null) {
		logger.info("------ Fim do método - listUsers() ------");
		return new ListUserRestResponse(generateError(Constants.MSG_ERROR_PERFIL_INVALIDO));
	    }
	}

	User user = new User(null, nome, cpf, null, null, cargoToFilter, perfilToFilter, null);

	if (status != null) {
	    user.setStatus(StatusEnum.valueOf(status));
	}

	List<User> users = userService.listUsers(user);

	logger.info("------ Fim do método - listUsers() ------");
	if (users.isEmpty()) {
	    return new ListUserRestResponse(generateSuccess(Constants.MSG_EMPTY_LIST), users);
	} else {
	    return new ListUserRestResponse(generateSuccess(Constants.MSG_SUCCESS), users);
	}
    }

    @GetMapping("/femaleEighteenPlus")
    public ListUserRestResponse listFemaleEighteenPlus() {
	logger.info("------ Início do método - listFemaleEighteenPlus() ------");

	List<User> users = userService.listFemaleEighteenPlus();

	logger.info("------ Fim do método - listFemaleEighteenPlus() ------");
	if (users.isEmpty()) {
	    return new ListUserRestResponse(generateSuccess(Constants.MSG_EMPTY_LIST), users);
	} else {
	    return new ListUserRestResponse(generateSuccess(Constants.MSG_SUCCESS), users);
	}
    }

    @GetMapping("/cpfStartWithZero")
    public ListUserRestResponse listCpfStartWithZero() {
	logger.info("------ Início do método - listCpfStartWithZero() ------");

	List<User> users = userService.listCpfStartWithZero();

	logger.info("------ Fim do método - listCpfStartWithZero() ------");
	if (users.isEmpty()) {
	    return new ListUserRestResponse(generateSuccess(Constants.MSG_EMPTY_LIST), users);
	} else {
	    return new ListUserRestResponse(generateSuccess(Constants.MSG_SUCCESS), users);
	}
    }

    @GetMapping
    public ListPageableUserRestResponse listPageableUsers(@RequestParam(name = "page", required = false) Integer page) {
	logger.info("------ Início do método - listPageableUsers() ------");

	PageRequest pageRequest;

	if (page != null) {
	    pageRequest = PageRequest.of(page, 20, Sort.Direction.ASC, "nome");
	} else {
	    pageRequest = PageRequest.of(0, 20, Sort.Direction.ASC, "nome");
	}

	Page<User> users = userService.listUsers(pageRequest);

	logger.info("------ Fim do método - listPageableUsers() ------");
	if (users.isEmpty()) {
	    return new ListPageableUserRestResponse(generateSuccess(Constants.MSG_EMPTY_LIST), users);
	} else {
	    return new ListPageableUserRestResponse(generateSuccess(Constants.MSG_SUCCESS), users);
	}
    }

    @DeleteMapping("/{id}")
    public GenericRestResponse deleteUser(@PathVariable("id") Integer id) {
	logger.info("------ Início do método - deleteUser() ------");
	userService.deleteUser(id);
	logger.info("------ Fim do método - deleteUser() ------");
	return new GenericRestResponse(generateSuccess(Constants.MSG_SUCCESS));

    }

}
