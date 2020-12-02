package isa.ProjectIsa.controller;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import isa.ProjectIsa.model.Actions;
import isa.ProjectIsa.rabbitmq.ScheduledTasks;
import isa.ProjectIsa.service.ActionsService;

@Controller
@RequestMapping("/actions")
public class ActionsController {
	@Autowired
	private ActionsService actionsService;
	@Autowired
	private ScheduledTasks scheduledTasks;

	
	@GetMapping
	public ModelAndView getActions() {
		Collection<Actions> actions = actionsService.findAll();
		return new ModelAndView("listActions", "actions", actions);
	}
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String getNew(Model model) {
		model.addAttribute("action", new Actions());
		return "createNewAction";
	}
	@PostMapping(value = "/create")
	public ModelAndView createGreeting(Actions action) throws Exception {
		
		
		actionsService.create(action);
		System.out.println(action.getPharmacyName());
		
		scheduledTasks.sendMessage(action.getText(), action.getPharmacyName(), action.getDateFrom(), action.getDateTo());
		//scheduledTasks.sendMessage(action.getText(), action.getPharmacyName());
		return new ModelAndView("redirect:/actions", "action", actionsService.findAll());
	}

	
}
