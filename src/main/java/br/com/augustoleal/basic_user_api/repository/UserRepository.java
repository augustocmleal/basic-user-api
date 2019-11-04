package br.com.augustoleal.basic_user_api.repository;

import org.springframework.stereotype.Repository;

import br.com.augustoleal.basic_user_api.model.User;

@Repository
public interface UserRepository extends AbstractRepository<User, Integer> {

}
