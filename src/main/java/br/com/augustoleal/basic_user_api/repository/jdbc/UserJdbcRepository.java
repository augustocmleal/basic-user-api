package br.com.augustoleal.basic_user_api.repository.jdbc;

import java.util.List;

import br.com.augustoleal.basic_user_api.model.User;

public interface UserJdbcRepository {

    List<User> findAllWithFilters(User user);
}
