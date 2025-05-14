# 🧩 Document de Travail – Développement d’un Yams Duo

**Noms des étudiants : BEN HAMOUDA/BOUKAYOUH**  
**Date :24/04/2025**

---

## ✨ Tâche a. – Analyse du Code Produit pour l’Objectif 1

### 1. Démarche suivie  
_Décrivez comment vous avez relu, testé ou réutilisé le code produit pour l'objectif 1 pour identifier les points à adapter ou à compléter._

> Tout d'abord, j'ai executer le code pour explorer comment le jeu fonctionne.
> Puis j'ai regardé les règles du jeu en ligne pour mieux comprendre comment ça fonctionne.
> Ensuite, j'ai commenté le code en fonction et créer une javadoc avec.
> En me basant sur les règles j'ai fait une liste de tache à faire.

---

### 2. Liste des éléments réutilisables

> Indiquez ici ce qui peut rester inchangé ou être réutilisé tel quel dans la version duo.

- [x] Classe `Dice`  
- [x] Interface `Combination`  
- [x] Tout les records de combinaisons
- [x] Classe `Board`  

---

### 3. Liste des manques par rapport à un Yams duo

> Listez ici les fonctionnalités ou éléments manquants pour avoir un jeu jouable à deux, humain ou IA.

- 🔲 Gestion de deux joueurs  
- 🔲 Gestion de l'IA
- L'IA n'est pas capable de roll et de chosir une option
- Pas de méthode pour dire que c'est le tour d'un tel
- Pas de méthode pour CHOISIR le mode 2J ou IA

---

## 🛠️ Tâche b. – Proposition de Solution

- Copier le code de gestion du joueur 1, 2 fois et par rapport au round dire quand c'est le tour d'un tel.

- Pour l'IA il suffisait de crée un scoresheet et un board pour lui et faire un code afin qu'il choisisse la meilleure option.
### 1. Cahier des charges simplifié

> Listez les fonctionnalités que vous comptez développer ou modifier.

- [x] Permettre à deux joueurs de jouer à tour de rôle  
- [x] Permettre au joueur de pouvoir choisir un adversaire IA

---

### 2. Choix techniques importants

> Décrivez ici vos grandes orientations de conception.

- Créer plusieurs scoresheet et board
- Tour impaire J1 tour pair J2
- System de detection de meilleur score pour combinaison et choisir la meilleure

---

### 3. Schéma simple de l’organisation du programme

```
Yams (main)
 ├── Board
 │    └── Dice x5
 ├── ScoreSheet
 ├── Computer
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

> Détaillez les ajouts/modifications apportés au code.

- Ajouts : Ajout de la classe Computer  
- Modifications : Modification de la classe Yams afin d'implémenter le mode deux joueur ainsi que le mode VS Ia.
- Tests réalisés : Essai de plusieurs parties contre une IA et contre un autre joueur

---

## 📦 Tâche d. – Livraison

> Cochez ce qui a été fait.

 
- [x] Partie jouable en ligne de commande à deux joueurs  
- [x] Ce document rempli
- [x] Le mode versus IA. 

---

## ✍️ Commentaire personnel 

> Vous pouvez écrire ici ce que vous avez appris, aimé ou trouvé difficile dans cette version duo.

- C'était pas très compliqué dans la majorité, au début l'idée d'IA était "overwhelming" mais finalement ça s'est terminé plutot bien avec le système simple actuel, pareil le joueur qui s'est retrouvé à juste copier le code de gestion du tour joueur 2 fois et juste gérer quand c'était le tour d'un tel.