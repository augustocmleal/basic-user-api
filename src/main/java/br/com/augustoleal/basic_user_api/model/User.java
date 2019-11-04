package br.com.augustoleal.basic_user_api.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.augustoleal.basic_user_api.commons.enums.SexoEnum;
import br.com.augustoleal.basic_user_api.commons.enums.StatusEnum;
import br.com.augustoleal.basic_user_api.commons.enums.converters.SexoEnumConverter;
import br.com.augustoleal.basic_user_api.commons.enums.converters.StatusEnumConverter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User implements Serializable {

    private static final long serialVersionUID = 341301446830325810L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "dataNasc")
    private LocalDate dataNasc;

    @Column(name = "sexo")
    @Convert(converter = SexoEnumConverter.class)
    private SexoEnum sexo;

    @ManyToOne
    @JoinColumn(name = "cargo")
    private Cargo cargo;

    @ManyToOne
    @JoinColumn(name = "perfil")
    private Perfil perfil;

    @Column(name = "status")
    @Convert(converter = StatusEnumConverter.class)
    private StatusEnum status;

}
