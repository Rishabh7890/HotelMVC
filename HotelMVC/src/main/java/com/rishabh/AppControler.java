package com.rishabh;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppControler {

	@Autowired
	private RoomService service;

	@RequestMapping("/")
	public String viewHomePage(Model model) {
		List<Room> listRooms = service.listAll();
		model.addAttribute("listRooms", listRooms);

		return "index.html";
	}

	@RequestMapping("/new")
	public String showAddRoomPage(Model model) {
		Room room = new Room();
		model.addAttribute("room", room);

		return "addRoom.html";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveRoom(@ModelAttribute("room") Room room) {
		service.save(room);

		return "redirect:/";
	}

	@RequestMapping("/edit/{roomNumber}")
	public ModelAndView showEditProductPage(@PathVariable(name = "roomNumber") Long roomNumber) {
		ModelAndView mav = new ModelAndView("addReservation");
		Optional<Room> room = service.get(roomNumber);
		mav.addObject("room", room);

		return mav;
	}

	@RequestMapping("/delete/{roomNumber}")
	public String deleteRoom(@PathVariable(name = "roomNumber") Long roomNumber) {
		service.delete(roomNumber);
		return "redirect:/";
	}
}
