package com.bprice.bpapipos.Enum;

import java.util.HashMap;
import java.util.Map;

public enum EnumMessage {

	ERREUR_QUERY("Query failed",-3),
	SUCCESS_CREATION("objet créé avec succes",1),
	PARTENAIREBPRICE_EMPTY("PartenaireBprice est vide",0),
	LIST_PARTENAIREBPRICES_EMPTY("List des PartenaireBprice est vide",0),
	SUCCESS_UPDATE("objet modifié avec succes",1),
	PARTENAIREBPRICE_NOT_EXIST("PartenaireBprice n'exist pas",-1),
	SUCCESS_DELETE("objet supprimé avec succes",1),
	ID_EMPTY("Id est vide",0),
	PARTENAIREBPRICE_EXIST("PartenaireBprice exist",1),
	LIST_PARTENAIREBPRICE_NOT_EMPTY("List PartenaireBprice n'est pas vide",1),
	LIST_PARTENAIREBPRICE_EMPTY("List PartenaireBprice est vide",0),
	PARAMETRE_EMPTY("le parametre envoyer est null",-2),
	PARAMETRES_EMPTY("un ou plusieurs parametres envoyer sont null",-2),
	POINTVENTE_EMPTY("PointVente est vide",0),
	POINTVENTE_EXIST("PointVente exist",1),
	LIST_POINTVENTE_NOT_EMPTY("List PointVente n'est pas vide",1),
	LIST_POINTVENTE_EMPTY("List PointVente est vide",0),
	POINTVENTE_NOT_EXIST("PointVente n'exist pas",-1),
	POINTVENTE_NOT_EXIST_FOR_JOURNEE("PointVente n'exist pas",-1),
	USER_EMPTY("Utilisateur est vide",0),
	USER_EMPTY_FOR_SESSION("Utilisateur est vide",-4),
	USER_EXIST("Utilisateur exist",1),
	LIST_USER_NOT_EMPTY("List Utilisateur n'est pas vide",1),
	LIST_USER_EMPTY("List Utilisateur est vide",0),
	USER_NOT_EXIST("Utilisateur n'exist pas",-1),
	USER_NOT_EXIST_FOR_SESSION("Utilisateur n'exist pas",-5),
	TYPEUSER_EMPTY("TypeUtilisateur est vide",0),
	TYPEUSER_NULL_FOR_USER("TypeUtilisateur est vide",-1),
	TYPEUSER_EXIST("TypeUtilisateur exist",1),
	LIST_TYPEUSER_NOT_EMPTY("List TypeUtilisateur n'est pas vide",1),
	LIST_TYPEUSER_EMPTY("List TypeUtilisateur est vide",0),
	TYPEUSER_NOT_EXIST("TypeUtilisateur n'exist pas",-1),
	TYPEUSER_NOT_EXIST_FOR_USER("TypeUtilisateur n'exist pas",-2),
	POINTVENTE_ID_EMPTY("id PointVente est null",-2),
	JOURNEE_EMPTY("journee est vide",0),
	JOURNEE_EMPTY_FORSESSION("journee est vide",-1),
	JOURNEE_NOT_EXIST("journee n'exist pas",-4),
	JOURNEE_NOT_EXIST_FOR_SESSION("journee n'exist pas",-2),
	JOURNEE_EXIST("journee exist",1),
	LIST_JOURNEE_NOT_EMPTY("List Journee n'est pas vide",1),
	LIST_JOURNEE_EMPTY("List Journee est vide",0),
	CAISSE_NOT_EXIST("caisse n'exist pas",-5),
	SESSION_EMPTY("session est vide",0),
	SESSION_NOT_EXIST("session n'exist pas",-6),
	SESSION_EXIST("session exist",1),
	JOURNEE_CLOSED("journee est fermée",-4),
	SESSION_CLOSED("session est fermée",-6),
	SUCCESS_LOGIN("login avec succes",1),
	NOT_AUTHORIZED("utilisateur non autorisé",-4),
	USER_NOT_ACTIF("utilisateur non actif",-7),
	LOGIN_OR_PASSWORD_EMPTY("login ou password sont vide",-6),
	TYPE_CONNECTION_EMPTY("type de connection est null",-5),
	LOGIN_EMPTY("login est null",-4),
	LOGIN_IS_USED("login est utilisée",-5),
	PASSWORD_EMPTY("password est null",-6),
	TYPEUSER_EMPTY_FOR_USER("type utilisateur est null",-7),
	PARTENAIRE_NOT_EXIST_FOR_USER("partenaire n'exist pas",-8),
	PROFIL_NOT_EXIST_FOR_USER("profil n'exist pas",-9),
	IDCAISSE_EMPTY("id caisse est null",-6),
	IDCAISSE_EMPTY2("id caisse est null",-8),
	CAISSE_NOT_EXIST1("caisse n'exist pas",-7),
	DEVISE_EMPTY("Devise est vide",0),
	DEVISE_EMPTY_FORSESSION("Devise est vide",-1),
	DEVISE_NOT_EXIST("Devise n'exist pas",-4),
	DEVISE_NOT_EXIST_FOR_SESSION("Devise n'exist pas",-2),
	DEVISE_EXIST("Devise exist",1),
	LIST_DEVISE_NOT_EMPTY("List Devise n'est pas vide",1),
	LIST_DEVISE_EMPTY("List Devise est vide",0),
	LIST_BILLET_NOT_EMPTY("List Billet n'est pas vide",3),
	LIST_BILLET_EMPTY("List Billet est vide",2),
	TABLE_EMPTY_FORSESSION("table est vide",-1),
	TABLE_NOT_EXIST("table n'exist pas",-4),
	TABLE_NOT_EXIST_FOR_SESSION("table n'exist pas",-2),
	TABLE_EXIST("table exist",1),
	LIST_TABLE_NOT_EMPTY("List table n'est pas vide",1),
	LIST_TABLE_EMPTY("List table est vide",0),
	TABLE_EMPTY("table est vide",0),
	OPERTATIONTYPE_NOT_EXIST("OperationType n'exist pas",-4),
	OPERTATIONTYPE_EXIST("opertationtype exist",1),
	LIST_OPERTATIONTYPE_NOT_EMPTY("List OperationType n'est pas vide",1),
	LIST_OPERTATIONTYPE_EMPTY("List OperationType est vide",0),
	OPERTATIONTYPE_EMPTY("l'OperationType est vide",0),
	IDOPERTATIONTYPE_EMPTY("l'idOperationType est vide",-2),
	DESIGNATION_EMPTY("la designation est vide",-2),
	DESIGNATION_EXIST("la designation exist deja",-1),
	OPERTATION_NOT_EXIST("Operation n'exist pas",-1),
	OPERTATION_EXIST("Operation exist",1),
	LIST_OPERTATION_NOT_EMPTY("List Operation n'est pas vide",1),
	LIST_OPERTATION_EMPTY("List Operation est vide",0),
	OPERTATION_EMPTY("l'Operation est vide",0),
	MATRICULE_EXIST("matricule deja utiliser",-2),
	MATRICULE_EMPTY("matricule est vide",-4),
	VILLE_NOT_EXIST("ville n'exist pas",-5),
	CHART_NOT_EXIST("chart n'exist pas",-6),
	CODE_EXIST("le code est déjà utilisé",-2),
	CLIENT_NOT_EXIST("client n'exist pas",-1),
	CODE_EMPTY("le code est vide",-4),
	CIN_EXIST("cin est  déjà utilisé",-5),
	CIN_EMPTY("cin est vide",-6),
	CLIENT_EXIST("client exist",1),
	LIST_CLIENT_NOT_EMPTY("list client n'est pas vide",1),
	LIST_CLIENT_EMPTY("list client est vide",0),
	CLIENT_EMPLY("le client est vide",-7),
	TYPECAISSE_NOT_EXIST("Type caisse n'exist pas",-4),
	CAISSE_EMPTY("l'object caisse est vide",0),
	CAISSE_EXIST("la caisse exist",1),
	REFERANCE_EXIST("la reference est déja utilisé",-7),
	REFERANCE_EMPTY("reference est null",-8),
	LIST_CAISSE_NOT_EMPTY("la list des caisses est non vide",1),
	LIST_CAISSE_EMPTY("la list des caisses est vide",0),
	LIST_CAISSETYPE_NOT_EMPTY("la list des types caisses  est non vide",1),
	LIST_CAISSETYPE_EMPTY("la list des types caisses est vide",0),
	CAISSETYPE_EXIST("le type caisse exist",1),
	CAISSETYPE_NOT_EXIST("le type caisse n'exist pas",-4),
	CAISSETYPE_EMPTY("le type caisse est vide",-1),
	TAXE_EMPTY("taxe est vide",0),
	TAXE_EMPTY_FORSESSION("taxe est vide",-1),
	TAXE_NOT_EXIST("taxe n'exist pas",-4),
	TAXE_NOT_EXIST_FOR_SESSION("taxe n'exist pas",-2),
	TAXE_EXIST("taxe exist",1),
	LIST_TAXE_NOT_EMPTY("List taxe n'est pas vide",1),
	LIST_TAXE_EMPTY("List taxe est vide",0),
	MODEREGELEMNT_EMPTY("ModeReglement est vide",0),
	MODEREGELEMNT_EMPTY_FORSESSION("ModeReglement est vide",-1),
	MODEREGELEMNT_NOT_EXIST("ModeReglement n'exist pas",-4),
	MODEREGELEMNT_NOT_EXIST_FOR_SESSION("ModeReglement n'exist pas",-2),
	MODEREGELEMNT_EXIST("ModeReglement exist",1),
	LIST_MODEREGELEMNT_NOT_EMPTY("List ModeReglement n'est pas vide",1),
	LIST_MODEREGELEMNT_EMPTY("List ModeReglement est vide",0),
	LIST_SECTOR_NOT_EMPTY("List sector n'est pas vide",1),
	LIST_SECTOR_EMPTY("List sector est vide",0),
	OBJECT_EMPTY("l'object envoyer est null",-5),

