package br.com.augustoleal.basic_user_api.repository;

import org.springframework.stereotype.Repository;

import br.com.augustoleal.basic_user_api.model.Perfil;

@Repository
public interface PerfilRepository extends AbstractRepository<Perfil, Integer> {

    public Perfil findByNomeIgnoreCase(String nome);
}
