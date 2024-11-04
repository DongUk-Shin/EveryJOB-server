package sch.EveryJOB.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sch.EveryJOB.domain.Location;
import sch.EveryJOB.repository.LocationRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationService {
    
    private final LocationRepository locationRepository;
    
    
    public List<Location> getLocations() {
        
        Location location = new Location();
        
        Location l1 = locationRepository.findById(1L).get();
        Location l2 = locationRepository.findById(2L).get();
        Location l3 = locationRepository.findById(3L).get();
        Location l4 = locationRepository.findById(4L).get();
        
        List<Location> locations = new ArrayList<>();
        locations.add(l1);
        locations.add(l2);
        locations.add(l3);
        locations.add(l4);
        
        return locations;
    }
}
