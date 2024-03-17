package com.isge.DorsalCare.service;
import com.isge.DorsalCare.dto.CorrectionDTO;
import java.util.List;
public interface CorrectionService {

    CorrectionDTO createCorrection(Long userId, CorrectionDTO correctionDTO);

    List<CorrectionDTO> getAllCorrectionsByUserId(Long userId);

    void deleteCorrection(Long id);
}