	REGLEUSER_EMPTY("regleUtilisationFidelite est vide",0),
	REGLEUSER_EMPTY_FORSESSION("regleUtilisationFidelite est vide",-1),
	REGLEUSER_NOT_EXIST("regleUtilisationFidelite n'exist pas",-4),
	REGLEUSER_EXIST("regleUtilisationFidelite exist",1),
	LIST_REGLEUSER_NOT_EMPTY("List regleUtilisationFidelite n'est pas vide",1),
	LIST_REGLEUSER_EMPTY("List regleUtilisationFidelite est vide",0),
	RAPPORT_TRAITE("Rapport traité",1),
	CLOTURE_SUCCES("Cloture effectée avec succées",1),
	CLOTURE_JOURNEE_SESSION_NO_CLOT("Veuillez cloturer les sessions suivantes pour proceder à la cloture de la journée",-1),
	LIST_NOT_EMPTY("la liste n'est pas vide",1),
	LIST_EMPTY("la liste est  vide",-2),
	OBJECT_EXIST("OBJECT exist",1),

	BONCOMMANDE_EMPTY("Bon de commande vide",0),
	BONCOMMANDEID_EMPTY("Numero bon de commande vide",1),
	BONCOMMANDE_NOT_FOUND("Bon de commande n'existe pas",2),
	LIST_BONCOMMANDE_EMPTY("pas de bon de commande",3),

