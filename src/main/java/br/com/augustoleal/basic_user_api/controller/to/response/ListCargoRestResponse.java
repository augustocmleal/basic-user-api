package br.com.augustoleal.basic_user_api.controller.to.response;

import java.util.List;

import br.com.augustoleal.basic_user_api.model.Cargo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListCargoRestResponse extends AbstractRestResponse {

    private List<Cargo> cargos;

    public ListCargoRestResponse(Result result, List<Cargo> cargos) {
	super(result);
	this.cargos = cargos;
    }

}
