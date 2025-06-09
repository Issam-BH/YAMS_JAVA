# Rapport Final – Projet Java BUT1

## Page de garde

**Titre du projet** :  SAE Java YAMS    
**Nom(s) des étudiant·e·s** : BEN HAMOUDA - BOUKAYOUH
**Groupe / TD / TP** :  TD A TP ALPHA   
**Date de rendu** : 09/06/2025

---

## Introduction

> Présentez en quelques lignes le projet et le scénario suivi :
- Dans le cadre de cette SAE nous devions coder un jeu Yams pour notre client, la jeune entreprise “ctrlC-ctrlV Games” composée d’une équipe d’une personne. Ce jeu devait être jouable sur terminal par ligne de commandes et nous devions faire des réunions avec le client pour connaître les futurs objectifs et les améliorations au vu de la première phase de développement. Les objectifs principaux étaient de livrer un yams solo jouable sur ligne de commande et livrer un yams duo (avec choix de l’ia de l’adversaire) jouable sur ligne de commande , le troisieme objectif était de l'améliorer avec des bonus et/ou une interface graphique et/ou un mode avec des cartes. Nous avons organisé notre travail de manière assez équitable en ayant tout les deux fait un peu tout, et corriger les bugs de l'autre quand il ne savait pas comment.

## 1.  Bilan Phase 1

Scénario : B (Approfondissement)
Priorités :
- Corriger les bugs vu avec le client 
- Intégrer des bonus et potentiellement une interface graphiques 

## 2. Phase 2

- Modification des modes de jeux en leurs créant chacun leurs classes et correctifs de bugs, et mise en place des packages en mode MVC (La partie modèle contient aussi les combinaisons)
- Problème : Nous avons eu quelques problèmes avec l'implementation de l'interface graphique, malgré les FXML fait, nous n'avons pas réussi a les intégrer au code sans que tout soit en erreur de partout.


#### Réorganisation du code selon le modèle MVC

- Structure :
    - Modèle (model) : Board, Dice, ScoreSheet, Computer, etc...
    - Vue (vue) : Vue.java (affichage texte).
    - Contrôleur (controller) : Game.java, Multiplayer.java, Classic.java, CompVs.java.
- Les classes principales et leur rôle:
    - Yams : Fonction main du progamme
    - Game : cœur du moteur de jeu
    - Dice : gestion des dés
    - ScoreSheet : feuilles de score des joueurs
    - Combination et ses sous-classes : logique de calcul des points
- Un schéma représentant la structure de votre code : 
 - Vue --> Controller (game.java et Yams.java) --> Modèle 



## 4. Fonctionnalités finales

> Listez ici toutes les fonctionnalités réalisées à la fin du projet.
> Pour chaque amélioration, expliquez brièvement son intérêt et sa difficulté.

- [x] Fonctionnalités de base (lancer de dés, score…)
    - Permet de jouer une partie complète de Yams en respectant les règles , c'est ce qui sert de base au jeu 
- [x] Corrections apportées
- [x] Modificateurs (jokers, rerolls…)
    - L'intérêt est de pimenter un peu le jeu en ajoutant des avantages qui rendent la game unique , c'est simple d'en rajouter d'autre ayant fait un systeme similaire à celui des combinaisons 
- [ ] Version graphique (JavaFX)
    - Nous avons essayé mais nous n'avons pas réussi malgré les FXML et les controller (retiré car ça faisait des erreurs dans le projets)
- [ ] Version avec cartes



## 5. Tests et validation

> Montrez que vous avez vérifié le bon fonctionnement :
- Cas testés (exemples)
- Résultats (succès, échecs connus)

Exemples :
- Le programme ne plante pas si on reroll plusieurs fois le même dé
- Les bonus fonctionne correctement
- Le mode IA est fonctionnelle et il fait bien de l'aléatoire 
- Validation correcte des combinaisons

## 6. Difficultés rencontrées

- Difficulté dans l'implémentation de l'interface graphique 
- Manque de temps à cause de tout les projets en simultanée, nous n'avons donc pas pu faire tout ce que l'on voulait


## 7. Pistes d’amélioration ou d’évolution

> Essayer de corriger l'interface graphique pour qu'elle soit vraiment fonctionnelle
> Implementer le mode avec les cartes 
> Amélioration de l'IA pour qu'elle soit encore plus poussé     
 

## ✍️ Commentaire personnel 

> Ce projet nous a permis de consolider notre compréhension du Java ce qui nous a fait beaucoup aimé cette SAé, nous l'avons trouvé pertinente et nous mettait dans le cadre d'un vrai projet dans le monde du travail ! Nous avons aussi pu bien séparer les tâches et s'organiser, et cela nous a montré les difficultés qu'il faut surmonter

