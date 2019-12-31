package com.rishabh;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoomService {

	@Autowired
	private RoomRepository rr;

	public List<Room> listAll() {
		return rr.findAll();
	}

	public void save(Room room) {
		rr.save(room);
	}

	public Optional<Room> get(long roomNumber) {
		return rr.findById(roomNumber);
	}

	public void delete(long roomNumber) {
		rr.deleteById(roomNumber);
	}

}
