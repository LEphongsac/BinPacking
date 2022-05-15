# BinPacking

## Principe du Bin Packing

Le principe du Bin Packing est de mettre différents objets dans des sacs. Chaque objet a un poids et les sac ont une limite commune qui est le poids supporté par le sac. L’objectif étant de minimiser le nombre de sacs total nécessaire pour stocker les objets.

## Explication de l’algorithme  
Notre solution first fit est un algorithme assez simple qui met les objets dans les sacs dans l’ordre. Nous parcourons les sacs pour vérifier si les sacs existants ont suffisamment de place pour contenir l’objet n. Nous commençons l'expérience avec au minimum un sac que nous remplissons au fur et à mesure de l’avancement de l’algorithme. Quand il ne peut plus contenir l’objet n, nous instancions un nouveau sac qui va contenir l’objet n. Et pour chaque objet n+1. nous regardons l’ensemble de nos sacs pour vérifier s’il peut contenir l’objet n+1.

Nous créons aléatoirement le poids des objets et le poids supporté par les sacs qui sont égaux.

Nous regardons ensuite le nombre de sacs requis pour stocker l’ensemble de nos objets et nous le comparons à un minorant qui est calculé par rapport au poids des objets totaux/poids du sac. 

Afin d’étudier l’efficacité de notre algorithme nous avons ajouté la variable essaie qui détermine le nombre d’essaie de notre algorithme, un nombre d’objet est définie par avance.

Nous avons donc 2 paramètres initiaux à imposer le nombre d’objet total, et le nombre d'essais.


## Résultat 
Nous avons 7 colonnes correspondent à 7 paramètres dans notre fichier de résultat: 
* _Nombre d'essais_: Nous avons mis notre algorithme dans un boucle de 10,50 et 100 fois afin de récupérer la performance moyenne de cet algorithme. 

* _Nombre Object Total_: Nous choisissons les nombre d'objets le plus petit et le plus grand pour que nous puissions évaluer et analyser profondément cet algorithme. Nous avons donc des nombres de: 10, 50, 100, 500, 1000, 5000, 10000

* _Nombre Poids Total_: le poid de chaque objet va être généré aléatoirement entre 1 et le poid maximal de sac. Nombre Poids Total représente le nombre de poids de tous les objets. 

* _Poids Max du Sac_:  le poid maximal de chaque sac va être généré aléatoirement entre 1 et 100.

* _Nombre Sac Total par Algo_: Nous avons calculé le sac total généré par cet algorithme pour comparer au nombre de sacs possibles et pour évaluer la performance.

* _Nombre Sac Possible_:  Nous avons pris le poids total d'objets divisé par le poid max du sac afin de calculer un minorant du nombre de sac possible. 
 
* _Performance en %_: La performance de cet algorithme est calculée selon le nombre d'essais et le pourcentage moyen entre Nombre Sac Total et Nombre Sac Possible.



## Interpretation des Resultats

En total, nous avons 20 résultats, avec les différent Nombre d'essais et les différent nombre d’objets, nous prenons le moyen de ces 20 résultats et nous avons donc 91,04% la performance en % de cet algorithme. 

Mais nous pouvons observer que plus il y a d'objets, plus notre algorithme est performant. 

Nous supposons que par rapport à l'instantiation des sacs et comment nous les ajoutons les objets dedans, plus il y a de sac plus il est facile de les stocker et d’obtenir un résultat proche du minorant.

Cependant nous aurions voulu générer des valeurs d’objets légèrement moins élevés que ceux des sacs pour essayer d’obtenir des sacs contenant plus facilement plusieurs objets. 

