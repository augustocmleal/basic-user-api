package br.com.augustoleal.basic_user_api.repository;

import org.springframework.stereotype.Repository;

import br.com.augustoleal.basic_user_api.model.Cargo;

@Repository
public interface CargoRepository extends AbstractRepository<Cargo, Integer> {

    public Cargo findByNomeIgnoreCase(String nome);
}
