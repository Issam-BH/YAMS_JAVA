# 🧩 Document de Travail – Développement d’un Yams Solo

**Noms des étudiants : Yanis BOUKAYOUH**  
**Date : 27/04/2025**

---

## ✨ Tâche a. – Analyse du Code Existant

### 1. Démarche suivie  
_Décrivez brièvement comment vous avez exploré le code existant : ce que vous avez testé, observé, etc._

> Tout d'abord, j'ai executer le code pour explorer comment le jeu fonctionne.
> Puis j'ai regardé les règles du jeu en ligne pour mieux comprendre comment ça fonctionne.
> Ensuite, j'ai commenté le code en fonction et créer une javadoc avec.
> En me basant sur les règles j'ai fait une liste de tache à faire.

---

### 2. Liste des fonctionnalités déjà implémentées

> Listez ici ce qui fonctionne déjà dans le programme.

- [x] Affichage des dés  
- [x] Relance d’un dé  
- [x] La maquette du jeu pour pouvoir le lancer (Classe YAMS)


---

### 3. Liste des manques

> Identifiez ce qui manque pour que le Yams soit complet et jouable correctement en solo.

- 🔲 Les combinaisons étaient soit incomplets soit ils étaient pas présent du tout
- 🔲 Seuls les 2 premières combinaisons étaient utilisables  
- 🔲 Pas de sacrifice de case dans le cas où il les combinaisons n'étaient pas appropriés

---

## 🛠️ Tâche b. – Proposition de Solution

- Ajoute des classes des combinaisons.
- Changer le print qui affiche et ajouter l'execution des classe
- Ajout d'un systeme de point restant pour le sacrifice et enlever les 5 par la variable gérer les point
- Créer une copie des five dice avec le nombre de dés autorisés
- Créer une classe qui permet d'executer la fonction sacrific

### 1. Cahier des charges simplifié

> Listez ici les fonctionnalités que vous comptez ajouter ou améliorer.
 
- [x] Ajouter les combinaisons manquantes  
- [x] Ajouter le sacrifice 
- [x] Documenter le code (commentaire & javadoc)
- [x] Pouvoir selectionner les combinaisons 

---

### 2. Choix techniques importants

> Expliquez ici brièvement comment vous comptez vous y prendre techniquement (nouvelle classe, refactorisation, etc.)

- Nous allons créer de nouveaux records qui implémentent l'interface Combination pour les combinaisons manquante

- Comprendre le code et pouvoir donc l'expliquer pour que tout fonctionne correctement 

- Modification des classes actuelles

- Modification du main Yams.java pour Sacrifice


---

### 3. Schéma simple de l’organisation du programme

> Ajoutez ici un schéma type UML ou une structure en texte brut pour montrer les classes et leurs relations.

```
Yams (main)
 ├── Board
 │    └── Dice x5
 ├── ScoreSheet
 └── Combination (interface)
       ├── Chance
       ├── Carre
       ├── FullHouse
       ├── SmallStraight
       ├── LargeStraight
       ├── ThreeOfAKind
       ├── YamsCombination
       └── Sacrifice

```
--- 

## 💻 Tâche c. – Programmation

> Listez ici les classes ou méthodes que vous avez créées ou modifiées pour répondre au cahier des charges.

- Création : Carre, Chance, YamsCombination, FullHouse, LargeStraight, SmallStraight, Sacrifice.
- Modification : Record ThreeOfAKind, la classe Board pour ajouter la capacité à sacrifier une case ainsi qu'un peu tout ce qui existait déjà pour le commenter 
- Tests réalisés : Tests de plusieurs parties afin de voir si tout fonctionne correctement ou non.

---

## 📦 Tâche d. – Livraison

> Vérifiez que tout est prêt pour la livraison.

- [x] Code fonctionnel  
- [x] Partie ligne de commande jouable sur 13 tours  
- [x] Combinaisons jouables au choix (et pas deux fois !)  
- [x] Affichage du score total  
- [x] Ce document rempli  
---

## ✍️ Commentaires personnels 

> Vous pouvez expliquer ici ce que vous avez appris, aimé ou trouvé difficile dans l’exercice.

- C'était pas très compliqué dans la majorité, au début l'idée d'IA était "overwhelming" mais finalement ça s'est terminé plutot bien avec le système simple actuel, pareil le joueur qui s'est retrouvé à juste copier le code de gestion du tour joueur 2 fois et juste gérer quand c'était le tour d'un tel.

- J'ai peut-être pas compris l'idée de tour.