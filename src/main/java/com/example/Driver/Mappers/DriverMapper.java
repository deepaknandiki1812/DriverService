package com.example.Driver.Mappers;

import org.springframework.stereotype.Component;

import com.example.Driver.DTO.DriverDTO;
import com.example.Driver.Entity.Driver;

@Component
public class DriverMapper {

	/**
	 * Converts a DriverDTO object to a Driver entity.
	 * <p>
	 * This method maps the fields from the DriverDTO to a new Driver entity instance.
	 * It's commonly used to transform data received from the client (DTO) into the
	 * format required for persistence or business logic operations (entity).
	 *
	 * @param driverDTO The data transfer object containing driver information.
	 * @return A Driver entity populated with data from the provided DriverDTO.
	 */
	public Driver dtotoEntity(DriverDTO driverDTO) {
		Driver driver = new Driver();

		driver.setAddress(driverDTO.getAddress());
		driver.setEmail(driverDTO.getEmail());
		driver.setId(driverDTO.getId());
		driver.setName(driverDTO.getName());
		driver.setVehicleNumber(driverDTO.getVehicleNumber());
//		driver.setImage(driverDTO.getAddress());
		driver.setJoindate(driverDTO.getJoindate());
//		driver.setLicence(driverDTO.getAddress());
		driver.setStatus(driverDTO.getStatus());
		driver.setVehicletype(driverDTO.getVehicletype());
		

		return driver;
	}

	/**
	 * Converts a Driver entity to a DriverDTO object.
	 * <p>
	 * This method maps the fields from a {@link Driver} entity to a new {@link DriverDTO} instance.
	 * It's typically used to prepare entity data for transfer or presentation in the API layer,
	 * keeping internal representations separate from exposed data formats.
	 *
	 * @param driver The Driver entity containing data from the database or service layer.
	 * @return A DriverDTO populated with data from the given Driver entity.
	 */
	public DriverDTO enitytoDto(Driver driver) {

		DriverDTO driverDTO = new DriverDTO();
		driverDTO.setId(driver.getId());
		driverDTO.setAddress(driver.getAddress());
		driverDTO.setEmail(driver.getEmail());
		driverDTO.setId(driver.getId());
		driverDTO.setName(driver.getName());
		driverDTO.setVehicleNumber(driver.getVehicleNumber());
//		driverDTO.setImage(driver.getImage());
		driverDTO.setJoindate(driver.getJoindate());
//		driverDTO.setLicence(driver.getLicence());
		driverDTO.setStatus(driver.getStatus());
		driverDTO.setVehicletype(driver.getVehicletype());
		
		return driverDTO;

	}

}
