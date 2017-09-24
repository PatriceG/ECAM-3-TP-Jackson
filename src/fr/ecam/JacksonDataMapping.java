package fr.ecam;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class JacksonDataMapping {
	ObjectMapper mapper;

	public void enrichirGrapheObjets() throws JsonProcessingException, IOException {
		//chargement du flux JSON
		InputStream in = getClass().getResourceAsStream("contact.json");
		mapper = new ObjectMapper();
		// crée un arbre depuis le flux JSON
		Contact contact = mapper.readValue(in, Contact.class);

		
		// enrichissement de l'arbre d'objets
		
		//TODO créer un objet de type Adresse
		//affecter le code postal, la ville et le type
		//ajouter cet objet à la liste d'adresses de l'objet contact		
		//affichage de l'objet Java enrichi
		
		System.out.println(contact);
		
		//sérialise l'objet Contact dans un nouveau fichier json
		mapper.writeValue(new File("contact_mapping_mod.json"), contact);
		
	}

	public static void main(String[] args) {
		try {
			JacksonDataMapping tp = new JacksonDataMapping();
			tp.enrichirGrapheObjets();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
