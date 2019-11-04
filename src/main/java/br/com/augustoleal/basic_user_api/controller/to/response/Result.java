package br.com.augustoleal.basic_user_api.controller.to.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Result {

    private Boolean success;
    private String message;

    public Result(Boolean success, String message) {
	this.success = success;
	this.message = message;
    }
}
