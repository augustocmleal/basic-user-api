package br.com.augustoleal.basic_user_api.controller.to.response;

import org.springframework.data.domain.Page;

import br.com.augustoleal.basic_user_api.model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListPageableUserRestResponse extends AbstractRestResponse {

    private Page<User> users;

    public ListPageableUserRestResponse(Result result, Page<User> users) {
	super(result);
	this.users = users;
    }

}
