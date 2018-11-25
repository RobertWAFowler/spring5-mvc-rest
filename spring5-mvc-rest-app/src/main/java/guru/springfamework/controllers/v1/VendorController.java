package guru.springfamework.controllers.v1;

import guru.springfamework.api.v1.model.VendorDTO;
import guru.springfamework.api.v1.model.VendorListDTO;
import guru.springfamework.services.VendorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jt on 9/27/17.
 */
@Api(description = "This is my Vender Controller")
@RestController
@RequestMapping(VendorController.BASE_URL)
public class VendorController {

    public static final String BASE_URL = "/api/v1/vendors";
    private final VendorService vendorService;

    public VendorController(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    @ApiOperation(value = "This will get a list of venders", notes ="These are some notes about the API for getting venders")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public VendorListDTO getListofVendors(){
        return new VendorListDTO(vendorService.getAllVendors());
    }

    @ApiOperation(value = "This will get a vender by Id", notes ="These are some notes about getting a vender by id")
    @GetMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public VendorDTO getVendorById(@PathVariable Long id){
        return vendorService.getVendorById(id);
    }

    @ApiOperation(value = "This will create a vender", notes ="These are some notes about creating a new vender")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VendorDTO createNewVendor(@RequestBody VendorDTO vendorDTO){
        return vendorService.createNewVendor(vendorDTO);
    }

    @ApiOperation(value = "This will update a vender", notes ="These are some notes about updating a vender")
    @PutMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public VendorDTO updateVendor(@PathVariable Long id, @RequestBody VendorDTO vendorDTO){
        return vendorService.saveVendorByDTO(id, vendorDTO);
    }

    @ApiOperation(value = "This will patch a vender", notes ="Notes on patching a vender")
    @PatchMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public VendorDTO patchVendor (@PathVariable Long id, @RequestBody VendorDTO vendorDTO){
        return vendorService.patchVendor(id, vendorDTO);
    }

    @ApiOperation(value = "This will delete a vender", notes ="Notes on deleting a vender")
    @DeleteMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public void deleteVendor (@PathVariable Long id){
        vendorService.deleteVendorById(id);
    }

}
