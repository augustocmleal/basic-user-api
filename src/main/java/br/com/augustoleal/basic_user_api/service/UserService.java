package br.com.augustoleal.basic_user_api.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.augustoleal.basic_user_api.model.User;
import br.com.augustoleal.basic_user_api.repository.UserRepository;

@Service
public class UserService {

    private static Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    public void addUser(User user) {
	try {
	    userRepository.save(user);
	} catch (Exception e) {
	    logger.error("Erro no metodo addUser()", e);
	}

    }

    public void updateUser(User user) {
	try {
	    userRepository.save(user);
	} catch (Exception e) {
	    logger.error("Erro no metodo updateUser()", e);
	}
    }

    public Page<User> listUsers(int pageNumber) {
	PageRequest pageRequest = PageRequest.of(pageNumber, 20, Sort.Direction.ASC, "nome");

	return userRepository.findAll(pageRequest);
    }

    public void deleteUser(Integer id) {
	try {
	    userRepository.deleteById(id);
	} catch (Exception e) {
	    logger.error("Erro no metodo deleteUser()", e);
	}
    }

}
