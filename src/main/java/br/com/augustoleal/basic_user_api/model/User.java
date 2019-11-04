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
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;

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

    @NotNull(message = "Nome não pode ser nulo")
    @Column(name = "nome")
    private String nome;

    @NotNull
    @CPF(message = "O CPF é inválido")
    @Column(name = "cpf")
    private String cpf;

    @NotNull(message = "A data não pode ser nula")
    @Column(name = "dataNasc")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNasc;

    @NotNull(message = "O sexo não pode ser nulo")
    @Column(name = "sexo")
    @Convert(converter = SexoEnumConverter.class)
    private SexoEnum sexo;

    @NotNull(message = "O cargo não pode ser nulo")
    @ManyToOne
    @JoinColumn(name = "cargo")
    private Cargo cargo;

    @NotNull(message = "O perfil não pode ser nulo")
    @ManyToOne
    @JoinColumn(name = "perfil")
    private Perfil perfil;

    @NotNull(message = "O status não pode ser nulo")
    @Column(name = "status")
    @Convert(converter = StatusEnumConverter.class)
    private StatusEnum status;

}
