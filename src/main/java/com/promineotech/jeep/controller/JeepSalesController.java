package com.promineotech.jeep.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.promineotech.jeep.entity.Jeep;
import com.promineotech.jeep.entity.JeepModel;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;S
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;


@OpenAPIDefinition(info = @Info(title = "Jeep Sales Service"), servers = {
    @Server(url = "http://localhost:8080", description = "Local Server")})

@RequestMapping("/jeeps")
public interface JeepSalesController {
  
  //formatter:off
  @Operation(
      summary = "Returns a list of Jeep",
      description = "Returns a list of Jeep given the model and trim",
      responses = {
          @ApiResponse(responseCode = "200",
              description = "A list of Jeep is returned",
              content = @Content(mediaType = "application/json",
                              schema = @Schema(implementation = Jeep.class)
                              )),
          
          @ApiResponse(responseCode = "400",
              description = "The request parameter are invalid",
              content = @Content(mediaType = "application/json")),
          
          @ApiResponse(responseCode = "404",
              description = "No Jeeps were founds with the criteria",
              content = @Content(mediaType = "application/json")),
          
          @ApiResponse(responseCode = "500",
              description = "A unplanned error occurred",
              content = @Content(mediaType = "application/json"))
      },
      parameters = {
          @Parameter(
              name = "model", 
              allowEmptyValue = false, 
              required = false, 
              description = "The model name"),
          @Parameter(
              name = "trim", 
              allowEmptyValue = false, 
              required = false, 
              description = "The trim level")
          
      })
  
 
  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
  List<Jeep> fetchJeeps(@RequestParam JeepModel model, 
      @RequestParam String trim);
  
  //formater:on
}
