Hello !
Tout d'abord voici les prérequis : 
	- installer le plugin JSON viewer sur votre navigateur Chrome en suivant ce lien, cela facilitera la lecture du JSON retourné par l'API REST: 
		https://chrome.google.com/webstore/detail/json-viewer/gbmdgpbipfallnflgajpaliibnhdgobh

Sur le repository vous avez le code source de l'appli. 

Pour lancer l'application vous pouvez : 

1) Télécharger et importer le projet dans votre IDE pour inspecter le code source et runner l'application à partir de votre IDE en exécutant la classe "CatalogApplication".

2) Cette méthode n'est pas d'actualité étant donné que le jar est trop volumineux pour être uploadé sur le repository github, se référer donc à l'option 1).
Lancer le .jar présent sur le repository qui se nomme : "catalog-0.0.1-SNAPSHOT"
	Pour exécuter le jar il suffit de double cliquer dessus, le jar s'exécutera en background, vous n'aurez donc pas de feedback visuel à première vue.
	Attention néanmoins à vérifier que le port 8080 est libre sur votre machine avant d'exécuter le jar.
	Voici la commande à exécuter sous windows pour vérifier cela : 
		netstat -ano | findstr :8080  -> cette commande vous listera les processus qui utilisent le port 8080 s'il y en a
		taskkill /PID ??? /F          -> cette commande permet de killer les processus repérés avec la première commande. les '???' sont à remplacer par le PID du processus repéré à l'aide de la première commande, le PID est le numéro tout à droite dans le tableau retourné de la première commande.


Les credentials pour se connecter à l'application sont : nexio/nexio

Voici la liste des urls auxquelles vous pouvez accéder : 
	- localhost:8080/products -> Affiche la liste de tous les produits disponibles
	- localhost:8080/product/{id} -> Affiche le détail d'un produit
	- localhost:8080/add/{id} -> Permet d'ajouter un produit à votre panier
	- localhost:8080/remove/{id} -> Permet de retirer un produit de votre panier
	- localhost:8080/cart -> Permet d'afficher les éléments de votre panier
	- localhost:8080/infos -> Page récapitulant ces informations, un bouton de déconnexion utilisateur est aussi présent.
Pour toutes les requêtes précédentes, {id} est à remplacer par l'id du produit en question
