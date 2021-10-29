package khan.solution.blingfootwearltd.data.service;

import khan.solution.blingfootwearltd.data.model.RawMaterial;
import khan.solution.blingfootwearltd.data.repository.RawMaterialRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RawMaterialServiceImpl implements RawMaterialService{

    @Autowired
    private RawMaterialRepo rawMaterialRepo;

    @Override
    public List<RawMaterial> getAllRawMaterials() {
        return rawMaterialRepo.findAll();
    }

    @Override
    public RawMaterial createRawMaterialInput(RawMaterial rawMaterial) {
        return rawMaterialRepo.save(rawMaterial);
    }

    @Override
    public RawMaterial getRawMaterialById(String rawMaterialId) {
        return rawMaterialRepo.findById(rawMaterialId).orElse(null);
    }

    @Override
    public RawMaterial updateRawMaterialById(String rawMaterialId, RawMaterial material) {
        RawMaterial rawMaterial=rawMaterialRepo.findById(rawMaterialId).orElse(null);
        rawMaterial.setNameRM(material.getNameRM());
        rawMaterial.setCostRM(material.getCostRM());
        rawMaterial.setQuantityRM(material.getQuantityRM());
        rawMaterial.setBoughtFromRM(material.getBoughtFromRM());
        return rawMaterialRepo.save(rawMaterial);
    }

    @Override
    public void deleteRawMaterialsById(String rawMaterialId) {
        RawMaterial rawMaterial=rawMaterialRepo.findById(rawMaterialId).orElse(null);
        assert rawMaterial != null;
        rawMaterialRepo.delete(rawMaterial);
    }
}
