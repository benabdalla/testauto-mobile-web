@tag
Feature: Creation de Demande Action
  

  @AjoutDemandeAction
  Scenario Outline: Ajouter Demande Action
		Given Ouvrir le site QualiProWeb
    When saisir Login et PW
    When cliquer sur ouvrir une session
    When Consulter demande Action
    And saisir <exemple> demande action
    And Cliquer sur ajouter
    And Selectionner source
    And Selectionner type
    And Selectionner origine
    And Ajouter Type Cause
    And Ajouter Produit
    And Selectionner date creation
    And Saisir Designation 
    And Saisir description 
    And Saisir Cause 
    And Saisir Objective 
    And Selectionner Site 
    And Selectionner Processus 
    And Selectionner Activite 
    And Selectionner Direction 
    And Selectionner Service 
    And Cliquer valider demande action
    When cliquer sur ajouter sous action demande
		And  ajouter sous action demande
		When choisir gravité DA
		When choisir Priorité DA
		When saisir cout previ DA
		When saisir Risque DA
		When cliquer sur valider sous action demande
		Then Verifier sous action ajouté a la liste
    Then Verifier fiche Demande Action ajoute
    Then Recuperer responsable validation
    And Valider Demande Action par les responsable
   When Consulter demande Action
   And Saisir Numero Demande
   And Cliquer rechercher Demande
   Then Verifier Demande Action validé
   When Consulter Action
   When Saisir Code Action
   When Rechercher Action
   Then Afficher Fiche Action
  Examples:
  |exemple|
  |1|
 
 	@TestRapportAction
  Scenario Outline: Ajouter Demande Action
		Given Ouvrir le site QualiProWeb
    When saisir Login et PW
    When cliquer sur ouvrir une session
    When Consulter Action
   When Saisir <Code> Action
   When Rechercher Action
   Then Afficher Fiche Action
   Then Afficher aperçu Fiche Action
   Then Exporter fiche Action
Examples:
|Code|
|"22248"|
 