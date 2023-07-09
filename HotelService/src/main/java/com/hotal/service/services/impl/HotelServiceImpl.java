package com.hotal.service.services.impl;

import com.hotal.service.entities.Hotel;
import com.hotal.service.exceptions.ResourceNotFoundException;
import com.hotal.service.repoistories.HotelRepository;
import com.hotal.service.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;
    @Override
    public Hotel createHotel(Hotel hotel) {
        String hotelId =  UUID.randomUUID().toString();
        hotel.setId(hotelId);
        return hotelRepository.save(hotel);
    }
    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getSingleHotel(String id) {
        return hotelRepository.findById(id).orElseThrow((() -> new ResourceNotFoundException("Hotel with given id not found !!")));

    }
}
