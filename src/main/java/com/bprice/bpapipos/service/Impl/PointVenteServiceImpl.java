package com.bprice.bpapipos.service.Impl;

import com.bprice.bpapipos.Enum.EnumMessage;
import com.bprice.bpapipos.repository.IModeReglementRepository;
import com.bprice.bpapipos.repository.IPointVenteRepository;
import com.bprice.bpapipos.response.ResponseObject;
import com.bprice.bpapipos.service.IModeReglementService;
import com.bprice.bpapipos.service.IPointVenteService;
import com.bprice.persistance.model.ModeReglement;
import com.bprice.persistance.model.PointVente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ahmed on 18/01/2020.
 */
@Service
public class PointVenteServiceImpl implements IPointVenteService {

	@Autowired
	private IPointVenteRepository pointVenteRepository;
	@Autowired
	private IModeReglementRepository modeReglementRepository;

	@Override
	public ResponseObject CreatePointVente(PointVente pointVente) {
		try {
			if (pointVente != null) {
				PointVente result = pointVenteRepository.save(pointVente);
				pointVente.getModeReglements().forEach(el -> {
					ModeReglement modeReglement = el;
					modeReglement.setIdModeReglement(null);
					modeReglement.setIdPointVente(result.getIdPointVente());
					modeReglementRepository.save(modeReglement);
				});
				return new ResponseObject(EnumMessage.SUCCESS_CREATION.code, EnumMessage.SUCCESS_CREATION.label,
						result);

			} else {
				return new ResponseObject(EnumMessage.POINTVENTE_EMPTY.code, EnumMessage.POINTVENTE_EMPTY.label, null);

			}
		} catch (Exception e) {
			return new ResponseObject(EnumMessage.ERREUR_QUERY.code, EnumMessage.ERREUR_QUERY.label, null);

		}
	}

	@Override
	public ResponseObject CreateManyPointVente(List<PointVente> pointVentes) {
		try {
			if (pointVentes != null) {
				List<PointVente> result = pointVenteRepository.saveAll(pointVentes);
				return new ResponseObject(EnumMessage.SUCCESS_CREATION.code, EnumMessage.SUCCESS_CREATION.label,
						result);

			} else {
				return new ResponseObject(EnumMessage.LIST_POINTVENTE_EMPTY.code,
						EnumMessage.LIST_POINTVENTE_EMPTY.label, null);

			}
		} catch (Exception e) {
			return new ResponseObject(EnumMessage.ERREUR_QUERY.code, EnumMessage.ERREUR_QUERY.label, null);

		}
	}

	@Override
	public ResponseObject UpdatePointVente(PointVente pointVente) {
		try {
			if (pointVente != null) {
				if (pointVenteRepository.existsById(pointVente.getIdPointVente())) {
					PointVente result = pointVenteRepository.save(pointVente);
					return new ResponseObject(EnumMessage.SUCCESS_UPDATE.code, EnumMessage.SUCCESS_UPDATE.label,
							result);
				} else {
					return new ResponseObject(EnumMessage.POINTVENTE_NOT_EXIST.code,
							EnumMessage.POINTVENTE_NOT_EXIST.label, null);
				}
			} else {
				return new ResponseObject(EnumMessage.POINTVENTE_EMPTY.code, EnumMessage.POINTVENTE_EMPTY.label, null);

			}
		} catch (Exception e) {
			return new ResponseObject(EnumMessage.ERREUR_QUERY.code, EnumMessage.ERREUR_QUERY.label, null);

		}
	}

	@Override
	public ResponseObject DeletePointVente(String idPointVente) {
		try {
			if (idPointVente != null) {
				if (pointVenteRepository.existsById(idPointVente)) {
					pointVenteRepository.deleteById(idPointVente);
					return new ResponseObject(EnumMessage.SUCCESS_DELETE.code, EnumMessage.SUCCESS_DELETE.label, true);
				} else {
					return new ResponseObject(EnumMessage.POINTVENTE_NOT_EXIST.code,
							EnumMessage.POINTVENTE_NOT_EXIST.label, false);
				}
			} else {
				return new ResponseObject(EnumMessage.ID_EMPTY.code, EnumMessage.ID_EMPTY.label, false);

			}
		} catch (Exception e) {
			return new ResponseObject(EnumMessage.ERREUR_QUERY.code, EnumMessage.ERREUR_QUERY.label, null);

		}
	}

