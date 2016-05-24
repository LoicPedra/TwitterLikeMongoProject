# Projet MongoDb (*TwitterLike*)

Ce répertoire un projet Maven répondant au sujet défini ci-dessous.

## Sujet
Le projet consiste à créer un twitter like.

## Fonctionnalités et spécifications techniques

L'application doit fournir les fonctionnalités suivantes :
- Chaque utilisateur peut twitter un message (140 caractères)
- Chaque tweet peut inclure des hashtags, en le préfixant d'un '#' (#hashtag).
- Chaque tweet peut mentionner un utilisateur en préfixant son pseudo par '@' (@user).
- L'utilisateur doit pouvoir rechercher les tweets, la recherche peut se faire sur un hashtag, sur le contenu du tweet, ou sur l'auteur du tweet.
- Chaque utilisateur a une page de profil qui liste les tweets qu'il a créé, ainsi que les tweets qui le mentionnent.

La base de données doit être mongodb, le choix du langage est libre.

## Guide d'utilisation

### Mise en place et lancement du projet

Pour que l'application puisse se connecter à la base de données Mongo, il faut :
* Lancer la base de données Mongo (avec l'utilitaire `mongod.exe` sous Windows)
* Créer une base de données nommée `TwitterDb`
* Créer une collection nommée `TwitterDb`

Afin de lancer le projet, rendez-vous à la racine et exécutez la classe (dans ```TwitterLikeMongoProject/src/main/java/fr/metz/iut/louis/pedrazzani/TwitterMongo/```) en tant qu'application Java.

#### Ecran de connexion

![Ecran de connexion](doc/images/ecran_connexion.png)

*Ecran de connexion permettant à l'utilisateur de mettre son nom d'utlisateur*

#### Ecran principal

![Ecran d'accueil](doc/images/ecran_accueil.png)

*Ecran d'accueil après que l'utlisateur ai renseigné son nom d'utlisateur*

![Ecran mes tweets](doc/images/ecran_accueil_mes_tweets.png)

*Ecran contenant les tweets de l'utilisateur*

![Ecran d'accueil](doc/images/ecran_accueil_tweeter.png)

*Ecran où l'utilisateur saisi et valide un tweet**

##### Recherche

![Ecran de recherche](doc/images/ecran_accueil_recherche_hashtag.png)

*Ecran de recherche par le biais d'un hashtag**

![Ecran de recherche](doc/images/ecran_accueil_recherche_utilisateur.png)

*Ecran de recherche par le biais d'un arobase**

**\* : Il faut appuyer sur la touche Entrée afin de valider l'action**
