package com.cch.pokemon.service;

import com.cch.pokemon.dto.DresseurReduitDTO;
import com.cch.pokemon.entity.Dresseurs;
import com.cch.pokemon.entity.RegionDresseur;
import com.cch.pokemon.exceptions.CustomException;
import com.cch.pokemon.repository.DresseurRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
* Le service des dresseurs
*/
@Service
@Transactional
public class DresseurService {

  /**
   * Le repository des dresseurs
   */
  private final DresseurRepository dresseurRepository;

  /**
   * Le service des regionDresseur
   */
  private final RegionDresseurService regionDresseurService;

  /**
   * Sérialisation d'objet Java au format Json
   */
  private final ObjectMapper objectMapper;

  /**
   * Le constructeur
   * @param dresseurRepository Injection du repository
   */
  public DresseurService(DresseurRepository dresseurRepository, RegionDresseurService regionDresseurService, ObjectMapper objectMapper) {
      this.dresseurRepository = dresseurRepository;
      this.regionDresseurService = regionDresseurService;
      this.objectMapper = objectMapper;
  }

  /**
   * Méthode pour créer un nouveau dresseur
   * @param numDresseur le numéro de dresseur
   * @param nomDresseur le nom de du dresseur
   * @param nbPokemon le nombre de pokemon du dresseur
   * @param nbShiny le nombre de pokemon shiny du dresseur
   * @param idRegionDresseur l'id de la région dresseur
   * @return le dresseur nouvellement créé
   */
  public Dresseurs save(String numDresseur, String nomDresseur, Long nbPokemon, Long nbShiny,
                        Long idRegionDresseur) {
      RegionDresseur regionDresseur = regionDresseurService.findById(idRegionDresseur);

      Dresseurs dresseur = new Dresseurs(numDresseur, nomDresseur, nbPokemon, nbShiny, regionDresseur);

      return dresseurRepository.save(dresseur);
  }

  /**
   * Méthode pour trouver tous les dresseurs (complets)
   * @return la liste des dresseurs
   */
  public List<Dresseurs> findAll() {
      return dresseurRepository.findAll();
  }

  /**
   * Méthode pour trouver tous les dresseurs, numDresseur et nomDresseur
   * @return la liste de tous les dresseurs
   */
  public List<DresseurReduitDTO> findAllDresseurs() {
      List<Dresseurs> dresseurList = dresseurRepository.findAllDresseursReduit();
      return dresseurList.stream()
              .map(dresseur -> objectMapper.convertValue(dresseur, DresseurReduitDTO.class))
              .collect(Collectors.toList());
  }

  /**
   * Méthode pour afficher les listes de dresseurs
   * dont l'id de la région est 1 (non découpés)
   * @return la liste des dresseurs
   */
  public List<Dresseurs> findAllDresseursRegion1() {
      return dresseurRepository.findAllDresseursByRegion1();
  }

  /**
   * Méthode pour afficher les listes de dresseurs
   * dont l'id de la région est 1 et l'id dresseur est compris entre 1 et 40
   * @return la liste des dresseurs
   */
  public List<Dresseurs> findAllDresseursRegion1Part1() {
      return dresseurRepository.findAllDresseursByRegion1Part1();
  }

  /**
   * Méthode pour afficher les listes de dresseurs
   * dont l'id de la région est 1 et l'id dresseur est compris entre 41 et 81
   * @return la liste des dresseurs
   */
  public List<Dresseurs> findAllDresseursRegion1Part2() {
      return dresseurRepository.findAllDresseursByRegion1Part2();
  }

  /**
   * Méthode pour afficher les listes de dresseurs de la région 2
   * @return la liste des dresseurs
   */
  public List<Dresseurs> findAllDresseursRegions2() {
      return dresseurRepository.findAllDresseursRegion2();
  }

  /**
   * Méthode pour afficher les listes de dresseurs de la région 3
   * @return la liste des dresseurs
   */
  public List<Dresseurs> findAllDresseursRegions3() {
      return dresseurRepository.findAllDresseursRegion3();
  }

