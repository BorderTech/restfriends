package com.github.bordertech.swagger.sample.app;

/**
 * Test REST API.
 */
import com.github.bordertech.restfriends.envelope.impl.ErrorResponse;
import com.github.bordertech.restfriends.exception.RestBusinessException;
import com.github.bordertech.restfriends.exception.RestSystemException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Api(value = "Test")
@Path(value = "v1")
@ApiResponses(value = {
	@ApiResponse(code = 200, message = "Successful")
	, @ApiResponse(code = 400, message = "Invalid request", response = ErrorResponse.class)
	, @ApiResponse(code = 500, message = "Internal error", response = ErrorResponse.class)
})
@Produces(value = "application/json")
public class SampleApi {

	@GET
	@Path("/tests")
	@ApiOperation(value = "Test GET")
	public SampleResponse doTestGet(@ApiParam(value = "ECHO Value") @QueryParam(value = "echo") final String echo) throws RestBusinessException {
		if ("bus".equals(echo)) {
			throw new RestBusinessException("Mock business exception");
		}
		if ("sys".equals(echo)) {
			throw new RestSystemException("Mock system exception");
		}
		if ("other".equals(echo)) {
			throw new IllegalArgumentException("Mock other exception");
		}
		return new SampleResponse(echo);
	}

}
