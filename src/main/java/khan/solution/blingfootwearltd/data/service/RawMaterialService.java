package khan.solution.blingfootwearltd.data.service;
import khan.solution.blingfootwearltd.data.model.RawMaterial;

import java.util.List;

public interface RawMaterialService {

    List<RawMaterial>getAllRawMaterials();
    RawMaterial createRawMaterialInput(RawMaterial rawMaterial);
    RawMaterial getRawMaterialById(String rawMaterialId);
    RawMaterial updateRawMaterialById(String rawMaterialId,RawMaterial material);
    void deleteRawMaterialsById(String rawMaterialId);

}
