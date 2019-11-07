package test.org.springdoc.api.app34;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController<T> {

    @GetMapping(value = "/hello/{numTelco}")
    @Operation(summary = "GET Persons", responses = @ApiResponse(responseCode = "418"))
    public T index(@PathVariable("numTelco") String numTel, String adresse) {
        return null;
    }
}
