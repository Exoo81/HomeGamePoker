package com.exoo.hgp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TournamentsController {

	@RequestMapping("/tournaments")
	public String index(){
		return "tournaments";
	}
}