	COMMANDE_EMPTY(" commande vide",4),
	COMMANDEID_EMPTY("Numero commande vide",5),
	COMMANDE_NOT_FOUND("commande n'existe pas",6),
	LIST_COMMANDE_EMPTY("pas de commande",7),

	DETAILCOMMANDE_EMPTY("detail commande vide",8),
	DETAILCOMMANDEID_EMPTY("Numero detail commande vide",9),
	DETAILCOMMANDE_NOT_FOUND("detail commande n'existe pas",10),
	LIST_DETAILCOMMANDE_EMPTY("pas de detail commande",11),

	ACTIONMARKETING_EMPTY("Action Marketing vide",0),
	ACTIONMARKETING_ID_EMPTY("id Action Marketing est null",-2),
	ACTIONMARKETING_NOT_EXIST("Action Marketing n'exist pas",-5),
	ACTIONMARKETING_EXIST("l'Action Marketing exist",1),
	LIST_ACTIONMARKETING_NOT_EMPTY("la list des Action Marketing est non vide",1),
	LIST_ACTIONMARKETING_EMPTY("la list des Action Marketing est vide",0),


	CATEGORIE_EMPTY("Categorie vide",0),
	CATEGORIE_ID_EMPTY("id Categorie est null",-2),
	CATEGORIE_NOT_EXIST("Categorie n'exist pas",-5),
	CATEGORIE_EXIST("la Categorie exist",1),
	LIST_CATEGORIE_NOT_EMPTY("la list des Categories est non vide",1),
	LIST_CATEGORIE_EMPTY("la list des Categories est vide",0),

	POPULATIONCIBLE_EMPTY("Population Cible vide",0),
	POPULATIONCIBLE_ID_EMPTY("id Population Cible est null",-2),
	POPULATIONCIBLE_NOT_EXIST("Population Cible n'exist pas",-5),
	POPULATIONCIBLE_EXIST("la Population Cible exist",1),
	LIST_POPULATIONCIBLE_NOT_EMPTY("la list des Population Cibles est non vide",1),
	LIST_POPULATIONCIBLE_EMPTY("la list des Population Cibles est vide",0),

	PARTENAIREBPRICE_ID_EMPTY("id Partenaire est null",-2),



	;

	private static final Map<Integer, EnumMessage> BY_CODE = new HashMap<>();
	private static final Map<String, EnumMessage> BY_LABEL = new HashMap<>();

	static {
		for (EnumMessage e : values()) {
			BY_LABEL.put(e.label, e);
			BY_CODE.put(e.code, e);
		}
	}

	public final String label;
	public final Integer code;

	private EnumMessage(String label, Integer code) {
		this.label = label;
		this.code = code;
	}

	public static EnumMessage valueOfLabel(String label) {
		return BY_LABEL.get(label);
	}

	public static EnumMessage valueOfCode(Integer number) {
		return BY_CODE.get(number);
	}

}