package sch.EveryJOB.service;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sch.EveryJOB.common.error.LocationErrorCode;
import sch.EveryJOB.common.exception.CustomException;
import sch.EveryJOB.domain.Location;
import sch.EveryJOB.domain.dto.LocationDetailResponseDTO;
import sch.EveryJOB.domain.dto.LocationSearchResponseDTO;
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
    
    public LocationSearchResponseDTO searchLocation(String name) {
        
        Location location = locationRepository.findByName(name).orElseThrow(
                () -> new CustomException(LocationErrorCode.LOCATION_NOT_FOUND));
        
        return LocationSearchResponseDTO.builder()
                .id(location.getId())
                .latitude(location.getLatitude())
                .longitude(location.getLongitude())
                .build();
        
        
    }
    
    public LocationDetailResponseDTO searchDetailLocation(Long id) {
        
        Location location = locationRepository.findById(id).orElseThrow(
                () -> new CustomException(LocationErrorCode.LOCATION_NOT_FOUND));
        
        return LocationDetailResponseDTO.builder()
                .id(location.getId())
                .address(location.getAddress())
                .name(location.getName())
                .recruitment_period(location.getRecruitment_period())
                .job_category(location.getJob_category())
                .employment_type(location.getEmployment_type())
                .salary_type(location.getSalary_type())
                .salary(location.getSalary())
                .entry_type(location.getEntry_type())
                .required_experience(location.getRequired_experience())
                .required_education(location.getRequired_education())
                .major_field(location.getMajor_field())
                .certifications(location.getCertifications())
                .responsible_agency(location.getResponsible_agency())
                .call_info(location.getCall_info())
                .build();
    }
    
    @Transactional
    public void refreshLocation() {
        
        
        
        
    }
}
