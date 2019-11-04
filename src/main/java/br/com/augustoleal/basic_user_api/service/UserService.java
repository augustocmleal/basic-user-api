package br.com.augustoleal.basic_user_api.service;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.augustoleal.basic_user_api.model.User;
import br.com.augustoleal.basic_user_api.repository.UserRepository;
import br.com.augustoleal.basic_user_api.repository.jdbc.UserJdbcRepositoryImpl;

@Service
public class UserService {

    private static Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserJdbcRepositoryImpl userJdbcRepository;

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

    public User findById(Integer id) {
	User user = null;
	try {
	    user = userRepository.findById(id).get();
	} catch (Exception e) {
	    logger.error("Erro no metodo findById()", e);
	}

	return user;

    }

    public List<User> listFemaleEighteenPlus() {
	LocalDate dataLimite = LocalDate.now().minusYears(18);

	return userRepository.findSexoEqualsAndDataNascBefore(dataLimite);

    }

    public List<User> listCpfStartWithZero() {

	return userRepository.findCpfStartWithZero();

    }

    public List<User> listUsers(User user) {

	return userJdbcRepository.findAllWithFilters(user);

    }

    public Page<User> listUsers(PageRequest pageRequest) {

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
