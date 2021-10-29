package khan.solution.blingfootwearltd.data.Controller;

import khan.solution.blingfootwearltd.data.model.RawMaterial;
import khan.solution.blingfootwearltd.data.service.RawMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:8080")
@RestController
@RequestMapping(path = "/RawMaterials")
public class RawMaterialController {

    @Autowired
    private RawMaterialService rawMaterialService;

    @GetMapping
    public List<RawMaterial> getAllRawMaterials(){
        return rawMaterialService.getAllRawMaterials();
    }

    @GetMapping("/{rawMaterialId}")
    public RawMaterial getRawMaterialById(@PathVariable ("rawMaterialId") String rawMaterialId){
        return rawMaterialService.getRawMaterialById(rawMaterialId);
    }

    @PostMapping
    public RawMaterial createRawMaterials(@RequestBody RawMaterial rawMaterial){
        return rawMaterialService.createRawMaterialInput(rawMaterial);
    }

    @PutMapping("/{rawMaterialId}")
    public RawMaterial updateRawMaterial(@PathVariable("rawMaterialId") String rawMaterialId,@RequestBody RawMaterial material){

        return rawMaterialService.updateRawMaterialById(rawMaterialId, material);
    }

    @DeleteMapping("{rawMaterialId}")
    public void deleteRawMaterialById(@PathVariable("rawMaterialId") String rawMaterialId){
        rawMaterialService.deleteRawMaterialsById(rawMaterialId);
    }

}
