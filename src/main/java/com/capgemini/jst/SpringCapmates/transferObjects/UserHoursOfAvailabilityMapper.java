package com.capgemini.jst.SpringCapmates.transferObjects;

import org.springframework.stereotype.Component;
import com.capgemini.jst.SpringCapmates.data.UserHoursOfAvailability;

@Component
public class UserHoursOfAvailabilityMapper {

	public UserHoursOfAvailabilityDto mapUserHoursOfAvailabilityToUserHoursOfAvailabilityDto(
			UserHoursOfAvailability userHoursOfAvailability) {
		
		UserHoursOfAvailabilityDto userHoursOfAvailabilityDto = new UserHoursOfAvailabilityDto(
				userHoursOfAvailability.getFrom(), userHoursOfAvailability.getTo(), userHoursOfAvailability.getDate(),
				userHoursOfAvailability.getComment());

		return userHoursOfAvailabilityDto;
	}

	public UserHoursOfAvailability mapUserGameCollectionDtoToUser(UserHoursOfAvailabilityDto userHoursOfAvailabilityDto,
			UserHoursOfAvailability userHoursOfAvailability) {
		
		UserHoursOfAvailability newUserHoursOfAvailability = userHoursOfAvailability;
		newUserHoursOfAvailability.setComment(userHoursOfAvailabilityDto.getComment());
		newUserHoursOfAvailability.setDate(userHoursOfAvailabilityDto.getDate());
		newUserHoursOfAvailability.setFrom(userHoursOfAvailabilityDto.getFrom());
		newUserHoursOfAvailability.setTo(userHoursOfAvailabilityDto.getTo());
		return newUserHoursOfAvailability;
	}
}
