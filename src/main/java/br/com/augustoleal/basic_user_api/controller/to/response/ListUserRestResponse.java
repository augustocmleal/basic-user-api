package br.com.augustoleal.basic_user_api.controller.to.response;

import java.util.List;

import br.com.augustoleal.basic_user_api.model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListUserRestResponse extends AbstractRestResponse {

    private List<User> users;

    public ListUserRestResponse(Result result, List<User> users) {
	super(result);
	this.users = users;
    }

    public ListUserRestResponse(Result result) {
	super(result);
    }

}
