package br.com.augustoleal.basic_user_api.controller.to.response;

import java.util.List;

import br.com.augustoleal.basic_user_api.model.Perfil;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListPerfilRestResponse extends AbstractRestResponse {

    private List<Perfil> perfis;

    public ListPerfilRestResponse(Result result, List<Perfil> perfis) {
	super(result);
	this.perfis = perfis;
    }

}
