package resources;


import utils.PropertiesReader;


public enum APIResources {
	CreateToken("/auth"),
	GetBookingIds("/booking"),
	GetBooking("/booking/:id"),
	CreateBooking("/booking"),
	UpdateBooking("/booking/:id"),
	PartialUpdateBooking("/booking/:id"),
	DeleteBooking("/booking/:id"),
	HealthCheck("/ping"),
	UpdateBookingWithoutAuth("/booking/:id");

	private String resource;
	
	APIResources(String resource) {
		this.resource=resource;
	}

	public String getResource(String param) {
		// Replace the placeholder with the actual parameter if it exists
		return resource.replace(":id", param);
	}

	public String getResource() {
		// Overloaded method for paths without parameters
		return resource;
	}
}
