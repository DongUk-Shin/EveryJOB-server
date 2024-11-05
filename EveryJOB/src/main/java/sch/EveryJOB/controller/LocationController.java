package sch.EveryJOB.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sch.EveryJOB.domain.dto.LocationDetailResponseDTO;
import sch.EveryJOB.domain.dto.LocationSearchResponseDTO;
import sch.EveryJOB.service.LocationService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/location")
public class LocationController {
    
    private final LocationService locationService;
    
    @ResponseBody
    @GetMapping("/{name}")
    public LocationSearchResponseDTO searchLocation(@PathVariable String name) {
        System.out.println("name = " + name);
        return locationService.searchLocation(name);
    }
    
    @ResponseBody
    @GetMapping("/detail/{id}")
    public LocationDetailResponseDTO searchLocation(@PathVariable Long id) {
        
        return locationService.searchDetailLocation(id);
    }
    
    @ResponseBody
    @GetMapping("/refresh")
    public void refresh() {
        
        locationService.refreshLocation();
    }
    
}
