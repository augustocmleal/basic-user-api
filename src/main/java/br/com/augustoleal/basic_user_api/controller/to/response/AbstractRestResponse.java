package br.com.augustoleal.basic_user_api.controller.to.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public abstract class AbstractRestResponse {

    private Result result;

    public AbstractRestResponse(Result result) {
	super();
	this.result = result;
    }
}