	@Override
	public ResponseObject findByIdPointVente(String idPointVente) {
		try {
			if (idPointVente != null) {
				PointVente pointVente = pointVenteRepository.findByIdPointVente(idPointVente);
				if (pointVente != null) {
					return new ResponseObject(EnumMessage.POINTVENTE_EXIST.code,
							EnumMessage.PARTENAIREBPRICE_EXIST.label, pointVente);
				} else {
					return new ResponseObject(EnumMessage.POINTVENTE_NOT_EXIST.code,
							EnumMessage.PARTENAIREBPRICE_NOT_EXIST.label, null);
				}
			} else {
				return new ResponseObject(EnumMessage.ID_EMPTY.code, EnumMessage.ID_EMPTY.label, null);

			}
		} catch (Exception e) {
			return new ResponseObject(EnumMessage.ERREUR_QUERY.code, EnumMessage.ERREUR_QUERY.label, null);

		}
	}

	@Override
	public ResponseObject findAllByFActif(Short fActif) {
		try {
			if (fActif != null) {
				List<PointVente> pointVentes = pointVenteRepository.findAllByFActif(fActif);
				if (pointVentes.size() > 0) {
					return new ResponseObject(EnumMessage.LIST_POINTVENTE_NOT_EMPTY.code,
							EnumMessage.LIST_PARTENAIREBPRICE_NOT_EMPTY.label, pointVentes);
				} else {
					return new ResponseObject(EnumMessage.LIST_POINTVENTE_EMPTY.code,
							EnumMessage.LIST_PARTENAIREBPRICES_EMPTY.label, null);
				}
			} else {
				return new ResponseObject(EnumMessage.PARAMETRE_EMPTY.code, EnumMessage.PARAMETRE_EMPTY.label, null);

			}
		} catch (Exception e) {
			return new ResponseObject(EnumMessage.ERREUR_QUERY.code, EnumMessage.ERREUR_QUERY.label, null);

		}
	}

	@Override
	public ResponseObject findAllByIdPartenaire(String idPartenaireBprice) {
		try {
			if (idPartenaireBprice != null) {
				List<PointVente> pointVentes = pointVenteRepository.findAllByIdPartenaire(idPartenaireBprice);
				if (pointVentes.size() > 0) {
					return new ResponseObject(EnumMessage.LIST_POINTVENTE_NOT_EMPTY.code,
							EnumMessage.LIST_PARTENAIREBPRICE_NOT_EMPTY.label, pointVentes);
				} else {
					return new ResponseObject(EnumMessage.LIST_POINTVENTE_EMPTY.code,
							EnumMessage.LIST_PARTENAIREBPRICES_EMPTY.label, null);
				}
			} else {
				return new ResponseObject(EnumMessage.PARAMETRE_EMPTY.code, EnumMessage.PARAMETRE_EMPTY.label, null);

			}
		} catch (Exception e) {
			return new ResponseObject(EnumMessage.ERREUR_QUERY.code, EnumMessage.ERREUR_QUERY.label, null);

		}
	}

	@Override
	public ResponseObject findAllByIdPartenaireAndFActif(String idPartenaireBprice, Short fActif) {
		try {
			if (idPartenaireBprice != null && fActif != null) {
				List<PointVente> pointVentes = pointVenteRepository.findAllByIdPartenaireAndFActif(idPartenaireBprice,
						fActif);
				if (pointVentes.size() > 0) {
					return new ResponseObject(EnumMessage.LIST_POINTVENTE_NOT_EMPTY.code,
							EnumMessage.LIST_PARTENAIREBPRICE_NOT_EMPTY.label, pointVentes);
				} else {
					return new ResponseObject(EnumMessage.LIST_POINTVENTE_EMPTY.code,
							EnumMessage.LIST_PARTENAIREBPRICES_EMPTY.label, null);
				}
			} else {
				return new ResponseObject(EnumMessage.PARAMETRE_EMPTY.code, EnumMessage.PARAMETRE_EMPTY.label, null);

			}
		} catch (Exception e) {
			return new ResponseObject(EnumMessage.ERREUR_QUERY.code, EnumMessage.ERREUR_QUERY.label, null);

		}
	}

	@Override
	public ResponseObject changeStatusPv(String idpointVente, Short status) {
		// TODO Auto-generated method stub
		try {
            if(idpointVente!=null && status!=null){
                PointVente pv = pointVenteRepository.findByIdPointVente(idpointVente);
                if(pv!=null){
                     pv.setFarretVenteOnline(status);
                     pv=pointVenteRepository.save(pv);
                    return new ResponseObject(EnumMessage.SUCCESS_UPDATE.code, EnumMessage.SUCCESS_UPDATE.label, true);
                }else{
                    return new ResponseObject(EnumMessage.POINTVENTE_NOT_EXIST.code, EnumMessage.POINTVENTE_NOT_EXIST.label, false);
                }
            }else{
                return new ResponseObject(EnumMessage.ID_EMPTY.code, EnumMessage.ID_EMPTY.label, false);

            }
        }catch (Exception e){
            return new ResponseObject(EnumMessage.ERREUR_QUERY.code, EnumMessage.ERREUR_QUERY.label, null);

        }
	}
}
