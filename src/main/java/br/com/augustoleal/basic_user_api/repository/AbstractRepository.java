package br.com.augustoleal.basic_user_api.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface AbstractRepository<T, U extends Serializable> extends JpaRepository<T, U> {

}
