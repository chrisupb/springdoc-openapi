/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (3.0.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package test.org.springdoc.api.app2.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import test.org.springdoc.api.app2.model.Order;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Map;

@javax.annotation.Generated(value = "org.springdoc.demo.app2.codegen.languages.SpringCodegen", date = "2019-07-11T00:09:29.839+02:00[Europe/Paris]")

@Tag(name = "store", description = "the store API")
public interface StoreApi {

    default StoreApiDelegate getDelegate() {
        return new StoreApiDelegate() {
        };
    }

    @Operation(summary = "Delete purchase order by ID", tags = {"store"})
    @ApiResponses(value = {@ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
            @ApiResponse(responseCode = "404", description = "Order not found")})
    @DeleteMapping(value = "/store/order/{orderId}")
    default ResponseEntity<Void> deleteOrder(
            @Parameter(description = "ID of the order that needs to be deleted", required = true) @PathVariable("orderId") String orderId) {
        return getDelegate().deleteOrder(orderId);
    }

    @Operation(summary = "Returns pet inventories by status", description = "Returns a map of status codes to quantities", security = {
            @SecurityRequirement(name = "api_key")}, tags = {"store"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Map.class))))})
    @GetMapping(value = "/store/inventory", produces = {"application/json"})
    default ResponseEntity<Map<String, Integer>> getInventory() {
        return getDelegate().getInventory();
    }

    @Operation(summary = "Find purchase order by ID", tags = {"store"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = Order.class))),
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
            @ApiResponse(responseCode = "404", description = "Order not found")})
    @GetMapping(value = "/store/order/{orderId}", produces = {"application/xml", "application/json"})
    default ResponseEntity<Order> getOrderById(
            @Min(1L) @Max(5L) @Parameter(description = "ID of pet that needs to be fetched", required = true) @PathVariable("orderId") Long orderId) {
        return getDelegate().getOrderById(orderId);
    }

    @Operation(summary = "Place an order for a pet", tags = {"store"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = Order.class))),
            @ApiResponse(responseCode = "400", description = "Invalid Order")})
    @PostMapping(value = "/store/order", produces = {"application/xml", "application/json"}, consumes = {
            "application/json"})
    default ResponseEntity<Order> placeOrder(
            @Parameter(description = "order placed for purchasing the pet", required = true) @Valid @RequestBody Order order) {
        return getDelegate().placeOrder(order);
    }

}
