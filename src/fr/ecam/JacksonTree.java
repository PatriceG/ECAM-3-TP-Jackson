package fr.ecam;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ArrayNode;

public class JacksonTree {
	ObjectMapper mapper;

	public void enrichirArbre() throws JsonProcessingException, IOException {
		//chargement du flux JSON
		InputStream in = getClass().getResourceAsStream("contact.json");
		mapper = new ObjectMapper();
		// crée un arbre depuis le flux JSON
		JsonNode rootNode = mapper.readTree(in);

		// recherche un attribut par son nom
		// Tous les nœuds de l'arbre sont de type JsonNode
		JsonNode nameNode = rootNode.path("nom");
		System.out.println("Nom: " + nameNode.asText());

		//récupération du noeud Adresse, de type ArrayNode (tableau)
		ArrayNode adresses = (ArrayNode) rootNode.path("adresses");
				
		// enrichissement de l'arbre JSON
		//TODO créer un nouvel objet de type JSonNode via mapper.createObjectNode()
		//ajouter les attributs type, ville et codePostal
		//ajouter cet élément au noeud adresses
		
		

		//affichage de la liste d'adresses
		System.out.println("adresses: ");
		Iterator<JsonNode> iterator = adresses.elements();			
		while (iterator.hasNext()) {
			JsonNode adresse = (JsonNode) iterator.next();
			System.out.println("Type: " + adresse.path("type").asText());
			System.out.println("Ville: " + adresse.path("ville").asText());
			System.out.println("CodePostal: " + adresse.path("codePostal").asText());
		}
		
		//sauvegarde dans un nouveau fichier personne_mod.json
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		mapper.writeValue(new File("contact_mod.json"), rootNode);
	}

	public static void main(String[] args) {
		try {
			JacksonTree tp = new JacksonTree();
			tp.enrichirArbre();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
