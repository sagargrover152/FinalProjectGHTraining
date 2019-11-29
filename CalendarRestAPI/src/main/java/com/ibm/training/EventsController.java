package com.ibm.training;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.training.bean.AnEvent;
import com.ibm.training.service.EventService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("app")
@Api(value = "EVENT CALENDAR" , description = "CONTAINS API FOR CALENDAR")
public class EventsController {

	@Autowired
	EventService eventService;
	
	@ApiOperation(value = "Get The Events" , notes = "hit this url to get all events",response = List.class)
	@RequestMapping(method = RequestMethod.GET,value = "events")
	Iterable<AnEvent> getEvents() {
		return eventService.getEvents();
	}
	
	@ApiOperation(value = "Save Events" , notes = "hit this url to save events",response = List.class)
	@RequestMapping(method = RequestMethod.POST, value = "events")
	void saveEvent(@RequestBody AnEvent event){
		eventService.saveEvent(event);
	}
	
	@ApiOperation(value = "Delete Events" , notes = "hit this url to delete events",response = List.class)
	@RequestMapping(method = RequestMethod.DELETE, value = "events/{id}")
	void deleteEvent(@PathVariable Integer id){
		eventService.deleteEvent(id);
	}
}
