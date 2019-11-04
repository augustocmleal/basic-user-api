package br.com.augustoleal.basic_user_api.controller.to.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenericUserRestResponse extends AbstractRestResponse{

	public GenericUserRestResponse(Result result) {
		super(result);
	}
}