  /**
   * Méthode pour trouver un dresseur par son id (retourne l'entité complète)
   * @param id l'id du dresseur recherché
   * @return le dresseur trouvé
   */
  public Dresseurs findById(Integer id) {
      return dresseurRepository.findById(id)
              .orElseThrow(() -> new CustomException("Dresseur", "id", id)); // Renvoie l'entité
  }

  /**
   * Méthode pour trouver un dresseur par son id (dresseur réduit)
   * @param id l'id du dresseur recherché
   * @return le dresseur trouvé
   */
  public DresseurReduitDTO findDresseurById(Integer id) {
      Dresseurs dresseur = dresseurRepository.findById(id)
              .orElseThrow(() -> new CustomException("Dresseur", "id", id)); // Gère l'absence de dresseur
      return objectMapper.convertValue(dresseur, DresseurReduitDTO.class); // Convertit l'entité en DTO
  }

  /**
   * Méthode pour retrouver le nombre total de dresseurs
   * @return le nombre de dresseurs
   */
  public Long findDresseursCount() {
      return dresseurRepository.countDresseurs();
  }

  /**
   * Mettre à jour un dresseur
   * @param dresseur L'objet à mettre à jour
   * @return L'objet mis à jour
   */
  public Dresseurs updateDresseur(Dresseurs dresseur) {
      Optional<Dresseurs> isDresseurExist= dresseurRepository.findById(dresseur.getId());

      if (isDresseurExist.isPresent()) {
          Dresseurs existingDresseur = isDresseurExist.get();

          existingDresseur.setNumDresseur(dresseur.getNumDresseur());
          existingDresseur.setNomDresseur(dresseur.getNomDresseur());
          existingDresseur.setNbPokemon(dresseur.getNbPokemon());
          existingDresseur.setNbShiny(dresseur.getNbShiny());
          existingDresseur.setRegionDresseur(dresseur.getRegionDresseur());
          return dresseurRepository.save(existingDresseur);
      } else {
          throw new CustomException("Le dresseur n'existe pas", "id", dresseur.getId());
      }
  }

  /**
   * Méthode pour incrémenter le nombre de pokémon d'un dresseur donné lorsqu'on ajoute un nouveau pokémon
   * @param dresseurId L'identifiant du dresseur
   */
  public void incrementerNbPokemon(Integer dresseurId) {
    Dresseurs dresseur = dresseurRepository.findById(dresseurId)
      .orElseThrow(() -> new CustomException("Dresseur non trouvé", "Id", dresseurId));
    dresseur.setNbPokemon(dresseur.getNbPokemon() + 1);
    dresseurRepository.save(dresseur);
  }

  /**
   * Méthode pour incrémenter le nombre de shiny d'un dresseur donné lorsqu'on ajoute un nouveau shiny
   * @param dresseurId L'identifiant du dresseur
   */
  public void incrementerNbShiny(Integer dresseurId) {
      Dresseurs dresseur = dresseurRepository.findById(dresseurId)
              .orElseThrow(() -> new CustomException("Dresseur non trouvé", "Id", dresseurId));
      dresseur.setNbShiny(dresseur.getNbShiny() + 1);
      dresseurRepository.save(dresseur);
  }

  /**
   * Méthode pour supprimer un dresseur par son Id
   * @param id L'identifiant du dresseur à supprimer
   * @return L'objet supprimé
   */
  public Dresseurs deleteById(Integer id) {
      // Récupérer l'objet dans un Optional
      Optional<Dresseurs> optionalDresseur = dresseurRepository.findById(id);

      // Vérifier si l'objet existe
      if (optionalDresseur.isPresent()) {
          Dresseurs shiny = optionalDresseur.get();
          dresseurRepository.delete(shiny); // Supprimer l'objet
          return shiny; // Retourner l'objet supprimé
      } else {
          throw new CustomException("Dresseur", "id",  id);
      }
  }

  /**
   * Supprimer tous les dresseurs
   */
  public void deleteAll() {
      dresseurRepository.deleteAll();
  }

}
