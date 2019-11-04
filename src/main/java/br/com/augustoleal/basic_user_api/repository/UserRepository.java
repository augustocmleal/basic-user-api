package br.com.augustoleal.basic_user_api.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.augustoleal.basic_user_api.model.User;

@Repository
public interface UserRepository extends AbstractRepository<User, Integer> {

    @Query("select u  from User u where u.sexo = 'F' AND u.dataNasc <= :dataLimite")
    public List<User> findSexoEqualsAndDataNascBefore(@Param("dataLimite") LocalDate dataLimite);

    @Query("select u  from User u where u.cpf like '0%'")
    public List<User> findCpfStartWithZero();
}
