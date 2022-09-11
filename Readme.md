# Test technique Kreactive
Ce projet est un test technique pour Kreactive. C'est une application Android développée en Kotlin.
L’objectif de ce projet est de réaliser une application Android qui implémente le jeu Fizz-Buzz.

## Règle du jeu 
L’application consiste à afficher un formulaire pour saisir 2 entiers : Entier1 et Entier2, et 2 Strings : mot1 et mot2 ainsi qu’une limite.
L’objectif est d’afficher ensuite une liste de résultats dans laquelle tous les multiples de l’entier1 seront remplacés par mot1, les multiples de l’entier2 par mot 2 et les multiples de entier1*entier2 remplacé par mot1mot2.Exemple:
entier1 : 3
entier2 : 5
mot1 : fizz
mot2 : buzz
Le résultat sera : 1,2,fizz, 4, buzz, fizz, 7, 8, fizz, buzz, 11, fizz, 13, 14, fizzbuzz, 16,…

## Temps passé dessus
1er jour : 10min (Création du projet et les activités)
2ème jour : 1h45 (Reste du projet)

# Description de l'application
## Analyse fonctionnelle

### Comportement de l'application
L'application est composée de 2 écrans:
- Un formulaire pour entrer les éléments du jeu
- Un écran de résultat avec la liste


### Comportement du code
Pour faire cela, l'application télécharge les données via l'API fourni par l'entreprise.
Nous récupérons seulement les informations dont nous avons besoin à des fins d'optimisation. 
Ces informations sont directement envoyées à la vue (pas de stockage en base de données interne).

## Analyse technique
### Architecture
La structure de l'application est en MVVM (Model View ViewModel)
Sur ce projet, seul l'activity Result a son viewmodel.
Nous aurions pu en faire de même pour le mainActivity notamment pour la vérification des champs entrés

### Process
#### Vérification des données
Champs vérifiés dans le mainActivity
Nous vérifions s'ils sont vides et si les textes entrés sont des mots uniques

#### Passage des données
Nous passons à l'autre activité les champs entrés de manière individuelle
Il n'est pas utile de créer un objet sérialisable juste pour le passage de données

#### Construction de liste
La liste est construite dans l'affichage du second écran pour :
- Ne pas passer une liste (potentiellement longue) en extra d'intent
- Rendre l'écran de résultat indépendant

### Choix des librairies 
#### LiveData
Nous utilisons le liveData pour passer le resultat une fois la liste construite

### Test unitaires

Les tests ont été conçus avant le développement de la fonction (TDD)
Nous avons testé uniquement la fonction de formatage de la liste

