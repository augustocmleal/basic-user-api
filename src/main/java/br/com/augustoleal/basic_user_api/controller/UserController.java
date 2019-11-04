package br.com.augustoleal.basic_user_api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.augustoleal.basic_user_api.Constants;
import br.com.augustoleal.basic_user_api.controller.to.response.GenericUserRestResponse;
import br.com.augustoleal.basic_user_api.controller.to.response.ListUserRestResponse;
import br.com.augustoleal.basic_user_api.model.User;
import br.com.augustoleal.basic_user_api.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController extends AbstractController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @PostMapping
    public GenericUserRestResponse addUser(@RequestBody User user) {
	logger.info("------ Início do método - addUser() ------");
	userService.addUser(user);
	logger.info("------ Fim do método - addUser() ------");
	return new GenericUserRestResponse(generateSuccess(Constants.MSG_SUCCESS));

    }

    @PutMapping
    public GenericUserRestResponse updateUser(@RequestBody User user) {
	logger.info("------ Início do método - updateUser() ------");
	userService.updateUser(user);
	logger.info("------ Fim do método - updateUser() ------");
	return new GenericUserRestResponse(generateSuccess(Constants.MSG_SUCCESS));

    }

    @GetMapping("/{pageNumber}")
    public ListUserRestResponse listUsers(@PathVariable("pageNumber") Integer pageNumber) {
	logger.info("------ Início do método - listUsers() ------");
	Page<User> users = userService.listUsers(pageNumber);
	logger.info("------ Fim do método - listUsers() ------");
	return new ListUserRestResponse(generateSuccess(Constants.MSG_SUCCESS), users);
    }

    @DeleteMapping("/{id}")
    public GenericUserRestResponse deleteUser(@PathVariable("id") Integer id) {
	logger.info("------ Início do método - deleteUser() ------");
	userService.deleteUser(id);
	logger.info("------ Fim do método - deleteUser() ------");
	return new GenericUserRestResponse(generateSuccess(Constants.MSG_SUCCESS));

    }

}
