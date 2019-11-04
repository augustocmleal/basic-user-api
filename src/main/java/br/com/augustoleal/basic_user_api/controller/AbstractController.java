package br.com.augustoleal.basic_user_api.controller;

import org.springframework.web.bind.annotation.CrossOrigin;

import br.com.augustoleal.basic_user_api.controller.to.response.Result;

@CrossOrigin(origins = "*")
public abstract class AbstractController {

    public Result generateSuccess(String message) {
	Result result = new Result();

	result.setSuccess(true);
	result.setMessage(message);

	return result;
    }

    public Result generateError(String message) {
	Result result = new Result();

	result.setSuccess(false);
	result.setMessage(message);

	return result;
    }
}
