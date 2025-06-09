package com.example.Driver.controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.example.Driver.DTO.DriverDTO;
import com.example.Driver.service.Driverservice;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.*;

/**
 * REST controller for managing driver-related operations.
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
@Api(value = "DriverController", tags = { "Driver Management" })
public class Drivercontroller {

	private final Driverservice driverservice;
	 private final ObjectMapper objectMapper;

	/**
	 * Constructor to inject the driver service.
	 *
	 * @param driverservice the service handling business logic for drivers
	 */
	public Drivercontroller(Driverservice driverservice, ObjectMapper objectMapper) {
		this.driverservice = driverservice;
		 this.objectMapper = objectMapper;
	}
	/**
	 * Updates an existing driver's details.
	 *
	 * @param id        The ID of the driver to update
	 * @param driverDTO The updated driver data
	 * @return ResponseEntity containing:
	 *         - 200 OK and updated driver data
	 *         - 404 Not Found if driver not found
	 */
	@ApiOperation(value = "Update an existing driver", response = DriverDTO.class)
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Driver updated successfully", response = DriverDTO.class),
	    @ApiResponse(code = 404, message = "Driver not found")
	})
	@PutMapping("/driver")
	public ResponseEntity<DriverDTO> updateDriver(
	        @ApiParam(value = "Updated driver data", required = true) @RequestBody DriverDTO driverDTO) {
		   
	    DriverDTO updatedDriver = driverservice.update(driverDTO);

	    if (updatedDriver != null) {
	        return ResponseEntity.ok(updatedDriver); // 200 OK
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // 404 Not Found
	    }
	}

	/**
	 * Endpoint to create/save a new driver.
	 *
	 * @param driverDTO The driver data transfer object received in the request
	 *                  body.
	 * @return ResponseEntity containing the saved driver data and the appropriate
	 *         HTTP status code.
	 *
	 *         - 201 (Created): If the driver was successfully saved. - 500
	 *         (Internal Server Error): If an error occurred during the save
	 *         operation.
	 */
	@ApiOperation(value = "Create a new driver", response = DriverDTO.class)
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Driver created successfully", response = DriverDTO.class),
			@ApiResponse(code = 500, message = "Internal server error") })
	 @PostMapping(value = "/driver", consumes = {"multipart/form-data"})
    public ResponseEntity<?> uploadDriver(
            @RequestPart("driver") String driverJson,
            @RequestPart("image") MultipartFile image,
            @RequestPart(value = "licence", required = false) MultipartFile licence) {

        try {
            // Convert JSON string to DriverDTO object
            DriverDTO driverDTO = objectMapper.readValue(driverJson, DriverDTO.class);

            System.out.println("Vehicle Type: " + driverDTO.getVehicletype());
            System.out.println("Join Date: " + driverDTO.getJoindate());

            System.out.println("Image filename: " + image.getOriginalFilename());
            System.out.println("Licence filename: " + licence.getOriginalFilename());

            // Call your service to save DriverDTO + files
            DriverDTO result = driverservice.save(driverDTO, image, licence);

            if (result != null) {
                return ResponseEntity.status(HttpStatus.CREATED).body(result);
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid request data");
        }
    }

	

	/**
	 * Endpoint to retrieve a list of all drivers.
	 *
	 * @return ResponseEntity containing: - 200 OK and a list of DriverDTOs if
	 *         drivers are found. - 204 No Content if no drivers exist in the
	 *         system.
	 */
	@ApiOperation(value = "Get list of all drivers", response = DriverDTO.class, responseContainer = "List")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Drivers retrieved successfully", response = DriverDTO.class),
			@ApiResponse(code = 204, message = "No drivers found") })
	@GetMapping("/driver")
	public ResponseEntity<List<DriverDTO>> driverList() {

		List<DriverDTO> list = driverservice.findAll();

		if (list.isEmpty()) {
			return ResponseEntity.noContent().build(); // 204 No Content
		} else {
			return ResponseEntity.ok(list); // 200 OK with driver data
		}
	}

	/**
	 * Endpoint to retrieve a driver by their unique ID.
	 *
	 * @param id The ID of the driver to be retrieved.
	 * @return ResponseEntity containing: - 200 OK and the DriverDTO if the driver
	 *         is found. - 404 Not Found if no driver exists with the given ID.
	 */
	@ApiOperation(value = "Get a driver by ID", response = DriverDTO.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Driver found", response = DriverDTO.class),
			@ApiResponse(code = 404, message = "Driver not found") })
	@GetMapping("/driver/{id}")
	public ResponseEntity<DriverDTO> getDriverById(
			@ApiParam(value = "The ID of the driver to be retrieved", required = true) @PathVariable int id) {

		DriverDTO driverDto = driverservice.findById(id);

		if (driverDto != null) {
			return ResponseEntity.ok(driverDto); // 200 OK with driver data
		} else {
			return ResponseEntity.notFound().build(); // 404 Not Found
		}
	}

	/**
	 * Deletes a driver by their ID.
	 *
	 * @param id the unique identifier of the driver to delete
	 * @return ResponseEntity containing: - 200 OK and success message if deletion
	 *         is successful - 404 Not Found if no driver exists with the provided
	 *         ID
	 *
	 *         Example request: DELETE /driver/3
	 */
	@ApiOperation(value = "Delete a driver by ID")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Driver deleted successfully"),
			@ApiResponse(code = 404, message = "Driver not found with the given ID") })
	@DeleteMapping("/driver/{id}")
	public ResponseEntity<String> deleteDriverById(
			@ApiParam(value = "The ID of the driver to delete", required = true) @PathVariable int id) {

		boolean deleted = driverservice.delete(id);

		if (deleted) {
			return ResponseEntity.ok("Driver deleted successfully");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Driver not found with ID: " + id);
		}
	}
}
