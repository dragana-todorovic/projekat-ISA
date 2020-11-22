package isa.ProjectIsa.controller;

import java.util.Collection;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import isa.ProjectIsa.model.Hospital;
import isa.ProjectIsa.service.HospitalService;

@Controller
/*
 * Mapiranje zahteva moze se obaviti na nekoliko nacina. Jedan od nacina je
 * koriscenjem @RequestMapping anotacije. Anotacija moze ici na nivou klase
 * (kontrolera) gde se zahtevi za pojedinim resursima mogu grupisati prema
 * klasama.
 */
@RequestMapping("/greetings")
public class HospitalController {
	@Autowired
	private HospitalService hospitalService;
	
	@GetMapping
	public ModelAndView getGreetings() {
		Collection<Hospital> greetings = hospitalService.findAll();
		return new ModelAndView("listGreetings", "greetings", greetings);
	}
	
	@PostMapping(value = "/create")
	public ModelAndView registerHospital(Hospital hospital, BindingResult result) throws Exception {
//		if (result.hasErrors()) {
//			return new ModelAndView("createGreeting", "formErrors", result.getAllErrors());
//		}
		System.out.println("uslo");
		System.out.println(hospital.getName() + "mmmmmmmmmmm");
		hospitalService.registerHospital(hospital);
		System.out.println(hospital.getName());
		return new ModelAndView("listGreetings", "hospital",hospital);
	}
		
}
