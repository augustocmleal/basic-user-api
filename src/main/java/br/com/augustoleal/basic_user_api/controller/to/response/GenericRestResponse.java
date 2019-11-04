package br.com.augustoleal.basic_user_api.controller.to.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenericRestResponse extends AbstractRestResponse{

	public GenericRestResponse(Result result) {
		super(result);
	}
}
