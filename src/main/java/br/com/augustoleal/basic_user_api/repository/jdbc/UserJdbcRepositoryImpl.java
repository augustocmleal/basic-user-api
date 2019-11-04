package br.com.augustoleal.basic_user_api.repository.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.augustoleal.basic_user_api.commons.enums.SexoEnum;
import br.com.augustoleal.basic_user_api.commons.enums.StatusEnum;
import br.com.augustoleal.basic_user_api.model.Cargo;
import br.com.augustoleal.basic_user_api.model.Perfil;
import br.com.augustoleal.basic_user_api.model.User;
import br.com.augustoleal.basic_user_api.repository.CargoRepository;
import br.com.augustoleal.basic_user_api.repository.PerfilRepository;

@Repository
public class UserJdbcRepositoryImpl implements UserJdbcRepository {

    @Autowired
    private NamedParameterJdbcTemplate namedJdbcTemplate;

    @Autowired
    private CargoRepository cargoRepository;

    @Autowired
    private PerfilRepository perfilRepository;

    RowMapper<User> mapper = new RowMapper<User>() {
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
	    User user = new User();
	    user.setId(rs.getInt("id"));
	    user.setNome(rs.getString("nome"));
	    user.setCpf(rs.getString("cpf"));
	    user.setDataNasc(rs.getDate("data_nasc").toLocalDate());
	    user.setSexo(SexoEnum.valueOfCode(rs.getString("sexo")));
	    user.setStatus(StatusEnum.valueOfCode(rs.getString("status")));

	    Cargo cargo = new Cargo();
	    cargo = cargoRepository.findById(rs.getInt("cargo")).get();
	    user.setCargo(cargo);

	    Perfil perfil = new Perfil();
	    perfil = perfilRepository.findById(rs.getInt("perfil")).get();
	    user.setPerfil(perfil);

	    return user;
	}
    };

    @Override
    public List<User> findAllWithFilters(User user) {
	StringBuilder sql = new StringBuilder();

	sql.append("SELECT * FROM user WHERE 1=1 ");
	MapSqlParameterSource parameters = new MapSqlParameterSource();

	if (user.getNome() != null) {
	    sql.append("AND LOWER(nome) LIKE :nome ");
	    user.setNome("%" + user.getNome().toLowerCase().trim() + "%");
	    parameters.addValue("nome", user.getNome());
	}

	if (user.getCpf() != null) {
	    sql.append("AND cpf = :cpf ");
	    parameters.addValue("cpf", user.getCpf());
	}

	if (user.getCargo() != null) {
	    if (user.getCargo().getId() != null) {
		sql.append("AND cargo = :cargo ");
		parameters.addValue("cargo", user.getCargo().getId());
	    }
	}

	if (user.getPerfil() != null) {
	    if (user.getPerfil().getId() != null) {
		sql.append("AND perfil = :perfil ");
		parameters.addValue("perfil", user.getPerfil().getId());
	    }
	}

	if (user.getStatus() != null) {
	    sql.append("AND status = :status ");
	    parameters.addValue("status", user.getStatus().getCode());
	}

	return namedJdbcTemplate.query(sql.toString(), parameters, mapper);
    }

}
